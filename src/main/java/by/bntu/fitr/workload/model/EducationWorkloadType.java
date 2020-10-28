package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EducationWorkloadType {

    LECTURE("Лекции"),
    PRACTISE("Практические и семинарские занятия"),
    LABORATORY("Лабораторные занятия"),
    COURSEWORK("Курсовое проектирование"),
    CONSULTATION("Консультации"),
    SET_OFF("Зачёт"),
    EXAM("Экзамены"),
    POST_GRADUATE("Руководство и занятия с аспирантами"),
    DIPLOMA("Дипломное проектирование"),
    EXAM_COMMITTEE("ГЭК"),
    FIELD_TRIP("Производственные и учебные практики"),
    ATTENDANCE("Контрольное посещение занятий"),
    REVIEW("Рецензирование контрольных работ");

    private String value;
}
