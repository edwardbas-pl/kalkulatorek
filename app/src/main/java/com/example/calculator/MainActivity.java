package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {

    TextView workingsTV;
    TextView resultsTV;

    String workings = "";
    String results = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putString("KEY1", workings);
        outState.putString("KEY2", results);
    }


    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        workings = savedInstanceState.getString("KEY1", workings);
        results = savedInstanceState.getString("KEY2", results);
        workingsTV.setText(workings);
        resultsTV.setText(results);
    }

    private void initTextViews()
    {
        workingsTV = (TextView)findViewById(R.id.workingsTextView);
        resultsTV = (TextView)findViewById(R.id.resultTextView);
    }


    private void setWorkings(String givenValue)
    {
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }


    public void equalsOnClick(View view)
    {
        Expression e = new Expression(workings);
        double v = e.calculate();
        results = Double.toString(v);
        resultsTV.setText(results);
    }


    public void clearOnClick(View view)
    {
        if(workings.length() > 0) {
            workings = workings.substring(0, workings.length() - 1);
            workingsTV.setText(workings);
            resultsTV.setText("");
        }
    }

    public void clearAllOnClick(View view)
    {
        workingsTV.setText("");
        workings = "";
        results = "";
        resultsTV.setText("");
    }


    public void plusMinusOnClick(View view)
    {
        setWorkings("-");
    }

    public void percentageOnClick(View view)
    {
        setWorkings("%");
    }

    public void divisionOnClick(View view)
    {
        setWorkings("/");
    }

    public void sevenOnClick(View view)
    {
        setWorkings("7");
    }

    public void eightOnClick(View view)
    {
        setWorkings("8");
    }

    public void nineOnClick(View view)
    {
        setWorkings("9");
    }

    public void timesOnClick(View view)
    {
        setWorkings("*");
    }

    public void fourOnClick(View view)
    {
        setWorkings("4");
    }

    public void fiveOnClick(View view)
    {
        setWorkings("5");
    }

    public void sixOnClick(View view)
    {
        setWorkings("6");
    }

    public void minusOnClick(View view)
    {
        setWorkings("-");
    }

    public void oneOnClick(View view)
    {
        setWorkings("1");
    }

    public void twoOnClick(View view)
    {
        setWorkings("2");
    }

    public void threeOnClick(View view)
    {
        setWorkings("3");
    }

    public void plusOnClick(View view)
    {
        setWorkings("+");
    }

    public void decimalOnClick(View view)
    {
        setWorkings(".");
    }

    public void zeroOnClick(View view)
    {
        setWorkings("0");
    }

    public void doublePowerOnClick(View view)
    {
        setWorkings("^2");
    }

    public void triplePowerOnClick(View view)
    {
        setWorkings("^3");
    }

    public void sqrtOnClick(View view)
    {
        String sqrtValue = workings;
        workings = "";
        setWorkings("sqrt("+sqrtValue+")");
    }

    public void factorialOnClick(View view)
    {
        setWorkings("!");
    }

    public void logarithmOnClick(View view)
    {
        String logValue = workings;
        workings = "";
        setWorkings("log10("+logValue+")");
    }
}