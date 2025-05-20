package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import ntu.edu.nhom13.entity.Book;
import ntu.edu.nhom13.entity.Scientist;
import ntu.edu.nhom13.repositories.BookRepository;
import ntu.edu.nhom13.repositories.ScientistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ScientistService {

    @Autowired
    private ScientistRepository scientistRepository;
    
    @Autowired
    private BookRepository bookRepository;
    
    public List<Scientist> getAllScientists() {
        return scientistRepository.findAll();
    }
    
    public Scientist getScientistByAccountId(Integer id) {
    	return scientistRepository.findScientistByAccountId(id);
    }
    public Optional<Scientist> getScientistById(Integer id) {
        return scientistRepository.findById(id);
    }

    public Scientist saveScientist(Scientist scientist) {
        return scientistRepository.save(scientist);
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
        // Trả về thông tin nhà khoa học hoặc ném exception nếu không tìm thấy
        return scientistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Scientist not found with id " + id));
    }



    public List<Scientist> findAll() {
        return scientistRepository.findAll();
    }

    public void save(Scientist scientist) {
        scientistRepository.save(scientist);
    }

    public void deleteById(Integer id) {
        scientistRepository.deleteById(id);
    }

    public boolean existsById(Integer id) {
        return scientistRepository.existsById(id);
    }

    public List<Book> getAllBooks(Integer id) {
    	return bookRepository.findByScientistId(id);
    }

}
