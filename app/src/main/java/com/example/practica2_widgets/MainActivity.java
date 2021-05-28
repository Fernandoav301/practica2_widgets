package com.example.practica2_widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CheckBox check1, check2, check3;
    private Button btn1;
    private Spinner spColores;
    private List<String> listcol=new ArrayList<String>();
    private ArrayAdapter<String> adpList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check1=(CheckBox)findViewById(R.id.check1);
        check2=(CheckBox)findViewById(R.id.check2);
        check3=(CheckBox)findViewById(R.id.check3);
        btn1=(Button) findViewById(R.id.click);
        spColores=(Spinner)findViewById(R.id.spin1);
        listcol.add("Rojo");
        listcol.add("Verde");
        listcol.add("Azul");
        listcol.add("Amarillo");
        adpList=new ArrayAdapter<String>( this,android.R.layout.simple_list_item_1,listcol);
        adpList.setDropDownViewResource(R.layout.spinnernegro);
        spColores.setAdapter(adpList);

        spColores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected (AdapterView<?> parent, View view, int position, long id) {
                String colorSelect= listcol.get(position);
                Toast.makeText(getApplicationContext(), "Usted Selecciono el color: "+ colorSelect,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)  {

            }

        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check1.isChecked())
                    Toast.makeText(getApplicationContext(), "Usted Marco el color Rojo", Toast.LENGTH_SHORT).show();
                if(check2.isChecked())
                    Toast.makeText(getApplicationContext(), "Usted Marco el color Verde", Toast.LENGTH_SHORT).show();
                if(check3.isChecked())
                    Toast.makeText(getApplicationContext(), "Usted Marco el color Azul", Toast.LENGTH_SHORT).show();
            }
        });
         check1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(check1.isChecked()==true)
                 Toast.makeText(getApplicationContext(), "Acabas de marcar el color Rojo", Toast.LENGTH_SHORT);
             }
         });
    }
}