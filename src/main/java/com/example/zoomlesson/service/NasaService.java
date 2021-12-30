package com.example.zoomlesson.service;

import com.example.zoomlesson.dto.NasaPhoto;
import com.example.zoomlesson.dto.PhotoList;
import com.example.zoomlesson.entity.Photo;
import com.example.zoomlesson.mapper.CameraMapper;
import com.example.zoomlesson.mapper.PhotoMapper;
import com.example.zoomlesson.repository.CameraRepository;
import com.example.zoomlesson.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NasaService {

    private static final String NASA_DEMO_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=15" +
            "&api_key=DEMO_KEY";
    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private CameraRepository cameraRepository;
    @Autowired
    private CameraMapper cameraMapper;
    @Autowired
    private PhotoMapper photoMapper;

    @EventListener(ApplicationReadyEvent.class)
    public void savePhotosFromNasa(){
        List<NasaPhoto> nasaPhotos = getNasaPhotos();
        saveNasaPhotos(nasaPhotos);
    }
    public List<NasaPhoto> getNasaPhotos() {
        RestTemplate restTemplate = new RestTemplate();
        PhotoList photoList = restTemplate.getForObject(NASA_DEMO_URL, PhotoList.class);

        return photoList.getPhotos();
    }

    public void saveNasaPhotos(List<NasaPhoto> photos) {
        List<Photo> entities = photos.stream().map(photoMapper::toEntity).toList();
        photoRepository.saveAll(entities);
    }
}
