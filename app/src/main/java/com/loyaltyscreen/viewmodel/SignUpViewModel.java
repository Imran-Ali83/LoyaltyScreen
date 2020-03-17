package com.loyaltyscreen.viewmodel;

import android.text.Editable;
import android.text.TextWatcher;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loyaltyscreen.model.User;

/**
 * SignUpViewModel class contains the user object and update the
 * view class when user object is updated.
 *
 * @author Imran
 */
public class SignUpViewModel extends ViewModel {

    private MutableLiveData<User> userMutableLiveData;
    private User user;

    /**
     * No argument constructor which initialize the user
     * and mutable live user object
     */
    public SignUpViewModel() {
        user = new User();
        userMutableLiveData = new MutableLiveData<User>();
    }

    /**
     * Listener method which get the updated value of the first name
     * from the EditText and update the user object
     * @return TextWatcher listener object of first name
     */
    public TextWatcher getFirstNameTextWatcher() {

        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setFirstName(s.toString());
            }
        };
    }

    /**
     * Listener method which get the updated value of the last name
     * from the EditText and update the user object
     * @return TextWatcher listener object of last name
     */
    public TextWatcher getLastNameTextWatcher() {

        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setLastName(s.toString());
            }
        };
    }

    /**
     *  Listener method which get the updated value of the email
     *  from the EditText and update the user object
     * @return TextWatcher listener object of email
     */
    public TextWatcher getEmailTextWatcher() {

        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setEmail(s.toString());
            }
        };
    }

    /**
     *  Listener method which get the updated value of the phone
     *  from the EditText and update the user object
     * @return TextWatcher listener object of phone
     */
    public TextWatcher getPhoneTextWatcher() {

        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setPhone(s.toString());
            }
        };
    }

    /**
     * Set the user object to the mutable live user
     * object to observer the updated value on the view
     */
    public void onlogin() {

        userMutableLiveData.setValue(user);
    }

    /**
     * Return the liveData user object
     * @return user
     */
    public LiveData<User> getUser() {
        return userMutableLiveData;
    }
}
