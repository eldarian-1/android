package com.eldarian.translator.presentation.story;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.eldarian.translator.R;
import com.eldarian.translator.app.TranslateView;

import java.util.ArrayList;
import java.util.List;

public class StoryActivity extends AppCompatActivity implements StoryView {

    private StoryPresenter presenter;

    private RecyclerView recyclerStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        init();
    }

    @Override
    public void init(){
        recyclerStory = findViewById(R.id.recycler_story);
        presenter = new StoryPresenter();
        presenter.attachView(this);
        presenter.viewIsReady();
        setTranslateList();
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
                List empty = new ArrayList<TranslateView>();
                StoryAdapter adapter = new StoryAdapter(empty);
                recyclerStory.setAdapter(adapter);
                presenter.clearTranslations();
                break;
            }
        }
        return true;
    }

    @Override
    public void setTranslateList(){
        StoryAdapter adapter = new StoryAdapter(presenter.getTranslateList());
        recyclerStory.setAdapter(adapter);
    }

}