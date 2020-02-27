package com.eldarian.translator.presentation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.eldarian.translator.R;
import com.eldarian.translator.presentation.renderer.Translator;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

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

        langOut = findViewById(R.id.lang_out);
        langIn = findViewById(R.id.lang_in);
        textOut = findViewById(R.id.text_out);
        textIn = findViewById(R.id.text_in);
        buttonGo = findViewById(R.id.button_go);

        langOut.setOnItemSelectedListener(this);
        langIn.setOnItemSelectedListener(this);

        Spinner spinner = findViewById(R.id.lang_out);
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
                new TranslateTask().execute();
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

    private class TranslateTask extends AsyncTask<Void, Void, String> {

        private String query;

        public TranslateTask() {
            String[] choose = getResources().getStringArray(R.array.lang_code);
            query = Translator.API_URI + "?";
            query += "key=" + Translator.API_KEY + "&";
            query += "text=" + textOut.getText().toString() + "&";
            query += "lang=" + choose[langOut.getSelectedItemPosition()] + "-" + choose[langIn.getSelectedItemPosition()] + "&";
            query += "format=plain";
        }

        @Override
        protected String doInBackground(Void... voids) {
            String content = getContent(query);
            return content;
        }

        protected void onPostExecute(String content) {
            try {
                JSONObject json = new JSONObject(content);
                System.out.println(json.toString());
                String temp = json.getJSONObject("text").toString();
                System.out.println(temp);
                textIn.setText(temp);
                System.out.println(content);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private String getContent(String path) {
            try {
                URL url = new URL(path);
                HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
                c.setRequestMethod("GET");
                c.setReadTimeout(20000);
                c.connect();
                BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
                String content = "";
                String line = "";
                while ((line = reader.readLine()) != null) {
                    content += line + "\n";
                }
                System.out.println(content);
                return content;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

    }
}
