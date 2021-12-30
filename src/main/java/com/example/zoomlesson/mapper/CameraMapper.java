package com.example.zoomlesson.mapper;

import com.example.zoomlesson.dto.NasaCamera;
import com.example.zoomlesson.entity.Camera;
import org.springframework.stereotype.Component;

@Component
public class CameraMapper {

    public Camera toEntity(NasaCamera nasaCamera) {
        return Camera.builder()
                     .nasaId(nasaCamera.getId())
                     .name(nasaCamera.getName())
                     .fullName(nasaCamera.getFull_name())
                     .build();
    }
}
