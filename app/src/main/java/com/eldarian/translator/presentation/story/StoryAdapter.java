package com.eldarian.translator.presentation.story;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eldarian.translator.R;
import com.eldarian.translator.app.Translations;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private List<Translations> translates;

    public StoryAdapter(List<Translations> translates) {
        this.translates = translates;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.item_stories, parent, false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        Translations translate = translates.get(position);
        holder.langIn.setText(translate.getLangIn());
        holder.langOut.setText(translate.getLangOut());
        holder.textIn.setText(translate.getTextIn());
        holder.textOut.setText(translate.getTextOut());
    }

    @Override
    public int getItemCount() {
        return translates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView langIn, langOut, textIn, textOut;

        ViewHolder(View view) {
            super(view);
            langIn = view.findViewById(R.id.lang_in);
            langOut = view.findViewById(R.id.lang_out);
            textIn = view.findViewById(R.id.text_in);
            textOut = view.findViewById(R.id.text_out);
        }
    }
}
