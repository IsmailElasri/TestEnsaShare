package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.Student;
import com.example.myapplication.model.StudentDao;

public class signupstudent2 extends AppCompatActivity {
    private ImageView imagebacksignup1;
    private Intent intent;
    private EditText username ;
    private EditText password ;
    private EditText passwordConfimed;
    private Button submit ;
    private StudentDao studentdao;
    private Student  student ;



    public void init(){
        username =(EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        passwordConfimed = (EditText) findViewById(R.id.passwordconfirmed);
        submit = (Button) findViewById(R.id.submit);
        studentdao  = new StudentDao() ;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupstudent2);
        init();

        Intent i = getIntent();
        student = (Student) i.getSerializableExtra("student");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString().equals(passwordConfimed.getText().toString())){

                  student.setUserName(username.getText().toString());
                  student.setPassword(password.getText().toString());

                  studentdao.registerStudent(student);

                  Toast.makeText(signupstudent2.this,student.toString(), Toast.LENGTH_LONG).show();


                }else{

                    Toast.makeText(signupstudent2.this,"passwords don t match ", Toast.LENGTH_LONG).show();
                }




            }
        });


        imagebacksignup1 = (ImageView) findViewById(R.id.backsignup1Image);
        imagebacksignup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), signup1.class);
                startActivity(intent);

            }
        });
    }

}

