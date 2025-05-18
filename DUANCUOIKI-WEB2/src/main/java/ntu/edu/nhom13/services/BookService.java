package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntu.edu.nhom13.entity.Book;
import ntu.edu.nhom13.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
    // Đếm số lượng sách của nhà khoa học
    public int countByScientistId(Integer scientistId) {
        return bookRepository.countByScientistId(scientistId);
    }

    // Lấy sách theo nhà khoa học
    public List<Book> findByScientistId(Integer scientistId) {
        return bookRepository.findByScientistId(scientistId);
    }
}
