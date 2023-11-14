package javaee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

public class ManyToMany extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_ee_db",
                    "postgres", "postgresql");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT authors.name, books.title FROM authors" +
                    " JOIN authors_books ON authors.authors_id = authors_books.authors_id\n" +
                    "JOIN books ON authors_books.books_id = books.books_id");

            while (resultSet.next()) {
                System.out.print(resultSet.getString("title") + " : ");
                System.out.println(resultSet.getString("name"));
            }

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
