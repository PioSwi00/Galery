package vod.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vod.repository.GalleryDao;
import vod.repository.ArtistDao;
import vod.repository.ArtworkDao;
import vod.model.Gallery;
import vod.model.Artist;
import vod.model.Artwork;
import vod.service.ArtworkService;

import java.util.List;
import java.util.logging.Logger;

@Component
public class ArtworkServiceBean implements ArtworkService {

    private static final Logger log = Logger.getLogger(ArtworkService.class.getName());


    @Autowired
    private ArtistDao artistDao;
    private GalleryDao galleryDao;
    private ArtworkDao artworkDao;

    public ArtworkServiceBean(ArtistDao artistDao, GalleryDao galleryDao, ArtworkDao artworkDao) {
        this.artistDao = artistDao;
        this.galleryDao = galleryDao;
        this.artworkDao = artworkDao;
    }
    @Autowired
    public void setArtistDao(ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    public List<Artwork> getAllArtworks() {
        log.info("searching all artworks...");
        return artworkDao.findAll();
    }

    public List<Artwork> getArtworksByArtist(Artist artist) {
        log.info("searching artworks by artist " + artist.getId());
        return artworkDao.findByArtist(artist);
    }

    public List<Artwork> getArtworksInGallery(Gallery gallery) {
        log.info("searching artworks displayed in gallery " + gallery.getId());
        return artworkDao.findByGallery(gallery);
    }

    public Artwork getArtworkById(int id) {
        log.info("searching artwork by id " + id);
        return artworkDao.findById(id);
    }

    public List<Gallery> getAllGalleries() {
        log.info("searching all galleries");
        return galleryDao.findAll();
    }

    public List<Gallery> getGalleriesByArtwork(Artwork artwork) {
        log.info("searching galleries displaying artwork " + artwork.getId());
        return galleryDao.findByArtwork(artwork);
    }

    public Gallery getGalleryById(int id) {
        log.info("searching gallery by id " + id);
        return galleryDao.findById(id);
    }

    public List<Artist> getAllArtists() {
        log.info("searching all artists");
        return artistDao.findAll();
    }

    public Artist getArtistById(int id) {
        log.info("searching artist by id " + id);
        return artistDao.findById(id);
    }

    @Override
    public Artwork addArtwork(Artwork artwork) {
        log.info("about to add artwork " + artwork);
        return artworkDao.add(artwork);
    }

    @Override
    public Artist addArtist(Artist artist) {
        log.info("about to add artist " + artist);
        return artistDao.add(artist);
    }
}
