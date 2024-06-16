package vod.model;

import java.util.ArrayList;
import java.util.List;

public class Artwork {

    private int id;
    private String title;
    private String poster; // URL
    private Artist artist; // relacja do artysty
    private float rating; // rating
    private int yearCreated; // new field
    private List<Gallery> galleries = new ArrayList<>(); // relacja wiele do wiele - bidirectional

    public Artwork(int id, String title, String poster, Artist artist, float rating, int yearCreated) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.artist = artist;
        this.rating = rating;
        this.yearCreated = yearCreated;
    }

    public Artwork() {
    }

    // Gettery i settery
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public List<Gallery> getGalleries() {
        return galleries;
    }

    public void setGalleries(List<Gallery> galleries) {
        this.galleries = galleries;
    }

    public void addGallery(Gallery gallery) {
        this.galleries.add(gallery);
    }

    @Override
    public String toString() {
        return "Artwork{" +
                "title='" + title + '\'' +
                ", artist=" + artist +
                ", rating=" + rating +
                ", yearCreated=" + yearCreated +
                '}';
    }
}
