package org.example.ATM;

public class Account {
    private double balance;
    private String name;
    private String pin;
    private String cardNum;

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

    public String getCardNum() {
        return cardNum;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }
}
