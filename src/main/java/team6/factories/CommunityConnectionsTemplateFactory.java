package team6.factories;

import java.util.HashMap;
import java.util.function.Consumer;

import team6.models.CommunityConnectionsTemplate;
import team6.models.Organization;
import team6.models.Template;

public class CommunityConnectionsTemplateFactory {
	public static Template build(HashMap<String, String> row, Organization organization) {
		CommunityConnectionsTemplate communityConnectionsTemplate = new CommunityConnectionsTemplate();
		HashMap<String, Consumer<String>> setters = new HashMap<String, Consumer<String>>();

		setters.put("processing_details", communityConnectionsTemplate::setProcessingDetails);
		setters.put("update_record_id", communityConnectionsTemplate::setUpdateRecordId);
		setters.put("client_validation_type_id", communityConnectionsTemplate::setClientValidationTypeId);
		setters.put("client_validation_id", communityConnectionsTemplate::setClientValidationId);
		setters.put("client_birth_dt", communityConnectionsTemplate::setClientBirthDt);
		setters.put("postal_cd", communityConnectionsTemplate::setPostalCd);
		setters.put("service_lang_id", communityConnectionsTemplate::setServiceLangId);
		setters.put("preferred_official_lang_id", communityConnectionsTemplate::setPreferredOfficialLangId);
		setters.put("assessment_referral_id", communityConnectionsTemplate::setAssessmentReferralId);
		setters.put("community_activity_id", communityConnectionsTemplate::setCommunityActivityId);
		setters.put("institution_type_id", communityConnectionsTemplate::setInstitutionTypeId);
		setters.put("events_type_attended_id", communityConnectionsTemplate::setEventsTypeAttendedId);
		setters.put("service_type_id", communityConnectionsTemplate::setServiceTypeId);
		setters.put("topics_service_id", communityConnectionsTemplate::setTopicsServiceId);
		setters.put("community_service_id", communityConnectionsTemplate::setCommunityServiceId);
		setters.put("group_clients_no_id", communityConnectionsTemplate::setGroupClientsNoId);
		setters.put("volunteers_participate_ind", communityConnectionsTemplate::setVolunteersParticipateInd);
		setters.put("target_group_specific_ind", communityConnectionsTemplate::setTargetGroupSpecificInd);
		setters.put("target_group_children_ind", communityConnectionsTemplate::setTargetGroupChildrenInd);
		setters.put("target_group_youth_ind", communityConnectionsTemplate::setTargetGroupYouthInd);
		setters.put("target_group_senior_ind", communityConnectionsTemplate::setTargetGroupSeniorInd);
		setters.put("target_group_gender_ind", communityConnectionsTemplate::setTargetGroupGenderInd);
		setters.put("target_group_refugee_ind", communityConnectionsTemplate::setTargetGroupRefugeeInd);
		setters.put("target_group_ethnic_ind", communityConnectionsTemplate::setTargetGroupEthnicInd);
		setters.put("target_group_hearing_ind", communityConnectionsTemplate::setTargetGroupHearingInd);
		setters.put("target_group_visual_ind", communityConnectionsTemplate::setTargetGroupVisualInd);
		setters.put("target_group_LGBTQ_ind", communityConnectionsTemplate::setTargetGroupLGBTQInd);
		setters.put("target_group_families_parents_ind", communityConnectionsTemplate::setTargetGroupFamiliesParentsInd);
		setters.put("target_group_other_impairments_ind", communityConnectionsTemplate::setTargetGroupOtherImpairmentsInd);
		setters.put("target_group_CWIT_in_regulated_profession_ind", communityConnectionsTemplate::setTargetGroupCWITInRegulatedProfessionInd);
		setters.put("target_group_CWIT_in_regulated_trade_ind", communityConnectionsTemplate::setTargetGroupCWITInRegulatedTradeInd);
		setters.put("target_group_official_language_minorities_ind", communityConnectionsTemplate::setTargetGroupOfficialLanguageMinoritiesInd);
		setters.put("service_status_id", communityConnectionsTemplate::setServiceStatusId);
		setters.put("community_leave_reason_id", communityConnectionsTemplate::setCommunityLeaveReasonId);
		setters.put("service_start_dt", communityConnectionsTemplate::setServiceStartDt);
		setters.put("service_end_dt", communityConnectionsTemplate::setServiceEndDt);
		setters.put("service_projected_end_dt", communityConnectionsTemplate::setServiceProjectedEndDt);
		setters.put("training_received_service_ind", communityConnectionsTemplate::setTrainingReceivedServiceInd);
		setters.put("training_received_computer_ind", communityConnectionsTemplate::setTrainingReceivedComputerInd);
		setters.put("training_received_document_ind", communityConnectionsTemplate::setTrainingReceivedDocumentInd);
		setters.put("training_received_interpersonal_ind", communityConnectionsTemplate::setTrainingReceivedInterpersonalInd);
		setters.put("training_received_leadership_ind", communityConnectionsTemplate::setTrainingReceivedLeadershipInd);
		setters.put("training_received_life_skills_ind", communityConnectionsTemplate::setTrainingReceivedLifeSkillsInd);
		setters.put("training_received_numeracy_ind", communityConnectionsTemplate::setTrainingReceivedNumeracyInd);
		setters.put("support_received_ind", communityConnectionsTemplate::setSupportReceivedInd);
		setters.put("childminding_ind", communityConnectionsTemplate::setChildmindingInd);
		setters.put("childminding_NewcomerChildren[1]childminding_age_id", communityConnectionsTemplate::setChildmindingNewcomerChildren1ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[1]childminding_type_id", communityConnectionsTemplate::setChildmindingNewcomerChildren1ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[2]childminding_age_id", communityConnectionsTemplate::setChildmindingNewcomerChildren2ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[2]childminding_type_id", communityConnectionsTemplate::setChildmindingNewcomerChildren2ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[3]childminding_age_id", communityConnectionsTemplate::setChildmindingNewcomerChildren3ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[3]childminding_type_id", communityConnectionsTemplate::setChildmindingNewcomerChildren3ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[4]childminding_age_id", communityConnectionsTemplate::setChildmindingNewcomerChildren4ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[4]childminding_type_id", communityConnectionsTemplate::setChildmindingNewcomerChildren4ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[5]childminding_age_id", communityConnectionsTemplate::setChildmindingNewcomerChildren5ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[5]childminding_type_id", communityConnectionsTemplate::setChildmindingNewcomerChildren5ChildmindingTypeId);
		setters.put("transportation_ind", communityConnectionsTemplate::setTransportationInd);
		setters.put("support_disability_ind", communityConnectionsTemplate::setSupportDisabilityInd);
		setters.put("translation_ind", communityConnectionsTemplate::setTranslationInd);
		setters.put("translation_language_from_id", communityConnectionsTemplate::setTranslationLAndLanguageFromId);
		setters.put("translation_language_to_id", communityConnectionsTemplate::setTranslationLanguageToId);
		setters.put("interpretation_ind", communityConnectionsTemplate::setInterpretationInd);
		setters.put("interpretation_language_from_id", communityConnectionsTemplate::setInterpretationLanguageFromId);
		setters.put("interpretation_language_to_id", communityConnectionsTemplate::setInterpretationLanguageToId);
		setters.put("counselling_ind", communityConnectionsTemplate::setCounsellingInd);
		setters.put("service_length_hours_no", communityConnectionsTemplate::setServiceLengthHoursNo);
		setters.put("service_length_minutes_no", communityConnectionsTemplate::setServiceLengthMinutesNo);
		setters.put("assessment_update_reason_id", communityConnectionsTemplate::setAssessmentUpdateReasonId);

		for (String column : row.keySet()) {
			if (setters.containsKey(column)) {
				setters.get(column).accept(row.get(column));
			} else {
				throw new IllegalArgumentException();
			}
		}

		communityConnectionsTemplate.setOrganization(organization);

		return communityConnectionsTemplate;
	}
}
