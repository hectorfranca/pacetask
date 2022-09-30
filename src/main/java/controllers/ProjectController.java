/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionFactory;

/**
 *
 * @author Héctor França
 */
public class ProjectController {

    public ProjectController() {

    }

    public void save(Project project) throws SQLException {
        String sql = "INSERT INTO project ("
                + "name, description, creation_date, update_date) "
                + "VALUES (?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setTimestamp(3, new Timestamp(project.getCreationDate().getTime()));
            statement.setTimestamp(4, new Timestamp(project.getUpdateDate().getTime()));

            statement.execute();
        } catch (SQLException exception) {
            throw new SQLException("Erro ao criar o projeto: "
                    + exception.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void update(Project project) throws SQLException {
        String sql = "UPDATE project SET "
                + "name = ?,"
                + "description = ?,"
                + "creation_date = ?,"
                + "update_date = ?"
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setTimestamp(3, new Timestamp(project.getCreationDate().getTime()));
            statement.setTimestamp(4, new Timestamp(project.getUpdateDate().getTime()));
            statement.setInt(5, project.getId());

            statement.execute();
        } catch (SQLException exception) {
            throw new SQLException("Erro ao atualizar o projeto: "
                    + exception.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeById(int id) throws SQLException {
        String sql = "DELETE FROM project WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException exception) {
            throw new SQLException("Erro ao deletar o projeto: "
                    + exception.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Project> getAll() throws SQLException {
        String sql = "SELECT * FROM project";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        ArrayList<Project> projects = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                Project project = new Project();

                project.setId(result.getInt("id"));
                project.setName(result.getString("name"));
                project.setDescription(result.getString("description"));
                project.setCreationDate(result.getTimestamp("creation_date"));
                project.setUpdateDate(result.getTimestamp("update_date"));

                projects.add(project);
            }
        } catch (SQLException exception) {
            throw new SQLException("Erro ao recuperar os projetos: "
                    + exception.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement, result);
        }

        return projects;
    }

}
