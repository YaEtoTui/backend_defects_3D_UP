package com.example.backend_defects_3d_up.adapter.web.controller;

import com.example.backend_defects_3d_up.service.PictureService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static lombok.AccessLevel.PRIVATE;

@RestController
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminImageController {
    PictureService pictureService;

    //update
    @PutMapping("/new_file/{id}")
    @SneakyThrows
    public ResponseEntity<?> addPathFileInDB(@PathVariable("id") int id,
                                             @RequestParam("file") MultipartFile file) {

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(pictureService.add_file(id, file));
    }
}
