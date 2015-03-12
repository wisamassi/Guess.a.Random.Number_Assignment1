package com.example.wisamassi.guessarandomnumber;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends Activity {
    private int randomNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"good bye",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Welcome in Guess a Random Number", Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"click on start to start game",Toast.LENGTH_SHORT).show();

    }

    public void generateRandomNumber(){
        Random random=new Random();
       randomNumber=random.nextInt(1000);
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

    public void click_start(View v){
        EditText editText= (EditText) findViewById(R.id.et1);
        Button checkButton= (Button) findViewById(R.id.bcheck);
        Toast.makeText(this,"start new game ",Toast.LENGTH_SHORT).show();

        checkButton.setClickable(true);
        editText.setClickable(true);
        generateRandomNumber();

    }
    public void click_stop(View v){
        EditText editText= (EditText) findViewById(R.id.et1);
        Button checkButton= (Button) findViewById(R.id.bcheck);
        Toast.makeText(this,"the random number  is "+randomNumber,Toast.LENGTH_SHORT).show();
    checkButton.setClickable(false);
        editText.setClickable(false);


    }
    public void click_check(View v){
         int inputNumber;

        EditText edittext=(EditText)findViewById(R.id.et1);
        String s=edittext.getText().toString();
        inputNumber=Integer.parseInt(s);

        int value=randomNumber-inputNumber;

       if((value==0)){
            Toast.makeText(this, "we win !!", Toast.LENGTH_SHORT).show();
        }
     else if (value >=0 && value<=5){
             Toast.makeText(this,"the number is very close to random number",Toast.LENGTH_SHORT).show();
        }
        else if( value >5 ){
            Toast.makeText(this,"the number is smaller than random number",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"the number is greater than random number",Toast.LENGTH_SHORT).show();
        }


    }

}
