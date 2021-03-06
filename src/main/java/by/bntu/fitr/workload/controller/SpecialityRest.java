package by.bntu.fitr.workload.controller;

import by.bntu.fitr.workload.controller.util.CrudRestImpl;
import by.bntu.fitr.workload.model.ObjectRef;
import by.bntu.fitr.workload.service.SpecialityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/specialities")
public class SpecialityRest extends CrudRestImpl<ObjectRef, SpecialityService> {
}