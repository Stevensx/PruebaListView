package com.example.listaconfotos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.listaconfotos.Adaptadores.AdaptadorLibros;
import com.example.listaconfotos.Modelos.LibrosModel;
import com.example.listaconfotos.Modelos.Usuario;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Webservice.Asynchtask;
import Webservice.WebService;

public class otraActividad extends AppCompatActivity implements Asynchtask {
    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otra_actividad);
        Bundle bundle  = this.getIntent().getExtras();
        lstOpciones = (ListView) findViewById(R.id.listlibros);
        View header = getLayoutInflater().inflate(R.layout.ldheaderusuarios,null);
        lstOpciones.addHeaderView(header);
        int a = bundle.getInt("journal_id");
        String url = "https://revistas.uteq.edu.ec/ws/issues.php?j_id=" + a;
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws = new WebService(url, datos, otraActividad.this, otraActividad.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray jsonArray = new JSONArray(result);
        ArrayList<LibrosModel> listlibros = LibrosModel.JsonObjectsBuild(jsonArray);
        AdaptadorLibros adaptadorLibros = new AdaptadorLibros(this, listlibros);
        lstOpciones.setAdapter(adaptadorLibros);

    }
}