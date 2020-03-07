package com.eldarian.translator.domain;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.eldarian.translator.app.AppData;
import com.eldarian.translator.presentation.translator.TranslatorPresenter;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class YandexQuery implements TranslateUseCase {

    private String query;
    private String text;

    public YandexQuery(String textIn, String langIn, String langOut, TranslatorPresenter presenter)
            throws UnsupportedEncodingException {

        text = URLEncoder.encode(textIn, "UTF-8");

        query = AppData.API_URI + "?";
        query += "lang=" + langIn + "-" + langOut + "&";
        query += "key=" + AppData.API_KEY + "&";
        query += "text=" + text;
    }

    @Override
    public void translate(){
        new ProgressTask().execute();
    }

    @SuppressLint("StaticFieldLeak")
    class ProgressTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... path) {
            String content;
            try{
                content = getContent(query);
                TranslatorPresenter presenter = new TranslatorPresenter(new TranslatorModel());
                presenter.setTextOut(content);
            }
            catch (IOException | JSONException ex){
                content = ex.getMessage();
            }
            return content;
        }

        @Override
        protected void onPostExecute(String content) {
        }

        private String getContent(String path) throws IOException {
            BufferedReader reader = null;
            try {
                URL url = new URL(path);
                HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
                c.setRequestMethod("GET");
                c.setReadTimeout(10000);
                c.connect();
                reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
                StringBuilder buf = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    buf.append(line + "\n");
                }
                return(buf.toString());
            }
            finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }

    }

}