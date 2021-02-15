package org.example.ATM;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestPring {
    private static Account account;
    private static Boolean bool = true;
    private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    private static double count;

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        ATM atm = context.getBean("ATM", ATM.class);
       DBConnection dbConnection = context.getBean("db", DBConnection.class);
        String pin = atm.enterPincode();


        Bank bank = context.getBean("bank", Bank.class);
         account = bank.CheckPincode(pin);



        while (bool) {
            System.out.println("Name:" + account.getName());
            String choice = atm.chooseOption();

            switch (choice){
                case "1":
                    System.out.println(account.getBalance());
                break;
                case "2":

                       System.out.println("Enter count");
                       count = Double.parseDouble(read.readLine());
                    if  (account.getBalance() >= count) {
                       account.withdraw(count);
                        dbConnection.update(account.getId(), account);
                   }else {
                       System.out.println("Not enough money to withdraw");
                   }
                    break;
                case "3":
                    System.out.println("Enter count");
                     count =  Double.parseDouble(read.readLine());
                     account.deposit(count);
                    dbConnection.update(account.getId(), account);
                     break;
                case "4":

                default:
                    System.out.println("Good Bye!");
                    bool = false;
            }
        }

        context.close();

    }
}
