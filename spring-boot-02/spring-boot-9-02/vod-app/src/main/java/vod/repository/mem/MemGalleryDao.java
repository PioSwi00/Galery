package vod.repository.mem;

import org.springframework.stereotype.Component;
import vod.repository.GalleryDao;
import vod.model.Gallery;
import vod.model.Artwork;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemGalleryDao implements GalleryDao {

    @Override
    public List<Gallery> findAll() {
        return SampleData.galleries;
    }

    @Override
    public Gallery findById(int id) {
        return SampleData.galleries.stream().filter(g -> g.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Gallery> findByArtwork(Artwork artwork) {
        return SampleData.galleries.stream().filter(g -> g.getArtworks().contains(artwork)).collect(Collectors.toList());
    }
}
