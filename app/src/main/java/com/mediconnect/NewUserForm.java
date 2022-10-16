package com.mediconnect;

public class NewUserForm {

    String UserType;
    Long UserPhone;
    String UserEmail;
    String UserFirstName;
    String UserLastName;
    String Gender;
    String DOB;
    String Address;
    String Address1;
    String City;
    String Pincode;
    String District;
    String State;
    String Qualification;
    String QualiDescr;
    String userPassword;

    public NewUserForm(String selectUser, String firstName, String lastName, String gender,String dob){
        UserType=selectUser;
        UserFirstName=firstName;
        UserLastName=lastName;
        DOB=dob;
        Gender=gender;
    }
    public NewUserForm(Long inpt_phno,String inpt_email, String Password){
        UserPhone=inpt_phno;
        UserEmail=inpt_email;
        userPassword = Password;
    }
    public NewUserForm (String qualification, String qualiDes){
        Qualification=qualification;
        QualiDescr=qualiDes;
    }
    public NewUserForm (String addLine1, String addLine2, String state,String city, String district, String pincode) {
        Address=addLine1;
        Address1=addLine2;
        State=state;
        City=city;
        District=district;
        Pincode=pincode;
    }

    public String getUserType() {
        return UserType;
    }

    public Long getUserPhone() {
        return UserPhone;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public String getUserFirstName() {
        return UserFirstName;
    }

    public String getUserLastName() {
        return UserLastName;
    }

    public String getGender() {
        return Gender;
    }

    public String getDOB() {
        return DOB;
    }

    public String getAddress() {
        return Address;
    }

    public String getAddress1() {
        return Address1;
    }

    public String getCity() {
        return City;
    }

    public String getPincode() {
        return Pincode;
    }

    public String getDistrict() {
        return District;
    }

    public String getState() {
        return State;
    }

    public String getQualification() {
        return Qualification;
    }

    public String getQualiDescr() {
        return QualiDescr;
    }

    public String getUserPassword(){return userPassword;}
}
