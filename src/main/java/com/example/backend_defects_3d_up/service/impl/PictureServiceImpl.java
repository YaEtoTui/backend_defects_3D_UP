package com.example.backend_defects_3d_up.service.impl;

import com.example.backend_defects_3d_up.domain.dto.entity.Defect;
import com.example.backend_defects_3d_up.repository.DefectRepository;
import com.example.backend_defects_3d_up.service.PictureService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PictureServiceImpl implements PictureService {
    DefectRepository defectsRepository;

    public String read(int id) {
        Defect defect = defectsRepository.findById((long) id).get();
        return defect.getPicture();
    }
}
