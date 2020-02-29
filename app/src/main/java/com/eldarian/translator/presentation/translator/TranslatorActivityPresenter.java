package com.eldarian.translator.presentation.translator;

import androidx.annotation.NonNull;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
import com.eldarian.translator.presentation.story.StoryActivity;
import com.eldarian.translator.presentation.renderer.Translator;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class TranslatorActivityPresenter {

    private TranslatorActivity view;
    private final TranslatorModel model;

    TranslatorActivityPresenter(TranslatorModel model){
        this.model = model;
    }

    public void attachView(TranslatorActivity view) {
        view = view;
    }

    public void detachView() {
        view = null;
    }


    public void viewIsReady() {
        //loadUsers();
    }

}
