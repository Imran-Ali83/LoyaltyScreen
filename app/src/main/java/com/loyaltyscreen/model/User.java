package com.loyaltyscreen.model;

import android.text.TextUtils;
import androidx.core.util.PatternsCompat;

import java.util.regex.Pattern;

/**
 * Class contains the information about the user
 *
 * @author Imran
 */
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public static final String NAME = "[a-zA-Z.? ]*";
    public static final String PHONE = "(\\+[0-9]+[\\- \\.]*)?"
                                        + "(\\([0-9]+\\)[\\- \\.]*)?"
                                        + "([0-9][0-9\\- \\.]+[0-9])";

    /**
     * Return first name of the user
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set first name to the user
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Return last name of the user
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set last name to the user
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Return email of the user
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email of the user
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return phone of the user
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set phone of the user
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Validate the first name of user and check that first name is not null
     * and empty and also contains valid characters
     * @return true if the user first name is valid
     */
    public boolean isValidFirstName() {
        return firstName != null &&
                !firstName.isEmpty() &&
                Pattern.compile(NAME).matcher(firstName).matches();
    }

    /**
     * Validate the last name of user and check that last name is not null
     * and empty and also contains valid characters
     * @return true if the user last name is valid
     */
    public boolean isValidLastName() {
        return lastName != null &&
                !lastName.trim().isEmpty() &&
                Pattern.compile(NAME).matcher(lastName).matches();
    }

    /**
     * Validate the email of user and check that email is not null
     * and empty and contains valid email address
     * @return true if the user email is valid
     */
    public boolean isValidEmail() {

        return email != null &&
                !TextUtils.isEmpty(email) &&
                PatternsCompat.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * Validate the phone of user and check that phone is null
     * or empty or contains non-numeric characters
     * @return true if the user phone number is empty or valid.
     */
    public boolean isValidPhone() {
        return phone == null ||
                phone.trim().isEmpty() ||
                Pattern.compile(PHONE).matcher(phone).matches();
    }
}
