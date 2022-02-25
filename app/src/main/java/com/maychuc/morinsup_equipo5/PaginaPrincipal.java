package com.maychuc.morinsup_equipo5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PaginaPrincipal extends AppCompatActivity {

    private Button btnQs, btnPro, btnCt, btnhelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnQs = findViewById(R.id. button4);
        btnPro= findViewById(R.id.button6);
        btnCt= findViewById(R.id.button5);
        btnhelp=findViewById(R.id.button3);

        btnQs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), QuienesSomos.class);
                startActivity(i);
            }
        });
        btnPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Productos.class);
                startActivity(i);
            }
        });

    }
}
