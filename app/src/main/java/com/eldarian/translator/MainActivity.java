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

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Spinner langOut;
    private Spinner langIn;
    private EditText textOut;
    private EditText textIn;
    private Button buttonGo;

    private String lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        langOut = (Spinner)findViewById(R.id.lang_out);
        langIn = (Spinner)findViewById(R.id.lang_in);
        textOut = (EditText) findViewById(R.id.text_out);
        textIn = (EditText) findViewById(R.id.text_in);
        buttonGo = (Button)findViewById(R.id.button_go);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lang_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        langOut.setAdapter(adapter);
        langIn.setAdapter(adapter);

        langIn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lang = parent.getItemAtPosition(position).toString();
            }
        });


        JSONObject translateText = new JSONObject();
        try {
            translateText.put("text", textOut.getText().toString());
            translateText.put("lang", lang);
            translateText.put("format", "plain");
            translateText.put("options", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }


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

}
