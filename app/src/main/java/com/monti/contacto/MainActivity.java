package com.monti.contacto;

import android.app.DatePickerDialog;
import java.util.Calendar;
import java.util.Date;
import java.util.StringJoiner;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

//http://es.androids.help/q25760
// https://www.mkyong.com/android/android-date-picker-example/

public class MainActivity extends AppCompatActivity {

    private TextView viewFecha;
    private static int year;
    private static int month;
    private static int day;
    private Button btnSiguiente;
    private Contacto unContacto;
    DialogFragment newFragment = new DatePickerFragment();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);


        setDateOnView();
        addListenerOnButton();

    }

    private void addListenerOnButton() {
        btnSiguiente = (Button) findViewById(R.id.botonSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
            //    crearObjeto();
           //     String nn = ((EditText) findViewById(R.id.nombreContacto)).getText().toString();
                intent.putExtra(getResources().getString(R.string.pnombre), ((EditText) findViewById(R.id.nombreContacto)).getText().toString());
                intent.putExtra(getResources().getString(R.string.pnacimiento),((TextView) findViewById(R.id.nacimiento)).getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), ((EditText) findViewById(R.id.telefonoContacto)).getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail), ((EditText) findViewById(R.id.emailContacto)).getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), ((EditText) findViewById(R.id.descripContacto)).getText().toString());
                startActivity(intent);
            }
        });
    }

    // muestra fecha actual
    public void setDateOnView() {

        viewFecha = (TextView) findViewById(R.id.nacimiento);
          // set date into textview
        viewFecha.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append("  ").append(day).append("/").append(month + 1).append("/")
                .append(year).append(" "));
    }

    public void showDatePickerDialog(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        newFragment.show(fragmentManager, "datePicker");

        setDateOnView();
    }

    class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int anio, int mes, int dia) {
            // Do something with the date chosen by the user
            year = anio;
            month = mes;
            day = dia;
            viewFecha = (TextView) findViewById(R.id.nacimiento);
            // set date into textview
            viewFecha.setText(new StringBuilder()
                    // Month is 0 based, just add 1
                    .append("  ").append(dia).append("/").append(mes + 1).append("/")
                    .append(anio).append(" "));
        }
    }

}
