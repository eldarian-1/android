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
import com.eldarian.translator.story.StoryActivity;

import java.io.IOException;

public class TranslatorActivity extends AppCompatActivity
        implements TranslatorView, View.OnClickListener, AdapterView.OnItemSelectedListener {

    private TranslatorPresenter presenter;
    private TranslatorModel model;

    private Spinner langIn;
    private Spinner langOut;
    private EditText textIn;
    private EditText textOut;
    private Button buttonGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);
        init();
    }

    private void init(){
        langIn = findViewById(R.id.lang_in);
        langOut = findViewById(R.id.lang_out);
        textIn = findViewById(R.id.text_in);
        textOut = findViewById(R.id.text_out);
        buttonGo = findViewById(R.id.button_go);

        langIn.setOnItemSelectedListener(this);
        langOut.setOnItemSelectedListener(this);
        buttonGo.setOnClickListener(this);

        model = new TranslatorModel();
        presenter = new TranslatorPresenter(model);
        presenter.attachView(this);
        presenter.viewIsReady();
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
            case R.id.cl_field:{
                clearField();
                break;
            }
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_go:{
                try {
                    presenter.pushQuery();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
//        String[] choose = getResources().getStringArray(R.array.lang_code);
//        switch (parent.getId()){
//            case R.id.lang_in:{
//                Toast toast = Toast.makeText(getApplicationContext(), "Ваш выбор: " + choose[position], Toast.LENGTH_SHORT);
//                toast.show();
//                break;
//            }
//            case R.id.lang_out:{
//                Toast toast = Toast.makeText(getApplicationContext(), "Ваш выбор: " + choose[position], Toast.LENGTH_SHORT);
//                toast.show();
//                break;
//            }
//        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void setTextIn(String text){
        textIn.setText(text);
    }

    @Override
    public void setTextOut(String text){
        textOut.setText(text);
    }

    @Override
    public String getTextIn() {
        return textIn.getText().toString();
    }

    @Override
    public String getLangIn() {
        String[] choose = getResources().getStringArray(R.array.lang_code);
        return choose[langIn.getSelectedItemPosition()];
    }

    @Override
    public String getLangOut() {
        String[] choose = getResources().getStringArray(R.array.lang_code);
        return choose[langOut.getSelectedItemPosition()];
    }

    @Override
    public void clearField() {
        langIn.setSelection(0);
        langOut.setSelection(0);
        textIn.setText("");
        textOut.setText("");
    }

}
