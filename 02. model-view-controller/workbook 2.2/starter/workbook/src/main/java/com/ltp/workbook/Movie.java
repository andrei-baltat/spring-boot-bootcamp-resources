package com.ltp.workbook;

public class Movie {
    private String title;
    private String episode;
    private String rating;

    public Movie(String title, String episode, String rating) {
        this.title = title;
        this.episode = episode;
        this.rating = rating;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
