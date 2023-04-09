package com.example.backend_defects_3d_up.service;

import com.example.backend_defects_3d_up.domain.dto.response.DefectResponse;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DefectService {
    List<DefectResponse> readAll();

    DefectResponse read(int id);

    Resource getFile(int id);
}
