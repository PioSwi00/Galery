package vod.repository.mem;

import vod.model.Gallery;
import vod.model.Artist;
import vod.model.Artwork;

import java.util.ArrayList;
import java.util.List;

class SampleData {

    static List<Gallery> galleries = new ArrayList<>();
    static List<Artist> artists = new ArrayList<>();
    static List<Artwork> artworks = new ArrayList<>();

    static {
        Artist vanGogh = new Artist(1, "Vincent", "van Gogh");
        Artist picasso = new Artist(2, "Pablo", "Picasso");
        Artist daVinci = new Artist(3, "Leonardo", "da Vinci");
        Artist rembrandt = new Artist(4, "Rembrandt", "van Rijn");

        Artwork starryNight = new Artwork(1, "Starry Night", "https://example.com/starry_night.jpg", vanGogh, 4.9f, 1889);
        Artwork sunflowers = new Artwork(2, "Sunflowers", "https://example.com/sunflowers.jpg", vanGogh, 4.7f, 1888);

        Artwork guernica = new Artwork(3, "Guernica", "https://example.com/guernica.jpg", picasso, 4.8f, 1937);
        Artwork lesDemoiselles = new Artwork(4, "Les Demoiselles d'Avignon", "https://example.com/les_demoiselles.jpg", picasso, 4.6f, 1907);

        Artwork monaLisa = new Artwork(5, "Mona Lisa", "https://example.com/mona_lisa.jpg", daVinci, 5.0f, 1503);
        Artwork lastSupper = new Artwork(6, "The Last Supper", "https://example.com/last_supper.jpg", daVinci, 4.9f, 1498);

        Artwork nightWatch = new Artwork(7, "The Night Watch", "https://example.com/night_watch.jpg", rembrandt, 4.8f, 1642);
        Artwork selfPortrait = new Artwork(8, "Self-Portrait", "https://example.com/self_portrait.jpg", rembrandt, 4.7f, 1660);

        bind(starryNight, vanGogh);
        bind(sunflowers, vanGogh);

        bind(guernica, picasso);
        bind(lesDemoiselles, picasso);

        bind(monaLisa, daVinci);
        bind(lastSupper, daVinci);

        bind(nightWatch, rembrandt);
        bind(selfPortrait, rembrandt);

        Gallery louvre = new Gallery(1, "Louvre", "https://example.com/louvre_logo.png");
        Gallery met = new Gallery(2, "Metropolitan Museum of Art", "https://example.com/met_logo.png");
        Gallery tate = new Gallery(3, "Tate Modern", "https://example.com/tate_logo.png");
        Gallery rijksmuseum = new Gallery(4, "Rijksmuseum", "https://example.com/rijksmuseum_logo.png");

        bind(louvre, monaLisa);
        bind(louvre, starryNight);
        bind(met, starryNight);
        bind(met, guernica);
        bind(tate, lesDemoiselles);
        bind(tate, sunflowers);
        bind(rijksmuseum, nightWatch);
        bind(rijksmuseum, selfPortrait);

        artworks.add(starryNight);
        artworks.add(sunflowers);
        artworks.add(guernica);
        artworks.add(lesDemoiselles);
        artworks.add(monaLisa);
        artworks.add(lastSupper);
        artworks.add(nightWatch);
        artworks.add(selfPortrait);

        artists.add(vanGogh);
        artists.add(picasso);
        artists.add(daVinci);
        artists.add(rembrandt);

        galleries.add(louvre);
        galleries.add(met);
        galleries.add(tate);
        galleries.add(rijksmuseum);
    }

    private static void bind(Gallery g, Artwork a) {
        g.addArtwork(a);
        a.addGallery(g);
    }

    private static void bind(Artwork a, Artist ar) {
        ar.addArtwork(a);
        a.setArtist(ar);
    }
}
