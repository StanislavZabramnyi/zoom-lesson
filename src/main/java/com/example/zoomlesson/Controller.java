package com.example.zoomlesson;

import com.example.zoomlesson.entity.Photo;
import com.example.zoomlesson.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/cameras")
public class Controller {

    @Autowired
    private PhotoRepository photoRepository;

    @GetMapping
    public List<Photo> getPhotos() {
        return photoRepository.findAll();
    }
}
