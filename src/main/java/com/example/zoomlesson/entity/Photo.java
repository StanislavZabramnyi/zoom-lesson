package com.example.zoomlesson.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

    @Id
    @GeneratedValue
    private Long id;
    private Long nasaId;
    private String url;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "camera_id")
    private Camera camera;
}
