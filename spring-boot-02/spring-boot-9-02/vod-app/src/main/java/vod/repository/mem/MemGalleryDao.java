package vod.repository.mem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.GalleryDao;
import vod.model.Gallery;
import vod.model.Artwork;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
@Primary
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

    @Override
    public Gallery save(Gallery gallery) {
        Optional<Gallery> optionalGallery = SampleData.galleries.stream()
                .max(Comparator.comparing(Gallery::getId));
        int maxId = 0;
        if (optionalGallery.isPresent()) {
            maxId = optionalGallery.get().getId();
        }
        gallery.setId(maxId + 1);
        SampleData.galleries.add(gallery);
        return gallery;
    }

}
