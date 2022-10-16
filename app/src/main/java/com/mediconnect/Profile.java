package com.mediconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import org.jetbrains.annotations.NotNull;

public class Profile extends AppCompatActivity {
    String UserType;
    TextView ProfileUserName,ProfileUserType;
    TextView ProfileDoBValue, ProfileUserGender, ProfileUserMobileValue;
    TextView ProfileUserEmailValue, ProfileUserAddL1, ProfileUserAddL2, ProfileUserCity;
    TextView ProfileUserDistrict, ProfileUserState, ProfileUserPincode;
    TextView ProfileUerQuali,ProfileUerQualiDesc;
    Long UserId; String Password;
    Button GoToDashborad;
    Button Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        UserId = Long.parseLong(Signin.phone.getText().toString());
        Password = Signin.userPassword.getText().toString();

        ProfileUserType = findViewById(R.id.ProfileUserType);
        ProfileUserName = findViewById(R.id.ProfileUserName);
        ProfileDoBValue = findViewById(R.id.ProfileDoBValue);
        ProfileUserGender = findViewById(R.id.ProfileUserGender);
        ProfileUserMobileValue = findViewById(R.id.ProfileUserMobileValue);
        ProfileUserEmailValue = findViewById(R.id.ProfileUserEmailValue);
        ProfileUerQuali = findViewById(R.id.ProfileUerQuali);
        ProfileUerQualiDesc = findViewById(R.id.ProfileUerQualiDesc);
        ProfileUserAddL1 = findViewById(R.id.ProfileUserAddL1);
        ProfileUserAddL2 = findViewById(R.id.ProfileUserAddL2);
        ProfileUserCity = findViewById(R.id.ProfileUserCity);
        ProfileUserDistrict = findViewById(R.id.ProfileUserDistrict);
        ProfileUserState = findViewById(R.id.ProfileUserState);
        ProfileUserPincode = findViewById(R.id.ProfileUserPincode);
        FetchUserData();
        GoToDashborad=findViewById(R.id.btnGoToDashboard);
        GoToDashborad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPRFL();
            }
        });
    }

    public void FetchUserData(){

        DatabaseReference UserData = FirebaseDatabase.getInstance().getReference("Users").child(String.valueOf(UserId)).child(String.valueOf(Password));
        UserData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                UserType = snapshot.child("ProfileDetails").child("PersonalDetails").child("userType").getValue().toString();
                String FirstName = snapshot.child("ProfileDetails").child("PersonalDetails").child("userFirstName").getValue().toString();
                String LastName = snapshot.child("ProfileDetails").child("PersonalDetails").child("userLastName").getValue().toString();
                String Dob = snapshot.child("ProfileDetails").child("PersonalDetails").child("dob").getValue().toString();
                String Gender = snapshot.child("ProfileDetails").child("PersonalDetails").child("gender").getValue().toString();
                String Mobile = snapshot.child("ProfileDetails").child("ContactDetails").child("userPhone").getValue().toString();
                String Email = snapshot.child("ProfileDetails").child("ContactDetails").child("userEmail").getValue().toString();
                String Qualification = snapshot.child("ProfileDetails").child("EducationalDetails").child("qualification").getValue().toString();
                String QualiDesc = snapshot.child("ProfileDetails").child("EducationalDetails").child("qualiDescr").getValue().toString();
                String Add1 = snapshot.child("ProfileDetails").child("AddressDetails").child("address").getValue().toString();
                String Add2 = snapshot.child("ProfileDetails").child("AddressDetails").child("address1").getValue().toString();
                String City = snapshot.child("ProfileDetails").child("AddressDetails").child("city").getValue().toString();
                String District = snapshot.child("ProfileDetails").child("AddressDetails").child("district").getValue().toString();
                String State = snapshot.child("ProfileDetails").child("AddressDetails").child("state").getValue().toString();
                String Pincode = snapshot.child("ProfileDetails").child("AddressDetails").child("pincode").getValue().toString();
                ProfileUserType.setText(UserType);
                ProfileUserName.setText(FirstName +" "+LastName);
                ProfileDoBValue.setText(Dob);
                ProfileUserGender.setText(Gender);
                ProfileUserMobileValue.setText(Mobile);
                ProfileUserEmailValue.setText(Email);
                ProfileUerQuali.setText(Qualification);
                ProfileUerQualiDesc.setText(QualiDesc);
                ProfileUserAddL1.setText(Add1);
                ProfileUserAddL2.setText(Add2);
                ProfileUserCity.setText(City);
                ProfileUserDistrict.setText(District);
                ProfileUserState.setText(State);
                ProfileUserPincode.setText(Pincode);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
    }

    public void openPRFL(){
        if (UserType.equals("Patient")){
            Intent intent1 = new Intent(this,Patient.class);
            startActivity(intent1);
        }

        if (UserType .equals( "Doctor")){
            Intent intent1 = new Intent(this,Doctor.class);
            startActivity(intent1);
        }

        if (UserType .equals( "Pathology Laboratory")){
            Intent intent1 = new Intent(this,Lab.class);
            startActivity(intent1);
        }

        if (UserType .equals( "Medical")){
            Intent intent1 = new Intent(this,Medical.class);
            startActivity(intent1);
        }
    }
}
