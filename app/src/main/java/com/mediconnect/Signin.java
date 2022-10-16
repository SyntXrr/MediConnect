package com.mediconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Signin extends AppCompatActivity {

    Long InputuserId;
    String Inputpassword;
    static  EditText phone;
    static  EditText userPassword;
    TextView warning;
    Button btn_frgt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        phone= (EditText) findViewById(R.id.phone);
        userPassword = (EditText)findViewById(R.id.userPassword);
        warning=(TextView) findViewById(R.id.warning1);
        btn_frgt =(Button)findViewById(R.id.btn_frgt);
        btn_frgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgotPassWin();
            }
        });
    }

    public void forgotPassWin(){
       Intent intent11 = new Intent(this,ForgotPassword.class);
       startActivity(intent11);
    }

    public void CheckCred(View view){
        int digit = phone.length();
        int digit1 = userPassword.length();
        if(phone.getText().toString().isEmpty() || userPassword.getText().toString().isEmpty() || digit <10 || digit1 <=0 || digit >10 || digit>10) {
            warning.setVisibility(View.VISIBLE);
            warning.setText("Enter Valid Credentials");
        }
        else{
            openprfl();
        }
    }

    public void openprfl()
    {
        Intent intent00 = new Intent(this, Profile.class);
        startActivity(intent00);
        warning.setVisibility(View.GONE);
    }
}