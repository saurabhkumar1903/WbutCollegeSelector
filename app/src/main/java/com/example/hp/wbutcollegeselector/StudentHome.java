package com.example.hp.wbutcollegeselector;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StudentHome extends AppCompatActivity {
private TextView stname,stusername,stemail,stwbroll,stwbrank;
    private ProgressDialog progressDialog;
    private Button Studentlogoutbutton,fillcollegechoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
        stname=(TextView) findViewById(R.id.stname);
        stusername=(TextView) findViewById(R.id.stusername);
        stwbroll=(TextView) findViewById(R.id.stwbroll);
        stwbrank=(TextView) findViewById(R.id.stwbrank);
        stemail=(TextView) findViewById(R.id.stemail);

        Studentlogoutbutton=(Button)findViewById(R.id.Student_logout_button);
        fillcollegechoice=(Button)findViewById(R.id.Fill_your_College_Choice);
        Intent i=getIntent();
        Student s1=(Student)i.getSerializableExtra("user");
        stname.setText(s1.getName());
        stusername.setText(s1.getUsername());
        stwbroll.setText(s1.getWbroll());

        Log.i("sru name",s1.getName());
        Log.i("wbrank##############3",s1.getWbroll());
        stwbrank.setText(s1.getWbrank());
        stemail.setText(s1.getEmail());

        progressDialog = new ProgressDialog(StudentHome.this);
        progressDialog.setCancelable(false);
        Studentlogoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //progressDialog.setMessage("Logging Out...");
                Intent i=new Intent(StudentHome.this,MainActivity.class);
                startActivity(i);
            }
        });

        fillcollegechoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StudentHome.this,FillCollegeChoice.class);
                Student s1=(Student)i.getSerializableExtra("user");
                i.putExtra("user", s1);
                startActivity(i);
            }
        });

    }
}
