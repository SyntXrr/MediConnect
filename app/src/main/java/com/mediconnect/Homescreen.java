package com.mediconnect;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
public class Homescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btn_signup;
        Button btn_signin;
        ImageView emr_phone;
        ImageView police;
        ImageView abmulance;
        ImageView hospital;
        ImageView lab;
        ImageView medical;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignup();
            }
        });

        btn_signin = (Button) findViewById(R.id.btn_signin);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignin();
            }
        });

        emr_phone = (ImageView) findViewById(R.id.emr_phone);
        emr_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEmerg();
            }
        });

        police = (ImageView) findViewById(R.id.police);
        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPolice();
            }
        });

        abmulance = (ImageView) findViewById(R.id.ambulance);
        abmulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAmbulacne();
            }
        });

        hospital = (ImageView) findViewById(R.id.hospital);
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHospital();
            }
        });

        lab = (ImageView) findViewById(R.id.laboratory);
        lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlab();
            }
        });

        medical = (ImageView) findViewById(R.id.medical_store);
        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMedical();
            }
        });

    }

    public void openSignup(){
        Intent intent = new Intent(this,Signup.class);
        startActivity(intent);
    }

    public void openSignin(){
        Intent intent1 = new Intent(this,Signin.class);
        startActivity(intent1);
    }

    public void openEmerg(){
        Intent intent2 = new Intent(this,emergcall.class);
        startActivity(intent2);
    }
    public void openPolice(){
        Intent intent3 = new Intent(this,police.class);
        startActivity(intent3);
    }

    public void openAmbulacne(){
        Intent intent4 = new Intent(this,ambulance.class);
        startActivity(intent4);
    }

    public void openHospital(){
        Intent intent5 = new Intent(this,hospital.class);
        startActivity(intent5);
    }

    public void openlab(){
        Intent intent6 = new Intent(this,pathology_lab.class);
        startActivity(intent6);
    }

    public void openMedical(){
        Intent intent7 = new Intent(this,medical_store.class);
        startActivity(intent7);
    }
}