package vod.repository;

import vod.model.Gallery;
import vod.model.Artwork;

import java.util.List;

public interface GalleryDao {

    List<Gallery> findAll();

    Gallery findById(int id);

    List<Gallery> findByArtwork(Artwork artwork);
}
