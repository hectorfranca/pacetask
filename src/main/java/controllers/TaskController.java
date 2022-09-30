/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Task;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import util.ConnectionFactory;

/**
 *
 * @author Héctor França
 */
public class TaskController {

    public TaskController() {

    }

    public void save(Task task) throws SQLException {
        String sql = "INSERT INTO task ("
                + "project_id, name, description, completed, notes, deadline, "
                + "creation_date, update_date) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, task.getProjectId());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setTimestamp(7, new Timestamp(task.getCreationDate().getTime()));
            statement.setTimestamp(8, new Timestamp(task.getUpdateDate().getTime()));

            statement.execute();
        } catch (SQLException exception) {
            throw new SQLException("Erro ao criar a tarefa: "
                    + exception.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void update(Task task) throws SQLException {
        String sql = "UPDATE task SET "
                + "project_id = ?,"
                + "name = ?,"
                + "description = ?,"
                + "completed = ?,"
                + "notes = ?,"
                + "deadline = ?,"
                + "creation_date = ?,"
                + "update_date = ? "
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, task.getProjectId());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setTimestamp(7, new Timestamp(task.getCreationDate().getTime()));
            statement.setTimestamp(8, new Timestamp(task.getUpdateDate().getTime()));
            statement.setInt(9, task.getId());

            statement.execute();
        } catch (SQLException exception) {
            throw new SQLException("Erro ao atualizar a tarefa: "
                    + exception.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeById(int id) throws SQLException {
        String sql = "DELETE FROM task WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException exception) {
            throw new SQLException("Erro ao deletar a tarefa: "
                    + exception.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Task> getAll(int projectId) throws SQLException {
        String sql = "SELECT * FROM task WHERE project_id = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        ArrayList<Task> tasks = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, projectId);
            result = statement.executeQuery();

            while (result.next()) {
                Task task = new Task();

                task.setId(result.getInt("id"));
                task.setProjectId(result.getInt("project_id"));
                task.setName(result.getString("name"));
                task.setDescription(result.getString("description"));
                task.setCompleted(result.getBoolean("completed"));
                task.setNotes(result.getString("notes"));
                task.setDeadline(result.getDate("deadline"));
                task.setCreationDate(result.getTimestamp("creation_date"));
                task.setUpdateDate(result.getTimestamp("update_date"));

                tasks.add(task);
            }
        } catch (SQLException exception) {
            throw new SQLException("Erro ao deletar a tarefa: "
                    + exception.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement, result);
        }

        return tasks;
    }

}
