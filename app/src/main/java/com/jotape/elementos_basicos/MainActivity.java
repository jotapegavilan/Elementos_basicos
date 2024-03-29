package com.jotape.elementos_basicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;


public class MainActivity extends AppCompatActivity {

    // Declarar los objetos visuales
    private TextView txtTitulo;
    private EditText txtNombre, txtEdad, txtEmail;
    private Button btnGuardar, btnMover;
    private String nombre, email;
    private int edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Realizar el enlace a la UI
        txtTitulo = findViewById(R.id.txtTitulo);
        txtNombre = findViewById(R.id.txtNombre);
        txtEdad = findViewById(R.id.txtEdad);
        txtEmail = findViewById(R.id.txtEmail);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnMover = findViewById(R.id.btnMover);

        // Escuchador de click para el boton 2

        btnMover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Nos mueva desde la main activity a otra
                // Intent
                Intent intento =
                        new Intent(MainActivity.this,
                        Componentes_complejos.class);

                startActivity(intento);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Todo lo que programemos acá
                // se ejecutará al hacer click en el botón
                nombre = txtNombre.getText().toString();
                email = txtEmail.getText().toString();
                try {
                    edad = Integer.parseInt(txtEdad.getText().toString());
                    //Validaciones
                    // min nombre = 3 letras
                    // min email = 13 letras
                    // edad minima 5 y maxima 100
                    if(nombre.length() < 3){
                        Toast.makeText(MainActivity.this,
                                "Error : El nombre debe contener minino 3 letras",
                                Toast.LENGTH_LONG).show();
                        txtNombre.requestFocus();
                    }else if(email.length() < 13){
                        Toast.makeText(MainActivity.this,
                                "Error : El email debe contener minino 13 letras",
                                Toast.LENGTH_LONG).show();
                        txtEmail.requestFocus();
                    }else if(edad <5 || edad>100){
                        Toast.makeText(MainActivity.this,
                                "Error : La edad minina es 5 años y maxima 100 años",
                                Toast.LENGTH_LONG).show();
                        txtEdad.requestFocus();
                    }else{
                        //Toast = enviar mensajes emergentes en android
                        FancyToast.makeText(MainActivity.this,
                                "Nombre :"+nombre+"\nEdad :"+edad+"\nEmail :"+email,
                                FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,
                            "Ingrese la edad!",Toast.LENGTH_LONG).show();
                    txtEdad.requestFocus(); // Dar foco a la caja edad
                }



            }
        });


    }
}
