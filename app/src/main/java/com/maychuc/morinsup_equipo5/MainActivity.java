package com.maychuc.morinsup_equipo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etxtUs,etxtPass;
    private Button btnIniciar, btnRegistrar;
    private Credenciales archivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIniciar=findViewById(R.id.btnCinicio);
        btnRegistrar=findViewById(R.id.btnCregistro);
        etxtUs=findViewById(R.id.etxtCuser);
        etxtPass=findViewById(R.id.etxtCpass);
        archivo = new Credenciales(getApplicationContext().getExternalFilesDir(null).getPath());

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Registro.class);
                startActivity(i);
            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etxtUs.getText().toString().isEmpty() |
                        etxtPass.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"No deje campos vacíos",
                            Toast.LENGTH_SHORT).show();
                }
                else if
                (archivo.getValidacion(etxtUs.getText().toString(),etxtPass.getText().toString())) {
                    Toast.makeText(getApplicationContext(),"Usuario válido", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),archivo.getEncriptar(etxtPass.getText().toString()),Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), PaginaPrincipal.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(),"El usuario no está registrado",Toast.LENGTH_SHORT).show();
                }
            }

        });


    }
}