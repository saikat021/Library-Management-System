package com.StudentLibrary.Studentlibrary.Model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Card {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToOne(mappedBy = "card",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Student student;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(value=EnumType.STRING)
    private CardStatus cardStatus;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Book> books;



    public Card(){
        this.cardStatus=CardStatus.ACTIVATED;
    }


    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
