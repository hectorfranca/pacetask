/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Héctor França
 */
public class Task {

    private int id;
    private int projectId;
    private String name;
    private String description;
    private boolean completed;
    private String notes;
    private Date deadline;
    private Date creationDate;
    private Date updateDate;

    public Task() {

    }

    public Task(int projectId, String name, boolean completed, Date deadline) {
        this.projectId = projectId;
        this.name = name;
        this.completed = completed;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", projectId=" + projectId
                + ", name=" + name + ", description=" + description
                + ", completed=" + completed + ", notes=" + notes
                + ", deadline=" + deadline + ", creationDate=" + creationDate
                + ", updateDate=" + updateDate + '}';
    }

}
