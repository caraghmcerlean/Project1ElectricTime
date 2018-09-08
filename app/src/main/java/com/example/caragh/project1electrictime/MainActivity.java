package com.example.caragh.project1electrictime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;

    public ArrayList<Transport> transportList;
    public ArrayList<String> methodList;
    public ArrayList<Double> speedList;
    public ArrayList<Integer> rangeList;

    private Adapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        transportList = new ArrayList<>();
        adapt = new Adapter(transportList);
        recyclerView.setAdapter(adapt);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.transport_array, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        methodList = new ArrayList<String>(
                Arrays.asList(
                        "Walking",
                        "Boosted Mini S Board",
                        "Evolve Skateboard",
                        "OneWheel",
                        "MotoTec Skateboard",
                        "Segway Ninebot One S1",
                        "Segway i2 SE",
                        "Razor Scooter",
                        "GeoBlade 500",
                        "Hovertrax Hoverboard"));

        speedList = new ArrayList<Double>(Arrays.asList(3.1, 18., 26., 19., 22., 12.5, 12.5, 10., 15., 8.));
        rangeList = new ArrayList<>(Arrays.asList(30, 7, 31, 7, 10, 15, 24, 7, 8, 9));


        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                DoTheThing();
            }
        });
    }

    //inspiration for this layout found here: https://www.androidhive.info/2016/05/android-working-with-card-view-and-recycler-view/

    //wait for user to input distance and preferred method
    //display the top card with a different colored background
    //follow with comparisons

    public void DoTheThing(){
        transportList.clear();
        adapt.notifyDataSetChanged();

        EditText distanceInput = (EditText) findViewById(R.id.inputNum);
        String str = distanceInput.getText().toString();
        if(str.isEmpty()){ str = "0"; }
        double distance = Double.parseDouble(str); //distance variable

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        String name = spinner.getSelectedItem().toString();

        for (int i=0; i<methodList.size();i++){
            Transport temp = new Transport(methodList.get(i), speedList.get(i), distance, rangeList.get(i));

            if (methodList.get(i).equals(name)){
                transportList.add(0, temp);
            }else {
                transportList.add(temp);

            }
        }
        adapt.notifyDataSetChanged();
    }

}
