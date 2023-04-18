package com.example.loginappas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.loginappas.service.RegistationDBService;
import com.example.loginappas.utils.DbUtilHelper;

import java.util.List;

public class MainActivityReg extends AppCompatActivity {
    RegistationDBService registationDBService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reg);

        Button giveList = (Button) findViewById(R.id.buttonGive);
        TextView textViewReg = (TextView) findViewById(R.id.textViewReg);


        giveList.setOnClickListener(view -> {
            registationDBService = new RegistationDBService(this);
            Cursor cursor =  registationDBService.findAll();
            if (cursor.moveToFirst()){
                do {
                    @SuppressLint("Range") String login = cursor.getString(cursor.getColumnIndex("login"));
                    textViewReg.setText(login);

                }while (cursor.moveToNext());



            }

        });



    }
}