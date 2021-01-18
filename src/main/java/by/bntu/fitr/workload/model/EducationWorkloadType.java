package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EducationWorkloadType {

    LECTURE("LECTURE", "Лекции"),
    PRACTISE("PRACTISE", "Практические и семинарские занятия"),
    LABORATORY("LABORATORY", "Лабораторные занятия"),
    COURSEWORK("COURSEWORK", "Курсовое проектирование"),
    CONSULTATION("CONSULTATION", "Консультации"),
    SET_OFF("SET_OFF", "Зачёт"),
    EXAM("EXAM", "Экзамены"),
    POST_GRADUATE("POST_GRADUATE", "Руководство и занятия с аспирантами"),
    DIPLOMA("DIPLOMA", "Дипломное проектирование"),
    EXAM_COMMITTEE("EXAM_COMMITTEE", "ГЭК"),
    FIELD_TRIP("FIELD_TRIP", "Производственные и учебные практики"),
    ATTENDANCE("ATTENDANCE", "Контрольное посещение занятий"),
    REVIEW("REVIEW", "Рецензирование контрольных работ"),
    NONE("NONE", "");

    private final String value;
    private final String strongValue;
}
