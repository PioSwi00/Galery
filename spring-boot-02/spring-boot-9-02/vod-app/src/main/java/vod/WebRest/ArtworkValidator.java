package vod.WebRest;

import vod.WebRest.DTO.ArtworkDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ArtworkValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ArtworkDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ArtworkDTO artworkDTO = (ArtworkDTO) target;

        if (artworkDTO.getTitle() == null || artworkDTO.getTitle().isEmpty()) {
            errors.rejectValue("title", "title.empty", "Title must not be empty");
        }

        if (artworkDTO.getArtistId() <= 0) {
            errors.rejectValue("artistId", "artistId.invalid", "Artist ID must be a positive number");
        }

        if (artworkDTO.getYearCreated() <= 0) {
            errors.rejectValue("yearCreated", "yearCreated.invalid", "Year Created must be a positive number");
        }
    }
}
