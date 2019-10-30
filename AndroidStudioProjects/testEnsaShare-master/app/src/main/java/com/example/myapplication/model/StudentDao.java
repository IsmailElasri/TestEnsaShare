package com.example.myapplication.model;

import com.example.myapplication.firebaseHelper.NodeCreator;
import com.google.firebase.database.DatabaseReference;

public class StudentDao {
    private DatabaseReference databaseReference ;
    public StudentDao() {
        NodeCreator nodeCreator = new NodeCreator("students");
        this.databaseReference=nodeCreator.getDatabaseReference();
    }

    public void registerStudent(Student s){
        String id = databaseReference.push().getKey();
        s.setStudentId(id);

         databaseReference.child(id).setValue(s);

    }

}
