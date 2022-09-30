/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Héctor França
 */
public class ConnectionFactory {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException exception) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: "
                    + exception.getMessage());
        }
    }

    public static void closeConnection(Connection connection,
            PreparedStatement statement) throws SQLException {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException exception) {
            throw new SQLException("Erro ao fechar a conexão. "
                    + exception.getMessage());
        }
    }

    public static void closeConnection(Connection connection,
            PreparedStatement statement, ResultSet result) throws SQLException {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (result != null) {
                result.close();
            }
        } catch (SQLException exception) {
            throw new SQLException("Erro ao fechar a conexão. "
                    + exception.getMessage());
        }
    }

}
