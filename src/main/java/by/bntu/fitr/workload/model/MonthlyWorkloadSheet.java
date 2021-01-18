package by.bntu.fitr.workload.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@SuperBuilder
public class MonthlyWorkloadSheet extends WorkloadSheet {

    private List<MonthlyWorkloadSheetRow> sheetRows;
    private int educationMethodical;
    private int scientificResearch;
    private int organizationalMethodical;

    public MonthlyWorkloadSheet() {
        sheetRows = new LinkedList<>();
    }

    public void addRow(MonthlyWorkloadSheetRow row) {
        sheetRows.add(row);
    }

    public List<String> getHeader() {
        return Arrays.asList(
                "Дата",
                "Лекция",
                "Практическая",
                "Лабораторная",
                "Руководство ГР",
                "Консультации",
                "Руководство КП",
                "Руководство ДП",
                "Зачёты",
                "Экзамены, ГЭК",
                "Практика",
                "Дисциплина");
    }

    @Override
    public String getType() {
        return "Monthly";
    }
}
