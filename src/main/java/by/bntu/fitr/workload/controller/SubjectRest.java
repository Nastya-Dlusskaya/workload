package by.bntu.fitr.workload.controller;

import by.bntu.fitr.workload.model.entity.Subject;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/subject")
public interface SubjectRest extends CrudRest<Subject> {

}
