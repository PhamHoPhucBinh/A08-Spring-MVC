package com.Mylibrary.Librarymanagement.Controller;

import com.Mylibrary.Librarymanagement.Bean.Book;
import com.Mylibrary.Librarymanagement.Bean.Student;
import com.Mylibrary.Librarymanagement.Service.Book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/Create-Book")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("view/book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/Create-Book")
    public ModelAndView saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("view/book/create");
        modelAndView.addObject("book", new Book());
        modelAndView.addObject("message", "create successfully");
        return modelAndView;
    }

    @GetMapping("/books")
    public ModelAndView listBooks() {
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("view/book/list");
        modelAndView.addObject("book", books);
        return modelAndView;
    }

    @GetMapping("/edit-book/{bookId}")
    public ModelAndView showEditForm(@PathVariable Integer bookId) {
        Optional<Book> book = bookService.findById(bookId);
        if (book.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/book/edit");
            modelAndView.addObject("book", book.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-book")
    public ModelAndView updateBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("/book/edit");
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", "Book updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-book/{bookId}")
    public ModelAndView showDeleteForm(@PathVariable Integer bookId) {
        Optional<Book> book = bookService.findById(bookId);
        if (book.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/book/delete");
            modelAndView.addObject("book", book.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-book")
    public String deleteBook(@ModelAttribute("book") Book book) {
        bookService.remove(book.getBookId());
        return "redirect:books";
    }
}
