package com.example.backend_defects_3d_up.controller;

import com.example.backend_defects_3d_up.service.impl.DefectServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;


@RestController
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ImageController {

    DefectServiceImpl defectService;

    @GetMapping(value = "/defects/picture/{id}")
    public ResponseEntity<?> read(@PathVariable(name = "id") int id) {
        Resource resource = defectService.getFile(id);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }
}
