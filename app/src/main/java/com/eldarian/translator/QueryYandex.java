package com.eldarian.translator;

import android.content.res.Resources;
import android.os.AsyncTask;

import com.eldarian.translator.DataApp;
import com.eldarian.translator.R;
import com.eldarian.translator.translator.TranslatorView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class QueryYandex extends AsyncTask<Void, Void, String> {

    private TranslatorView view;
    private String query;

    public QueryYandex(TranslatorView view, Resources resources, String textOut, int langOut, int langIn) {
        String[] choose = resources.getStringArray(R.array.lang_code);
        query = DataApp.API_URI + "?";
        query += "key=" + DataApp.API_KEY + "&";
        query += "text=" + textOut + "&";
        query += "lang=" + choose[langOut] + "-" + choose[langIn] + "&";
        query += "format=plain";
        this.view = view;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String content = getContent(query);
        return content;
    }

    protected void onPostExecute(String content) {
        try {
            JSONObject json = new JSONObject(content);
            System.out.println(json.toString());
            String temp = json.getJSONObject("text").toString();
            System.out.println(temp);
            view.setText(temp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String getContent(String path) {
        try {
            URL url = new URL(path);
            HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.setReadTimeout(20000);
            c.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
            String content = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                content += line + "\n";
            }
            System.out.println(content);
            return content;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}