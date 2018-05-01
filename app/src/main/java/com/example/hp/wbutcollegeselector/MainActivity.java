package com.example.hp.wbutcollegeselector;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button signup, login;
        final Spinner spinner;
        login = (Button) findViewById(R.id.btnlogin);
        signup = (Button) findViewById(R.id.btnsignup);
        spinner = (Spinner) findViewById(R.id.UserSelectSpinner);






            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String SelectedUser=(String)spinner.getSelectedItem();
                    //Log.i("SElecteduser",SelectedUser);
                    if(SelectedUser.equals("Admin"))
                    {
                       Intent i=new Intent(MainActivity.this,AdminLogin.class);
                        startActivity(i);

                    }
                    else {
                        Intent i = new Intent(MainActivity.this, StudentLogin.class);
                        startActivity(i);
                    }
                }
            });


            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String SelectedUser=(String)spinner.getSelectedItem();
                    //Log.i("SElecteduser",SelectedUser);
                    if(SelectedUser.equals("Admin"))
                    {
                        Intent i=new Intent(MainActivity.this,AdminSignup.class);
                        startActivity(i);
                    }
                    else {
                        Intent i = new Intent(MainActivity.this, StudentSignup.class);
                        startActivity(i);
                    }

                }
            });

    }
}
