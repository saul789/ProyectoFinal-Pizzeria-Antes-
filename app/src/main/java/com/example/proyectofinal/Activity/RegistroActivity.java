package com.example.proyectofinal.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofinal.Helper.MeserosDB;
import com.example.proyectofinal.R;

public class RegistroActivity extends AppCompatActivity {
    Button btnGuardarMesero;
    EditText txtNombre,txtApellido,txtUsuario,txtPassword;
    MeserosDB helper= new MeserosDB(this,"MeserosDB",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnGuardarMesero=(Button) findViewById(R.id.agregarMeseroBtn);
        txtNombre=findViewById(R.id.TxtNombreM);
        txtApellido=findViewById(R.id.TxtApellidosM);
        txtUsuario=findViewById(R.id.TxtUsuarioM);
        txtPassword=findViewById(R.id.TxtContraseñaM);

        btnGuardarMesero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.abrrir();
                helper.insertarMesero(String.valueOf(txtNombre.getText()),
                        String.valueOf(txtApellido.getText()),
                        String.valueOf(txtUsuario.getText()),
                        String.valueOf(txtPassword.getText()));
                helper.close();
                Toast.makeText(getApplicationContext(),"Mesero Guardado con Exito",Toast.LENGTH_LONG).show();

                Intent intent=new Intent(getApplicationContext(),InicioDeSesionActivity.class);
                startActivity(intent);
            }
        });
    }
}