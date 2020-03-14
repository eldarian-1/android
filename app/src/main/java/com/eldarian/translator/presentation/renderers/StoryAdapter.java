package com.eldarian.translator.presentation.renderers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eldarian.translator.R;
import com.eldarian.translator.app.types.TranslateBase;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private List<TranslateBase> translateBaseList;

    public StoryAdapter(List<TranslateBase> translateBaseList) {
        this.translateBaseList = translateBaseList;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        TranslateBase translateBase = translateBaseList.get(position);
        holder.lang.setText(translateBase.lang);
        holder.textIn.setText(translateBase.textIn);
        holder.textOut.setText(translateBase.textOut);
    }

    @Override
    public int getItemCount() {
        return translateBaseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView lang, textIn, textOut;

        ViewHolder(View view) {
            super(view);
            lang = view.findViewById(R.id.lang);
            textIn = view.findViewById(R.id.text_in);
            textOut = view.findViewById(R.id.text_out);
        }
    }
}
