package com.eldarian.translator.presentation.story;

import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

public interface StoryView {

    boolean onCreateOptionsMenu(Menu menu);
    boolean onOptionsItemSelected(@NonNull MenuItem item);
    void setTranslationsList();

}
