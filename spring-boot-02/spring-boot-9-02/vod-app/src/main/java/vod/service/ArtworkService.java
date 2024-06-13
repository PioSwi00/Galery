package vod.service;

import vod.model.Artist;
import vod.model.Artwork;

import java.util.List;

public interface ArtworkService {

    List<Artwork> getAllArtworks();

    List<Artwork> getArtworksByArtist(Artist artist);

    Artwork getArtworkById(int id);

    Artwork addArtwork(Artwork artwork);


    List<Artist> getAllArtists();

    Artist getArtistById(int id);

    Artist addArtist(Artist artist);
}
