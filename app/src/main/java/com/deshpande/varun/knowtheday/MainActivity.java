package com.deshpande.varun.knowtheday;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void send_data(View v)
    {
        EditText editText = (EditText) findViewById(R.id.day);
        String message = editText.getText().toString();
        EditText editText1 = (EditText) findViewById(R.id.month);
        String message1 = editText1.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.year);
        String message2 = editText2.getText().toString();
        String one=message2.substring(0, 2);
        String two=message2.substring(2, 4);
        int k = Integer.parseInt(message);
        int m = Integer.parseInt(message1);
        int c = Integer.parseInt(one);
        int d = Integer.parseInt(two);
        int r;
        if (m==1)
        {
            m=11;
            if(d==0)
            {
                c=c-1;
                d=99;
            }
            else
            {
                d=d-1;
            }

        }
        else if(m==2)
        {
            m=12;
            if(d==0)
            {
                c=c-1;
                d=99;
            }
            else
            {
                d=d-1;
            }
        }
        else
        {
            m=m-2;
        }
        r = k+((13*m-1)/5)+d+(d/4)+(c/4)-(2*c);
        if(r<0)
        {
            r=-(r);
            r=r%7;
            r=7-r;
        }
        else
        {
            r=r%7;
        }
        switch(r)
        {
            case 0: message="Sunday";
                    break;
            case 1: message="Monday";
                    break;
            case 2: message="Tuesday";
                    break;
            case 3: message="Wednesday";
                    break;
            case 4: message="Thursday";
                    break;
            case 5: message="Friday";
                    break;
            case 6: message="Saturday";
                    break;
            default:message="Error in the input";
                    break;
        }
        message="The Day is "+" "+message+" ";
        TextView abc = (TextView) findViewById(R.id.res);
        abc.setTextSize(20);
        abc.setPadding(0,20,0,0);
        abc.setText(message);
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
}
