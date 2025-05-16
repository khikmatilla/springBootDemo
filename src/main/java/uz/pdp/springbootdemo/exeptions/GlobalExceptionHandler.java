package uz.pdp.springbootdemo.exeptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;
import java.util.function.BiFunction;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorDto> error_404(ItemNotFoundException e, HttpServletRequest request) {
        return ResponseEntity.status(404)
                .body(ErrorDto.builder()
                        .errorPath(request.getRequestURI())
                        .errorCode(404)
                        .errorBody(e.getMessage())
                        .build()
                );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> notValidArgumentExceptionHandler(MethodArgumentNotValidException e, HttpServletRequest request) {
        Map<String, List<String>> errorBody = new HashMap<>();
        for (FieldError fieldError : e.getFieldErrors()) {
         String field = fieldError.getField();
         String message = fieldError.getDefaultMessage();
         errorBody.compute(field, new BiFunction<String, List<String>, List<String>>() {
             @Override
             public List<String> apply(String s, List<String> strings) {
                 strings = Objects.requireNonNullElse(strings, new ArrayList<>());
                 strings.add(message);
                 return strings;
             }
         });
        }
        return ResponseEntity.status(404)
                .body(ErrorDto.builder()
                        .errorPath(request.getRequestURI())
                        .errorCode(404)
                        .errorBody(errorBody)
                        .build()
                );
    }


}
