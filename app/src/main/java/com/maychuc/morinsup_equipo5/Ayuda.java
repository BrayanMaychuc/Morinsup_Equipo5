package com.maychuc.morinsup_equipo5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Ayuda extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);
    }

    public void retroceder(View view){
        Intent i = new Intent(this, PaginaPrincipal.class);
        startActivity(i);
    }
}
