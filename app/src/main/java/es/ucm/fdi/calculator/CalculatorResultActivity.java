package es.ucm.fdi.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CalculatorResultActivity extends AppCompatActivity {

    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_result);
        Intent intent = getIntent();
        double result = intent.getDoubleExtra("suma", 0);
        view=findViewById(R.id.result);
        view.setText(Double.toString(result));
    }
}