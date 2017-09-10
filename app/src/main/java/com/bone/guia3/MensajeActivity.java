package com.bone.guia3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MensajeActivity extends AppCompatActivity {



    public EditText txtEntrada;
    public Button btnEnviar;
    private ListView list;
    private AdaptadorMensaje adaptadorMensaje;
    private ArrayList<Mensaje> mensajeArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        //inicializando varibales
        txtEntrada= (EditText) findViewById(R.id.txtEntrada);
         btnEnviar= (Button) findViewById(R.id.btnEnviar);
//inicializando el adaptador
        mensajeArrayList = new ArrayList<>();

        //inicializando el adaptador
        adaptadorMensaje=new AdaptadorMensaje(this, mensajeArrayList);
        // incializando el listview

       // ListView listView= (ListView) findViewById(R.id.lstMensaje);
        list=(ListView) findViewById(R.id.lstMensaje);
        list.setAdapter(adaptadorMensaje);
        // seteando el adaptador al listview
       // listView.setAdapter(adaptadorMensaje);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             agregar();
            }
        });

    }
    public static  String getfechaActual(){
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat(" dd/MM/yyyy  HH:mm:ss ");
        String dateString = sdf.format(date);

        return dateString;

    }
    public  void agregar() {

        Mensaje c = new Mensaje(
                getfechaActual(),
                txtEntrada.getText().toString()
        );
        mensajeArrayList.add(c);
        adaptadorMensaje.notifyDataSetChanged();
    }
    }

