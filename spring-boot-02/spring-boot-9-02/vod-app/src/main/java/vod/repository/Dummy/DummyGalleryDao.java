package vod.repository.Dummy;

import vod.model.Artwork;
import vod.model.Gallery;
import vod.repository.GalleryDao;

import java.util.List;

public class DummyGalleryDao implements GalleryDao {
    @Override
    public List<Gallery> findAll() {
        return List.of();
    }

    @Override
    public Gallery findById(int id) {
        return null;
    }

    @Override
    public List<Gallery> findByArtwork(Artwork artwork) {
        return List.of();
    }

    @Override
    public Gallery save(Gallery gallery) {
        return null;
    }


}
