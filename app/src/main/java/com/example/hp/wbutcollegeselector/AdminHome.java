package com.example.hp.wbutcollegeselector;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.hp.wbutcollegeselector.R.id.SLB;
import static com.example.hp.wbutcollegeselector.R.id.UpdateCollegeDetails;

public class AdminHome extends AppCompatActivity {
private TextView adname,adusername,ademail;
    private Button adminlogoutbtn,addnewcollege,updatecollegedeatails,allocatecollege;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        adname=(TextView) findViewById(R.id.adname);
        adusername=(TextView) findViewById(R.id.adusername);
        ademail=(TextView) findViewById(R.id.ademail);
        adminlogoutbtn=(Button)findViewById(R.id.admin_logout_button);
        addnewcollege=(Button)findViewById(R.id.AddNewCollege);
        updatecollegedeatails=(Button)findViewById(R.id.UpdateCollegeDetails);
        allocatecollege=(Button)findViewById(R.id.AllocateCollege);
        Intent i=getIntent();
        Admin a1=(Admin) i.getSerializableExtra("useradmin");
        adname.setText(a1.getName());
        ademail.setText(a1.getEmail());
        adusername.setText("admin1");
        progressDialog = new ProgressDialog(AdminHome.this);
        progressDialog.setCancelable(false);
        adminlogoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //progressDialog.setMessage("Logging Out...");
                Intent i=new Intent(AdminHome.this,MainActivity.class);
                startActivity(i);
            }
        });
        addnewcollege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdminHome.this,Add_College.class);
                Intent i2=getIntent();
                Admin a1=(Admin) i2.getSerializableExtra("useradmin");

                Admin a2=new Admin(a1.getName(),a1.getEmail());
                i.putExtra("useradmin", a2);
                startActivity(i);
            }
        });
        updatecollegedeatails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdminHome.this,UpdateCollegeDetails.class);
                Intent i2=getIntent();
                Admin a1=(Admin) i2.getSerializableExtra("useradmin");

                Admin a2=new Admin(a1.getName(),a1.getEmail());
                i.putExtra("useradmin", a2);
                startActivity(i);
            }
        });

    }
}
