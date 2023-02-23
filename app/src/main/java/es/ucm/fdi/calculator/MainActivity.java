package es.ucm.fdi.calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Calculator calculator;
    private EditText editTextx,editTexty;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator = new Calculator();
        Log.d("MainActivity", "Se ha creado bien la calculadora");
        editTextx = findViewById(R.id.numero1);
        editTexty = findViewById(R.id.numero2);
        button = findViewById(R.id.button);
        buttonListener();
    }


    public void addXandY(){
        Intent intent = new Intent(this, CalculatorResultActivity.class);
        double res = -1;
        try {
            res=calculator.suma(Double.parseDouble(this.editTextx.getText().toString()),Double.parseDouble(this.editTexty.getText().toString()));
            intent.putExtra("suma",res);
            startActivity(intent);
        }
        catch(Exception nfe){
            Log.e("MainActivity","Mete todos los valores: " + nfe.toString());
        }
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