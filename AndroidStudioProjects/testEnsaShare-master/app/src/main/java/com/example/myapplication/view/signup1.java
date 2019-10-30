package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.Student;

public class signup1 extends AppCompatActivity{

    private EditText  firstName ;
    private EditText  lastName ;
    private ImageView imagenext;
    private ImageView imageback;
    private Intent i;
    private Spinner levelSpinner;
    private Student student;


    public void init(){
        firstName =(EditText) findViewById(R.id.firstname);
        lastName = (EditText) findViewById(R.id.lastname);
        imagenext = (ImageView) findViewById(R.id.nextsignup2Image);
        imageback = (ImageView) findViewById(R.id.backmainImage);
        student = new Student();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);
        init();
        levelSpinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.levels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        levelSpinner.setAdapter(adapter);
        levelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                student.setLevel(parent.getItemAtPosition(position).toString());
                Toast.makeText(signup1.this, student.getLevel(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        imagenext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                student.setFirstName(firstName.getText().toString());
                student.setLastName(lastName.getText().toString());

                // Toast.makeText(signup1.this,student.toString(),Toast.LENGTH_LONG).show();
                i = new Intent(signup1.this, signupstudent2.class);

                i.putExtra("student",student);
                startActivity(i);
            }


        });


        imageback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

    }
}