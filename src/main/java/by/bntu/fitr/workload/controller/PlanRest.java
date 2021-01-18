package by.bntu.fitr.workload.controller;

import by.bntu.fitr.workload.controller.util.CrudRestImpl;
import by.bntu.fitr.workload.model.EducationWorkloadSheetRow;
import by.bntu.fitr.workload.model.PlanDto;
import by.bntu.fitr.workload.service.FileService;
import by.bntu.fitr.workload.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanRest extends CrudRestImpl<PlanDto, PlanService> {

    @Autowired
    private FileService fileService;

    @GetMapping("/{id}/download")
    public ResponseEntity download(@PathVariable Long id) throws IOException {
        File file = fileService.getFile(id);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(file.length()) //
                .body(resource);
    }

    @GetMapping("/{id}/education-plan")
    public List<EducationWorkloadSheetRow> getEducationPlan(@PathVariable Long id) throws IOException {
        return service.getEducationPlan(id);
    }
}
