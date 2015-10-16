package com.mobile.csanche.carsharing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends ActionBarActivity {

    EditText dataLabelTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dataLabelTextView = (EditText) findViewById(R.id.credentialInput);
    }

    void showUniversidadField(View view){
        dataLabelTextView.setHint("Número de cuenta");

    }
    /*
    Este método va a un webservice por los datos, por ahora es fake
     */
    void validateCredentials(View view){

        String credential=dataLabelTextView.getText().toString();
        if(credential=="" || credential== null){
            Toast.makeText(this,"Tienes que introducir tus credenciales", Toast.LENGTH_SHORT).show();
        }else{
            boolean checked = ((RadioButton) view).isChecked();
            boolean response = false;
            switch(view.getId()){
                case R.id.universidad:
                    //Se hace la llamada al web service
                    response = true;
                    break;
            }
            if(response){
                //avanzamos en el registro, y guardamos datos en el servidor
                startActivity(new Intent(this, InformationActivity.class));
            }else{

            }
        }



    }

}
