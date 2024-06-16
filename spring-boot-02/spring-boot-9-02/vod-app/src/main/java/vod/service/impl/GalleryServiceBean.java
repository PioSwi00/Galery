package vod.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vod.model.Gallery;
import vod.model.Artwork;
import vod.repository.GalleryDao;
import vod.repository.ArtworkDao;
import vod.repository.ArtistDao;
import vod.service.GalleryService;

import java.util.List;
import java.util.logging.Logger;

@Service
public class GalleryServiceBean implements GalleryService {

    private static final Logger log = Logger.getLogger(GalleryService.class.getName());

    private GalleryDao galleryDao;
    private ArtworkDao artworkDao;

    public GalleryServiceBean(GalleryDao galleryDao, ArtworkDao artworkDao) {
        log.info("creating gallery service bean");
        this.galleryDao = galleryDao;
        this.artworkDao = artworkDao;
    }

    @Override
    public Gallery getGalleryById(int id) {
        log.info("searching gallery by id " + id);
        return galleryDao.findById(id);
    }

    @Override
    public List<Artwork> getArtworksInGallery(Gallery gallery) {
        log.info("searching artworks displayed in gallery " + gallery.getId());
        return artworkDao.findByGallery(gallery);
    }

    @Override
    public List<Gallery> getAllGalleries() {
        log.info("searching all galleries");
        return galleryDao.findAll();
    }

    @Override
    public List<Gallery> getGalleriesByArtwork(Artwork artwork) {
        log.info("searching galleries displaying artwork " + artwork.getId());
        return galleryDao.findByArtwork(artwork);
    }
    @Override
    public Gallery addGallery(Gallery gallery) {
        log.info("adding new gallery " + gallery);
        return galleryDao.save(gallery);
    }
}
