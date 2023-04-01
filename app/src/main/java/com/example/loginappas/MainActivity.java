package com.example.loginappas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button okBut = (Button) findViewById(R.id.buttonok);
        TextView regBut = (TextView) findViewById(R.id.textrejestracja);

        regBut.setOnClickListener(view -> {
            Intent intentRegestration = new Intent(this,  RegistrationActivity.class);
            startActivity(intentRegestration);
        });
        okBut.setOnClickListener(but -> {
            Bundle arguments = getIntent().getExtras();
            if (arguments != null) {
                String login = arguments.get("login").toString();
                String password = arguments.get("password").toString();

                EditText editTextlog = (EditText) findViewById(R.id.editTextTextPersonName2);
                String log = editTextlog.getText().toString();
                EditText editTextHaslo = (EditText) findViewById(R.id.editTextTextPassword2);
                String pass = editTextHaslo.getText().toString();
                if(log.isEmpty()){
                    Toast.makeText(this, "Podaj login", Toast.LENGTH_SHORT).show();

                } else if (pass.isEmpty()) {
                    Toast.makeText(this, "Podaj hasło", Toast.LENGTH_SHORT).show();

                } else if (!log.equals(login)){
                    Toast.makeText(this, "Login jest niepoprawny", Toast.LENGTH_SHORT).show();

                } else if (!pass.equals(password)) {Toast.makeText(this, "Hasło jest niepoprawne", Toast.LENGTH_SHORT).show();

                }else {
                Toast.makeText(this, login +"Zalogowałeś się", Toast.LENGTH_SHORT).show();

            }
        }

    });

    /*public void sendMessage(View view){
        Intent intent = new Intent(this, RegestionActivity.class);//obiekt łaczacy jedno okienko z drugim
        //this jest to te  okienko w którym jestesmy a Display to to okienko drugie
       // EditText editText = (EditText) findViewById(R.id.editText);// jest to pole tekstowe w okienku drugim
       // String message = editText.getText().toString(); //jest to wiadomosc która wyciągniemy sobie z pola w pierwszym okienku
        //intent.putExtra(EXTRA_MESSAGE,message); // i wyslemy ta wiadomość poprzez metode putExtra intentu dla drugiego okienka
        startActivity(intent);// na koniec okienko wyswietlimy
    }*/
}
}