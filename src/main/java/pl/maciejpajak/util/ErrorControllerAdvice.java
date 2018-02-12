package pl.maciejpajak.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(ErrorControllerAdvice.class);

    // @ExceptionHandler
    // public String handleException(HttpServletRequest request,Throwable throwable,
    // Exception exception, Model model) {
    // model.addAttribute("exception", exception);
    // model.addAttribute("url", request.getRequestURL() );
    // model.addAttribute("errorMessage", exception.getMessage());
    //// ResponseEntity<Object> fas = new ResponseEntity<>(status) // TODO
    // return "error/general";
    //
    // }

    @ExceptionHandler({ BaseEntityNotFoundException.class })
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleBaseEntityNotFoundException(BaseEntityNotFoundException ex, Model model, HttpServletRequest request) {
        log.debug(ex.getMessage(), ex);
        log.error(ex.getMessage());
        model.addAttribute("exception", ex);
        model.addAttribute("url", request.getRequestURL());
        model.addAttribute("errorMessage", ex.getMessage());
        return "error/general";
    }

}
