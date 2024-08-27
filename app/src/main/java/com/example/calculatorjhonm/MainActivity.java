package com.example.calculatorjhonm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumber;
    private EditText secondNumber;
    private TextView lifecycleText;
    private TextView resultText;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        lifecycleText = findViewById(R.id.lifecycleText);
        resultText = findViewById(R.id.resultText);

        Switch themeSwitch = findViewById(R.id.themeSwitch);
        themeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });
    }

    public void onDigit(View view) {
        Button button = (Button) view;
        String digit = button.getText().toString();
        if (operator.isEmpty()) {
            firstNumber.append(digit);
        } else {
            secondNumber.append(digit);
        }
    }

    public void onOperator(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
    }

    public void onClear(View view) {
        firstNumber.setText("");
        secondNumber.setText("");
        operator = "";
        resultText.setText("Result: 0");
    }

    public void onEqual(View view) {
        String num1 = firstNumber.getText().toString();
        String num2 = secondNumber.getText().toString();

        if (num1.isEmpty() || num2.isEmpty() || operator.isEmpty()) {
            return; // Do nothing if any field is empty
        }

        double n1 = Double.parseDouble(num1);
        double n2 = Double.parseDouble(num2);
        double result;

        switch (operator) {
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                if (n2 != 0) {
                    result = n1 / n2;
                } else {
                    // Handle division by zero
                    result = Double.NaN; // or use a different way to handle the error
                }
                break;
            default:
                result = 0;
                break;
        }

        // Show result in resultText
        resultText.setText("Result: " + result);
        firstNumber.setText(""); // Clear first number
        secondNumber.setText(""); // Clear second number
        operator = ""; // Reset operator
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifecycleText.setText("OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        lifecycleText.setText("OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        lifecycleText.setText("OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleText.setText("OnDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        lifecycleText.setText("OnRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifecycleText.setText("OnStart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        lifecycleText.setText("OnSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lifecycleText.setText("OnRestoreInstanceState");
    }
}
