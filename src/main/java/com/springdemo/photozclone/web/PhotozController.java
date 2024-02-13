package com.springdemo.photozclone.web;


import com.springdemo.photozclone.model.Photo;
import com.springdemo.photozclone.service.PhotozService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;

@RequestMapping("/photoz")
@RestController
public class PhotozController {
    public PhotozController(PhotozService photozService){
        this.service = photozService;
    }
    private final PhotozService service;

    private MultipartFile file;

//    @GetMapping("/")
//    public String hello() { return "Hello World";}


    @GetMapping("")
    public Collection<Photo> get() {
        return service.get();
    }


    @GetMapping("/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = service.get(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/{id}")
    public void delete(String id){
        Photo photo = service.remove(id);
        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return service.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }

}

