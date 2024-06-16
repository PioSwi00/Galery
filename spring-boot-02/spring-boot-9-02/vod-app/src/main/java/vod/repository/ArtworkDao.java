package vod.repository;

import org.springframework.stereotype.Component;
import vod.model.Gallery;
import vod.model.Artist;
import vod.model.Artwork;

import java.util.List;
@Component
public interface ArtworkDao {

    List<Artwork> findAll();

    Artwork findById(int id);

    List<Artwork> findByArtist(Artist artist);

    List<Artwork> findByGallery(Gallery gallery);

    Artwork add(Artwork artwork);
}
