package vod.repository.mem;

import org.springframework.stereotype.Component;
import vod.repository.ArtworkDao;
import vod.model.Gallery;
import vod.model.Artist;
import vod.model.Artwork;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class MemArtworkDao implements ArtworkDao {
    @Override
    public List<Artwork> findAll() {
        return SampleData.artworks;
    }

    @Override
    public Artwork findById(int id) {
        return SampleData.artworks.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Artwork> findByArtist(Artist artist) {
        return SampleData.artworks.stream().filter(a -> a.getArtist() == artist).collect(Collectors.toList());
    }

    @Override
    public List<Artwork> findByGallery(Gallery gallery) {
        return SampleData.artworks.stream().filter(a -> a.getGalleries().contains(gallery)).collect(Collectors.toList());
    }

    @Override
    public Artwork add(Artwork artwork) {
        int max = SampleData.artworks.stream().max((a1, a2) -> a1.getId() - a2.getId()).get().getId();
        artwork.setId(++max);
        SampleData.artworks.add(artwork);
        return artwork;
    }
}
