package vod.repository;

import vod.model.Artist;

import java.util.List;

public interface ArtistDao {

    List<Artist> findAll();

    Artist findById(int id);

    Artist add(Artist d);


}
