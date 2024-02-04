package com.springdemo.photozclone;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController {

    @GetMapping("/download/{id}")
    public void ResponseEntity<byte[]> download(@PathVariable String id){
        byte[] data;
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(data, headers, HttpHeaders.OK);
    }
}
