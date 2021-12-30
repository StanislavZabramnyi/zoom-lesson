package com.example.zoomlesson.repository;

import com.example.zoomlesson.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
