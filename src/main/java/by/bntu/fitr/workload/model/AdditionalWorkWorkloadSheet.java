package by.bntu.fitr.workload.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class AdditionalWorkWorkloadSheet extends WorkloadSheet {
    public List<String> header = Arrays.asList("Наименование работ", "Количество часов", "Начало проведение", "Конец проведения", "Примечание");
    private List<AdditionalWorkWorkloadSheetRow> sheetRows;

    public AdditionalWorkWorkloadSheet() {
        sheetRows = new LinkedList<>();
    }

    public void addRow(AdditionalWorkWorkloadSheetRow row) {
        sheetRows.add(row);
    }

    public List<String> getHeader() {
        return header;
    }

    @Override
    public String getType() {
        return "Additional";
    }
}
