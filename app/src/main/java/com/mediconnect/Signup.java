package com.mediconnect;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    static EditText inpt_phno;
    static  EditText inpt_email;
    Button btn_gtotp;
    Button btn_verify_otp;
    TextView warning;
    EditText edit_ph_otp;
    EditText edit_email_otp;
    static Spinner selectUser;
    LinearLayout win_verify_otp;
    LinearLayout win_Newpass;
    static EditText edit_NewPass;
    static EditText edit_ConfNewPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Spinner userType = findViewById(R.id.select);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.UserType,R.layout.spiner_text);
        userType.setAdapter(adapter);

        selectUser = (Spinner)findViewById(R.id.select);
        inpt_phno = (EditText) findViewById(R.id.inpt_phno);
        inpt_email = (EditText) findViewById(R.id.inpt_email);
        btn_gtotp = (Button) findViewById(R.id.btn_gtotp);
        edit_ph_otp = (EditText) findViewById(R.id.edit_ph_otp);
        edit_email_otp = (EditText) findViewById(R.id.edit_email_otp);
        win_verify_otp = (LinearLayout) findViewById(R.id.win_verify_otp);
        win_Newpass = (LinearLayout)findViewById(R.id.win_Newpass);
        warning = (TextView) findViewById(R.id.warning);
        edit_NewPass = (EditText)findViewById(R.id.edit_NewPass);
        edit_ConfNewPass =(EditText)findViewById(R.id.edit_ConfNewPass);

        btn_verify_otp = (Button) findViewById(R.id.btn_verify_otp);
        btn_verify_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerifyOTP();
            }
        });
    }

    public  void openWinOTP(View view){
        int digit = inpt_phno.length();
        int charactores = inpt_email.length();
        if(digit == 10 && charactores > 0) {
            win_verify_otp.setVisibility(View.VISIBLE);
            warning.setVisibility(View.GONE);
            inpt_email.setFocusable(false);
            inpt_phno.setFocusable(false);
            btn_gtotp.setText("Resend OTP");
            Toast.makeText(Signup.this,"OTP has been sent" , Toast.LENGTH_LONG).show();
        }
        else{
            warning.setVisibility(View.VISIBLE);
            warning.setText("Enter Valid Credentials");
        }
    }

    public void VerifyOTP(){
       int digit = edit_ph_otp.length();
       int digit1 = edit_email_otp.length();
       if (digit == 6 && digit1 == 6){
            win_verify_otp.setVisibility(View.GONE);
            win_Newpass.setVisibility(View.VISIBLE);
            warning.setVisibility(View.VISIBLE);
            warning.setText("Password Should be at least 15 Charactors including a-z, A-Z, 0-9 with special charactors");
        }
        else{
            warning.setVisibility(View.VISIBLE);
            warning.setText("Enter Valid OTP");
        }
    }

    public void openCreatNewPass(View view){
        int digit = edit_NewPass.length();
        int digit1 = edit_ConfNewPass.length();
        if (digit <= 16 && digit1 <= 16  )
        {
            Intent intent1 = new Intent(this, Prfl_creation.class);
            startActivity(intent1);
        }
        else {
            warning.setVisibility(View.VISIBLE);
            warning.setText("Enter Valid Password");
        }
    }
}
