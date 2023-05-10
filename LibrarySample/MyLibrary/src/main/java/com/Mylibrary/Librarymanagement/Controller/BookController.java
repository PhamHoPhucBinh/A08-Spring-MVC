package com.Mylibrary.Librarymanagement.Controller;

import com.Mylibrary.Librarymanagement.Bean.Book;
import com.Mylibrary.Librarymanagement.Bean.LoanRecord;
import com.Mylibrary.Librarymanagement.Exception.BookRemainingZeroException;
import com.Mylibrary.Librarymanagement.Exception.NotFoundIdRentalBookException;
import com.Mylibrary.Librarymanagement.Service.Book.IBookService;
import com.Mylibrary.Librarymanagement.Service.LoanRecord.ILoanRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ILoanRecordService loanRecordService;

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

    @GetMapping(value = "/loanRecord/{bookId}")
    public String loanRecord(@PathVariable Integer bookId) throws Exception {
        Optional<Book> book = bookService.findById(bookId);
        if (book.get().isRemaining() == true) {
            throw new BookRemainingZeroException();
        }
        Book book1 = book.get();
        LoanRecord loanRecord = new LoanRecord();
        int idLoanRecord = (int) (Math.random() * 100000);
        loanRecord.setLoanId(idLoanRecord);
        loanRecord.setBook(book1);
        loanRecordService.save(loanRecord);
        book1.setRemaining(false);
        bookService.save(book1);
        return "redirect:/show";
//        return "redirect:/home";
    }

    @GetMapping(value = "/giveBack")
    public String giveBack(@RequestParam("idLoanRecord") Integer loanId) throws Exception {
        LoanRecord loanRecord = loanRecordService.findById(loanId).get();
        if (loanRecord == null) {
            throw new NotFoundIdRentalBookException();
        }
        Book book = loanRecord.getBook();
        loanRecordService.remove(loanId);
        book.setRemaining(true);
        bookService.save(book);
        return "redirect:/show";
//        return "redirect:/home";
    }

    @ExceptionHandler(BookRemainingZeroException.class)
    public String showErrorPage() {
        return "error";
    }

    @ExceptionHandler(NotFoundIdRentalBookException.class)
    public String showErrorNotFoundPage() {
        return "error";
    }
}
