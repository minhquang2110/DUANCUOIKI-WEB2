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

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

@Service
public class ScientistService {
    @Autowired 
    private ScientistRepository scientistRepository;
    
    @Autowired 
    private BookAuthorRepository bookAuthorRepository;
    
    @Autowired 
    private ArticleAuthorRepository articleAuthorRepository;
    
    @Autowired 
    private ProjectParticipantRepository projectParticipantRepository;
    
    @Autowired 
    private WorkHistoryRepository workHistoryRepository;
    
    @Autowired 
    private EducationHistoryRepository educationHistoryRepository;

    @Autowired
    private DegreeRepository degreeRepository;
    
    @Autowired
    private RankRepository rankRepository;
    
    @Autowired
    private TitleRepository titleRepository;
    
    @Autowired
    private OrganizationRepository organizationRepository;
    
    @Autowired
    private  LanguageLevelRepository languageLevelRepository;
    
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

    public Scientist save(Scientist scientist) {
        return scientistRepository.save(scientist);
    }
    
    public void saveScientist(ScientistDTO scientist) throws IOException {
        Scientist sc = new Scientist();
        Account account = new Account();

        // Tạo username tự động không dấu + thời gian
        String normalized = Normalizer.normalize(scientist.getFullName(), Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String tenKhongDau = pattern.matcher(normalized).replaceAll("")
                .replaceAll("đ", "d")
                .replaceAll("Đ", "D");
        String tenXuLy = tenKhongDau.toLowerCase().replaceAll("\\s+", "");
        String thoiGian = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        String ketQua = tenXuLy + thoiGian;

        account.setUsername(ketQua);
        account.setPassword("1");  // Bạn nên mã hóa password ở đây
        account.setRole(Role.Scientist);

        // Gán account cho scientist
        sc.setAccount(account);

        // Set các trường khác
        sc.setFullName(scientist.getFullName());
        sc.setEmail(scientist.getEmail());
        sc.setGender(scientist.getGender());
        sc.setBirthYear(scientist.getBirthYear());
        sc.setAddress(scientist.getAddress());
        sc.setPhoneNumber(scientist.getPhone());
        sc.setMajor(scientist.getMajor());
        sc.setSubMajor(scientist.getSubMajor());
        sc.setTeachingSpecialty(scientist.getTeachingSpecialty());

        // Lấy các đối tượng liên quan từ repository theo ID
        Degree de = degreeRepository.getById(Integer.parseInt(scientist.getDegree()));
        Rank ra = rankRepository.getById(Integer.parseInt(scientist.getRank()));
        Title ti = titleRepository.getById(Integer.parseInt(scientist.getTitle()));
        ResearchField re = researchFieldRepository.getById(Integer.parseInt(scientist.getResearchField()));
        Organization or = organizationRepository.getById(Integer.parseInt(scientist.getOrganization()));
        LanguageLevel la = languageLevelRepository.getById(Integer.parseInt(scientist.getLanguageLevel()));

        sc.setDegree(de);
        sc.setRank(ra);
        sc.setTitle(ti);
        sc.setResearchField(re);
        sc.setOrganization(or);
        sc.setLanguageLevel(la);

        // Xử lý upload ảnh nếu có
        if (scientist.getImageUrl() != null && !scientist.getImageUrl().isEmpty()) {
            Map uploadResult = cloudinary.uploader().upload(scientist.getImageUrl().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            String imageUrl = (String) uploadResult.get("secure_url");
            sc.setImage(imageUrl);
        }

        // Lưu scientist (cascade tự động lưu account nếu bạn set cascade)
        scientistRepository.save(sc);
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

    public List<Scientist> searchScientists(String keyword) {
        return scientistRepository.search(keyword);
    }

}
