// package rest_api.rest_api_sprintboot.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;

// import java.util.HashMap;
// import java.util.Map;

// @ControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<Map<String, String>> handleNotFound(ResourceNotFoundException ex) {
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
//     }

//     @ExceptionHandler(MethodArgumentNotValidException.class)
//     public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
//         Map<String, String> errors = new HashMap<>();
//         ex.getBindingResult().getFieldErrors()
//                 .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
//         return ResponseEntity.badRequest().body(errors);
//     }
// }
