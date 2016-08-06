package com.example.timonology.mynewapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by TimonoloGy on 7/29/2016.
 */
public class SignUp extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onSignUpClick(View v)
    {
        if(v.getId() == R.id.Bsignupbutton){
            EditText name = (EditText)findViewById(R.id.TFname);
            EditText email = (EditText)findViewById(R.id.TFemail);
            EditText username = (EditText)findViewById(R.id.TFusername);
            EditText pass1 = (EditText)findViewById(R.id.TFpass1);
            EditText pass2 = (EditText)findViewById(R.id.TFpass2);

            String nameStr = name.getText().toString();
            String emailStr = email.getText().toString();
            String usernameStr = username.getText().toString();
            String passStr = pass1.getText().toString();
            String pass2Str = pass2.getText().toString();

            if(!passStr.equals(pass2Str)){
                // Show some popUp message
                Toast message = Toast.makeText(SignUp.this, "Your does not Match", Toast.LENGTH_SHORT);
                message.show();
            }else{
                // Insert User Details into the Database
                Contact con = new Contact();
                con.setName(nameStr);
                con.setEmail(emailStr);
                con.setUsername(usernameStr);
                con.setPassword(passStr);

                helper.insertContact(con);
            }
        }
    }
}
