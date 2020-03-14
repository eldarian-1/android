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
import android.widget.TextView;

import com.eldarian.translator.R;
import com.eldarian.translator.app.types.TranslateView;
import com.eldarian.translator.presentation.story.StoryActivity;

public class TranslatorActivity extends AppCompatActivity implements TranslatorView, View.OnClickListener {

    private TranslatorPresenter presenter;

    private Spinner langFrom;
    private Spinner langTo;
    private EditText textIn;
    private TextView textOut;
    private Button buttonTranslate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);
        init();
    }

    @Override
    public void init(){

        langFrom = findViewById(R.id.lang_from);
        langTo = findViewById(R.id.lang_to);
        textIn = findViewById(R.id.text_in);
        textOut = findViewById(R.id.text_out);
        buttonTranslate = findViewById(R.id.button_translate);

        buttonTranslate.setOnClickListener(this);

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
            case R.id.button_translate:{
                presenter.getTranslate(getTranslateView());
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
    public void setLangFrom(int position){
        langFrom.setSelection(position);
    }

    @Override
    public void setLangTo(int position){
        langTo.setSelection(position);
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
    public TranslateView getTranslateView(){
        String[] choose = getResources().getStringArray(R.array.lang_code);
        TranslateView translateView = new TranslateView();
        translateView.setLangFrom(choose[langFrom.getSelectedItemPosition()]);
        translateView.setLangTo(choose[langTo.getSelectedItemPosition()]);
        translateView.setTextIn(textIn.getText().toString());
        return translateView;
    }

}