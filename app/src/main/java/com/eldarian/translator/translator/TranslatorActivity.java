package com.eldarian.translator.translator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.eldarian.translator.QueryYandex;
import com.eldarian.translator.story.StoryActivity;

public class TranslatorActivity extends AppCompatActivity
        implements TranslatorView, View.OnClickListener, AdapterView.OnItemSelectedListener {

    private TranslatorPresenter presenter;
    private TranslatorModel model;

    private Spinner langOut;
    private Spinner langIn;
    private EditText textOut;
    private EditText textIn;
    private Button buttonGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);
        init();
    }

    private void init(){
        langOut = findViewById(R.id.lang_out);
        langIn = findViewById(R.id.lang_in);
        textOut = findViewById(R.id.text_out);
        textIn = findViewById(R.id.text_in);
        buttonGo = findViewById(R.id.button_go);

        langOut.setOnItemSelectedListener(this);
        langIn.setOnItemSelectedListener(this);
        buttonGo.setOnClickListener(this);

        String selected = langOut.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();

        model = new TranslatorModel();
        presenter = new TranslatorPresenter(model);
        presenter.attachView(this);
        presenter.viewIsReady();
    }

    public void setText(String text){
        textOut.setText(text);
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
                Intent intent = new Intent(TranslatorActivity.this, StoryActivity.class);
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
                new QueryYandex(this, getResources(), textOut.getText().toString(),
                        langOut.getSelectedItemPosition(),
                        langIn.getSelectedItemPosition()).execute();
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
    public void onNothingSelected(AdapterView<?> parent) {}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

}
