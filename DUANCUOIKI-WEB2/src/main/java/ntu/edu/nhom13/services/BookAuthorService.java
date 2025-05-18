package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ntu.edu.nhom13.entity.BookAuthor;
import ntu.edu.nhom13.repositories.BookAuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookAuthorService {

    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    public List<BookAuthor> getAllBookAuthors() {
        return bookAuthorRepository.findAll();
    }

    public Optional<BookAuthor> getBookAuthorById(Integer id) {
        return bookAuthorRepository.findById(id);
    }

    public BookAuthor saveBookAuthor(BookAuthor bookAuthor) {
        return bookAuthorRepository.save(bookAuthor);
    }

    public void deleteBookAuthor(Integer id) {
        bookAuthorRepository.deleteById(id);
    }
}
