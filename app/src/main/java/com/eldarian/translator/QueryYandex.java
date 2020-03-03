package com.eldarian.translator;

import android.os.AsyncTask;

import com.eldarian.translator.story.StoryView;
import com.eldarian.translator.translator.TranslatorPresenter;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class QueryYandex {

    private String query;
    private String text;
    private TranslatorPresenter presenter;

    public QueryYandex(String textIn, String langIn, String langOut, TranslatorPresenter presenter)
            throws UnsupportedEncodingException {

        text = URLEncoder.encode(textIn, "UTF-8");

        query = StoryView.DataApp.API_URI + "?";
        query += "lang=" + langIn + "-" + langOut + "&";
        query += "key=" + StoryView.DataApp.API_KEY + "&";
        query += "text=" + text;

        System.out.println(query);
        this.presenter = presenter;
    }

    public String getQuery() {
        return query;
    }

    public void getTextOut(){
        new ProgressTask().execute();
    }

    class ProgressTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... path) {
            String content;
            try{
                content = getContent(query);
            }
            catch (IOException ex){
                content = ex.getMessage();
            }
            return content;
        }

        @Override
        protected void onPostExecute(String content) {
            try {
                presenter.setTextOut(content);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private String getContent(String path) throws IOException {
            BufferedReader reader = null;
            try {
                URL url = new URL(path);
                HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
                //c.setRequestMethod("POST");
                //c.addRequestProperty("text", text);
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