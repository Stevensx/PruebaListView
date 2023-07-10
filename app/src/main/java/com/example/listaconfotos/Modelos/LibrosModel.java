package com.example.listaconfotos.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LibrosModel {
    private String nombres;
    private String email;
    private String website;
    private String urlavatar;
    public LibrosModel(JSONObject a) throws JSONException {
        nombres = a.getString("title").toString();
        email = a.getString("volume").toString() ;
        website = a.getString("date_published").toString() ;
        urlavatar = a.getString("cover").toString() ;
    }
    public static ArrayList<LibrosModel> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<LibrosModel> libros = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            libros.add(new LibrosModel(datos.getJSONObject(i)));
        }
        return libros;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUrlavatar() {
        return urlavatar;
    }

    public void setUrlavatar(String urlavatar) {
        this.urlavatar = urlavatar;
    }
}
