package com.example.loginappas;

import static com.example.loginappas.utils.Constants.LOGIN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginappas.dto.LoginDTO;
import com.example.loginappas.dto.RegistrationDTO;
import com.example.loginappas.service.RegistationDBService;

public class RegistrationActivity extends AppCompatActivity {

   private RegistrationDTO reg;
   private RegistationDBService registationDBService;

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
        Button exitBut = (Button) findViewById(R.id.buttonexit);

        login.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                boolean isLoginEmpty= login.getText().toString().isEmpty();
                reg = new RegistrationDTO(login.getText().toString(),pwd.getText().toString(),
                        pwd2.getText().toString());
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
                reg = new RegistrationDTO(login.getText().toString(),pwd.getText().toString(),
                        pwd2.getText().toString());
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
                reg = new RegistrationDTO(login.getText().toString(),pwd.getText().toString(),
                        pwd2.getText().toString());
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
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                reg = new RegistrationDTO(login.getText().toString(),pwd.getText().toString(),
                    pwd2.getText().toString());

            }
        };
        login.addTextChangedListener(textWatcher);
        pwd.addTextChangedListener(textWatcher);
        pwd2.addTextChangedListener(textWatcher);

        registrationBut.setOnClickListener(view -> {

           RegistrationDTO reg = new RegistrationDTO(login.getText().toString(),pwd.getText().toString(),
                    pwd2.getText().toString());

            boolean isLoginEmpty = reg.getLogin().isEmpty();
            updateComponent(login,isLoginEmpty? "Podaj login":"",isLoginEmpty? Color.RED:Color.WHITE);

            boolean isHasloEmpty = reg.getHaslo().isEmpty();
            updateComponent(pwd,isHasloEmpty? "Podaj hasło":"",isHasloEmpty? Color.RED:Color.WHITE);

            boolean isHaslo2Empty = reg.getHaslo2().isEmpty();
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



            if(!reg.isHasloEquals()){
                pwd2.setText("");
                updateComponent(pwd2,"Powtórzone hasło nie jest identyczne", Color.RED);
            }else if(reg.hasFieldsFilled()) {
                //LoginDTO loginDTO = new LoginDTO(reg.getLogin(),reg.getHaslo());
                //Intent intentRegestration = new Intent(this, MainActivity.class);
                //intentRegestration.putExtra(LOGIN, loginDTO);
            //startActivity(intentRegestration);

                registationDBService = new RegistationDBService(this);

                Boolean czySieUdalo;
                        czySieUdalo= registationDBService.addRegistration(reg);
                if (czySieUdalo){
                    Toast.makeText(this, "Udało się zapisać", Toast.LENGTH_LONG).show();


                }else {
                    Toast.makeText(this, "Nie udało się", Toast.LENGTH_LONG).show();
                }


            }


        });
        exitBut.setOnClickListener(view -> {
            Intent intentexit = new Intent(this,MainActivity.class);
            startActivity(intentexit);
        });
    }

    public void updateComponent(EditText editText,String text,int color){
        editText.setHint(text);
        editText.setBackgroundColor(color);
    }

}