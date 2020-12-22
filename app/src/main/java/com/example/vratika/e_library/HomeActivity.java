package com.example.vratika.e_library;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

public class HomeActivity extends AppCompatActivity  {

    private Button button1; //button declaration
    List<String> Subjects = new ArrayList<>(); //list declaration-SUBJECTS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //button next start
        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(HomeActivity.this, nextbutton.class);//to nextbutton.class
                startActivity(intent1);
            }
        });//next button end


        //SPINNER1-Semester selection
        Spinner spinner1 = findViewById(R.id.spinner1);                                  //R.array.Semester to call string.xml
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//diff layouts
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { //when item is selected

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { //when nothing is selected

            }
        });//SPINNER1 ends


        //SPINNER2- BRANCH SELECTION
        Spinner spinner2 = findViewById(R.id.spinner2);                                   //R.array.Branch
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Branch, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2); //to associate it with list
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override          //When items in Branch are selected
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).equals("ECE")) {
                    Subjects.clear(); //Subjects list cleared and items are added.
                    Subjects.add("Select Subject");
                    Subjects.add("DC");
                    Subjects.add("ARM");
                    Subjects.add("VLSI");
                    Subjects.add("CCN");
                    Subjects.add("DSS");
                    Subjects.add("PYTHON");
                    fillSpinner(); //My method to create a spinner out of the list.
                } else if (adapterView.getItemAtPosition(i).equals("CSE")) {
                    Subjects.clear();
                    Subjects.add("Select Subject");
                    Subjects.add("DM");
                    Subjects.add("OS");
                    Subjects.add("CD");
                    Subjects.add("PYTHON");
                    Subjects.add("CNS");
                    Subjects.add("CG");
                    fillSpinner(); //method
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { //nothing selected

            }
        });
    }

        //fillSpinner method
        public void fillSpinner(){
            Spinner spinner3 = findViewById(R.id.spinner3);                                                    //Subjects list included
            ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,Subjects);
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner3.setAdapter(adapter3);
        }
}


