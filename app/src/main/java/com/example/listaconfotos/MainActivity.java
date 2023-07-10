package com.example.listaconfotos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listaconfotos.Adaptadores.AdaptadorUsuario;
import com.example.listaconfotos.Modelos.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Webservice.Asynchtask;
import Webservice.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask,AdapterView.OnItemClickListener {
    ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstOpciones = (ListView)findViewById(R.id.listusuario);
        View header = getLayoutInflater().inflate(R.layout.ldheaderusuarios, null);
        lstOpciones.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivity.this,MainActivity.this );
        ws.execute("GET");

        lstOpciones.setOnItemClickListener(this);




    }

    @Override
    public void processFinish(String result) throws JSONException {

        JSONArray JSONlistaUsuarios= new JSONArray(result);
        ArrayList<Usuario>lstUsuarios = Usuario.JsonObjectsBuild(JSONlistaUsuarios);
        AdaptadorUsuario adapatorUsuario = new AdaptadorUsuario(this,lstUsuarios );
        lstOpciones.setAdapter(adapatorUsuario);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Usuario user = (Usuario) adapterView.getItemAtPosition(position);
        if (position == 1) {
            int a = 3;
            Bundle b = new Bundle();
            b.putInt("journal_id", a);
            Intent intent = new Intent(MainActivity.this, otraActividad.class);
            intent.putExtras(b);
            startActivity(intent);
        } else if (position == 2) {
            int d = 2;
            Bundle b = new Bundle();
            b.putInt("journal_id", d);
            Intent intent = new Intent(MainActivity.this, otraActividad.class);
            intent.putExtras(b);
            startActivity(intent);
        } else if (position == 3) {
            int c = 1;
            Bundle b = new Bundle();
            b.putInt("journal_id", c);
            Intent intent = new Intent(MainActivity.this, otraActividad.class);
            intent.putExtras(b);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_SHORT).show();
        }
    }
}