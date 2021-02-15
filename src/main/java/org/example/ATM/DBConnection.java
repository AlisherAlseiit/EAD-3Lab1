package org.example.ATM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component("db")
@Scope("singleton")
public class DBConnection {

    @Value("${dataConnection.URL}")
    private  String URL;
    @Value("${dataConnection.USERNAME}")
    private  String USERNAME;
    @Value("${dataConnection.PASSWORD}")
    private  String PASSWORD;
    private static Connection connection;
    private static List<Account> accounts;




    @PostConstruct
    private void getInit(){

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        accounts = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Account";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){

                Account account = new Account();

                account.setId(resultSet.getInt("id"));
                account.setName(resultSet.getString("name"));
                account.setCardNum(resultSet.getString("cardNumber"));
                account.setPin(resultSet.getString("pin"));
                account.setBalance(resultSet.getDouble("balance"));

                accounts.add(account);

            }
            System.out.println("initialization db");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void update(int id, Account updatedAccount){

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Account SET name=?, cardNumber=?, pin=?, balance=?  WHERE id=?");

            preparedStatement.setString(1, updatedAccount.getName());
            preparedStatement.setString(2, updatedAccount.getCardNumber());
            preparedStatement.setString(3,updatedAccount.getPin());
            preparedStatement.setDouble(4,updatedAccount.getBalance());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }





    @PreDestroy
    private void getDestroy() throws SQLException {

        accounts.clear();
        connection.close();

    }

    public static List<Account> getAccounts() {
        return accounts;
    }

}
