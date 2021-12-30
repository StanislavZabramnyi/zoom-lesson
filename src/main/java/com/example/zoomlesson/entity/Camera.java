package com.example.zoomlesson.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Camera {
    @Id
    @GeneratedValue
    private Long id;
    private Long nasaId;
    private String name;
    private String fullName;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "camera")
    private List<Photo> photos = new ArrayList<>();

    public void addPhoto(Photo photo){
        photo.setCamera(this);
        photos.add(photo);
    }

    public void removePhoto(Photo photo){
        photo.setCamera(null);
        photos.remove(photo);
    }
}
