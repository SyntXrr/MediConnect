package com.mediconnect;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Lab extends AppCompatActivity {

    ConstraintLayout lab_chat1;
    ConstraintLayout lab_appointment_management;
    ScrollView lab_report1;
    ConstraintLayout lab_holder_add_btn;
    View msg1_lab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);

        lab_chat1 = (ConstraintLayout) findViewById(R.id.lab_chat1);
        lab_appointment_management = (ConstraintLayout) findViewById(R.id.lab_app_mngt);
        lab_report1=(ScrollView)findViewById(R.id.lab_report1);
        lab_holder_add_btn=(ConstraintLayout)findViewById(R.id.lab_holder_add_btn);

        msg1_lab  =  (View)findViewById(R.id.msg1_lab);
        msg1_lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLabConversation();
            }
        });

        lab_holder_add_btn = (ConstraintLayout)findViewById(R.id.lab_holder_add_btn);
        lab_holder_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openLabNewConversation();}
        });
    }

    public void showPrfl3(View v){
        lab_chat1.setVisibility(View.GONE);
        lab_appointment_management.setVisibility(View.GONE);
        lab_report1.setVisibility(View.GONE);
        lab_holder_add_btn.setVisibility(View.GONE);
    }

    public void ShowLabChat(View v){
        lab_chat1.setVisibility(View.VISIBLE);
        lab_appointment_management.setVisibility(View.GONE);
        lab_report1.setVisibility(View.GONE);
        lab_holder_add_btn.setVisibility(View.VISIBLE);
    }

    public void showLabAppoint(View v){
        lab_chat1.setVisibility(View.GONE);
        lab_appointment_management.setVisibility(View.VISIBLE);
        lab_report1.setVisibility(View.GONE);
        lab_holder_add_btn.setVisibility(View.GONE);
    }

    public void showLabReport(View v){
        lab_chat1.setVisibility(View.GONE);
        lab_appointment_management.setVisibility(View.GONE);
        lab_report1.setVisibility(View.VISIBLE);
        lab_holder_add_btn.setVisibility(View.GONE);
    }

    public void openLabConversation(){
        Intent intent00 = new Intent(this,Conversation.class);
        startActivity(intent00);
    }

    public void openLabNewConversation(){
        Intent intent01 = new Intent(this,NewConversation.class);
        startActivity(intent01);
    }
}



