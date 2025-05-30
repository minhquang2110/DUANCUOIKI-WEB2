package ntu.edu.nhom13.services;

import jakarta.transaction.Transactional;
import ntu.edu.nhom13.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import jakarta.persistence.EntityNotFoundException;
import ntu.edu.nhom13.dto.ScientistDTO;
import ntu.edu.nhom13.entity.Account;
import ntu.edu.nhom13.entity.Account.Role;
import ntu.edu.nhom13.entity.Book;
import ntu.edu.nhom13.entity.Degree;
import ntu.edu.nhom13.entity.LanguageLevel;
import ntu.edu.nhom13.entity.Organization;
import ntu.edu.nhom13.entity.Rank;
import ntu.edu.nhom13.entity.ResearchField;
import ntu.edu.nhom13.entity.Scientist;
import ntu.edu.nhom13.entity.Title;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Queue;
import java.util.Set;

@Service
public class ScientistService {
    @Autowired private ScientistRepository scientistRepository;
    @Autowired private BookAuthorRepository bookAuthorRepository;
    @Autowired private ArticleAuthorRepository articleAuthorRepository;
    @Autowired private ProjectParticipantRepository projectParticipantRepository;
    @Autowired private WorkHistoryRepository workHistoryRepository;
    @Autowired private EducationHistoryRepository educationHistoryRepository;

    @Autowired
    private DegreeRepository degree;
    @Autowired
    private RankRepository rankRepository;
    @Autowired
    private TitleRepository titleRepository;
  
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private  LanguageLevelRepository languageLevelRepository;
    @Autowired
    private  AccountRepository accountRepository;
    
    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private ResearchFieldRepository researchFieldRepository;
    
    @Autowired
    private Cloudinary cloudinary;
    
    public static String UPLOAD_DIRECTORY = "/bin";

    public List<Scientist> getAllScientists() {
        return scientistRepository.findAll();
    }
    
    public Scientist getScientistByAccountId(Integer id) {
    	return scientistRepository.findScientistByAccountId(id);
    }
    public Optional<Scientist> getScientistById(Integer id) {
        return scientistRepository.findById(id);
    }

    public Scientist saveScientist(ScientistDTO scientist) throws IOException {
    	Scientist sc=new Scientist();
    	Account account=new Account();
    	Degree de=degree.getById(Integer.parseInt(scientist.getDegree()));
    	Rank ra=rankRepository.getById(Integer.parseInt(scientist.getRank()));
    	Title ti=titleRepository.getById(Integer.parseInt(scientist.getTitle()));
    	ResearchField re=researchFieldRepository.getById(Integer.parseInt(scientist.getResearchField()));
    	Organization or=organizationRepository.getById(Integer.parseInt(scientist.getOrganization()));
    	LanguageLevel la=languageLevelRepository.getById(Integer.parseInt(scientist.getLanguageLevel()));
    	int num=(int) scientistRepository.count();
    	sc.setId(num+1);
    	sc.setAccount(account);
    	sc.setAddress(scientist.getAddress());
    	sc.setFullName(scientist.getFullName());
    	sc.setGender(scientist.getGender());
    	sc.setBirthYear(scientist.getBirthYear());
    	sc.setPhoneNumber(scientist.getPhone());
    	sc.setEmail(scientist.getEmail());
    	sc.setDegree(de);
    	sc.setRank(ra);
    	sc.setTitle(ti);
    	sc.setResearchField(re);
    	sc.setOrganization(or);
    	sc.setLanguageLevel(la);
    	sc.setMajor(scientist.getMajor());
    	sc.setSubMajor(scientist.getSubMajor());
    	sc.setTeachingSpecialty(scientist.getTeachingSpecialty());
    	String base = scientist.getFullName().toLowerCase().replaceAll("\\s+", "");
        int random = new Random().nextInt(900) + 100; 
    	account.setUsername(base);
    	account.setPassword("1");
    	account.setRole(Role.Scientist);
    	try {
    		java.util.Map r=cloudinary.uploader().upload(scientist.getImageUrl().getBytes(), ObjectUtils.asMap("resource_type","auto"));
    		String img=(String) r.get("secure_url");
    		sc.setImage(img);
    	}catch (IOException e){
    		e.printStackTrace();
    	}
    	accountRepository.save(account);
        return scientistRepository.save(sc);
    }

    public void deleteScientist(Integer id) {
        scientistRepository.deleteById(id);
    }

    public Scientist findByEmail(String email) {
        return scientistRepository.findByEmail(email);
    }

    public List<Scientist> searchByName(String keyword) {
        return scientistRepository.findByFullNameContainingIgnoreCase(keyword);
    }

    public Scientist findByIdWithRelations(Integer id) {
        return scientistRepository.findByIdWithRelations(id)
              .orElseThrow(() -> new EntityNotFoundException("Scientist not found with id " + id));
    }

    public Scientist findById(Integer id) {
        return scientistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Scientist not found with id " + id));
    }

    public List<Scientist> findAll() {
        return scientistRepository.findAll();
    }

//    public void save(ScientistDTO scientist) {
//        scientistRepository.save(scientist);
//    }
    @Transactional
    public void deleteById(Integer id) {
        // Xóa các bản ghi liên quan trước
        bookAuthorRepository.deleteByScientist_Id(id);
        articleAuthorRepository.deleteByScientist_Id(id);
        projectParticipantRepository.deleteByScientist_Id(id);
        workHistoryRepository.deleteByScientist_Id(id);
        educationHistoryRepository.deleteByScientist_Id(id);

        // Sau đó mới xóa Scientist
        scientistRepository.deleteScientistById(id);
    }

    public boolean existsById(Integer id) {
        return scientistRepository.existsById(id);
    }

    public List<Book> getAllBooks(Integer id) {
    	return bookRepository.findByScientistId(id);
    }

    public List<Scientist> filterScientists(String keyword, Integer degreeId, Integer titleId, Integer researchFieldId) {
        Set<Integer> researchFieldIds = null;

        if (researchFieldId != null) {
            researchFieldIds = getAllRelatedResearchFieldIds(researchFieldId);
        }

        return scientistRepository.filter(keyword, degreeId, titleId, researchFieldIds);
    }

    private Set<Integer> getAllRelatedResearchFieldIds(Integer rootId) {
        Set<Integer> ids = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootId);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            if (ids.add(current)) {
                List<ResearchField> children = researchFieldRepository.findByParentFieldId(current);
                for (ResearchField child : children) {
                    queue.add(child.getId());
                }
            }
        }
        return ids;
    }
}
