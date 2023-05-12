package com.Mylibrary.Librarymanagement.Controller;

import com.Mylibrary.Librarymanagement.Bean.Book;
import com.Mylibrary.Librarymanagement.Bean.LoanRecord;
import com.Mylibrary.Librarymanagement.Bean.Student;
import com.Mylibrary.Librarymanagement.Exception.BookRemainingZeroException;
import com.Mylibrary.Librarymanagement.Exception.NotFoundIdRentalBookException;
import com.Mylibrary.Librarymanagement.Service.Book.IBookService;
import com.Mylibrary.Librarymanagement.Service.LoanRecord.ILoanRecordService;
import com.Mylibrary.Librarymanagement.Service.Student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ILoanRecordService loanRecordService;

    @Autowired
    private IStudentService studentService;

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
//        return modelAndView;
        return new ModelAndView("redirect:/books");
    }

    @GetMapping("/books")
    public ModelAndView listBooks() {
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("view/book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/edit-book/{bookId}")
    public ModelAndView showEditForm(@PathVariable Integer bookId) {
        Optional<Book> book = bookService.findById(bookId);
        if (book.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("view/book/edit");
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
        ModelAndView modelAndView = new ModelAndView("view/book/edit");
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", "Book updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-book/{bookId}")
    public ModelAndView showDeleteForm(@PathVariable Integer bookId) {
        Optional<Book> book = bookService.findById(bookId);
        if (book.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("view/book/delete");
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
