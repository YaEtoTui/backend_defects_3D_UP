package com.example.backend_defects_3d_up.mapper;

import com.example.backend_defects_3d_up.domain.dto.entity.Defect;
import com.example.backend_defects_3d_up.domain.dto.response.DefectResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefectResponseMapper {
    public DefectResponse createDefectResponse(Defect defect) {
        return new DefectResponse(defect.getId(), defect.getName(), defect.getDescription(), defect.getReasons(), defect.getSolutions(), defect.getPicture());
    }

    public List<DefectResponse> createListDefectResponse(List<Defect> defectList) {
        List<DefectResponse> defectResponseList = defectList.stream().map(this::createDefectResponse).toList();
        return defectResponseList;
    }
}
