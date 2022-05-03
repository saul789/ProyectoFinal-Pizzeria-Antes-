package com.example.proyectofinal.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofinal.Helper.MeserosDB;
import com.example.proyectofinal.R;

public class InicioDeSesionActivity extends AppCompatActivity {
MeserosDB helper=new MeserosDB(this,"MeserosDB",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_de_sesion);

       inicioNavigation();

    }


    public void inicioNavigation() {
        Button LoginBtn=(Button) findViewById(R.id.btnLogin);


        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtUsuario=(EditText) findViewById(R.id.TxtUsuario);
                EditText txtContraseña=(EditText) findViewById(R.id.TxtContraseña);

                try { Cursor cursor = helper.ConsultarUsuario(txtUsuario.getText().toString(), txtContraseña.getText().toString());

                    if (cursor.getCount()>0){
                        helper.Mesa();
                       helper.setNomMesero(txtUsuario.getText().toString(), txtContraseña.getText().toString());
                        Intent showActivity=new Intent(getApplicationContext(),MesasActivity.class);
                        startActivity(showActivity);


                    }else {
                        Toast.makeText(getApplicationContext(),"Acceso Inválido. Por favor inténtelo otra Vez ",Toast.LENGTH_LONG).show();
                    }
                    txtUsuario.setText("");
                    txtContraseña.setText("");
                    txtContraseña.findFocus();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        });
        TextView registroBtn=findViewById(R.id.registroBtn);
        registroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InicioDeSesionActivity.this,RegistroActivity.class));
            }
        });
    }
}