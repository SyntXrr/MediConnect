package com.mediconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class Doctor extends AppCompatActivity {
    ConstraintLayout Doctor_chat;
    ScrollView Doctor_patient_management;
    ConstraintLayout doctor_appointment_manag;
    LinearLayout search_bar;
    View patient1;
    View msg1;
    ImageView New_conv_btn;
    ImageView btn_add2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        Doctor_chat=(ConstraintLayout) findViewById(R.id.Doctor_chat);
        Doctor_patient_management= (ScrollView) findViewById(R.id.Doctor_patient_management);
        doctor_appointment_manag = (ConstraintLayout) findViewById(R.id.doctor_appointment_manag);
        btn_add2=(ImageView)findViewById(R.id.btn_add2);
        search_bar=(LinearLayout)findViewById(R.id.search_bar);

        //patient Management
        patient1=(View)findViewById(R.id.patient1);
        patient1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPatientIssueDetails();
            }
        });

        msg1=(View)findViewById(R.id.msg1);
        msg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenConversation1();
            }
        });

        New_conv_btn= (ImageView)findViewById(R.id.New_conv_btn);
        New_conv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewConversation1();
            }
        });

        //New Patient
        btn_add2=(ImageView)findViewById(R.id.btn_add2);
        btn_add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddNewPatient();
            }
        });
    }

    public void openNewConversation1(){
        Intent intent09 = new Intent(this,NewConversation.class);
        startActivity(intent09);
    }

    public void OpenConversation1(){
        Intent intent15 = new Intent(this,Conversation.class);
        startActivity(intent15);
    }

    public void openAddNewPatient(){
        Intent intent17=new Intent(this,AddNewPatient.class);
        startActivity(intent17);
    }

    public  void openPatientIssueDetails(){
        Intent intent21=new Intent(this,Patient_issueDetails.class);
        startActivity(intent21);
    }

    public void showDctPrfl(View v){
        Doctor_patient_management.setVisibility(View.GONE);
        doctor_appointment_manag.setVisibility(View.GONE);
        btn_add2.setVisibility(View.GONE);
        search_bar.setVisibility(View.GONE);
        Doctor_chat.setVisibility(View.GONE);
    }

    public void showDctChat(View v){
        Doctor_patient_management.setVisibility(View.GONE);
        doctor_appointment_manag.setVisibility(View.GONE);
        search_bar.setVisibility(View.GONE);
        Doctor_chat.setVisibility(View.VISIBLE);
        btn_add2.setVisibility(View.GONE);
    }

    public void showPatientManage(View v){
        doctor_appointment_manag.setVisibility(View.GONE);
        Doctor_chat.setVisibility(View.GONE);
        Doctor_patient_management.setVisibility(View.VISIBLE);
        search_bar.setVisibility(View.VISIBLE);
        btn_add2.setVisibility(View.VISIBLE);
    }

    public void showAppointMange(View v){
        Doctor_patient_management.setVisibility(View.GONE);
        search_bar.setVisibility(View.GONE);
        Doctor_chat.setVisibility(View.GONE);
        doctor_appointment_manag.setVisibility(View.VISIBLE);
        btn_add2.setVisibility(View.GONE);
    }
}
