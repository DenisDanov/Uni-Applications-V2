package bg.duosoft.uniapplicationdemo.controllers;

import bg.duosoft.uniapplicationdemo.controllers.base.CrudController;
import bg.duosoft.uniapplicationdemo.models.dtos.nomenclatures.AccreditationStatusDTO;
import bg.duosoft.uniapplicationdemo.services.AccreditationStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accreditation-status")
@RequiredArgsConstructor
public class AccreditationStatusController extends CrudController<String, AccreditationStatusDTO, AccreditationStatusService> {
}
