package com.eldarian.translator.renderer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eldarian.translator.R;

import java.util.List;

public class TranslationsRender extends RecyclerView.Adapter<TranslationsRender.TransHolder> {


    private List<Translator> data;
    private TranslateListener listener;

    @NonNull
    @Override
    public TranslationsRender.TransHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stories, null);
        return new TransHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransHolder holder, int position) {
        Translator translate = data.get(position);
        holder.bind(translate);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<Translator> data) {
        this.data = data;
    }

    public void setListener(TranslateListener listener){
        this.listener = listener;
    }

    public class TransHolder extends RecyclerView.ViewHolder{

        private TextView textIn;
        private TextView textOut;
        private TextView langIn;
        private TextView langOut;

        public TransHolder(@NonNull View view) {
            super(view);
            textIn = view.findViewById(R.id.text_in);
            textOut = view.findViewById(R.id.text_out);
            langIn = view.findViewById(R.id.text_lang_in);
            langOut = view.findViewById(R.id.text_lang_out);

        }

        public void bind(Translator translate){
            this.textIn.setText(translate.getTextIn());
            this.textOut.setText(translate.getTextOut());
            this.langIn.setText(translate.getLangIn());
            this.langOut.setText(translate.getLangOut());
        }
    }

    public interface TranslateListener{
        void onClick(String translate);
    }

}
