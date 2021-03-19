package com.StudentLibrary.Studentlibrary.Model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionId= UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn
    private Card card;

    private int fineAmount;

    @ManyToOne
    @JoinColumn
    private Book book;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean isIssueOperation;

    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @CreationTimestamp
    private Date transactionDate;

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Boolean getIssueOperation() {
        return isIssueOperation;
    }

    public void setIssueOperation(Boolean issueOperation) {
        isIssueOperation = issueOperation;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
