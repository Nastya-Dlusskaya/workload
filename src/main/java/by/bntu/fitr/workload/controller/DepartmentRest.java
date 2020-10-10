package by.bntu.fitr.workload.controller;

import by.bntu.fitr.workload.controller.util.CrudRestImpl;
import by.bntu.fitr.workload.model.DepartmentDto;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.service.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentRest extends CrudRestImpl<DepartmentDto, DepartmentService> {


}