package com.eldarian.translator.entity.dto;

public class ShowcaseCore {

    private String link;
    private String title;
    private String posterUrl;


    public ShowcaseCore(String link, String title, String posterUrl) {
        this.link = link;
        this.title = title;
        this.posterUrl = posterUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

}
