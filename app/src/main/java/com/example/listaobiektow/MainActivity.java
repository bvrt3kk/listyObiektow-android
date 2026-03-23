package com.example.listaobiektow;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Produkt> arrayListProdukty;
    ArrayAdapter<Produkt> arrayAdapter;
    ListView listViewProdukty;

    Button buttonDodaj, buttonUsun;
    EditText editTextNazwa, editTextCena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        arrayListProdukty = new ArrayList<>();
        arrayListProdukty.add(new Produkt("chleb", 4.99));
        arrayListProdukty.add(new Produkt("bułka", 0.60));
        arrayListProdukty.add(new Produkt("jogurt", 3.69));

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListProdukty);
        listViewProdukty = findViewById(R.id.listViewProdukty);
        listViewProdukty.setAdapter(arrayAdapter);

        listViewProdukty.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                arrayListProdukty.get(position).odwroc();
                arrayAdapter.notifyDataSetChanged();
            }
        });

        buttonDodaj = findViewById(R.id.button);
        buttonUsun = findViewById(R.id.buttonUsun);
        editTextNazwa = findViewById(R.id.editTextNazwaProduktu);
        editTextCena = findViewById(R.id.editTextCena);
        buttonDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nazwa = editTextNazwa.getText().toString();
                double cena = Double.parseDouble(editTextCena.getText().toString());
                arrayListProdukty.add(new Produkt(nazwa, cena));
                arrayAdapter.notifyDataSetChanged();
            }
        });
        buttonUsun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayListProdukty.removeIf(Produkt::isCzyKupione);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}