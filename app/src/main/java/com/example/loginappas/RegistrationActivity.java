package com.example.loginappas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        /*EditText editTextFildMail = (EditText) findViewById(R.id.editTextFildMail);
        EditText editTextPassword3 = (EditText) findViewById(R.id.editTextTextPassword3);
        String message = editTextFildMail.getText().toString();
        if(!message.isEmpty()) */
        EditText login = (EditText) findViewById(R.id.editTextFildMail);
        EditText pwd = (EditText) findViewById(R.id.editTextTextPassword);
        EditText pwd2 = (EditText) findViewById(R.id.editTextTextPassword3);
        Button registrationBut = (Button) findViewById(R.id.buttonregister);

        login.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                boolean isLoginEmpty= login.getText().toString().isEmpty();
                if (hasFocus){
                    updateComponent(login,"", Color.WHITE);
                }else {updateComponent(login,isLoginEmpty?"Podaj login":"",
                        isLoginEmpty?Color.RED:Color.WHITE);

            }
        }});

        pwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                boolean isLoginEmpty= pwd.getText().toString().isEmpty();
                if (hasFocus){
                    updateComponent(pwd,"", Color.WHITE);
                }else {updateComponent(pwd,isLoginEmpty?"Podaj hasło":"",
                        isLoginEmpty?Color.RED:Color.WHITE);

                }
            }});

        pwd2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                boolean isLoginEmpty= pwd2.getText().toString().isEmpty();
                String pwdval = pwd.getText().toString();
                String pwd2val = pwd2.getText().toString();
                if (hasFocus){
                    updateComponent(pwd2,"", Color.WHITE);
                }else {updateComponent(pwd2,isLoginEmpty?"Powtórz hasło":"",
                        isLoginEmpty?Color.RED:Color.WHITE);

                }
                if(!pwd2val.isEmpty()){
                    if(pwd2val.equals(pwdval)){
                        updateComponent(pwd2,"",Color.WHITE);
                    }else {
                        pwd2.setText("");
                        updateComponent(pwd2,"Nieprawidłowe Hasło",Color.RED);
                    }
                }

            }});

        registrationBut.setOnClickListener(view -> {
            String loginValue = login.getText().toString();
            String pwdValue = pwd.getText().toString();
            String pwd2Value = pwd2.getText().toString();
            boolean equalsPwd2 = pwd2Value.equals(pwdValue);

            boolean isLoginEmpty = loginValue.isEmpty();
            updateComponent(login,isLoginEmpty? "Podaj login":"",isLoginEmpty? Color.RED:Color.WHITE);

            boolean isHasloEmpty = pwdValue.isEmpty();
            updateComponent(pwd,isHasloEmpty? "Podaj hasło":"",isHasloEmpty? Color.RED:Color.WHITE);

            boolean isHaslo2Empty = pwd2Value.isEmpty();
            updateComponent(pwd2,isHaslo2Empty? "Powtórz hasło":"",isHaslo2Empty? Color.RED:Color.WHITE);
            /*if (loginValue.isEmpty()) {
                Toast.makeText(this, "Nie podałeś loginu", Toast.LENGTH_SHORT).show();
            } else if (pwdValue.isEmpty()){
                Toast.makeText(this, "Nie podałeś hasła", Toast.LENGTH_SHORT).show();
            } else if (pwd2Value.isEmpty()){
                Toast.makeText(this, "Nie powtórzyłeś hasła", Toast.LENGTH_SHORT).show();
            } else if (!pwd2Value.equals(pwdValue)) {
                Toast.makeText(this, "Powtórzone hasło nie jest identyczne", Toast.LENGTH_SHORT).show();
            }else*/


            Intent intentRegestration = new Intent(this, MainActivity.class);
            intentRegestration.putExtra("login", loginValue);
            intentRegestration.putExtra("password", pwdValue);
            if(!equalsPwd2){
                pwd2.setText("");
                updateComponent(pwd2,"Powtórzone hasło nie jest identyczne", Color.RED);
            }else if(!pwdValue.isEmpty() && !loginValue.isEmpty() && !pwd2Value.isEmpty()) {
            startActivity(intentRegestration);
            }

        });
    }

    public void updateComponent(EditText editText,String text,int color){
        editText.setHint(text);
        editText.setBackgroundColor(color);
    }

}