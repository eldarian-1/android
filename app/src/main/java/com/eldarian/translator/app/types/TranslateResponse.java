package com.eldarian.translator.app.types;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TranslateResponse {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("text")
    @Expose
    private List<String> text;

    public TranslateResponse(int code, String lang, List<String> text) {
        this.code = code;
        this.lang = lang;
        this.text = text;
    }public int code() { return code; }public void setCode(int code) { this.code = code; }

    public String lang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<String> text() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }
}