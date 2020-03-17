package com.loyaltyscreen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.loyaltyscreen.databinding.ActivityMainBinding;
import com.loyaltyscreen.model.User;
import com.loyaltyscreen.viewmodel.SignUpViewModel;

/**
 * MainActivity class contains the UI which takes all the information from use
 * and perform actions by the user
 * @author Imran
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainActivityBinding;
    private SignUpViewModel signUpViewModel;

    /**
     * Initialize data binding, sign up view model, views click events
     * and observer user changes.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        signUpViewModel = new ViewModelProvider(this)
                .get(SignUpViewModel.class);
        mainActivityBinding.setSignUpViewModel(signUpViewModel);

        mainActivityBinding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpViewModel.onlogin();
            }
        });

        signUpViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {

                handleViewsByValidation(user);
            }
        });
    }

    /**
     * Method take user object and then called the validate method of user
     * fist name, last name, email and phone to show error if any of the user information
     * is invalid and updated the view and focus of the EditText or show success if
     * all fields are validated.
     * @param user
     */
    public void handleViewsByValidation(User user) {

        if (!user.isValidFirstName()) {

            mainActivityBinding.firstName.setError(getString(R.string.invalidFirstName));
            mainActivityBinding.firstName.requestFocus();

        } else if (!user.isValidLastName()) {

            mainActivityBinding.lastName.setError(getString(R.string.invalidLastName));
            mainActivityBinding.lastName.requestFocus();

        } else if (!user.isValidEmail()) {

            mainActivityBinding.email.setError(getString(R.string.invalidEmail));
            mainActivityBinding.email.requestFocus();

        } else if (!user.isValidPhone()) {

            mainActivityBinding.phone.setError(getString(R.string.invalidPhone));
            mainActivityBinding.phone.requestFocus();

        } else {

            showAlertDialog(getString(R.string.validated_successful));
        }
    }

    /**
     * Method take message string and show the alert dialog
     * @param message
     */
    public void showAlertDialog(String message) {

        AlertDialog alertDialog = new AlertDialog
                .Builder(this)
                .setMessage(message)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();

        alertDialog.show();
    }
}
