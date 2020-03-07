package com.eldarian.translator.app;

public class AppData {
    public static final String API_KEY = "trnsl.1.1.20200223T101151Z.f0b089fcc9cceaea.b8f54373181a5280fe6485a26d2e68a2e6475c92";
    public static final String API_URI = "https://translate.yandex.net/api/v1.5/tr.json/translate";
    public static final String CREATE_DB = "CREATE TABLE IF NOT EXISTS translations (id INTEGER PRIMARY KEY AUTOINCREMENT, langIn TEXT, langOut TEXT, textIn TEXT, textOut TEXT)";
}
