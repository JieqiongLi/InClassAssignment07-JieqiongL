package com.test.jq.inclassassignment07_jieqiongl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {
    Button submitButton;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    private String habitat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        spinner = (Spinner) findViewById(R.id.habitat_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter = ArrayAdapter.createFromResource(this, R.array.habitat_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                habitat = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submitButton = (Button) findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((EditText) findViewById(R.id.name_edit)).getText().toString();
                int legs = Integer.parseInt(((EditText) findViewById(R.id.legs_edit)).getText().toString());
                boolean hasFur = ((CheckBox) findViewById(R.id.has_fur_checkbox)).isChecked();
                Animal animal = new Animal(name, legs, hasFur, habitat);

                Intent data = new Intent();
                data.putExtra(Keys.ANIMAL_KEY, animal);
                setResult(RESULT_OK, data);
                finish();
            }
        });

    }
}