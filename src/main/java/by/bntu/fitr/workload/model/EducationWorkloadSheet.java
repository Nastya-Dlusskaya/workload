package by.bntu.fitr.workload.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class EducationWorkloadSheet extends WorkloadSheet {
    private List<EducationWorkloadSheetRow> sheetRows;

    public EducationWorkloadSheet() {
        sheetRows = new LinkedList<>();
    }

    public void addRow(EducationWorkloadSheetRow row) {
        sheetRows.add(row);
    }

    public List<String> getHeader() {
        return Arrays.asList(
                "Предмет",
                "Лекции(план)",
                "Лекции(текущий)",
                "Практические(план)",
                "Практические(текущий)",
                "Лабораторные(план)",
                "Лабораторные(текущий)",
                "Курсовые(план)",
                "Курсовые(текущий)",
                "Консультации(план)",
                "Консультации(текущий)",
                "Зачёты(план)",
                "Зачёты(текущий)",
                "Экзамены(план)",
                "Экзамены(текущий)",
                "Аспиранты(план)",
                "Аспиранты(текущий)",
                "Диплом(план)",
                "Диплом(текущий)",
                "ГЭК(план)",
                "ГЭК(текущий)",
                "Практика(план)",
                "Практика(текущий)",
                "Посещение(план)",
                "Посещение(текущий)",
                "Рецензия(план)",
                "Рецензия(текущий)");
    }

    @Override
    public String getType() {
        return "Education";
    }
}
