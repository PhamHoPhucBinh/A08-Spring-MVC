package com.Mylibrary.Librarymanagement.Controller;

import com.Mylibrary.Librarymanagement.Bean.Book;
import com.Mylibrary.Librarymanagement.Bean.LoanRecord;
import com.Mylibrary.Librarymanagement.Bean.Student;
import com.Mylibrary.Librarymanagement.Exception.BookRemainingZeroException;
import com.Mylibrary.Librarymanagement.Exception.NotFoundIdRentalBookException;
import com.Mylibrary.Librarymanagement.Service.Book.IBookService;
import com.Mylibrary.Librarymanagement.Service.LoanRecord.ILoanRecordService;
import com.Mylibrary.Librarymanagement.Service.Student.IStudentService;
import com.Mylibrary.Librarymanagement.dto.LoanRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
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

    @GetMapping("/loan-form/{bookId}")
    public ModelAndView showLoanForm(@PathVariable Integer bookId) {
        ModelAndView modelAndView = new ModelAndView("view/loan/loan-form");
        LoanRecordDTO loanRecordDTO = new LoanRecordDTO();
        loanRecordDTO.setBook(bookId);
//        if(loanRecord.isPresent()){
//            modelAndView.addObject("loanRecord", loanRecord.get());
//        }
        modelAndView.addObject("loanRecordDTO", loanRecordDTO);
        return modelAndView;
    }

    @GetMapping("/loan-details/{bookId}")
    public ModelAndView loanDetails(@PathVariable Integer bookId) {
        Optional<LoanRecord> loanRecords = loanRecordService.findByBookId(bookId);
        ModelAndView modelAndView = new ModelAndView("view/loan/loan-details");
        modelAndView.addObject("loanRecords", loanRecords.orElse(null));
        return modelAndView;
    }

    @PostMapping("/loanRecord")
    public String loanRecord(@ModelAttribute("loanRecordDTO") LoanRecordDTO loanRecordDTO) throws Exception {

        Student student = studentService.findById(loanRecordDTO.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        Book book = bookService.findById(loanRecordDTO.getBook())
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        LoanRecord loanRecord = new LoanRecord();
        loanRecord.setStudent(student);
        loanRecord.setBook(book);
        Instant borrowInstant = Instant.now();
        loanRecord.setLoanDate(Date.from(borrowInstant));
        book.setRemaining(true);
        Date returnDate = new SimpleDateFormat("yyyy-MM-dd").parse(loanRecordDTO.getReturnDate());
        loanRecord.setReturnDate(returnDate);
        loanRecordService.save(loanRecord);
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping(value = "/giveBack/{id}")
    public String giveBack(@PathVariable("id") Integer id) throws Exception {
        LoanRecord loanRecord = loanRecordService.findById(id).get();

        Book book = loanRecord.getBook();
        book.setRemaining(false);
        bookService.save(book);

//        loanRecordService.remove(loanRecord.getLoanId());
        return "redirect:/books";
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
