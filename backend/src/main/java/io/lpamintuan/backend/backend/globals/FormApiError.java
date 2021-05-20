package io.lpamintuan.backend.backend.globals;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.MethodArgumentNotValidException;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FormApiError extends ApiError {

    private List<String> errors = new ArrayList<String>();

    public FormApiError(MethodArgumentNotValidException ex, int status) {
        super(ex, status);
        this.generateErrorList(ex);
    }

    private void generateErrorList(MethodArgumentNotValidException ex) {
        ex.getAllErrors().stream().forEach(e -> {
            errors.add(e.getDefaultMessage());
        });
    }
    

}
