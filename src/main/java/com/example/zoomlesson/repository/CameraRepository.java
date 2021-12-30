package com.example.zoomlesson.repository;

import com.example.zoomlesson.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<Camera, Long> {
}
