package vod.repository;

import org.springframework.stereotype.Component;
import vod.model.Artist;

import java.util.List;
@Component
public interface ArtistDao {

    List<Artist> findAll();

    Artist findById(int id);

    Artist add(Artist d);


}
