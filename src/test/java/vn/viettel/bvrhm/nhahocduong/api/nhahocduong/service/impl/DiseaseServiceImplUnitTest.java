package vn.viettel.bvrhm.nhahocduong.api.nhahocduong.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.dto.DiseaseDTO;
import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.entity.Disease;
import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.mapper.DiseaseMapper;
import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.repository.DiseaseRepository;
import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.service.impl.DiseaseServiceImpl;

@DisplayName("DiseaseServiceImpl — Unit Test (2 dependencies)")
@ExtendWith(MockitoExtension.class)
class DiseaseServiceImplUnitTest {

  @Mock DiseaseRepository diseaseRepository;
  @Mock DiseaseMapper diseaseMapper;
  @InjectMocks DiseaseServiceImpl diseaseServiceImpl;

  @Nested
  @DisplayName("getAllDiseases()")
  class GetAllDiseases {

    @Test
    @DisplayName("trả về list DTO khi repo có data")
    void shouldMapDiseaseListToDTOList() {
        Disease entity = new Disease();
        entity.setCode("1");
        entity.setId(1L);
        entity.setName("flu");

        DiseaseDTO dto = new DiseaseDTO(entity.getId(), entity.getCode(), entity.getName());

        when(diseaseRepository.findAll()).thenReturn(List.of(entity));
        when(diseaseMapper.toListDTO(anyList())).thenReturn(List.of(dto));

        List<DiseaseDTO> result = diseaseServiceImpl.getAllDiseases();

        assertThat(result)
            .hasSize(1)
            .first()
            .extracting(DiseaseDTO::name)
            .isEqualTo("flu");

        verify(diseaseRepository).findAll();
        verify(diseaseMapper).toListDTO(anyList());
    }
  }
}
