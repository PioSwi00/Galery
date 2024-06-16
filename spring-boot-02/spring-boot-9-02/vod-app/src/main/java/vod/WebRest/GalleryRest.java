package vod.WebRest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import vod.model.Artwork;
import vod.model.Gallery;
import vod.service.ArtworkService;
import vod.service.GalleryService;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class GalleryRest {

    private final GalleryService galleryService;
    private final ArtworkService artworkService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/galleries")
    List<Gallery> getGalleries(
            @RequestParam(value = "param", required = false) String param,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "cookies", required = false) String someCookie
    ){
        log.info("param: {}", param);
        log.info("custom headers: {}", customHeader);
        log.info("cookies: {}", someCookie);
        List<Gallery> galleries = galleryService.getAllGalleries();
        log.info("{} znalezionych galerii", galleries.size());
        galleries.forEach(gallery -> log.info("{}", gallery));
        return galleries;
    }

    @GetMapping("/galleries/{id}")
    ResponseEntity<Gallery> getGalleryById(@PathVariable("id") int id){
        Gallery gallery = galleryService.getGalleryById(id);
        if(gallery != null){
            log.info("{} znaleziono galerie", gallery.getName());
            return ResponseEntity.ok(gallery);
        }else {
            log.info("Brak galerii");
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/artworks/{artworkId}/galleries")
    ResponseEntity<List<Gallery>> getGalleriesWithArtworks(@PathVariable("artworkId") int artworkId){
        log.info("Szukam galerii po rodzaju dzieła sztuki");
        Artwork artwork = artworkService.getArtworkById(artworkId);
        if(artwork == null){
            return ResponseEntity.notFound().build();
        }else {
            List<Gallery> galleries = galleryService.getGalleriesByArtwork(artwork);
            return ResponseEntity.ok(galleries);
        }
    }

    @PostMapping("/galleries")
    ResponseEntity<?> addNewGallery(@Validated @RequestBody Gallery gallery, Errors errors, HttpServletRequest request){
        log.info("Powstaje nowa galeria...");
        if(errors.hasErrors()){
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessages = errors.getAllErrors()
                    .stream()
                    .map(oe -> messageSource.getMessage(oe.getCode(), new Object[0], locale))
                    .reduce("errors:\n", (accu, oe) -> accu + oe + "\n");
            return ResponseEntity.badRequest().body(errorMessages);
        }
        gallery = galleryService.addGallery(gallery);
        log.info("Galeria dodana {}", gallery);
        return ResponseEntity.ok(gallery);
    }
}
