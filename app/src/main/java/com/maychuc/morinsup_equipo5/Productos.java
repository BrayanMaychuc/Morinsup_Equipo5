package com.maychuc.morinsup_equipo5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Productos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

    }

    public void retroceder(View view){
        Intent i = new Intent(this, PaginaPrincipal.class);
        startActivity(i);
    }
}
