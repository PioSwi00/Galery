package vod.WebRest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Gallery;

@Component
public class GalleryValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Gallery.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Gallery gallery = (Gallery) target;

        if (gallery.getName() == null || gallery.getName().isEmpty()) {
            errors.rejectValue("name", "name.empty", "Name must not be empty");
        }
            }
}