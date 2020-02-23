package com.eldarian.translator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Spinner langOut;
    private Spinner langIn;
    private EditText textOut;
    private EditText textIn;
    private Button buttonGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        langOut = (Spinner)findViewById(R.id.lang_out);
        langIn = (Spinner)findViewById(R.id.lang_in);
        textOut = (EditText) findViewById(R.id.text_out);
        textIn = (EditText) findViewById(R.id.text_in);
        buttonGo = (Button)findViewById(R.id.button_go);

        langOut.setOnItemSelectedListener(this);
        langIn.setOnItemSelectedListener(this);

        Spinner spinner = (Spinner) findViewById(R.id.lang_out);
        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();

        buttonGo.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.item_story:{
                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                startActivity(intent);
                break;
            }
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_go:{
                String[] choose = getResources().getStringArray(R.array.lang_code);

                String query = Translator.API_URI + "?";
                query += "key=" + Translator.API_KEY + "&";
                query += "text=" + textOut.getText().toString() + "&";
                query += "lang=" + choose[langOut.getSelectedItemPosition()] + "-" + choose[langIn.getSelectedItemPosition()] + "&";
                query += "format=plain";

                try {
                    URL url = new URL(query);
                    HttpURLConnection c = (HttpURLConnection)url.openConnection();
                    c.setRequestMethod("GET");
                    c.setReadTimeout(20000);
                    c.connect();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(), "Ваш выбор: " + choose[langOut.getSelectedItemPosition()], Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        String[] choose = getResources().getStringArray(R.array.lang_code);
        //Toast toast = Toast.makeText(getApplicationContext(), v.getId() + " " + R.id.lang_out + " " + R.id.lang_in);
        switch (v.getId()){
            case R.id.lang_out:{
                Toast toast = Toast.makeText(getApplicationContext(), "Ваш выбор: " + choose[position], Toast.LENGTH_SHORT);
                toast.show();
                break;
            }
            case R.id.lang_in:{
                Toast toast = Toast.makeText(getApplicationContext(), "Ваш выбор: " + choose[position], Toast.LENGTH_SHORT);
                toast.show();
                break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
