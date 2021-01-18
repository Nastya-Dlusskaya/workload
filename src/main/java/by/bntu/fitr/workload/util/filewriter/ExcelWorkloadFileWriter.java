package by.bntu.fitr.workload.util.filewriter;

import by.bntu.fitr.workload.model.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class ExcelWorkloadFileWriter implements WorkloadFileWriter {

    private Workbook workbook;

    @Override
    public File writeFile(Book workloadBook) throws IOException {
        workbook = new XSSFWorkbook();

        for (WorkloadSheet workloadSheet : workloadBook.getWorkloadSheets()) {
            Sheet sheet = workbook.createSheet(workloadSheet.getName());

            Row header = sheet.createRow(0);

            CellStyle headerStyle = getHeaderStyle(workbook);

            List<String> headerTitles = workloadSheet.getHeader();

            IntStream.range(0, headerTitles.size())
                    .forEach(
                            i -> {
                                sheet.setColumnWidth(i, 6000);
                                createCell(headerStyle, header, i, headerTitles.get(i));
                            });

            writeBody(workloadSheet, sheet);
        }

        return saveFile(workloadBook.getName(), workbook);
    }

    private CellStyle getBodyCellFormat() {
        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        return style;
    }

    //  private BorderStyle getBorderStyle() {
    //      BorderStyle borderStyle = new BorderStyle();
    //      return borderStyle;
    //  }

    private void writeBody(WorkloadSheet workloadSheet, Sheet sheet) {
        switch (workloadSheet.getType()) {
            case "Science":
                writeScienceBody(sheet, ((ScienceWorkloadSheet) workloadSheet).getSheetRows());
                break;
            case "Monthly":
                writeMonthlyBody(sheet, (MonthlyWorkloadSheet) workloadSheet);
                break;
            case "Education":
                writeEducationBody(sheet, ((EducationWorkloadSheet) workloadSheet).getSheetRows());
                break;
            case "Additional":
                writeAdditionalBody(sheet, ((AdditionalWorkWorkloadSheet) workloadSheet).getSheetRows());
                break;
            default:
                return;
        }
    }

    private void writeScienceBody(Sheet sheet, List<ScienceWorkloadSheetRow> sheetRows) {
        CellStyle style = getBodyCellFormat();
        IntStream.range(1, sheetRows.size() + 1)
                .forEach(
                        i -> {
                            Row row = sheet.createRow(i);
                            ScienceWorkloadSheetRow sheetRow = sheetRows.get(i - 1);
                            createCell(row, 0, sheetRow.getName());
                            createCell(row, 1, sheetRow.getHours());
                            createCell(row, 2, sheetRow.getResultForm());
                            createCell(row, 3, sheetRow.getStartDate());
                            createCell(row, 4, sheetRow.getEndDate());
                            createCell(row, 5, sheetRow.getNote());
                        });
    }

    private void writeMonthlyBody(Sheet sheet, MonthlyWorkloadSheet sheetRows) {
        CellStyle style = getBodyCellFormat();
        IntStream.range(1, sheetRows.getSheetRows().size() + 1)
                .forEach(
                        i -> {
                            Row row = sheet.createRow(i);
                            MonthlyWorkloadSheetRow sheetRow = sheetRows.getSheetRows().get(i - 1);
                            createCell(row, 0, sheetRow.getDate());
                            createCell(row, 1, sheetRow.getLecturerHours());
                            createCell(row, 2, sheetRow.getPractiseHours());
                            createCell(row, 3, sheetRow.getLaboratoryHours());
                            createCell(row, 4, sheetRow.getSetOffHours());
                            createCell(row, 5, sheetRow.getConsultationHours());
                            createCell(row, 6, sheetRow.getCourseworkHours());
                            createCell(row, 7, sheetRow.getDiplomaHours());
                            createCell(row, 8, sheetRow.getSetOffHours());
                            createCell(row, 9, sheetRow.getExamHours());
                            createCell(row, 10, sheetRow.getFieldTripHours());
                            createCell(row, 11, sheetRow.getSubjectName());
                        });

        writeAdditionalInfo(
                sheet,
                sheetRows,
                style,
                sheetRows.getSheetRows().size() + 3,
                "Учебно-методическая",
                sheetRows.getEducationMethodical());

        writeAdditionalInfo(
                sheet,
                sheetRows,
                style,
                sheetRows.getSheetRows().size() + 4,
                "Организационно – методическая",
                sheetRows.getOrganizationalMethodical());

        writeAdditionalInfo(
                sheet,
                sheetRows,
                style,
                sheetRows.getSheetRows().size() + 5,
                "Научно – исследовательская",
                sheetRows.getScientificResearch());
    }

    private void writeAdditionalInfo(
            Sheet sheet,
            MonthlyWorkloadSheet sheetRows,
            CellStyle style,
            int i,
            String s,
            int educationMethodical) {
        Row educationMethodicalRow = sheet.createRow(i);
        createCell(educationMethodicalRow, 0, s);
        createCell(educationMethodicalRow, 1, educationMethodical);
    }

    private void writeEducationBody(Sheet sheet, List<EducationWorkloadSheetRow> sheetRows) {
        IntStream.range(1, sheetRows.size() + 1)
                .forEach(
                        i -> {
                            Row row = sheet.createRow(i);
                            EducationWorkloadSheetRow sheetRow = sheetRows.get(i - 1);
                            List<EducationWorkloadSheetItem> items = sheetRow.getItems();
                            createCell(row, 0, sheetRow.getSubjectName());
                            createCell(row, 1, getExpectedResult(items, EducationWorkloadType.LECTURE));
                            createCell(row, 2, getActualResult(items, EducationWorkloadType.LECTURE));
                            createCell(row, 3, getExpectedResult(items, EducationWorkloadType.PRACTISE));
                            createCell(row, 4, getActualResult(items, EducationWorkloadType.PRACTISE));
                            createCell(row, 5, getExpectedResult(items, EducationWorkloadType.LABORATORY));
                            createCell(row, 6, getActualResult(items, EducationWorkloadType.LABORATORY));
                            createCell(row, 7, getExpectedResult(items, EducationWorkloadType.COURSEWORK));
                            createCell(row, 8, getActualResult(items, EducationWorkloadType.COURSEWORK));
                            createCell(row, 9, getExpectedResult(items, EducationWorkloadType.CONSULTATION));
                            createCell(row, 10, getActualResult(items, EducationWorkloadType.CONSULTATION));
                            createCell(row, 11, getExpectedResult(items, EducationWorkloadType.SET_OFF));
                            createCell(row, 12, getActualResult(items, EducationWorkloadType.SET_OFF));
                            createCell(row, 13, getExpectedResult(items, EducationWorkloadType.EXAM));
                            createCell(row, 14, getActualResult(items, EducationWorkloadType.EXAM));
                            createCell(row, 15, getExpectedResult(items, EducationWorkloadType.POST_GRADUATE));
                            createCell(row, 16, getActualResult(items, EducationWorkloadType.POST_GRADUATE));
                            createCell(row, 17, getExpectedResult(items, EducationWorkloadType.DIPLOMA));
                            createCell(row, 18, getActualResult(items, EducationWorkloadType.DIPLOMA));
                            createCell(row, 19, getExpectedResult(items, EducationWorkloadType.EXAM_COMMITTEE));
                            createCell(row, 20, getActualResult(items, EducationWorkloadType.EXAM_COMMITTEE));
                            createCell(row, 21, getExpectedResult(items, EducationWorkloadType.FIELD_TRIP));
                            createCell(row, 22, getActualResult(items, EducationWorkloadType.FIELD_TRIP));
                            createCell(row, 23, getExpectedResult(items, EducationWorkloadType.ATTENDANCE));
                            createCell(row, 24, getActualResult(items, EducationWorkloadType.ATTENDANCE));
                            createCell(row, 25, getExpectedResult(items, EducationWorkloadType.REVIEW));
                            createCell(row, 26, getActualResult(items, EducationWorkloadType.REVIEW));
                        });
    }

    private String getExpectedResult(
            List<EducationWorkloadSheetItem> items, EducationWorkloadType lecture) {
        Optional<EducationWorkloadSheetItem> educationWorkloadSheetItem =
                getEducationWorkloadSheetItem(items, lecture);
        return educationWorkloadSheetItem
                .map(workloadSheetItem -> workloadSheetItem.getExpected() + "")
                .orElse("");
    }

    private String getActualResult(
            List<EducationWorkloadSheetItem> items, EducationWorkloadType lecture) {
        Optional<EducationWorkloadSheetItem> educationWorkloadSheetItem =
                getEducationWorkloadSheetItem(items, lecture);
        return educationWorkloadSheetItem
                .map(workloadSheetItem -> workloadSheetItem.getActual() + "")
                .orElse("");
    }

    private Optional<EducationWorkloadSheetItem> getEducationWorkloadSheetItem(
            List<EducationWorkloadSheetItem> items, EducationWorkloadType lecture) {
        return items.stream().filter(item -> item.getName().equals(lecture.getValue())).findFirst();
    }

    private void writeAdditionalBody(Sheet sheet, List<AdditionalWorkWorkloadSheetRow> sheetRows) {
        IntStream.range(1, sheetRows.size() + 1)
                .forEach(
                        i -> {
                            Row row = sheet.createRow(i);
                            AdditionalWorkWorkloadSheetRow sheetRow = sheetRows.get(i - 1);
                            createCell(row, 0, sheetRow.getName());
                            createCell(row, 1, sheetRow.getHours());
                            createCell(row, 2, sheetRow.getStartDate());
                            createCell(row, 3, sheetRow.getEndDate());
                            createCell(row, 4, sheetRow.getNote());
                        });
    }

    private void createCell(CellStyle style, Row row, int i2, String s) {
        Cell cell = row.createCell(i2);
        cell.setCellValue(s);
        cell.setCellStyle(style);
    }

    private void createCell(Row row, int i2, String s) {
        CellStyle style = getBodyCellFormat();
        Cell cell = row.createCell(i2);
        cell.setCellValue(s);
        cell.setCellStyle(style);
    }

    private void createCell(Row row, int i2, int s) {
        CellStyle style = getBodyCellFormat();
        Cell cell = row.createCell(i2);
        cell.setCellValue(s);
        cell.setCellStyle(style);
    }

    private void createCell(Row row, int i2, LocalDate s) {
        CellStyle style = getBodyCellFormat();
        DataFormat format = workbook.createDataFormat();
        style.setDataFormat(format.getFormat("dd.mm.yyyy"));
        Cell cell = row.createCell(i2);
        cell.setCellValue(s);
        cell.setCellStyle(style);
    }

    private CellStyle getHeaderStyle(Workbook workbook) {
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 14);
        font.setBold(true);
        headerStyle.setFont(font);
        return headerStyle;
    }

    private File saveFile(String name, Workbook workbook) throws IOException {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + name + ".xlsx";

        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        return new File(fileLocation);
    }
}
