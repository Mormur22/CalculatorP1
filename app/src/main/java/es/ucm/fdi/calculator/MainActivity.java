package es.ucm.fdi.calculator;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Calculator calculator;
    private TextView t_sumando;
    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,buttonsuma,buttonequal,buttonAc,buttoncoma;

    private int entera,contadordecimal;
    private double total,sumando, decimal;
    private boolean pulsacoma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.total=0;
        this.sumando=0;
        this.entera=0;
        this.decimal=0;
        this.contadordecimal=1;
        this.pulsacoma=false;
        calculator = new Calculator();
        Log.d("MainActivity", "Se ha creado bien la calculadora");
        t_sumando = findViewById(R.id.sumando);
        t_sumando.setText(Double.toString(sumando));
        button1 = findViewById(R.id.b1);
        button1.setOnClickListener(this);

        button2 = findViewById(R.id.b2);
        button2.setOnClickListener(this);

        button3 = findViewById(R.id.b3);
        button3.setOnClickListener(this);

        button4 = findViewById(R.id.b4);
        button4.setOnClickListener(this);

        button5 = findViewById(R.id.b5);
        button5.setOnClickListener(this);

        button6 = findViewById(R.id.b6);
        button6.setOnClickListener(this);

        button7 = findViewById(R.id.b7);
        button7.setOnClickListener(this);

        button8 = findViewById(R.id.b8);
        button8.setOnClickListener(this);

        button9 = findViewById(R.id.b9);
        button9.setOnClickListener(this);

        button0 = findViewById(R.id.b0);
        button0.setOnClickListener(this);

        buttonsuma = findViewById(R.id.suma);
        buttonsuma.setOnClickListener(this);

        buttoncoma = findViewById(R.id.coma);
        buttoncoma.setOnClickListener(this);

        buttonAc = findViewById(R.id.borrar);
        buttonAc.setOnClickListener(this);

        buttonequal = findViewById(R.id.igual);
        buttonequal.setOnClickListener(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Verifica si la orientación de la pantalla ha cambiado
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.w("MainActivity","La pantalla ahora está en modo horizontal");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.w("MainActivity","La pantalla ahora está en modo vertical");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void addXandY(){
        Intent intent = new Intent(this, CalculatorResultActivity.class);

        try {
            intent.putExtra("suma",calculator.getTotal());
            startActivity(intent);

        }
        catch(Exception nfe){
            Log.e("MainActivity","No se ha podido mostrar el valor" + nfe.toString());
        }
        calculator.reset();
        calculator.setTotal(0);
    }


    public void onClick(View v) {

        switch (v.getId()){

            // cases applied over different buttons
            case R.id.b1:
                Log.i("MainActivity","Has pulsado el boton: 1");
                calculator.suma(1);
                break;

            case R.id.b2:
                Log.i("MainActivity","Has pulsado el boton: 2");
                calculator.suma(2);
                break;

            case R.id.b3:
                Log.i("MainActivity","Has pulsado el boton: 3");
                calculator.suma(3);
                break;

            case R.id.b4:
                Log.i("MainActivity","Has pulsado el boton: 4");
                calculator.suma(4);
                break;

            case R.id.b5:
                Log.i("MainActivity","Has pulsado el boton: 5");
                calculator.suma(5);
                break;

            case R.id.b6:
                Log.i("MainActivity","Has pulsado el boton: 6");
                calculator.suma(6);
                break;

            case R.id.b7:
                Log.i("MainActivity","Has pulsado el boton: 7");
                calculator.suma(7);
                break;

            case R.id.b8:
                Log.i("MainActivity","Has pulsado el boton: 8");
                calculator.suma(8);
                break;

            case R.id.b9:
                Log.i("MainActivity","Has pulsado el boton: 9");
                calculator.suma(9);
                break;

            case R.id.b0:
                Log.i("MainActivity","Has pulsado el boton: 0");
                calculator.suma(0);
                break;

            case R.id.suma:
                Log.i("MainActivity","Has pulsado el boton: suma");
                calculator.sumaTotal();
                this.calculator.reset();
                break;

            case R.id.coma:
                Log.i("MainActivity","Has pulsado el boton: coma");
                calculator.setPulsacoma(true);
                break;

            case R.id.borrar:
                Log.i("MainActivity","Has pulsado el boton: borrar");
                this.calculator.reset();
                break;

            case R.id.igual:
                Log.i("MainActivity","Has pulsado el boton: igual");
                calculator.sumaTotal();
                this.calculator.reset();
                this.addXandY();
                break;

        }

        t_sumando.setText(Double.toString(calculator.getSumando()));
    }
}