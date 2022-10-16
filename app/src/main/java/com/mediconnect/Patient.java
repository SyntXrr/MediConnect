package com.mediconnect;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Patient extends AppCompatActivity {
    ScrollView appointment;
    ConstraintLayout chat;
    ConstraintLayout issue;
    ConstraintLayout medicine;
    ScrollView report;
    ScrollView order;
    View conversation;
    ImageView New_conv_btn;
    View card_issue;
    ImageView add_newissue_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        //option
        appointment= (ScrollView) findViewById(R.id.appointment);
        chat= (ConstraintLayout) findViewById(R.id.chat);
        issue= (ConstraintLayout) findViewById(R.id.issue);
        medicine= (ConstraintLayout) findViewById(R.id.medicine);
        report= (ScrollView) findViewById(R.id.report);
        order= (ScrollView) findViewById(R.id.order);

        //Chatbox
        conversation =(View)findViewById(R.id.msg1);
        conversation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConversation();
            }
        });
        //add Button
        New_conv_btn =(ImageView)findViewById(R.id.New_conv_btn);
        New_conv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewConversation();
            }
        });

        //issue details
        card_issue = (View) findViewById(R.id.card_issue);
        card_issue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIssueDetails();
            }
        });

        //add_newIssue_button
        add_newissue_btn= (ImageView)findViewById(R.id.add_newissue_btn);
        add_newissue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddNewIssue();
            }
        });

    }

    //open add new issue
    public  void openAddNewIssue(){
        Intent intent19 = new Intent(this,AddNewIssue.class);
        startActivity(intent19);
    }
    //open issue Details
    public void openIssueDetails(){
        Intent intent11 = new Intent(this,IssueDetails.class);
        startActivity(intent11);
    }

    //open New Conversation
    public void openNewConversation() {
        Intent intent12 = new Intent(this,NewConversation.class);
        startActivity(intent12);
    }

    public void openConversation(){
        Intent intent13 = new Intent(this,Conversation.class);
        startActivity(intent13);
    }

    public void showAppointment(View v){
        chat.setVisibility(View.INVISIBLE);
        issue.setVisibility(View.INVISIBLE);
        medicine.setVisibility(View.INVISIBLE);
        report.setVisibility(View.INVISIBLE);
        order.setVisibility(View.INVISIBLE);
        appointment.setVisibility(View.VISIBLE);
    }

    public void ShowChat(View v){
        issue.setVisibility(View.INVISIBLE);
        medicine.setVisibility(View.INVISIBLE);
        report.setVisibility(View.INVISIBLE);
        order.setVisibility(View.INVISIBLE);
        appointment.setVisibility(View.INVISIBLE);
        chat.setVisibility(View.VISIBLE);
    }

    public void showIssue(View v){
        medicine.setVisibility(View.INVISIBLE);
        report.setVisibility(View.INVISIBLE);
        order.setVisibility(View.INVISIBLE);
        appointment.setVisibility(View.INVISIBLE);
        chat.setVisibility(View.INVISIBLE);
        issue.setVisibility(View.VISIBLE);
    }
    public void showMedicine(View v){
        report.setVisibility(View.INVISIBLE);
        order.setVisibility(View.INVISIBLE);
        appointment.setVisibility(View.INVISIBLE);
        chat.setVisibility(View.INVISIBLE);
        issue.setVisibility(View.INVISIBLE);
        medicine.setVisibility(View.VISIBLE);
    }

    public void showReport(View v){
        order.setVisibility(View.INVISIBLE);
        appointment.setVisibility(View.INVISIBLE);
        chat.setVisibility(View.INVISIBLE);
        issue.setVisibility(View.INVISIBLE);
        medicine.setVisibility(View.INVISIBLE);
        report.setVisibility(View.VISIBLE);
    }

    public void showOrder(View v){
        appointment.setVisibility(View.INVISIBLE);
        chat.setVisibility(View.INVISIBLE);
        issue.setVisibility(View.INVISIBLE);
        medicine.setVisibility(View.INVISIBLE);
        report.setVisibility(View.INVISIBLE);
        order.setVisibility(View.VISIBLE);
    }

}
