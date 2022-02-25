package com.maychuc.morinsup_equipo5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity {

    private EditText txtusuario, txtPass, txtpass2;
    private Button btnregitrar;
    private int PERMISO_REQUERIDO=11;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Estas variables van a poder leer los datos que les insertemos
        //en el caso del boton, permitira la funcion click
        txtusuario.findViewById(R.id.txtUs);
        txtPass.findViewById(R.id.txtPass);
        txtpass2.findViewById(R.id.txtpass2);
        btnregitrar.findViewById(R.id.btnguardar);

    }
}
