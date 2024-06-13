package vod.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.repository.GalleryDao;
import vod.repository.ArtworkDao;
import vod.repository.mem.MemGalleryDao;
import vod.repository.mem.MemArtworkDao;
import vod.model.Gallery;
import vod.service.impl.GalleryServiceBean;

import java.util.List;

public class VodServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find galleries!");

        ApplicationContext context= new AnnotationConfigApplicationContext("vod");
        GalleryDao galleryDao = new MemGalleryDao();
        ArtworkDao artworkDao = new MemArtworkDao();

        GalleryService service = new GalleryServiceBean(galleryDao, artworkDao);


        List<Gallery> galleries = service.getAllGalleries();
        System.out.println(galleries.size() + " galleries found:");
        galleries.forEach(System.out::println);
    }
}
