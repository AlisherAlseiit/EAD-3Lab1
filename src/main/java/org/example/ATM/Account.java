package org.example.ATM;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Account {
    private  int id;
    private double balance;
    private String name;
    private String pin;
    private String cardNumber;

    public double getBalance() {
        return balance;
    }

    // IOC
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    // IOC
    public void setName(String name) {
        this.name = name;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public String getPin() {
        return pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setCardNum(String cardNum) {
        this.cardNumber = cardNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
