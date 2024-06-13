package vod.service;

import vod.model.Gallery;
import vod.model.Artwork;

import java.util.List;

public interface GalleryService {
    // API zwraca nam wszystkie galerie
    Gallery getGalleryById(int id);

    List<Gallery> getAllGalleries();

    List<Gallery> getGalleriesByArtwork(Artwork artwork);

    List<Artwork> getArtworksInGallery(Gallery gallery);
}
