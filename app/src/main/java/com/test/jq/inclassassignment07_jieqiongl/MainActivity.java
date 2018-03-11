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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView displayText;
    Button addAnimalButton;
    String animalInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayText = (TextView) findViewById(R.id.display_input_text);
        addAnimalButton = (Button) findViewById(R.id.add_animal_button);

        addAnimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), InputActivity.class);
                startActivityForResult(myIntent, Keys.REQUEST_ANIMAL_KEY);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Keys.REQUEST_ANIMAL_KEY && resultCode == RESULT_OK) {
            Animal animal = (Animal) data.getSerializableExtra(Keys.ANIMAL_KEY);
            animalInfo = "";
            animalInfo = animalInfo + animal.toString();
            displayText.setText(animalInfo);
        }
    }

}

