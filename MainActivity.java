package com.codecademy.simplecalculator;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView firstNumber = (TextView) findViewById(R.id.number1);
        final TextView secondNumber = (TextView) findViewById(R.id.number2);
        final RadioGroup operators = (RadioGroup) findViewById(R.id.operators);
        final RadioButton add = (RadioButton) findViewById(R.id.add);
        final RadioButton subtract = (RadioButton) findViewById(R.id.subtract);
        final RadioButton multiply = (RadioButton) findViewById(R.id.multiply);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);
        Button equals = (Button) findViewById(R.id.equlas);
        final TextView result = (TextView) findViewById(R.id.result);
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double firstNumberValue = Double.parseDouble(firstNumber.getText().toString());
                double secondNumberValue = Double.parseDouble(secondNumber.getText().toString());
                int operatorButtonId = operators.getCheckedRadioButtonId();
                Double answer = null;
                if((firstNumberValue>=0 && secondNumberValue >=0) || (firstNumberValue <=0 && secondNumberValue <=0)) {
                    if (operatorButtonId == add.getId()) {
                        answer = firstNumberValue + secondNumberValue;
                    } else if (operatorButtonId == subtract.getId()) {
                        answer = firstNumberValue - secondNumberValue;
                    } else if (operatorButtonId == multiply.getId()) {
                        answer = firstNumberValue * secondNumberValue;
                    } else {
                        answer = firstNumberValue / secondNumberValue;
                    }

                    result.setText(answer.toString());
                }else{
                    result.setText("enter numbers");
                }
            }
        });
    }



}
