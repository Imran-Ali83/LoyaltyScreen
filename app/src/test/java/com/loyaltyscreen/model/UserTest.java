package com.loyaltyscreen.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user = new User();

    @Test
    public void user_CorrectFirstName_ReturnTrue() {

        user.setFirstName("Imran");
        assertTrue(user.isValidFirstName());
    }

    @Test
    public void user_CorrectFirstName_WithSpaces_ReturnTrue() {

        user.setFirstName(" Imran ");
        assertTrue(user.isValidFirstName());
    }

    @Test
    public void user_InvalidFirstName_Null_ReturnFalse() {

        user = new User();
        assertFalse(user.isValidFirstName());
    }


    @Test
    public void user_InvalidFirstName_Empty_ReturnFalse() {

        user.setFirstName("");
        assertFalse(user.isValidFirstName());
    }

    @Test
    public void user_InvalidFirstName_SpecialCharacters_ReturnFalse() {

        user.setFirstName("Imran!#");
        assertFalse(user.isValidFirstName());
    }


    @Test
    public void user_CorrectLasttName_ReturnTrue() {

        user.setLastName("Ali");
        assertTrue(user.isValidLastName());
    }

    @Test
    public void user_CorrectLastName_WithSpaces_ReturnTrue() {

        user.setLastName(" Ali ");
        assertTrue(user.isValidLastName());
    }

    @Test
    public void user_InvalidLastName_Null_ReturnFalse() {

        user = new User();
        assertFalse(user.isValidLastName());
    }


    @Test
    public void user_InvalidLastName_Empty_ReturnFalse() {

        user.setLastName("");
        assertFalse(user.isValidLastName());
    }

    @Test
    public void user_InvalidLastName_SpecialCharacters_ReturnFalse() {

        user.setLastName("Ali!#");
        assertFalse(user.isValidLastName());
    }

    @Test
    public void user_CorrectEmail_ReturnTrue() {

        user.setEmail("imran@abc.com");
        assertTrue(user.isValidEmail());
    }

    @Test
    public void user_CorrectEmail_SubDomain_ReturnTrue() {

        user.setEmail("imran@abc.co.ca");
        assertTrue(user.isValidEmail());
    }

    @Test
    public void user_InvalidEmail_Null_ReturnFalse() {

        user = new User();
        assertFalse(user.isValidEmail());
    }


    @Test
    public void user_InvalidEmail_Empty_ReturnFalse() {

        user.setEmail("");
        assertFalse(user.isValidEmail());
    }

    @Test
    public void user_InvalidEmail_WithoutAtTheRate_ReturnFalse() {

        user.setEmail("imranabc.com");
        assertFalse(user.isValidEmail());
    }

    @Test
    public void user_InvalidEmail_DoubleDot_ReturnFalse() {

        user.setEmail("imran@abc..com");
        assertFalse(user.isValidEmail());
    }

    @Test
    public void user_InvalidEmail_StartWithAtTheRate_ReturnFalse() {

        user.setEmail("@abc..com");
        assertFalse(user.isValidEmail());
    }


    @Test
    public void user_CorrectPhone_ReturnTrue() {

        user.setPhone("12345678");
        assertTrue(user.isValidPhone());
    }

    @Test
    public void user_CorrectPhone_WithPlus_ReturnTrue() {

        user.setPhone("+12345678");
        assertTrue(user.isValidPhone());
    }

    @Test
    public void user_InvalidPhone_Null_ReturnTrue() {

        user = new User();
        assertTrue(user.isValidPhone());
    }

    @Test
    public void user_InvalidPhone_Empty_ReturnTrue() {

        user.setPhone("");
        assertTrue(user.isValidPhone());
    }

    @Test
    public void user_InvalidPhone_AlphaNumericCharacters_ReturnFalse() {

        user.setPhone("123abc374");
        assertFalse(user.isValidPhone());
    }

    @Test
    public void user_InvalidPhone_Characters_ReturnFalse() {

        user.setPhone("abcdefghi");
        assertFalse(user.isValidPhone());
    }
}