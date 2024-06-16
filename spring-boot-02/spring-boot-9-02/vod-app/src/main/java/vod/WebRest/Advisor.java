package vod.WebRest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.LocaleResolver;
import vod.WebRest.ArtworkValidator;
import vod.WebRest.GalleryValidator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ControllerAdvice
@RequiredArgsConstructor
public class Advisor {

    private final ArtworkValidator artworkValidator;
    private final GalleryValidator galleryValidator;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @InitBinder
    void initBinder(WebDataBinder binder) {
        binder.addValidators(artworkValidator, galleryValidator);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        Locale locale = localeResolver.resolveLocale(request);

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            String errorMessage = messageSource.getMessage(error, locale);
            errors.put(error.getField(), errorMessage);
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex, HttpServletRequest request) {
        Locale locale = localeResolver.resolveLocale(request);
        String errorMessage = messageSource.getMessage("error.internalServerError", null, "Internal Server Error", locale);
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
