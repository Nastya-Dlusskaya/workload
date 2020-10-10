package by.bntu.fitr.workload.controller;

import by.bntu.fitr.workload.controller.util.CrudRestImpl;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.service.AcademicRankService;
import by.bntu.fitr.workload.service.SubjectService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/academicRank")
public class AcademicRankRest extends CrudRestImpl<ObjectRef, AcademicRankService> {

}