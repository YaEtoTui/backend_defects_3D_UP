package com.example.backend_defects_3d_up.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface PictureService {
    String read(int id);

    Resource add_file(long id, MultipartFile multipartFile);
}
