package com.springdemo.photozclone;
import java.security.PublicKey;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class Photo {
    private String id;

    @NotEmpty
    private String fileName;

    @JsonIgnore
    private byte[] data;
    public Photo() {
    }

    public Photo(String id, String fileName); {
            this.id = id;
            this.fileName = fileName;
        }

    public Photo() {

        }
        // raw data

        public String getId(){
            return id;
        }
        public String getFileName(){
            return fileName;
        }
        public void setId (String id){

        }
    }
