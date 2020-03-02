package com.eldarian.translator.story;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.eldarian.translator.R;
import com.eldarian.translator.renderer.StoryAdapter;
import com.eldarian.translator.Translations;
import com.eldarian.translator.translator.TranslatorActivity;

import java.util.ArrayList;

public class StoryActivity extends AppCompatActivity implements StoryView {

    private StoryPresenter presenter;
    private StoryModel model;

    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        init();
    }

    private void init(){
        recycler = findViewById(R.id.recycler);

        ArrayList<Translations> translations = new ArrayList<Translations>();
        Translations temp = new Translations("En", "Ru", "Hello", "Privet");
        translations.add(temp);
        translations.add(temp);
        translations.add(temp);
        translations.add(temp);
        translations.add(temp);

        StoryAdapter adapter = new StoryAdapter(this, translations);
        recycler.setAdapter(adapter);

        model = new StoryModel();
        presenter = new StoryPresenter(model);
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
            case R.id.to_main:{
                Intent intent = new Intent(StoryActivity.this, TranslatorActivity.class);
                startActivity(intent);
                break;
            }
        }
        return true;
    }

}
