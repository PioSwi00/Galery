package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.ArtistDao;
import vod.model.Artist;

import java.util.List;
@Repository
public class MemArtistDao implements ArtistDao {
    @Override
    public List<Artist> findAll() {
        return SampleData.artists;
    }

    @Override
    public Artist findById(int id) {
        return SampleData.artists.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Artist add(Artist d) {
        int max = SampleData.artists.stream().max((d1, d2) -> d1.getId() - d2.getId()).get().getId();
        d.setId(++max);
        SampleData.artists.add(d);
        return d;
    }
}
