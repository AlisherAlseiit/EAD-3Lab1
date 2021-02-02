package org.example.ATM;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private static List<String> cardPins;
    private List<Account> accounts = new ArrayList<>();


    static {
        cardPins = new ArrayList<>();
        cardPins.add("3415");
        cardPins.add("1234");
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Account CheckPincode(String pinCode) throws Exception {

        for (Account x : accounts) {
            if (x.getPin().equals(pinCode)) {
                return x;
            }

        }


        throw new Exception(  "Access Denied! wrong pin code");
    }

}
