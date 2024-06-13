package vod.model;

import java.util.ArrayList;
import java.util.List;

public class Gallery {

    private int id;
    private String name;
    private String logo; // URL logo w przypadku UI będzie zaciągany dynamicznie
    private List<Artwork> artworks = new ArrayList<>(); // struktura kolekcyjna związaną z dziełami sztuki, uproszczone
    // relacja wiele do wiele

    public Gallery(int id, String name, String logo) { // konstruktor
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public Gallery() { // bezparametrowy
    }

    // settery, gettery i toString - później będziemy korzystać z wynalazku Lombok
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
        return "Gallery{" +
                "name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
