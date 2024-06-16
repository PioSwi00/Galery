package vod.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.model.Gallery;

import java.util.List;

@SpringBootApplication
public class VodServiceMain {

    public static void main(String[] args) {

        System.out.println("Let's find galleries!");

        ApplicationContext context = new AnnotationConfigApplicationContext("vod");

        GalleryService   service = context.getBean(GalleryService.class);
        GalleryService service2 = context.getBean(GalleryService.class);

        List<Gallery> schools = service.getAllGalleries();
        System.out.println(schools.size() + " Galleries found:");
        schools.forEach(System.out::println);

    }


}
