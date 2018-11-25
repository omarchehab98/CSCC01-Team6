package team6.factories;

import java.util.HashMap;
import java.util.function.Consumer;

import team6.models.EmploymentTemplate;
import team6.models.Organization;
import team6.models.Template;

public class EmploymentTemplateFactory {
	public static Template build(HashMap<String, String> row, Organization organization) {
		EmploymentTemplate employmentTemplate = new EmploymentTemplate();
		HashMap<String, Consumer<String>> setters = new HashMap<String, Consumer<String>>();

		setters.put("processing_details", employmentTemplate::setProcessingDetails);
		setters.put("update_record_id", employmentTemplate::setUpdateRecordId);
		setters.put("client_validation_type_id", employmentTemplate::setClientValidationTypeId);
		setters.put("client_validation_id", employmentTemplate::setClientValidationId);
		setters.put("client_birth_dt", employmentTemplate::setClientBirthDt);
		setters.put("postal_cd", employmentTemplate::setPostalCd);
		setters.put("session_result_intn_ind", employmentTemplate::setSessionResultIntnInd);
		setters.put("session_referral_id", employmentTemplate::setSessionReferralId);
		setters.put("session_service_lang_id", employmentTemplate::setSessionServiceLangId);
		setters.put("session_official_lang_id", employmentTemplate::setSessionOfficialLangId);
		setters.put("institution_type_id", employmentTemplate::setInstitutionTypeId);
		setters.put("assessment_referral_id", employmentTemplate::setAssessmentReferralId);
		setters.put("session_referral_dt", employmentTemplate::setSessionReferralDt);
		setters.put("session_employment_status_id", employmentTemplate::setSessionEmploymentStatusId);
		setters.put("session_education_status_id", employmentTemplate::setSessionEducationStatusId);
		setters.put("session_current_occupation_id", employmentTemplate::setSessionCurrentOccupationId);
		setters.put("session_intended_occupation_id", employmentTemplate::setSessionIntendedOccupationId);
		setters.put("intervention_type_id", employmentTemplate::setInterventionTypeId);
		setters.put("intervention_received_id", employmentTemplate::setInterventionReceivedId);
		setters.put("intervention_status_id", employmentTemplate::setInterventionStatusId);
		setters.put("intervention_leave_reason_id", employmentTemplate::setInterventionLeaveReasonId);
		setters.put("intervention_start_dt", employmentTemplate::setInterventionStartDt);
		setters.put("intervention_end_dt", employmentTemplate::setInterventionEndDt);
		setters.put("employer_size_id", employmentTemplate::setEmployerSizeId);
		setters.put("placement_type_id", employmentTemplate::setPlacementTypeId);
		setters.put("working_hours_id", employmentTemplate::setWorkingHoursId);
		setters.put("mentoring_location_id", employmentTemplate::setMentoringLocationId);
		setters.put("mentoring_hours_id", employmentTemplate::setMentoringHoursId);
		setters.put("intervention_profession_id", employmentTemplate::setInterventionProfessionId);
		setters.put("training_received_service_ind", employmentTemplate::setTrainingReceivedServiceInd);
		setters.put("training_received_computer_ind", employmentTemplate::setTrainingReceivedComputerInd);
		setters.put("training_received_document_ind", employmentTemplate::setTrainingReceivedDocumentInd);
		setters.put("training_received_interpersonal_ind", employmentTemplate::setTrainingReceivedInterpersonalInd);
		setters.put("training_received_leadership_ind", employmentTemplate::setTrainingReceivedLeadershipInd);
		setters.put("training_received_numeracy_ind", employmentTemplate::setTrainingReceivedNumeracyInd);
		setters.put("short_term_service[1]service_received_id", employmentTemplate::setShortTermService1ServiceReceivedId);
		setters.put("short_term_service[1]entry_dt", employmentTemplate::setShortTermService1EntryDt);
		setters.put("short_term_service[2]service_received_id", employmentTemplate::setShortTermService2ServiceReceivedid);
		setters.put("short_term_service[2]entry_dt", employmentTemplate::setShortTermService2EntryDt);
		setters.put("short_term_service[3]service_received_id", employmentTemplate::setShortTermService3ServiceReceivedId);
		setters.put("short_term_service[3]entry_dt", employmentTemplate::setShortTermService3EntryDt);
		setters.put("short_term_service[4]service_received_id", employmentTemplate::setShortTermService4ServiceReceivedId);
		setters.put("short_term_service[4]entry_dt", employmentTemplate::setShortTermService4EntryDt);
		setters.put("short_term_service[5]service_received_id", employmentTemplate::setShortTermService5ServiceReceivedId);
		setters.put("short_term_service[5]entry_dt", employmentTemplate::setShortTermService5Entrydt);
		setters.put("support_received_ind", employmentTemplate::setSupportReceivedInd);
		setters.put("childminding_ind", employmentTemplate::setChildmindingInd);
		setters.put("childminding_NewcomerChildren[1]childminding_age_id", employmentTemplate::setChildmindingNewcomerChildren1ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[1]childminding_type_id", employmentTemplate::setChildmindingNewcomerChildren1ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[2]childminding_age_id", employmentTemplate::setChildmindingNewcomerChildren2ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[2]childminding_type_id", employmentTemplate::setChildmindingNewcomerChildren2ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[3]childminding_age_id", employmentTemplate::setChildmindingNewcomerChildren3ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[3]childminding_type_id", employmentTemplate::setChildmindingNewcomerChildren3ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[4]childminding_age_id", employmentTemplate::setChildmindingNewcomerChildren4ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[4]childminding_type_id", employmentTemplate::setChildmindingNewcomerChildren4ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[5]childminding_age_id", employmentTemplate::setChildmindingNewcomerChildren5ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[5]childminding_type_id", employmentTemplate::setChildmindingNewcomerChildren5ChildmindingTypeId);
		setters.put("transportation_ind", employmentTemplate::setTransportationInd);
		setters.put("support_disability_ind", employmentTemplate::setSupportDisabilityInd);
		setters.put("translation_ind", employmentTemplate::setTranslationInd);
		setters.put("translation_language_from_id", employmentTemplate::setTranslationLanguagefromid);
		setters.put("translation_language_to_id", employmentTemplate::setTranslationLanguageToId);
		setters.put("interpretation_ind", employmentTemplate::setInterpretationInd);
		setters.put("interpretation_language_from_id", employmentTemplate::setInterpretationLanguagefromId);
		setters.put("interpretation_language_to_id", employmentTemplate::setInterpretationLanguageToId);
		setters.put("counselling_ind", employmentTemplate::setCounsellingInd);
		setters.put("complete_hours_spent_no", employmentTemplate::setCompleteHoursSpentNo);
		setters.put("complete_minutes_spent_no", employmentTemplate::setCompleteMinutesSpentno);
		setters.put("assessment_update_reason_id", employmentTemplate::setAssessmentUpdateReasonId);

		for (String column : row.keySet()) {
			if (setters.containsKey(column)) {
				setters.get(column).accept(row.get(column));
			} else {
				throw new IllegalArgumentException();
			}
		}

		employmentTemplate.setOrganization(organization);

		return employmentTemplate;
	}
}
