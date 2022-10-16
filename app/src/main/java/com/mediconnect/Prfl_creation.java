package com.mediconnect;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Prfl_creation extends AppCompatActivity {

    DatabaseReference User;
    EditText userFirstName;
    EditText userLastName;
    EditText userDOB;
    RadioButton userGenderMale;
    RadioButton userGenderFemale;
    RadioButton userGenderOther;
    EditText userQulaification;
    EditText userQualiDes;
    EditText Line2;
    EditText Line1;
    EditText State;
    EditText Pinecode;
    EditText City;
    EditText District;
    Button CreatProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creatprfl);

        userFirstName = (EditText) findViewById(R.id.userFirstName);
        userLastName = (EditText) findViewById(R.id.userLastName);
        userDOB = (EditText) findViewById(R.id.userDOB);
        userGenderMale = (RadioButton) findViewById(R.id.genderMale);
        userGenderFemale = (RadioButton)findViewById(R.id.genderFemale);
        userGenderOther=(RadioButton)findViewById(R.id.genderOther);
        userQulaification = (EditText) findViewById(R.id.UserQualification);
        userQualiDes = (EditText) findViewById(R.id.userQualidescription);
        Line1 = (EditText) findViewById(R.id.addLine1);
        Line2 = (EditText) findViewById(R.id.addLine2);
        State = (EditText) findViewById(R.id.userState);
        Pinecode = (EditText) findViewById(R.id.userPincode);
        City = (EditText) findViewById(R.id.userCity);
        District = (EditText) findViewById(R.id.userDistrict);
        CreatProfile = (Button) findViewById(R.id.btnCreateProfile);
        CreatProfile.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onClick(View view) {
                if(userFirstName.getText().toString().isEmpty()|| userLastName.getText().toString().isEmpty()
                || userDOB.getText().toString().isEmpty() || userGenderOther.getText().toString().isEmpty() ||
                        Line1.getText().toString().isEmpty() || userGenderMale.getText().toString().isEmpty()||
                        userGenderFemale.getText().toString().isEmpty() ||userGenderOther.getText().toString().isEmpty()
                        ||userQualiDes.getText().toString().isEmpty() || Line2.getText().toString().isEmpty() ||
                        State.getText().toString().isEmpty() || District.getText().toString().isEmpty() || CreatProfile.getText().toString().isEmpty())
                {
                    Toast.makeText(Prfl_creation.this,"Please Enter Valid Data",Toast.LENGTH_LONG).show();
                }
                else
                CreatNewProfile();
            }
        });
    }

    public void CreatNewProfile() {
        String selectUser = Signup.selectUser.getSelectedItem().toString();
        Long inpt_phno = Long.parseLong(Signup.inpt_phno.getText().toString());
        String inpt_email = Signup.inpt_email.getText().toString();
        String FirstName = userFirstName.getText().toString();
        String LastName = userLastName.getText().toString();
        String DOB = userDOB.getText().toString();
        String Gender="";
        if(userGenderMale.isChecked()){Gender="Male";}
        if(userGenderFemale.isChecked()){Gender="Female";}
        if(userGenderOther.isChecked()){Gender="Other";}
        String Qualification = userQulaification.getText().toString();
        String QualiDes = userQualiDes.getText().toString();
        String AddLine1 = Line1.getText().toString();
        String AddLine2 = Line2.getText().toString();
        String state = State.getText().toString();
        String city = City.getText().toString();
        String district = District.getText().toString();
        String pincode = String.valueOf(Pinecode.getText().toString());
        String Password = Signup.edit_ConfNewPass.getText().toString();

        NewUserForm NewUserPersonaltDetails = new NewUserForm(selectUser,FirstName,LastName,Gender,DOB);
        NewUserForm NewUserContctDetails =  new NewUserForm(inpt_phno,inpt_email,Password);
        NewUserForm NewUserEducationalDetails = new NewUserForm(Qualification,QualiDes);
        NewUserForm NewUserAddressDetails = new NewUserForm(AddLine1,AddLine2,state,city,district,pincode);

        FirebaseDatabase UserDatabase = FirebaseDatabase.getInstance();
        DatabaseReference DR = UserDatabase.getReference("Users").child(String.valueOf(inpt_phno)).child(String.valueOf(Password)).child("ProfileDetails");
        DR.child("PersonalDetails").setValue(NewUserPersonaltDetails);
        DR.child("ContactDetails").setValue(NewUserContctDetails);
        DR.child("EducationalDetails").setValue(NewUserEducationalDetails);
        DR.child("AddressDetails").setValue(NewUserAddressDetails);

        Toast.makeText(Prfl_creation.this,"Profile Successfully Created , Please Login",Toast.LENGTH_LONG).show();
        Intent intent11 =new Intent(this, Signin.class);
        startActivity(intent11);
    }

}