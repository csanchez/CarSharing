package com.mobile.csanche.carsharing;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InformationActivity extends ActionBarActivity {
    private SharedPreferences sharedPref;
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText carreraEditText;
    private EditText schoolEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        sharedPref =  getPreferences(Context.MODE_PRIVATE);
        nameEditText = (EditText) findViewById(R.id.name_edit_text);
        emailEditText = (EditText) findViewById(R.id.email_edit_text);
        carreraEditText = (EditText) findViewById(R.id.carrera_edit_text);
        schoolEditText = (EditText) findViewById(R.id.school_edit_text);
    }




    /*
        Guarda los datos en la app y servidor y continua con el registro
     */
    void saveAndContinue (View view){
        if(nameEditText.getText().toString()==""){
            Toast.makeText(this, "Es necesario que indiques tu nombre", Toast.LENGTH_SHORT).show();
        }else{
            if(emailEditText.getText().toString()==""){
                Toast.makeText(this, "Es necesario que indiques tu email", Toast.LENGTH_SHORT).show();
            }else{
                if(carreraEditText.getText().toString()==""){
                    Toast.makeText(this, "Es necesario que indiques tu carrera", Toast.LENGTH_SHORT).show();
                }else{
                    if(schoolEditText.getText().toString()==""){
                        Toast.makeText(this, "Es necesario que indiques tu facultad", Toast.LENGTH_SHORT).show();
                    }else{
                        sharedPref.edit().putString("name", nameEditText.getText().toString()).apply();
                        sharedPref.edit().putString("email", emailEditText.getText().toString()).apply();
                        sharedPref.edit().putString("carrera", carreraEditText.getText().toString()).apply();
                        sharedPref.edit().putString("school",schoolEditText.getText().toString()).apply();

                        startActivity(new Intent(this, RegisterActivity.class));
                    }
                }
            }
        }

    }
}
