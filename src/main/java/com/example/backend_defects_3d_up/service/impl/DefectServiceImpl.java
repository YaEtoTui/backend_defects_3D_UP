package com.example.backend_defects_3d_up.service.impl;

import com.example.backend_defects_3d_up.domain.dto.entity.Defect;
import com.example.backend_defects_3d_up.domain.dto.response.DefectResponse;
import com.example.backend_defects_3d_up.mapper.DefectResponseMapper;
import com.example.backend_defects_3d_up.repository.DefectRepository;
import com.example.backend_defects_3d_up.service.DefectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class DefectServiceImpl implements DefectService {
    DefectRepository defectsRepository;
    DefectResponseMapper defectResponseMapper;

    @Override
    @Transactional
    public List<DefectResponse> readAll() {
        List<Defect> defectList = defectsRepository.findAll();
        return defectResponseMapper.createListDefectResponse(defectList);
    }

    @Override
    @Transactional
    public DefectResponse read(int id) {
        Defect defect = defectsRepository.findById((long) id).get();
        return defectResponseMapper.createDefectResponse(defect);
    }

    @Override
    @SneakyThrows
    @Transactional
    public Resource getFile(int id) {

        Defect defect = defectsRepository.findById((long) id).get();

//        Path filePath = Paths.get(defect.getPicture()).normalize();
        Path filePath = Paths.get(defect.getPicture()).toAbsolutePath();
        return new UrlResource(filePath.toUri());
    }
}
