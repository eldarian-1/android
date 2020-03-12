package com.eldarian.translator.domain.print;

public class ShowcasePrint {

    private String id;
    private String title;
    private String poster;

    public ShowcasePrint(String id, String title, String poster){
        this.id = id;
        this.title = title;
        this.poster = poster;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

}
