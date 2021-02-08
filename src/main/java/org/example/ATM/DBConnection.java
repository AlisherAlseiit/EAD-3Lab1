package org.example.ATM;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static final String URL = "jdbc:postgresql://localhost:5433/ATM_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123456";
    private static Connection connection;
    private static List<Account> accounts;
    static {
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
    }




    private List<Account> getInit(){
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

        return accounts;
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





    private void getDestroy() throws SQLException {

        accounts.clear();
        connection.close();

    }

    public static List<Account> getAccounts() {
        return accounts;
    }

}
