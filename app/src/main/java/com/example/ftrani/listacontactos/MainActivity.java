package com.example.ftrani.listacontactos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listaContactos;
    private Context context;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mnuAdd:
                Toast.makeText(context,"Hice clic!!",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;

        listaContactos = (ListView) findViewById(R.id.lista_contactos);

        final List<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto(15445566,"Carlos","Lopez"));
        contactos.add(new Contacto(15334455,"Luis","Hernandez"));
        contactos.add(new Contacto(15221155,"Maria","Soria"));
        contactos.add(new Contacto(15998800,"Marta","Garcia"));
        contactos.add(new Contacto(15445566,"Carlos","Lopez"));
        contactos.add(new Contacto(15334455,"Luis","Hernandez"));
        contactos.add(new Contacto(15221155,"Maria","Soria"));
        contactos.add(new Contacto(15998800,"Marta","Garcia"));
        contactos.add(new Contacto(15445566,"Carlos","Lopez"));
        contactos.add(new Contacto(15334455,"Luis","Hernandez"));
        contactos.add(new Contacto(15221155,"Maria","Soria"));
        contactos.add(new Contacto(15998800,"Marta","Garcia"));

        listaContactos.setAdapter(new ContactoAdapter(contactos));

        listaContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contacto item = (Contacto) listaContactos.getItemAtPosition(position);

                String leyenda = "Telefono: "+ item.getTelefono()+" - Nombre: " + item.getNombre() + ", "+item.getApellido();

                Toast.makeText(context,leyenda,Toast.LENGTH_SHORT).show();
            }
        });


    }
}
