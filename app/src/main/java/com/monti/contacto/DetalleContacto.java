package com.monti.contacto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto_detalle);

        Bundle param = getIntent().getExtras();
        String nombre = param.getString(getResources().getString(R.string.pnombre));
        String nacimiento = param.getString(getResources().getString(R.string.pnacimiento));
        String telefono = param.getString(getResources().getString(R.string.ptelefono));
        String email = param.getString(getResources().getString(R.string.pemail));
        String desripcion = param.getString(getResources().getString(R.string.pdescripcion));

        TextView tvnombre = (TextView) findViewById(R.id.tvnombre);
        TextView tvnacimiento = (TextView) findViewById(R.id.tvnacimiento);
        TextView tvtelefono = (TextView) findViewById(R.id.tvtelefono);
        TextView tvemail = (TextView) findViewById(R.id.tvemail);
        TextView tvdescripcion = (TextView) findViewById(R.id.tvdescripcion);

        tvnombre.setText(nombre);
        tvnacimiento.setText(nacimiento);
        tvtelefono.setText(telefono);
        tvemail.setText(email);
        tvdescripcion.setText(desripcion);

        Button btneditar = (Button) findViewById(R.id.tvboton);
        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
