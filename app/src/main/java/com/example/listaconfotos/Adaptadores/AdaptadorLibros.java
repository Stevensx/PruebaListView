package com.example.listaconfotos.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.listaconfotos.Modelos.LibrosModel;
import com.example.listaconfotos.Modelos.Usuario;
import com.example.listaconfotos.R;

import java.util.ArrayList;


public class AdaptadorLibros extends ArrayAdapter<LibrosModel> {
    public AdaptadorLibros(Context context, ArrayList<LibrosModel> datos) {
        super(context, R.layout.lyitemlibros, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemlibros, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).getNombres());
        TextView lblEmail = (TextView)item.findViewById(R.id.lblEmail);
        lblEmail.setText(getItem(position).getEmail());
        TextView lblweb = (TextView)item.findViewById(R.id.lblweb);
        lblweb.setText(getItem(position).getWebsite());
        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext()).load(getItem(position).getUrlavatar()).into(imageView);
        return(item);
    }
}
