package org.example.ATM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class Bank {


    private List<Account> accounts = new ArrayList<>();

    private  DBConnection dbConnection;

    @Autowired
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
