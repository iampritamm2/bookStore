package com.weCode.bookStore.validator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class validator {
    public void  fileValidator(MultipartFile file) {
        if (file.isEmpty()) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contail file");
        }
        if (!file.getContentType().equals("image/jpeg")) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ONLY JPEG");
        }
    }
}
