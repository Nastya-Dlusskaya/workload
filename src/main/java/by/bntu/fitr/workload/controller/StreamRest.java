package by.bntu.fitr.workload.controller;

import by.bntu.fitr.workload.controller.util.CrudRestImpl;
import by.bntu.fitr.workload.model.StreamDto;
import by.bntu.fitr.workload.service.StreamService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/streams")
public class StreamRest extends CrudRestImpl<StreamDto, StreamService> {
}
