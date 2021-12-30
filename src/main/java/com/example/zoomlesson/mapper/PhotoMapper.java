package com.example.zoomlesson.mapper;

import com.example.zoomlesson.dto.NasaPhoto;
import com.example.zoomlesson.entity.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PhotoMapper {

    @Autowired
    private CameraMapper cameraMapper;

    public Photo toEntity(NasaPhoto nasaPhoto) {
        return Photo.builder()
                    .camera(cameraMapper.toEntity(nasaPhoto.getCamera()))
                    .nasaId(nasaPhoto.getId())
                    .url(nasaPhoto.getImg_src())
                    .build();
    }
}
