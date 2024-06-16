package vod.repository;

import org.springframework.stereotype.Component;
import vod.model.Gallery;
import vod.model.Artwork;

import java.util.List;
@Component
public interface GalleryDao {

    List<Gallery> findAll();

    Gallery findById(int id);

    List<Gallery> findByArtwork(Artwork artwork);

    Gallery save(Gallery gallery);
}
