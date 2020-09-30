package by.bntu.fitr.workload.controller.impl;

import by.bntu.fitr.workload.model.entity.Subject;
import by.bntu.fitr.workload.service.SubjectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectRestImpl extends CrudRestImpl<Subject, SubjectService> {


}
