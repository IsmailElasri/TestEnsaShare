package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class signup1teacher extends AppCompatActivity {

    private ImageView imagelistlevels;
    private ImageView imagenext;
    private ImageView imageback;
    public TextView textlist;
    private Intent i;
    static String level;
    static Dialog dialog;
    private CheckBox checkboxGI1;
    private CheckBox checkboxGI2;
    private CheckBox checkboxGI3;
    private ImageView imagenextd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1teacher);


        //INSTANCIATION
        dialog = new Dialog(this);
        textlist = (TextView) findViewById(R.id.listtextteacher);
        imagelistlevels = (ImageView) findViewById(R.id.listlevelsteacherImage);
        imagenext = (ImageView) findViewById(R.id.nextsignup2teacherImage);
        imageback = (ImageView) findViewById(R.id.backmainteacherImage);

        //EVENTS

        imagenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(), signupteacher2.class);
                startActivity(i);

            }
        });

        imageback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

            }
        });

        textlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUp();
            }
        });
    }


    public void showPopUp(){

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.activity_pop_up_listlevelsteacher);

        checkboxGI1 = (CheckBox) dialog.findViewById(R.id.GI1checkbox);
        checkboxGI2 = (CheckBox) dialog.findViewById(R.id.GI2checkbox);
        checkboxGI3 = (CheckBox) dialog.findViewById(R.id.GI3checkbox);
        imagenextd = (ImageView) dialog.findViewById(R.id.nextlevelshooseteacher);
        level="GI1";
/*
        checkboxGI1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkboxGI1.setBackgroundResource(R.drawable.rounded_button);
                checkboxGI1.setTypeface(null, Typeface.BOLD);
                checkboxGI1.setTextColor(Color.parseColor("#000000"));
                checkboxGI2.setBackgroundColor(Color.parseColor("#E8E8E6"));
                checkboxGI2.setTypeface(null, Typeface.NORMAL);
                checkboxGI2.setTextColor(Color.parseColor("#6B6969"));
                checkboxGI3.setBackgroundColor(Color.parseColor("#E8E8E6"));
                checkboxGI3.setTypeface(null, Typeface.NORMAL);
                checkboxGI3.setTextColor(Color.parseColor("#6B6969"));
                level="GI1";

            }});
        checkboxGI2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkboxGI2.setBackgroundResource(R.drawable.rounded_button);
                checkboxGI2.setTypeface(null, Typeface.BOLD);
                checkboxGI2.setTextColor(Color.parseColor("#000000"));
                checkboxGI1.setBackgroundColor(Color.parseColor("#E8E8E6"));
                checkboxGI1.setTypeface(null, Typeface.NORMAL);
                checkboxGI1.setTextColor(Color.parseColor("#6B6969"));
                checkboxGI3.setBackgroundColor(Color.parseColor("#E8E8E6"));
                checkboxGI3.setTypeface(null, Typeface.NORMAL);
                checkboxGI3.setTextColor(Color.parseColor("#6B6969"));
                level="GI2";
            }});
        checkboxGI3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkboxGI3.setBackgroundResource(R.drawable.rounded_button);
                checkboxGI3.setTypeface(null, Typeface.BOLD);
                checkboxGI3.setTextColor(Color.parseColor("#000000"));
                checkboxGI2.setBackgroundColor(Color.parseColor("#E8E8E6"));
                checkboxGI2.setTypeface(null, Typeface.NORMAL);
                checkboxGI2.setTextColor(Color.parseColor("#6B6969"));
                checkboxGI1.setBackgroundColor(Color.parseColor("#E8E8E6"));
                checkboxGI1.setTypeface(null, Typeface.NORMAL);
                checkboxGI1.setTextColor(Color.parseColor("#6B6969"));
                level="GI3";
            }});

        imagenextd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textlist.setText(level);
                dialog.dismiss();

            }
        });
*/

        dialog.show();
    }


}
