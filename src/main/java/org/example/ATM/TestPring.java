package org.example.ATM;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        ATM atm = context.getBean("ATM", ATM.class);

        String pin = atm.enterPincode();


        Bank bank = context.getBean("bank", Bank.class);
         account = bank.CheckPincode(pin);

//        System.out.println(account);
//        if (result == "1"){
//             account = context.getBean("account1", Account.class);
//        }else if(result.equals("2")){
//             account = context.getBean("account2", Account.class);
//        }




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
                   }else {
                       System.out.println("Not enough money to withdraw");
                   }
                    break;
                case "3":
                    System.out.println("Enter count");
                     count =  Double.parseDouble(read.readLine());
                     account.deposit(count);
                     break;
                case "4":

                default:
                    System.out.println("Good Bye!");
                    bool = false;
            }
        }



    }
}
