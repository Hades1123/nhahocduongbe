package vn.viettel.bvrhm.nhahocduong.api.nhahocduong.internal.entity;

import java.util.List;

public record Treatment(
    ToothTreatment service,
    String dentistName,
    String diagnosis,
    Tooth teeth,
    List<PrescriptionItem> prescription
) {}
