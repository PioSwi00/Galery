package vod.WebRest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import vod.WebRest.ArtworkValidator;

@ControllerAdvice
@RequiredArgsConstructor
public class Advisor {

    private final ArtworkValidator artworkValidator;

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.addValidators(artworkValidator);
    }
}
