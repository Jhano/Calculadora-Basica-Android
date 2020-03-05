package com.example.appejemplo;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View.OnClickListener;
import android.media.MediaPlayer;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener  {

    private Button btnC, btnDividir, btnMultiplicar, btnSuma, btnResta, btnBorrar, btnPorcentaje, btnComa, btnCero, btnUno, btnDos, btnTres,
                   btnCuatro, btnCinco, btnSix, btnSiete, btnOcho, btnNueve, btnIgual;

    private TextView contentResult;

    private String resultado = "";
    private String resultadoAux = "";
    private String operador = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnC = (Button) findViewById(R.id.btnC); //(Button) castear funcionaldiad el boton
        btnDividir = (Button) findViewById(R.id.btnDividir);
        btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnSuma = (Button) findViewById(R.id.btnSuma);
        btnResta = (Button) findViewById(R.id.btnResta);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        btnPorcentaje = (Button) findViewById(R.id.btnPorcentaje);
        btnComa = (Button) findViewById(R.id.btnComa);
        btnCero = (Button) findViewById(R.id.btnCero);
        btnUno = (Button) findViewById(R.id.btnUno);
        btnDos = (Button) findViewById(R.id.btnDos);
        btnTres = (Button) findViewById(R.id.btnTres);
        btnCuatro = (Button) findViewById(R.id.btnCuatro);
        btnCinco = (Button) findViewById(R.id.btnCinco);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSiete = (Button) findViewById(R.id.btnSiete);
        btnOcho = (Button) findViewById(R.id.btnOcho);
        btnNueve = (Button) findViewById(R.id.btnNueve);
        btnIgual = (Button) findViewById(R.id.btnIgual);

        contentResult = (TextView) findViewById(R.id.contentResult);

        btnC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultado = "";
                resultadoAux = "";

                contentResult.setText(resultado);
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultado = resultado.substring(0, resultado.length() - 1);

                contentResult.setText(resultado);
            }
        });

        btnCero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultado += "0";
                resultado = limitContentResultado(resultado);
                contentResult.setText(resultado);
            }
        });

        btnUno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultado += "1";
                resultado = limitContentResultado(resultado);
                contentResult.setText(resultado);
            }
        });

        btnDos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultado += "2";
                resultado = limitContentResultado(resultado);
                contentResult.setText(resultado);
            }
        });

        btnTres.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultado += "3";
                resultado = limitContentResultado(resultado);
                contentResult.setText(resultado);
            }
        });
        btnCuatro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultado += "4";
                resultado = limitContentResultado(resultado);
                contentResult.setText(resultado);
            }
        });
        btnCinco.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultado += "5";
                resultado = limitContentResultado(resultado);
                contentResult.setText(resultado);
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultado += "6";
                resultado = limitContentResultado(resultado);
                contentResult.setText(resultado);
            }
        });
        btnOcho.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultado += "8";
                resultado = limitContentResultado(resultado);
                contentResult.setText(resultado);
            }
        });
        btnNueve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultado += "9";
                resultado = limitContentResultado(resultado);
                contentResult.setText(resultado);
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultadoAux = contentResult.getText().toString();
                operador = "-";
                resultado = "";
                contentResult.setText(resultado);
            }
        });

        btnSuma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultadoAux = contentResult.getText().toString();
                operador = "+";
                resultado = "";
                contentResult.setText(resultado);
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultadoAux = contentResult.getText().toString();
                operador = "X";
                resultado = "";
                contentResult.setText(resultado);
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultadoAux = contentResult.getText().toString();
                operador = "÷";
                resultado = "";
                contentResult.setText(resultado);
            }
        });

        btnComa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultado += ".";
                resultado = limitContentResultado(resultado);
                contentResult.setText(resultado);
            }
        });

        btnPorcentaje.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resultadoAux = contentResult.getText().toString();
                operador = "%";
                resultado += "%";
                contentResult.setText(resultado);
            }
        });


        btnIgual.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                playSound();
                resultado = contentResult.getText().toString();
                if(resultado.isEmpty()){
                    resultado = "0";
                }
                Double resultOperation;



                if(operador.equals("+")){
                    resultOperation = Double.parseDouble(resultadoAux) + Double.parseDouble(resultado);
                    contentResult.setText(String.valueOf(resultOperation));
                    resultadoAux ="";

                }

                if(operador.equals("-")){
                    resultOperation = Double.parseDouble(resultadoAux) - Double.parseDouble(resultado);
                    contentResult.setText(String.valueOf(resultOperation));
                    resultadoAux ="";

                }

                if(operador.equals("X")){
                    resultOperation = Double.parseDouble(resultadoAux) * Double.parseDouble(resultado);
                    contentResult.setText(String.valueOf(resultOperation));
                    resultadoAux ="";

                }

                if(operador.equals("÷")){
                    resultOperation = Double.parseDouble(resultadoAux) / Double.parseDouble(resultado);
                    contentResult.setText(String.valueOf(resultOperation));
                    resultadoAux ="";

                }

                if(operador.equals("%")){
                    resultOperation = Double.parseDouble(resultadoAux) / 100;
                    contentResult.setText(String.valueOf(resultOperation));
                    resultadoAux ="";

                }


            }
        });



    }

    public void playSound(){
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sound);
        mp.start();
    }

    public String limitContentResultado (String resultado){
        resultado = this.resultado;
        Integer maxLength = 36;
        if(resultado.length()  > maxLength){
            resultado = resultado.substring(0, resultado.length() - 1);
        }

        return resultado;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }

}
