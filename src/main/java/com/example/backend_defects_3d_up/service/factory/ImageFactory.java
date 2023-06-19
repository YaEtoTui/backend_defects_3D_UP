package com.example.backend_defects_3d_up.service.factory;

import com.example.backend_defects_3d_up.adapter.repository.DefectRepository;
import com.example.backend_defects_3d_up.common.exception.NotFoundDefectException;
import com.example.backend_defects_3d_up.domain.entity.Defect;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ImageFactory {
    DefectRepository defectRepository;

    public void addFileInImage(Path filePath, MultipartFile multipartFile) {
        File convertFile = new File(filePath.toString());

        try (FileOutputStream fileOutputStream = new FileOutputStream(convertFile)) {
            fileOutputStream.write(multipartFile.getBytes());
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void saveInDBPath(long id, Path filePath) {
        Defect defect = defectRepository.findById(id)
                .orElseThrow(() -> new NotFoundDefectException(
                        String.format("Not found defect with '%s' id", id)
                        )
                );

        Defect defectEntity = new Defect(
                defect.getId(),
                defect.getName(),
                defect.getDescription(),
                defect.getReasons(),
                defect.getSolutions(),
                filePath.toString()
        );

        defectRepository.save(defectEntity);

        System.out.println("File has saved in db!");
    }
}
