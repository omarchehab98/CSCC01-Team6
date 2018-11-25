package team6.factories;

import java.util.HashMap;
import java.util.function.Consumer;

import team6.models.LTClientExitTemplate;
import team6.models.Organization;
import team6.models.Template;

public class LTClientExitTemplateFactory {
	public static Template build(HashMap<String, String> row, Organization organization) {
		LTClientExitTemplate ltClientExitTemplate= new LTClientExitTemplate();
		HashMap<String, Consumer<String>> setters = new HashMap<String, Consumer<String>>();

		setters.put("processing_details", ltClientExitTemplate::setProcessingDetails);
		setters.put("update_record_id", ltClientExitTemplate::setUpdateRecordId);
		setters.put("client_validation_type_id", ltClientExitTemplate::setClientValidationTypeId);
		setters.put("client_validation_id", ltClientExitTemplate::setClientValidationId);
		setters.put("client_birth_dt", ltClientExitTemplate::setClientBirthDt);
		setters.put("course_cd", ltClientExitTemplate::setCourseCd);
		setters.put("training_status_id", ltClientExitTemplate::setTrainingStatusId);
		setters.put("exit_course_dt", ltClientExitTemplate::setExitCourseDt);
		setters.put("exit_course_reason_id", ltClientExitTemplate::setExitCourseReasonId);
		setters.put("listening_CLB_level_id", ltClientExitTemplate::setListeningCLBLevelId);
		setters.put("speaking_CLB_level_id", ltClientExitTemplate::setSpeakingCLBLevelId);
		setters.put("reading_CLB_level_id", ltClientExitTemplate::setReadingCLBLevelId);
		setters.put("writing_CLB_level_id", ltClientExitTemplate::setWritingCLBLevelId);
		setters.put("certificate_issued_ind", ltClientExitTemplate::setCertificateIssuedInd);
		setters.put("certificate_listening_level_id", ltClientExitTemplate::setCertificateListeningLevelId);
		setters.put("certificate_speaking_level_id", ltClientExitTemplate::setCertificateSpeakingLevelId);
		setters.put("support_received_ind", ltClientExitTemplate::setSupportReceivedInd);
		setters.put("childminding_ind", ltClientExitTemplate::setChildmindingInd);
		setters.put("childminding_NewcomerChildren[1]childminding_age_id", ltClientExitTemplate::setChildmindingNewcomerChildren1ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[1]childminding_type_id", ltClientExitTemplate::setChildmindingNewcomerChildren1ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[2]childminding_age_id", ltClientExitTemplate::setChildmindingNewcomerChildren2ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[2]childminding_type_id", ltClientExitTemplate::setChildmindingNewcomerChildren2ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[3]childminding_age_id", ltClientExitTemplate::setChildmindingNewcomerChildren3ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[3]childminding_type_id", ltClientExitTemplate::setChildmindingNewcomerChildren3ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[4]childminding_age_id", ltClientExitTemplate::setChildmindingNewcomerChildren4ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[4]childminding_type_id", ltClientExitTemplate::setChildmindingNewcomerChildren4ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[5]childminding_age_id", ltClientExitTemplate::setChildmindingNewcomerChildren5ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[5]childminding_type_id", ltClientExitTemplate::setChildmindingNewcomerChildren5ChildmindingTypeId);
		setters.put("transportation_ind", ltClientExitTemplate::setTransportationInd);
		setters.put("support_disability_ind", ltClientExitTemplate::setSupportDisabilityInd);
		setters.put("translation_ind", ltClientExitTemplate::setTranslationInd);
		setters.put("translation_language_from_id", ltClientExitTemplate::setTranslationLanguageFromId);
		setters.put("translation_language_to_id", ltClientExitTemplate::setTranslationLanguageToId);
		setters.put("interpretation_ind", ltClientExitTemplate::setInterpretationInd);
		setters.put("interpretation_language_from_id", ltClientExitTemplate::setInterpretationLanguageFromId);
		setters.put("interpretation_language_to_id", ltClientExitTemplate::setInterpretationLanguageToId);
		setters.put("counselling_ind", ltClientExitTemplate::setCounsellingInd);
		setters.put("assessment_update_reason_id", ltClientExitTemplate::setAssessmentUpdateReasonId);

		for (String column : row.keySet()) {
			if (setters.containsKey(column)) {
				setters.get(column).accept(row.get(column));
			} else {
				throw new IllegalArgumentException();
			}
		}

		ltClientExitTemplate.setOrganization(organization);

		return ltClientExitTemplate;
	}

}
