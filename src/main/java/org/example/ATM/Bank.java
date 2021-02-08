package org.example.ATM;

import java.util.ArrayList;
import java.util.List;

public class Bank {


    private List<Account> accounts = new ArrayList<>();

    private  DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public Account CheckPincode(String pinCode) throws Exception {

        accounts = dbConnection.getAccounts();

        for (Account x : accounts) {
            if (x.getPin().equals(pinCode)) {
                return x;
            }

        }


        throw new Exception(  "Access Denied! wrong pin code");
    }

}
