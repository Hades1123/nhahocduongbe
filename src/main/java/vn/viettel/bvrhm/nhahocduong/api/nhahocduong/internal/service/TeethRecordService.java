package vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.service;

import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.dto.TeethRecordDTO;
import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.entity.Exam;
import vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.entity.TeethRecord;

/**
 * @author: longlb1
 * @since: 29-Sep-23
 */
public interface TeethRecordService {
    TeethRecordDTO getTeethRecordById(Long id);
    TeethRecordDTO getTeethRecordByPatientIdAndExamId(Long patientId, Long examId);
    TeethRecordDTO upsertTeethRecord(TeethRecordDTO teethRecordDTO);
}
