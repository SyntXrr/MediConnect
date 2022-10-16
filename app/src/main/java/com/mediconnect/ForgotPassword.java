package com.mediconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPassword extends AppCompatActivity {

    EditText edit_mobile;
    EditText edit_regemail;
    LinearLayout win_Frgtverify_otp;
    long userId;
    TextView txt_frgtpass;
    TextView warning12;
    Button btn_Frgtgtotp;
    EditText edit_mo_otp;
    EditText edit_regemail_otp;
    LinearLayout win_creatnew_pass;
    EditText edit_creat_pass;
    EditText edit_confirm_pass;
    LinearLayout win_ph_email;
    Button btn_finish;
    Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        warning12 = (TextView)findViewById(R.id.warning12) ;
        edit_mobile = (EditText)findViewById(R.id.edit_mobile);
        edit_regemail = (EditText)findViewById(R.id.edit_regemail);
        win_Frgtverify_otp= (LinearLayout)findViewById(R.id.win_Frgtverify_otp);
        btn_Frgtgtotp = (Button)findViewById(R.id.btn_gtotp);
        win_creatnew_pass = (LinearLayout)findViewById(R.id.win_creatnew_pass);
        win_ph_email=(LinearLayout)findViewById(R.id.win_ph_email);
        edit_mo_otp=(EditText)findViewById(R.id.edit_mo_otp);
        edit_regemail_otp=(EditText)findViewById(R.id.edit_regemail_otp);
        edit_creat_pass = (EditText)findViewById(R.id.edit_creat_pass);
        edit_confirm_pass = (EditText)findViewById(R.id.edit_confirm_pass);
        btn_login=(Button)findViewById(R.id.btn_login);
        txt_frgtpass= (TextView)findViewById(R.id.txt_frgtpass);

        btn_finish=findViewById(R.id.btn_finish);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyNewPass();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });
    }

    public  void openFrgtWinOTP(View view){
        int digit = edit_mobile.length();
        int charactores = edit_regemail.length();
        if(digit == 10 && charactores > 0) {
            userId = Long.parseLong(edit_mobile.getText().toString());
            if(userId == 7057674497l) {
                win_Frgtverify_otp.setVisibility(View.VISIBLE);
                warning12.setVisibility(View.GONE);
                edit_mobile.setFocusable(false);
                edit_regemail.setFocusable(false);
                btn_Frgtgtotp.setText("Resend OTP");
                Toast.makeText(ForgotPassword.this, "OTP has been sent", Toast.LENGTH_LONG).show();
            }
            else{
                warning12.setVisibility(View.VISIBLE);
                warning12.setText("Enter Valid Credentials");
            }
        }
        else{
            warning12.setVisibility(View.VISIBLE);
            warning12.setText("Enter Valid Credentials");
        }
    }

    public void verifyOTP(View v){
        int digit = edit_mo_otp.length();
        int digit1 = edit_regemail_otp.length();
        if (digit == 6 && digit1 == 6){
            warning12.setVisibility(View.GONE);
            win_Frgtverify_otp.setVisibility(View.GONE);
            win_creatnew_pass.setVisibility(View.VISIBLE);
        }
        else{
            warning12.setVisibility(View.VISIBLE);
            warning12.setText("Enter Valid OTP");
        }
    }

    public void verifyNewPass(){
        String newPass = edit_creat_pass.getText().toString();
        String conPass = edit_confirm_pass.getText().toString();
        if ( newPass.equals(conPass)){
            txt_frgtpass.setText("Password Reset Successfully");
            win_ph_email.setVisibility(View.GONE);
            win_Frgtverify_otp.setVisibility(View.GONE);
            win_creatnew_pass.setVisibility(View.GONE);
            btn_login.setVisibility(View.VISIBLE);
        }
        else{
            warning12.setVisibility(View.VISIBLE);
            warning12.setText("Password dosn't Match");
        }
    }

    public void openLoginPage(){
        Intent intent12 = new Intent(this,Signin.class);
        startActivity(intent12);
    }
}
