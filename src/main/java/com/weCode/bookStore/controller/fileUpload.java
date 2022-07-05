package com.weCode.bookStore.controller;

import com.weCode.bookStore.exception.Cause;
import com.weCode.bookStore.exception.invalidFileException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class fileUpload {
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
    {
        List<Cause> causeList= new ArrayList<Cause>();
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        if(file.isEmpty())
        {
            Map<String, String> m = new HashMap<String,String>();
            m.put("length",String.valueOf(file.getSize()));
            System.out.println(m);
            Cause c1 = new Cause("empty file","REQUEST BODY","file",m);
            causeList.add(c1);
        }
        if(!file.getContentType().equals("text/plain"))
        {
            Map<String, String> m2 = new HashMap<String,String>();
            m2.put("file type",file.getContentType());
            Cause c2 = new Cause("invalid file type","REQUEST BODY","file",m2);
            causeList.add(c2);
        }
        if(!causeList.isEmpty())
        {
            throw new invalidFileException(causeList);
        }
        return new ResponseEntity<>("Successful",HttpStatus.OK);
    }
}
