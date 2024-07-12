package bg.duosoft.uniapplicationdemo.services.impl;

import bg.duosoft.uniapplicationdemo.mappers.nomenclatures.AccreditationStatusMapper;
import bg.duosoft.uniapplicationdemo.models.dtos.nomenclatures.AccreditationStatusDTO;
import bg.duosoft.uniapplicationdemo.models.entities.nomenclatures.AccreditationStatusEntity;
import bg.duosoft.uniapplicationdemo.repositories.AccreditationStatusRepository;
import bg.duosoft.uniapplicationdemo.services.AccreditationStatusService;
import bg.duosoft.uniapplicationdemo.services.base.BaseServiceImpl;
import bg.duosoft.uniapplicationdemo.validators.nomenclatures.AccreditationStatusValidator;
import org.springframework.stereotype.Service;

@Service
public class AccreditationStatusServiceImpl extends BaseServiceImpl<String,AccreditationStatusDTO, AccreditationStatusEntity, AccreditationStatusMapper, AccreditationStatusValidator, AccreditationStatusRepository> implements AccreditationStatusService {
}
