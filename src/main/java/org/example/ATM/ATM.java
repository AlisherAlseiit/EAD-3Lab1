package org.example.ATM;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@Scope("singleton")
public class ATM {
    private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));



    public String enterPincode() throws IOException {
        System.out.println("Welcome");
        System.out.println("Please enter pin code ");
        String pin = read.readLine();
        return pin;
    }

    public String chooseOption( ) throws IOException {

        System.out.println("Main menu");
        System.out.println("1 - View my balance");
        System.out.println("2 - Withdraw cash");
        System.out.println("3 - Deposit money");
        System.out.println("4 - Exit");
        System.out.println("Enter choice:");
        String choice = read.readLine();

        return choice;
    }
}
