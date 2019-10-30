package com.example.myapplication.model;

import java.io.Serializable;

public class Group implements Serializable {
    private String name;
    private Student[] listStudents;
    private Admin admin;
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Student[] getListStudents() {
        return listStudents;
    }

    public void setListStudents(Student[] listStudents) {
        this.listStudents = listStudents;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
