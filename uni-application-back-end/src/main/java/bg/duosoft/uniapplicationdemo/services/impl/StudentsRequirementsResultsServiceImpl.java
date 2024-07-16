package bg.duosoft.uniapplicationdemo.services.impl;

import bg.duosoft.uniapplicationdemo.mappers.StudentsRequirementsResultsMapper;
import bg.duosoft.uniapplicationdemo.models.dtos.StudentsRequirementsResultsDTO;
import bg.duosoft.uniapplicationdemo.models.dtos.TestStateDTO;
import bg.duosoft.uniapplicationdemo.models.dtos.TestStateDTOFinal;
import bg.duosoft.uniapplicationdemo.models.entities.StudentsRequirementsResultsEntity;
import bg.duosoft.uniapplicationdemo.repositories.StudentsRequirementsResultsRepository;
import bg.duosoft.uniapplicationdemo.services.StudentsRequirementsResultsService;
import bg.duosoft.uniapplicationdemo.services.base.BaseServiceImpl;
import bg.duosoft.uniapplicationdemo.validators.StudentsRequirementsResultsValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsRequirementsResultsServiceImpl extends BaseServiceImpl<String, StudentsRequirementsResultsDTO, StudentsRequirementsResultsEntity, StudentsRequirementsResultsMapper, StudentsRequirementsResultsValidator, StudentsRequirementsResultsRepository> implements StudentsRequirementsResultsService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(StudentsRequirementsResultsServiceImpl.class);

    @Override
    public boolean isCachingEnabled() {
        return false;
    }

    @Override
    public void processTestResults(String jsonString) {
        try {
            int[] correctAnswersLanguageTest = {1, 1, 0, 2, 1, 1, 1, 1, 1, 2};
            TestStateDTO dto = objectMapper.readValue(jsonString, TestStateDTOFinal.class);
            String username = dto.getUsername();
            String testName = dto.getTestName();
            List<Integer> answers = dto.getAnswers();

            if (testName.equals("language")) {
                processTest(correctAnswersLanguageTest, answers, username, testName);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    private void processTest(int[] correctAnswers, List<Integer> answers, String username, String testName) {
        int correctCount = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (answers.get(i) == correctAnswers[i]) {
                correctCount++;
            }
        }

        double result = correctCount * 10.0;

        StudentsRequirementsResultsDTO testResultsDTO = new StudentsRequirementsResultsDTO(
                username,
                "language".equals(testName) ? result : null,
                "standard".equals(testName) ? result : null
        );

        super.create(testResultsDTO);
    }
}
