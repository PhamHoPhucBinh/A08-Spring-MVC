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
public class LoanController {


    @Autowired
    private IBookService bookService;
    @Autowired
    private ILoanRecordService loanRecordService;

    @Autowired
    private IStudentService studentService;

    //    @PostMapping(value = "/loanRecord/{bookId}")
//    public String loanRecord(@PathVariable Integer bookId,
//                             @RequestParam Integer studentId,
//                             @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date returnDate) throws Exception {
//
//        Student student = studentService.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));
//        Optional<Book> book = bookService.findById(bookId);
//        if (book.get().isRemaining() == true) {
//            throw new BookRemainingZeroException();
//        }
//        Book book1 = book.get();
//        LoanRecord loanRecord = new LoanRecord();
//        int idLoanRecord = (int) (Math.random() * 100000);
//        LocalDate borrowDate = LocalDate.now();
//        Instant instant = borrowDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
//        Date date = Date.from(instant);
//        loanRecord.setLoanDate(date);
//        loanRecord.setLoanId(idLoanRecord);
//        loanRecord.setReturnDate(returnDate);
//        loanRecord.setBook(book1);
//        loanRecordService.save(loanRecord);
//        book1.setRemaining(false);
//        bookService.save(book1);
//        return "redirect:/books";
//    }
    @GetMapping("/loan-form/{bookId}")
    public ModelAndView showLoanForm(@PathVariable Integer bookId) {
        Optional<LoanRecord> loanRecord = loanRecordService.findById(bookId);
        ModelAndView modelAndView = new ModelAndView("view/loan/loan-form");
        if(loanRecord.isPresent()){
            modelAndView.addObject("loanRecord", loanRecord.get());
        }
        return modelAndView;
    }


    @PostMapping( "/loanRecord/{bookId}")
    public String loanRecord(@PathVariable Integer bookId,
                             @RequestParam Integer studentId,
                             @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date returnDate) throws Exception {

        Student student = studentService.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        Book book = bookService.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        if (!book.isRemaining()) {
            throw new BookRemainingZeroException("All copies of the book are already borrowed");
        }

        LoanRecord loanRecord = new LoanRecord();
        loanRecord.setStudent(student);
        loanRecord.setBook(book);

        Instant borrowInstant = Instant.now();
        loanRecord.setLoanDate(Date.from(borrowInstant));

        loanRecord.setReturnDate(returnDate);
        loanRecordService.save(loanRecord);

        book.setRemaining(false);
        bookService.save(book);

        return "redirect:/books";
    }


//    @GetMapping("/loan-details")
//    public ModelAndView loanDetails

//
//    @GetMapping(value = "/giveBack")
//    public String giveBack(@RequestParam("idLoanRecord") Integer loanId) throws Exception {
//        LoanRecord loanRecord = loanRecordService.findById(loanId).get();
//        if (loanRecord == null) {
//            throw new NotFoundIdRentalBookException();
//        }
//        Book book = loanRecord.getBook();
//        loanRecordService.remove(loanId);
//        book.setRemaining(true);
//        bookService.save(book);
//        return "redirect:/show";
////        return "redirect:/home";
//    }

    @ExceptionHandler(BookRemainingZeroException.class)
    public String showErrorPage() {
        return "error";
    }

    @ExceptionHandler(NotFoundIdRentalBookException.class)
    public String showErrorNotFoundPage() {
        return "error";
    }


}
