package vod;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import vod.model.Gallery;
import vod.service.GalleryService;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class VodComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

    private final GalleryService galleryService;

    public VodComponent(GalleryService galleryService) {
        this.galleryService = galleryService;
        log.info("constructor");
    }

    @PostConstruct
    void init() {
        log.info("init");
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("args: {}", Arrays.toString(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("context refreshed");
        List<Gallery> galleries = galleryService.getAllGalleries();
        log.info("{} znalezionych galerii", galleries.size());
        galleries.forEach(gallery -> log.info("{}", gallery));
    }

    @EventListener
    public void eventListener(ContextRefreshedEvent event) {
        log.info("context refreshed event");
    }
}
