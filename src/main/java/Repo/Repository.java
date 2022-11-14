package Repo;


import Client.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private Class<T> clz;

    public Repository(Class<T> clz) {
        this.clz = clz;
    }//connection for a table

    public static List<User> ConnectionToSQL() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_ex", "root", "1234");
            Statement stmt = con.createStatement();


            ResultSet rs = stmt.executeQuery("select * from users");
            List<User> results = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setMoney_balance(rs.getInt("money_balance"));

                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) +
                        "  " + rs.getInt(5));
                results.add(user);
            }
            con.close();
            return results;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void insertUser() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_ex", "root", "1234");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO Users " + "VALUES (4, 'haitham@gmail.com','Haitham', 'haitham1234', 4000 )");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void deleteUser() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_ex", "root", "1234");
            Statement stmt = con.createStatement();
            String query = "delete from  Users " +
                    "where id = 4";
            stmt.executeUpdate(query);

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void updateUser() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_ex", "root", "1234");
            Statement stmt = con.createStatement();
            String query = "update Users set Name ='Mohammad' " + "where id = 1";
            stmt.executeUpdate(query);

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public static <T> List<T> ConnectionToSQLGen(Class<T> clz) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "root");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(String.format("select * from %s", clz.getSimpleName().toLowerCase()));
            List<T> results = new ArrayList<>();
            while (rs.next()) {
                Constructor<T> constructor = clz.getConstructor(null);
                T item = constructor.newInstance();
                Field[] declaredFields = clz.getDeclaredFields();
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    field.set(item, rs.getObject(field.getName()));
                }

                results.add(item);
            }
            con.close();
            return results;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}

    //Read

    //read all item from the table
    //get one item by id
    //Get item(s) by any property

    //Add

    //insert one item to table
    //insert multiple items to table

    //update

    //update one property for item by an id
    //update entire item//

    //Delete

    //delete Single item deletion by any property (delete user with email x)
    //delete Multiple item deletion by any property (delete all users called x)
    //Delete entire table (truncate)


    //Table Creation

    //the rest


