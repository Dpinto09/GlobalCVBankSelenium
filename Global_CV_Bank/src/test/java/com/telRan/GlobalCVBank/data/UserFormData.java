package com.telRan.GlobalCVBank.data;

public class UserFormData {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String confirmPassword;


    public UserFormData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserFormData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserFormData setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserFormData setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserFormData setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserFormData setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getEmail() {
        return email;

    }


}
