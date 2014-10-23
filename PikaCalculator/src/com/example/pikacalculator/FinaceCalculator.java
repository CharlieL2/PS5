package com.example.pikacalculator;

import org.w3c.dom.Text;

import engine.Calc;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class FinaceCalculator extends ActionBarActivity implements OnClickListener {

	Button pika;
	EditText editInvestment, editAnnual, editFuture;
	Spinner spinnerYears;
	Text textInvestment, textYears, textAnnual, textFuture;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finace_calculator);
		
		spinnerYears = (Spinner) findViewById(R.id.SpinnerYears);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.possible_years, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerYears.setAdapter(adapter);
		
		pika = (Button) findViewById(R.id.pika);
		editInvestment = (EditText) findViewById(R.id.editInvestment);
		editAnnual = (EditText) findViewById(R.id.editAnnual);
		editFuture = (EditText) findViewById(R.id.editFuture);
		textInvestment = (Text) findViewById(R.id.textInvestment);
		textYears = (Text) findViewById(R.id.textYears);
		textAnnual = (Text) findViewById(R.id.textAnnual);
		textFuture = (Text) findViewById(R.id.textFuture);
		
		pika.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.finace_calculator, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/** Called when the user clicks the Pika! button */

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
			  EditText editInvestmentText = (EditText) findViewById(R.id.editInvestment); 
			  String p = editInvestmentText.getText().toString(); 
			 double editInvestmentNum = Double.parseDouble(p); 
		
			 EditText editAnnualText = (EditText) findViewById(R.id.editAnnual); 
			  String g = editAnnualText.getText().toString(); 
			 double editAnnualNum = Double.parseDouble(g);
			 
			 Spinner SpinnerYearsText = (Spinner) findViewById(R.id.SpinnerYears); 
			  String n = SpinnerYearsText.getSelectedItem().toString(); 
			 double SpinnerYearsNum = Double.parseDouble(n);
			 
			 double value = Calc.compute(editInvestmentNum, SpinnerYearsNum, editAnnualNum);
			 
			 editFuture.setText(Double.toString(value)); 
		
	}
}
