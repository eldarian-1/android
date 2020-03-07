package com.eldarian.translator.presentation.translator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.eldarian.translator.R;
import com.eldarian.translator.presentation.story.StoryActivity;

public class TranslatorActivity extends AppCompatActivity
        implements TranslatorView, View.OnClickListener {

    private TranslatorPresenter presenter;

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

        buttonGo.setOnClickListener(this);

        presenter = new TranslatorPresenter();
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
                presenter.clearField();
                break;
            }
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_go:{
                presenter.getTranslate(getLangIn(), getLangOut(), getTextIn());
                break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void setLangIn(int position){
        langIn.setSelection(position);
    }

    @Override
    public void setLangOut(int position){
        langOut.setSelection(position);
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

}
