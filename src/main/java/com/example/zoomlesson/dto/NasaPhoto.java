package com.example.zoomlesson.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NasaPhoto {
    private long id;
    private int sol;
    private NasaCamera camera;
    private String img_src;
    private String earth_date;
}
