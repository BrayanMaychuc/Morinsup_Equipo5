package com.maychuc.morinsup_equipo5;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Registro extends AppCompatActivity {

    private EditText txtusuario, txtPass, txtpass2;
    private Button btnregitrar;
    private int PERMISO_REQUERIDO=11;
    private static Credenciales archivo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Estas variables van a poder leer los datos que les insertemos
        //en el caso del boton, permitira la funcion click
        txtusuario.findViewById(R.id.txtUs);
        txtPass.findViewById(R.id.txtPass);
        txtpass2.findViewById(R.id.txtpass2);
        btnregitrar.findViewById(R.id.btnguardar);

        archivo = new Credenciales(getApplicationContext().getExternalFilesDir(null).getPath());

        btnregitrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtPass.getText().toString().isEmpty() |
                        txtpass2.getText().toString().isEmpty() || txtusuario.getText().toString().isEmpty
                        ()) {
                    Toast.makeText(getApplicationContext(), "No deje campos vacíos",
                            Toast.LENGTH_SHORT).show();
                } else if
                (archivo.getValidaPassUs(txtPass.getText().toString().trim(), txtpass2.getText().
                                toString().trim()) == false) {
                    Toast.makeText(getApplicationContext(), "Las contraseñas son diferentes",
                            Toast.LENGTH_SHORT).show();
                    return;
                } else if (archivo.getDuplicado(txtusuario.getText().toString()) == true) {
                    Toast.makeText(getApplicationContext(), "El usuario se encuentra en la BD",
                            Toast.LENGTH_SHORT).show();
                } else {
                    int resultado =
                            archivo.setInsertarCredenciales(txtusuario.getText().toString(), txtPass.getText(
                            ).toString(), getApplicationContext());
                    if (resultado == 1) {
                        finish();
                        Toast.makeText(getApplicationContext(), "El usuario se registró con éxito", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }

    public void setPermiso() {
        int permisosd = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int permisosdescribir = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permisosd != getPackageManager().PERMISSION_GRANTED || permisosdescribir
                != getPackageManager().PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new
                        String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE},PERMISO_REQUERIDO);
            }
        }



    }
}
