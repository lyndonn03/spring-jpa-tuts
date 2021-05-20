package io.lpamintuan.backend.backend.globals;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class ApiError {

    private Timestamp timestamp;
    private String message;
    private int status;

    public ApiError(Exception message, int status) {
        this.timestamp = new Timestamp(new Date().getTime());
        this.message = message.getMessage();
        this.status = status;
    }
}
