package vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import vn.viettel.bvrhm.nhahocduong.api.auth.internal.service.AuthorizationService;
import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.dto.PatientDTO;
import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.dto.criteria.PatientSearchCriteria;
import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.entity.Disease;
import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.entity.Patient;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author: longlb1
 * @since: 26-Sep-23
 */
public interface PatientService {
    PatientDTO getPatientById(Long id);
    
    PatientDTO createPatient(PatientDTO patientDTO);
    
    PatientDTO updatePatient(PatientDTO patientDTO, Long id);

    List<PatientDTO> getPatientByCondition(
            String searchText,
            String organizationName,
            List<String> schoolClass);

    Page<PatientDTO> getPagePatientByCondition(
            PatientSearchCriteria searchCriteria, Pageable pageable);

    Page<PatientDTO> getAllPatients(Pageable pageable);

    boolean deletePatientById(Long id);

    List<PatientDTO> importPatientsFromExcel(MultipartFile file) throws IOException;

    byte[] generateExcelTemplateFile(HttpServletResponse response) throws IOException;
}
