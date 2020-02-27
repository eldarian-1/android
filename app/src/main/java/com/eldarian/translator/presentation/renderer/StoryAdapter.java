package com.eldarian.translator.presentation.renderer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.eldarian.translator.R;

import java.util.List;

public class StoryAdapter extends ArrayAdapter<Translator> {

    private LayoutInflater inflater;
    private int layout;
    private List<Translator> translates;

    public StoryAdapter(Context context, int resource, List<Translator> translates) {
        super(context, resource, translates);
        this.translates = translates;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(R.layout.item_stories, parent, false);

        TextView textIn = view.findViewById(R.id.text_in);
        TextView textOut = view.findViewById(R.id.text_out);
        TextView langIn = view.findViewById(R.id.text_lang_in);
        TextView langOut = view.findViewById(R.id.text_lang_out);

        Translator translate = translates.get(position);

        textIn.setText(translate.getTextIn());
        textOut.setText(translate.getTextOut());
        langIn.setText(translate.getLangIn());
        langOut.setText(translate.getLangOut());

        return view;
    }
}
