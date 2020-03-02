package com.eldarian.translator.story;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.eldarian.translator.R;
import com.eldarian.translator.renderer.StoryAdapter;
import com.eldarian.translator.Translations;

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
        translations.add(new Translations("En", "Ru", "Hello World!", "Привет Мир!"));
        translations.add(new Translations("En", "Ru", "My name is Eldar.", "Меня зовут Эльдар."));
        translations.add(new Translations("En", "Ru", "Hello World!", "Привет Мир!"));
        translations.add(new Translations("En", "Ru", "My name is Eldar.", "Меня зовут Эльдар."));
        translations.add(new Translations("En", "Ru", "Hello World!", "Привет Мир!"));
        translations.add(new Translations("En", "Ru", "My name is Eldar.", "Меня зовут Эльдар."));
        translations.add(new Translations("En", "Ru", "Hello World!", "Привет Мир!"));
        translations.add(new Translations("En", "Ru", "My name is Eldar.", "Меня зовут Эльдар."));

        StoryAdapter adapter = new StoryAdapter(this, translations);
        recycler.setAdapter(adapter);

        model = new StoryModel();
        presenter = new StoryPresenter(model);
        presenter.attachView(this);
        presenter.viewIsReady();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_story, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.to_main:{
                this.finish();
                break;
            }
            case R.id.cl_story:{
                ArrayList<Translations> empty = new ArrayList<Translations>();
                StoryAdapter adapter = new StoryAdapter(this, empty);
                recycler.setAdapter(adapter);
                break;
            }
        }
        return true;
    }

}
