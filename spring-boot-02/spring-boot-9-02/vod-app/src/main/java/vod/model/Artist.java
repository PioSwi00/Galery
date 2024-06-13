package vod.model;

import java.util.ArrayList;
import java.util.List;

public class Artist {

    private int id;
    private String firstName;
    private String lastName;
    private List<Artwork> artworks = new ArrayList<>(); // relacja 1 do wielu

    // Konstruktor z parametrami
    public Artist(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Konstruktor bezparametrowy
    public Artist() {
    }

    // Gettery i settery
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Artwork> getArtworks() {
        return artworks;
    }

    public void setArtworks(List<Artwork> artworks) {
        this.artworks = artworks;
    }

    public void addArtwork(Artwork artwork) {
        this.artworks.add(artwork);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
