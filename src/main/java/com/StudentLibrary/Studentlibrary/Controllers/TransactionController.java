package com.StudentLibrary.Studentlibrary.Controllers;

import com.StudentLibrary.Studentlibrary.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;


    //what i need ideally is card_id and book_id

    @PostMapping("/issueBook")
    public ResponseEntity issueBook(@RequestParam(value = "cardId") int cardId,
                                    @RequestParam("bookId")int bookId) throws Exception {
        String transaction_id=transactionService.issueBooks(cardId,bookId);
        return new ResponseEntity("Your Transaction was successfull here is your Txn id:"+transaction_id, HttpStatus.OK);

    }
    @PostMapping("/returnBook")
    public ResponseEntity returnBook(@RequestParam("cardId") int cardId,
                                     @RequestParam("bookId") int bookId) throws Exception {
        String transaction_id=transactionService.returnBooks(cardId,bookId);
        return new ResponseEntity(
                "Your Transaction was Successful here is your Txn id:"+transaction_id,HttpStatus.OK);

    }
}
