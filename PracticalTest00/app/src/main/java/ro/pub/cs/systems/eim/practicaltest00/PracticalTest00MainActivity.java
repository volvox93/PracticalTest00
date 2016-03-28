package ro.pub.cs.systems.eim.practicaltest00;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest00MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test00_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    int varx = 0, vary = 0;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test00_main, menu);
        return true;
    }

    public void count(View v){
        EditText e = null;
        switch (v.getId()) {
            case R.id.button1:

                varx++;

                e = (EditText) findViewById(R.id.text1);
                e.setText(Integer.toString(varx));

                break;
            case R.id.button2:

                vary++;
                e = (EditText) findViewById(R.id.text2);
                e.setText(Integer.toString(vary));

                break;

        }
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
    public void onDestroy(){

        android.os.Process.killProcess(android.os.Process.myPid());
        SharedPreferences.Editor editor = getSharedPreferences("clear_cache", Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
        super.onDestroy();
    }
}
