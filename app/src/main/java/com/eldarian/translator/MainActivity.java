package com.eldarian.translator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

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
