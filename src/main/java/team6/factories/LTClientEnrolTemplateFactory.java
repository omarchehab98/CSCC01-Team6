package team6.factories;

import java.util.HashMap;
import java.util.function.Consumer;

import team6.models.LTClientEnrolTemplate;
import team6.models.Organization;
import team6.models.Template;

public class LTClientEnrolTemplateFactory {
	public static Template build(HashMap<String, String> row, Organization organization) {
		LTClientEnrolTemplate ltClientEnrolTemplate= new LTClientEnrolTemplate();
		HashMap<String, Consumer<String>> setters = new HashMap<String, Consumer<String>>();

		setters.put("processing_details", ltClientEnrolTemplate::setProcessingDetails);
		setters.put("update_record_id", ltClientEnrolTemplate::setUpdateRecordId);
		setters.put("client_validation_type_id", ltClientEnrolTemplate::setClientValidationTypeId);
		setters.put("client_validation_id", ltClientEnrolTemplate::setClientValidationId);
		setters.put("client_birth_dt", ltClientEnrolTemplate::setClientBirthDt);
		setters.put("postal_cd", ltClientEnrolTemplate::setPostalCd);
		setters.put("course_cd", ltClientEnrolTemplate::setCourseCd);
		setters.put("first_class_dt", ltClientEnrolTemplate::setFirstClassDt);
		setters.put("preferred_official_lang_id", ltClientEnrolTemplate::setPreferredOfficialLangId);
		setters.put("support_received_ind", ltClientEnrolTemplate::setSupportReceivedInd);
		setters.put("childminding_ind", ltClientEnrolTemplate::setChildmindingInd);
		setters.put("childminding_NewcomerChildren[1]childminding_age_id", ltClientEnrolTemplate::setChildmindingNewcomerChildren1ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[1]childminding_type_id", ltClientEnrolTemplate::setChildmindingNewcomerChildren1ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[2]childminding_age_id", ltClientEnrolTemplate::setChildmindingNewcomerChildren2ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[2]childminding_type_id", ltClientEnrolTemplate::setChildmindingNewcomerChildren2ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[3]childminding_age_id", ltClientEnrolTemplate::setChildmindingNewcomerChildren3ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[3]childminding_type_id", ltClientEnrolTemplate::setChildmindingNewcomerChildren3ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[4]childminding_age_id", ltClientEnrolTemplate::setChildmindingNewcomerChildren4ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[4]childminding_type_id", ltClientEnrolTemplate::setChildmindingNewcomerChildren4ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[5]childminding_age_id", ltClientEnrolTemplate::setChildmindingNewcomerChildren5ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[5]childminding_type_id", ltClientEnrolTemplate::setChildmindingNewcomerChildren5ChildmindingTypeId);
		setters.put("transportation_ind", ltClientEnrolTemplate::setTransportationInd);
		setters.put("support_disability_ind", ltClientEnrolTemplate::setSupportDisabilityInd);
		setters.put("translation_ind", ltClientEnrolTemplate::setTranslationInd);
		setters.put("translation_language_from_id", ltClientEnrolTemplate::setTranslationLanguageFromId);
		setters.put("translation_language_to_id", ltClientEnrolTemplate::setTranslationLanguageToId);
		setters.put("interpretation_ind", ltClientEnrolTemplate::setInterpretationInd);
		setters.put("interpretation_language_from_id", ltClientEnrolTemplate::setInterpretationLanguageFromId);
		setters.put("interpretation_language_to_id", ltClientEnrolTemplate::setInterpretationLanguageToId);
		setters.put("counselling_ind", ltClientEnrolTemplate::setCounsellingInd);
		setters.put("assessment_update_reason_id", ltClientEnrolTemplate::setAssessmentUpdateReasonId);

		for (String column : row.keySet()) {
			if (setters.containsKey(column)) {
				setters.get(column).accept(row.get(column));
			} else {
				throw new IllegalArgumentException();
			}
		}

		ltClientEnrolTemplate.setOrganization(organization);

		return ltClientEnrolTemplate;
	}

}
