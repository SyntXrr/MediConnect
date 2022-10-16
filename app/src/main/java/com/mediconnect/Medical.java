package com.mediconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class Medical extends AppCompatActivity {
    ScrollView order_management;
    ScrollView history_management;
    ConstraintLayout med_chat;
    ConstraintLayout med_holder_add_btn;
    View conversation;
    View cust1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);

        order_management= (ScrollView) findViewById(R.id.order_management);
        history_management= (ScrollView) findViewById(R.id.history_management);
        med_chat=(ConstraintLayout) findViewById(R.id.medical_chat);

        //Chatbox
        conversation =(View)findViewById(R.id.msg1);
        conversation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConversation();
            }
        });

        med_holder_add_btn = (ConstraintLayout)findViewById(R.id.med_holder_add_btn);
        med_holder_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { opemedNewConversation();}
        });

        cust1 =(View) findViewById(R.id.cust1);
        cust1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMedicineList();
            }
        });

    }
    public void openMedicineList(){
     Intent intent04 = new Intent(this,MedicineList.class);
     startActivity(intent04);
    }

    public void opemedNewConversation(){
        Intent intent02 = new Intent(this,NewConversation.class);
        startActivity(intent02);
    }
    public void openConversation(){
        Intent intent13 = new Intent(this,Conversation.class);
        startActivity(intent13);
    }

    public void showPrfl2(View v){
        order_management.setVisibility(View.GONE);
        history_management.setVisibility(View.GONE);
        med_chat.setVisibility(View.GONE);
    }

    public void medOrders(View v){
        history_management.setVisibility(View.GONE);
        med_chat.setVisibility(View.GONE);
        order_management.setVisibility(View.VISIBLE);
    }

    public void medhistory(View v){
        order_management.setVisibility(View.GONE);
        med_chat.setVisibility(View.GONE);
        history_management.setVisibility(View.VISIBLE);
    }

    public void medshowChat(View v) {
        order_management.setVisibility(View.GONE);
        history_management.setVisibility(View.GONE);
        med_chat.setVisibility(View.VISIBLE);
    }
}
