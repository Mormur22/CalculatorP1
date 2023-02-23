package es.ucm.fdi.calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public Calculator calculator;
    private EditText editTextx,editTexty;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator = new Calculator();
        editTextx = findViewById(R.id.numero1);
        editTexty = findViewById(R.id.numero2);
        button = findViewById(R.id.button);
        buttonListener();
    }


    public void addXandY(){
        Intent intent = new Intent(this, CalculatorResultActivity.class);
        double res=calculator.suma(Double.parseDouble(this.editTextx.getText().toString()),Double.parseDouble(this.editTexty.getText().toString()));
        intent.putExtra("suma",res);
        startActivity(intent);
    }

    public void buttonListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addXandY();
            }
        });
    }
}