package com.example.myapplication.model;

import com.example.myapplication.firebaseHelper.NodeCreator;
import com.google.firebase.database.DatabaseReference;

public class GroupDao {
        private DatabaseReference databaseReference ;
    public GroupDao(){
        NodeCreator nodeCreator = new NodeCreator("groups");
        this.databaseReference=nodeCreator.getDatabaseReference();
    }

        public void registerStudent(Group group){
        String id = databaseReference.push().getKey();
        group.setGroupId(id);

        databaseReference.child(id).setValue(group);

    }

    }
