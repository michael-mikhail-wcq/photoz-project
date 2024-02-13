package com.springdemo.photozclone.repository;

import com.springdemo.photozclone.model.Photo;
import org.springframework.data.repository.CrudRepository;
public interface PhotozRepository  extends CrudRepository<Photo, Integer>{
}
