package com.springdemo.photozclone;


import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.*;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class PhotozController {
    private final PhotozService photozService;
    private Map<String, Photo> db = new HashMap<>() {
    };
    public PhotozController(PhotozService photozService){
                this.photozService = photozService;
                db.put("1", new Photo("1", "hello.jpg"));
    }

    private List<Photo> db = List.of(new Photo(id: "1", fileName:"hello.jpg"));

    @GetMapping("/")
    public String hello() {
        return "Hello World";

    }


    @GetMapping("/photoz/")
    public Collection<Photo> get() {
        return db.values();
    }


    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = db.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }


    @DeleteMapping("/photoz/{id}")
    public void delete(String id){
        Photo photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/photoz/")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
     return photozService.save(file.getOriginalFilename(), file.getBytes());
    }

}
