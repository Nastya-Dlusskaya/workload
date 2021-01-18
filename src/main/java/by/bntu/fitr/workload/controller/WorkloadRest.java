package by.bntu.fitr.workload.controller;

import by.bntu.fitr.workload.controller.util.CrudRestImpl;
import by.bntu.fitr.workload.model.WorkloadDto;
import by.bntu.fitr.workload.service.WorkloadService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workloads")
public class WorkloadRest extends CrudRestImpl<WorkloadDto, WorkloadService> {

}
