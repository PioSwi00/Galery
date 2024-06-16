package vod.WebRest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.WebRest.DTO.ArtworkDTO;
import vod.model.Artwork;
import vod.model.Gallery;
import vod.service.ArtworkService;
import vod.service.GalleryService;


import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class ArtworkRest {

    private final ArtworkService artworkService;
    private final GalleryService galleryService;

    @GetMapping("/artworks")
    ResponseEntity<List<Artwork>> getArtworks(){
        List<Artwork> artworks = artworkService.getAllArtworks();
        log.info("{} artworks found", artworks.size());
        artworks.forEach(artwork -> log.info("{}", artwork));
        return ResponseEntity.ok().body(artworks);
    }

    @GetMapping("/artworks/{id}")
    ResponseEntity<Artwork> getArtworkById(@PathVariable("id") int id){
        Artwork artwork = artworkService.getArtworkById(id);
        if(artwork != null){
            log.info("Artwork found: {}", artwork.getTitle());
            return ResponseEntity.ok(artwork);
        }else {
            log.info("No artwork found");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/galleries/{galleryId}/artworks")
    ResponseEntity<List<Artwork>> getArtworksFromGallery(@PathVariable("galleryId") int galleryId){
        log.info("Searching for artworks in gallery");
        Gallery gallery = galleryService.getGalleryById(galleryId);
        if(gallery == null){
            return ResponseEntity.notFound().build();
        }else {
            List<Artwork> artworks = gallery.getArtworks();
            return ResponseEntity.ok(artworks);
        }
    }

    @PostMapping("/artworks")
    ResponseEntity<?> addNewArtwork(@RequestBody ArtworkDTO artworkDTO){
        log.info("Adding new artwork: {}", artworkDTO);
        Artwork artwork = new Artwork();
        artwork.setTitle(artworkDTO.getTitle());
        artwork.setYearCreated(artworkDTO.getYearCreated());
        artwork.setArtist(artworkService.getArtistById(artworkDTO.getArtistId()));

        artwork = artworkService.addArtwork(artwork);
        log.info("Artwork added: {}", artwork);
        return ResponseEntity
                .created(ServletUriComponentsBuilder
                        .fromCurrentRequestUri()
                        .path("/" + artwork.getId())
                        .build()
                        .toUri())
                .body(artwork);
    }
}
