package com.eldarian.translator.presentation.translator;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;

import java.util.List;

public interface TranslatorView {

    //void onGetData(List<String> data);
    public boolean onOptionsItemSelected(MenuItem item);
    public void onClick(View view);
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id);

    void setText(String temp);
}