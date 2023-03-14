package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable; // for EditText event handling
import android.text.TextWatcher; // EditText listener
import android.widget.EditText;
import android.widget.TextView; // for displaying text


public class MainActivity extends AppCompatActivity {

    //all nesessary variables
    private double waga = 0.0;
    private double wzrost = 0.15;
    //TextViews definitions
    private TextView wzrostTextView;
    private TextView wagaTextView;


    private TextView totalTextView;

    //method onCreate, most important one
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.activity_main); // inflate the GUI

//looking up TextViews in layout
        wagaTextView = (TextView) findViewById(R.id.wagaTextView);
        wzrostTextView = (TextView) findViewById(R.id.wzrostTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        totalTextView.setText(String.format(0 + ""));

// setting TextWatchers for both weight and height fields
        EditText wagaEditText =
                (EditText) findViewById(R.id.wagaEditText);
        wagaEditText.addTextChangedListener(wagaEditTextWatcher);
        EditText wzrostEditText =
                (EditText) findViewById(R.id.wzrostEditText);
        wzrostEditText.addTextChangedListener(wzrostEditTextWatcher);

    }

    //method calculate, calculating BMI, setting totalTextView as result
    private void calculate() {


        double total = waga / (wzrost * wzrost);


        totalTextView.setText(String.format(total + ""));
    }


    // listeners object for TextViews weight and height text-changed events
    private final TextWatcher wagaEditTextWatcher = new TextWatcher() {
        // called when the user modifies weight or height field, or both
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                waga = Double.parseDouble(s.toString()) / 100.0;
                wagaTextView.setText(String.format(waga + ""));
            } catch (NumberFormatException e) {
                wagaTextView.setText("");
                waga = 0.0;
            }
//recalculate on change
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };
    private final TextWatcher wzrostEditTextWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try {
                wzrost = Double.parseDouble(s.toString()) / 100.0;
                wzrostTextView.setText(String.format(wzrost + ""));
            } catch (NumberFormatException e) {
                wzrostTextView.setText("");
                wzrost = 0.0;
            }
//recalculate on change
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) {
        }
    };
}


