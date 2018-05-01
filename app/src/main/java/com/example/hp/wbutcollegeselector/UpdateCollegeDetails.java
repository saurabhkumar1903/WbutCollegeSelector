package com.example.hp.wbutcollegeselector;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UpdateCollegeDetails extends AppCompatActivity {
    private Spinner selectStream,collegetype,SelectCollege,SelectState;
    private CheckBox ce, cse, ece, ee, me;
    private static final String TAG = "LoginActivity";
    private static final String URL_FOR_Update_college = "https://userlogs.000webhostapp.com/updateCollege/register.php";
    private static final String URL_FOR_update_stream = "https://userlogs.000webhostapp.com/UpdateStream/register.php";
    private static final String URL_FOR_Fetch_All_College = "https://userlogs.000webhostapp.com/FetchAllCollege/register.php";
    //  ProgressDialog progressDialog;

    private EditText or,cr,collegefacilities,air,swr;
    Button btnsubmit,btnreset,btnaddstream;
    CivilEngineering civilEngineering=new CivilEngineering();
    ComputerScienceEngineering computerScienceEngineering=new ComputerScienceEngineering();
    MechanicalEngineering mechanicalEngineering=new MechanicalEngineering();
    ElectricalEngineering electricalEngineering=new ElectricalEngineering();
    ElectronicsAndCommunicationEngineering electronicsAndCommunicationEngineering;
    String checkedString = "";
    String x,collegename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fetchAllCollege();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_college_details);
        selectStream = (Spinner) findViewById(R.id.SelectStream);
        collegetype = (Spinner) findViewById(R.id.collegeType);
        SelectCollege=(Spinner) findViewById(R.id.SelectCollege);
        SelectState=(Spinner)findViewById(R.id.SelectState);
        ce = (CheckBox) findViewById(R.id.civil);
        cse = (CheckBox) findViewById(R.id.cse);
        ece = (CheckBox) findViewById(R.id.ece);
        ee = (CheckBox) findViewById(R.id.ee);
        me = (CheckBox) findViewById(R.id.me);
        or=(EditText)findViewById(R.id.or);
        cr=(EditText)findViewById(R.id.cr);
        air=(EditText)findViewById(R.id.air);
        swr=(EditText)findViewById(R.id.swr);
        //collegename=(EditText)findViewById(R.id.CollegeNameEt);
        collegefacilities=(EditText)findViewById(R.id.collegefacilities);
        btnsubmit=(Button)findViewById(R.id.AddCollegeSubmit);
        btnreset=(Button)findViewById(R.id.resetcollgesubmit);
        btnaddstream=(Button)findViewById(R.id.AddStreamButton);
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UpdateCollegeDetails.this,UpdateCollegeDetails.class);
                startActivity(i);
            }
        });


        SelectCollege.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

               x= x.replace("[","");
               x= x.replace("]","");
               x= x.replace("\"","");
                final String[] array2 = x.split(",");
                Log.d("collgelist",x);
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(UpdateCollegeDetails.this, android.R.layout.simple_dropdown_item_1line
                        , array2);
                SelectCollege.setAdapter(adapter2);
                SelectCollege.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        collegename=SelectCollege.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                return false;
            }
        });


        selectStream.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                checkedString="";
                if(ce.isChecked())
                {
                    checkedString+=ce.getText().toString();
                    checkedString+=",";
                }
                if(cse.isChecked())
                {
                    checkedString+=cse.getText().toString();
                    checkedString+=",";
                }
                if(ece.isChecked())
                {
                    checkedString+=ece.getText().toString();
                    checkedString+=",";
                }
                if(ee.isChecked())
                {
                    checkedString+=ee.getText().toString();
                    checkedString+=",";
                }
                if(me.isChecked())
                {
                    checkedString+=me.getText().toString();
                    checkedString+=",";
                }

                if(checkedString.equals(""))
                {
                    AlertDialog.Builder alert=new AlertDialog.Builder(UpdateCollegeDetails.this);
                    alert.setMessage("Please check atleast One Checkbox");
                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            Toast.makeText(getApplicationContext(),
                                    "OK",
                                    Toast.LENGTH_LONG)
                                    .show();
                            ce.requestFocus();
                        }});

                    alert.show();
                }

                Log.i("chekcedString", checkedString);

                final String[] array = checkedString.split(",");
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(UpdateCollegeDetails.this, android.R.layout.simple_dropdown_item_1line
                        , array);
                selectStream.setAdapter(adapter);
                selectStream.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String value = array[position];
                        btnaddstream.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String selstream="";
                                if(selectStream.getSelectedItem().toString().equals("C.S.E."))
                                    selstream="Computer Science";
                                else if(selectStream.getSelectedItem().toString().equals("E.C.E."))
                                    selstream="Electronics And Communication";
                                else if(selectStream.getSelectedItem().toString().equals("M.E."))
                                    selstream="Mechanical Engineering";
                                else if(selectStream.getSelectedItem().toString().equals("C.E."))
                                    selstream="Civil Engineering";
                                else if(selectStream.getSelectedItem().toString().equals("E.E."))
                                    selstream="Electrical Engineering";

                                Log.i("data send%%#$#$#",collegename+""+selstream+or.getText().toString()+cr.getText().toString());

                                addcollegestream2(collegename,selstream,or.getText().toString(),cr.getText().toString());

                            }
                        });
                        if (value.equals("C.E.")) {
                            or.setText(civilEngineering.getOpeningRank());
                            cr.setText(civilEngineering.getClosingRank());
                            Log.i("Ce OR",or.getText().toString()+"###cr"+ cr.getText().toString());
                            civilEngineering = new CivilEngineering(or.getText().toString(), cr.getText().toString());

                        }
                        if (value.equals("M.E.")) {
                            or.setText(mechanicalEngineering.getOpeningRank());
                            cr.setText(mechanicalEngineering.getClosingRank());
                            Log.i("ME OR",or.getText().toString()+"###cr"+ cr.getText().toString());
                            mechanicalEngineering = new MechanicalEngineering(or.getText().toString(), cr.getText().toString());

                        }
                        if (value.equals("E.E.")) {
                            or.setText(electricalEngineering.getOpeningRank());
                            cr.setText(electricalEngineering.getClosingRank());
                            Log.i("EE OR",or.getText().toString()+"###cr"+ cr.getText().toString());
                            electricalEngineering = new ElectricalEngineering(or.getText().toString(), cr.getText().toString());

                        }
                        if (value.equals("C.S.E.")) {
                            or.setText(computerScienceEngineering.getOpeningRank());
                            cr.setText(computerScienceEngineering.getClosingRank());
                            Log.i("CSe OR",or.getText().toString()+"###cr"+ cr.getText().toString());
                            computerScienceEngineering = new ComputerScienceEngineering(or.getText().toString(), cr.getText().toString());

                        }
                        if (value.equals("E.C.E.")) {
                            or.setText("0");
                            cr.setText("0");
                            Log.i("Ece OR",or.getText().toString()+"###cr"+ cr.getText().toString());
                            electronicsAndCommunicationEngineering = new ElectronicsAndCommunicationEngineering(or.getText().toString(), cr.getText().toString());

                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });



                return false;
            }
        });



        final String[] facilities=collegefacilities.getText().toString().split(",");
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               collegename= SelectCollege.getSelectedItem().toString();
                Log.i("data send toi adllege",collegename+collegetype.getSelectedItem().toString()+collegefacilities.getText().toString()+SelectState.getSelectedItem().toString()+air.getText().toString()+swr.getText().toString());
                CollegeRank rank=new CollegeRank(air.getText().toString(),swr.getText().toString());
                College c=new College(collegename,collegetype.getSelectedItem().toString(),checkedString,civilEngineering,computerScienceEngineering,electricalEngineering,electronicsAndCommunicationEngineering,mechanicalEngineering,collegefacilities.getText().toString(),rank);
                addcollegestream(collegename,collegetype.getSelectedItem().toString(),collegefacilities.getText().toString(),SelectState.getSelectedItem().toString(),air.getText().toString(),swr.getText().toString());
            }
        });
    }


    private void addcollegestream2( final String collegename, final String streamname,final String orank,final String crank) {
        // Tag used to cancel the request
        final String collegeid=collegename.substring(0,8);
        final String streamid=streamname.substring(0,8);
        String cancel_req_tag = "login";
        // progressDialog.setMessage("Logging you in...");
        //  showDialog();
        StringRequest strReq = new StringRequest(Request.Method.POST,
                URL_FOR_update_stream, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
                // hideDialog();
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = false;
                    try {
                        error = jObj.getBoolean("error");
                        Log.i("$$$$",error+"");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if (!error) {
                        Log.i("$$$4","in if ");
                        //String user = jObj.getJSONObject("user").getString("cid");
                        //String email=jObj.getJSONObject("user").getString("sid");
                        //String Collgeadded=jObj.getJSONObject("user").getString("collegename");
                        String streamadded=jObj.getJSONObject("college").getString("strname");
                        String errorMsg = jObj.getString("error_msg");
                        Log.i("$$$$",streamadded);
                        // Launch User activity
                       /* Intent intent = new Intent(
                                Add_College.this,
                                AdminHome.class);
                        Admin a1=new Admin(user,email);
                        intent.putExtra("useradmin", a1);
                        startActivity(intent);
                        finish();*/

                        Toast.makeText(UpdateCollegeDetails.this,streamadded+" Addded Successfully",Toast.LENGTH_LONG).show();
                    } else {
                            Log.i("$$$$","in else");
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                // hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("cid", collegeid);
                params.put("sid", streamid);
                params.put("strname", streamname);
                params.put("orank", orank);
                params.put("crank", crank);


                return params;
            }

        };
        // Adding request to request queue
        AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(strReq,cancel_req_tag);
    }



    private void addcollegestream( final String collegename, final String collegetype,final String collgegefacilities,final String State,final String air,final String swr) {
        // Tag used to cancel the request
        String cancel_req_tag = "login";
        //    progressDialog.setMessage("Logging you in...");
        //   showDialog();
        StringRequest strReq = new StringRequest(Request.Method.POST,
                URL_FOR_Update_college, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
                // hideDialog();
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = false;
                    try {
                        error = jObj.getBoolean("error");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if (!error) {
                       // String Collgeadded=jObj.getJSONObject("user").getString("collegename");
                        String Collegeadded= jObj.getString("collegename");
                        Toast.makeText(UpdateCollegeDetails.this,Collegeadded+" Updated Successfully",Toast.LENGTH_LONG).show();
                        Intent i=new Intent(UpdateCollegeDetails.this,AdminHome.class);
                        Intent i2=getIntent();
                        Admin a1=(Admin) i2.getSerializableExtra("useradmin");

                        Admin a2=new Admin(a1.getName(),a1.getEmail());
                        i.putExtra("useradmin", a2);
                        startActivity(i);
                        // Launch User activity

                        finish();
                    } else {

                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                //  hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("collegename", collegename);
                params.put("collegetype", collegetype);
                params.put("collegefacilities", collgegefacilities);
                params.put("State",State);
                params.put("air", air);
                params.put("swr", swr);


                return params;
            }

        };
        // Adding request to request queue
        AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(strReq,cancel_req_tag);
    }


    void fetchAllCollege()
    {
        // Tag used to cancel the request
        String cancel_req_tag = "login";
        //    progressDialog.setMessage("Logging you in...");
        //   showDialog();
        StringRequest strReq = new StringRequest(Request.Method.POST,
                URL_FOR_Fetch_All_College, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
                // hideDialog();
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = false;
                    try {
                        error = jObj.getBoolean("error");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    if (!error) {
                       // String[] CollegeList=jObj.getJSONObject("collegenamelist").getJSONArray("collegelists");
                        JSONArray CollegeList=jObj.getJSONArray("collegelist");
                        Log.i("hellojson$$$$$",CollegeList+"");
                        x=CollegeList.toString();
                       // Toast.makeText(UpdateCollegeDetails.this,Collgeadded+" Addded Successfully",Toast.LENGTH_LONG).show();
                        Intent i=new Intent(UpdateCollegeDetails.this,AdminHome.class);
                        Intent i2=getIntent();
                        Admin a1=(Admin) i2.getSerializableExtra("useradmin");

                        Admin a2=new Admin(a1.getName(),a1.getEmail());
                        i.putExtra("useradmin", a2);
                        //startActivity(i);
                        // Launch User activity

                        //finish();
                    } else {

                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                //  hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to login url
                Map<String, String> params = new HashMap<String, String>();
               params.put("FetchAllCollege", "FetchAllCollege");
               /* params.put("collegetype", collegetype);
                params.put("collegefacilities", collgegefacilities);
                params.put("air", air);
                params.put("swr", swr);*/


                return params;
            }

        };
        // Adding request to request queue
        AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(strReq,cancel_req_tag);
    }

  /*  private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }
    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();


    }*/



}