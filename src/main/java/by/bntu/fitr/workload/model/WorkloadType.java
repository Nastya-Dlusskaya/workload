package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WorkloadType {
    EDUCATION("EDUCATION", "Учебная"),
    EDUCATION_METHODICAL("EDUCATION_METHODICAL", "Учебно-методическая"),
    ORGANIZATIONAL_METHODICAL("ORGANIZATIONAL_METHODICAL", "Организационно – методическая"),
    SCIENTIFIC_RESEARCH("SCIENTIFIC_RESEARCH", "Научно – исследовательская"),
    SOCIAL("SOCIAL", "Информационно – воспитательная, общественная и идеологическая"),
    NONE("", "");

    private String sheetValue;
    private String appValue;
}
