package com.example.backend_defects_3d_up.service.impl;

import com.example.backend_defects_3d_up.domain.entity.Defect;
import com.example.backend_defects_3d_up.adapter.repository.DefectRepository;
import com.example.backend_defects_3d_up.service.PictureService;
import com.example.backend_defects_3d_up.service.factory.ImageFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PictureServiceImpl implements PictureService {
    DefectRepository defectsRepository;
    ImageFactory imageFactory;

    public String read(int id) {
        Defect defect = defectsRepository.findById((long) id).get();
        return defect.getPicture();
    }

    @Override
    @Transactional
    @SneakyThrows
    public Resource add_file(long id, MultipartFile multipartFile) {
        Path filePath = Paths.get("src\\main\\java\\com\\example\\backend_defects_3d_up\\image\\" + multipartFile.getOriginalFilename()).toAbsolutePath();
        imageFactory.addFileInImage(filePath, multipartFile);
        System.out.println("File has uploaded!");
        imageFactory.saveInDBPath(id, filePath);
        return new UrlResource(filePath.toUri());
    }
}
