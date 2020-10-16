package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WorkloadType {
    EDUCATION("Учебная"),
    EDUCATION_METHODICAL("Учебно-методическая"),
    ORGANIZATIONAL_METHODICAL("Организационно – методическая"),
    SCIENTIFIC_RESEARCH("Научно – исследовательская"),
    SOCIAL("Информационно – воспитательная, общественная и идеологическая");

    private String value;
}
