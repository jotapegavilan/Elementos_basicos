package com.jotape.elementos_basicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class Componentes_complejos extends AppCompatActivity {

    private Button btnVolver, btnVerDatos;
    private CheckBox cbBasica, cbMedia, cbSuperior;
    private RadioButton rbMasculino, rbFemenino;
    private Switch swDonante;
    private Spinner spCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componentes_complejos);

        btnVolver = findViewById(R.id.btnVolver);
        btnVerDatos = findViewById(R.id.btnVer);
        cbBasica = findViewById(R.id.cbBasica);
        cbMedia = findViewById(R.id.cbMedia);
        cbSuperior = findViewById(R.id.cbSuperior);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        swDonante = findViewById(R.id.swDonante);
        spCiudades = findViewById(R.id.spCiudades);
        rbFemenino.setChecked(true);

        cargarSpinner();

        btnVerDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verificar check box
                ArrayList<String> Educacion =
                        new ArrayList<>();
                if(cbBasica.isChecked() == true){
                    Educacion.add(cbBasica.getText().toString());
                }
                if(cbMedia.isChecked() == true){
                    Educacion.add(cbMedia.getText().toString());
                }
                if(cbSuperior.isChecked() == true){
                    Educacion.add(cbSuperior.getText().toString());
                }
                String textEducacion = " ";
                if(Educacion.size()==0) {
                    textEducacion = "Sin nivel educacional";
                }
                //}else{
                  //  textEducacion = "Educación : ";
                    //if(Educacion.size()==1){
                     //   for(String texto : Educacion){
                     //       textEducacion += texto+".";
                     //   }
                    //}
                //}
                String textoEdu = String.join(",",Educacion);

                // Verificar genero
                String genero = "Indefinido";

                if(rbMasculino.isChecked()){
                    genero = rbMasculino.getText().toString();
                }else if(rbFemenino.isChecked()){
                    genero = rbFemenino.getText().toString();
                }
                //Verificar donante
                String donante;
                if(swDonante.isChecked()){
                    donante = "SI";
                }else{
                    donante = "NO";
                }
                // Desplegar mensaje
                Toast.makeText(Componentes_complejos.this,
                        "Educación : "+textoEdu+"\nGenero : "+genero+
                        "\nEs donante : "+donante,
                        Toast.LENGTH_LONG).show();
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(Componentes_complejos.this, MainActivity.class);
                startActivity(intento);
            }
        });
    }

    public void cargarSpinner(){
        ArrayList<String> ciudades = new ArrayList<>();
        ciudades.add("-Seleccione ciudad-");
        ciudades.add("Lota");
        ciudades.add("Coronel");
        ciudades.add("San Pedro");
        // Spinner aceptan ArrayAdapter

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(Componentes_complejos.this,
                        android.R.layout.simple_spinner_dropdown_item,ciudades);
        spCiudades.setAdapter(adaptador);

    }

}
