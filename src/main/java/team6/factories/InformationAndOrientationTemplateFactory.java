package team6.factories;

import java.util.HashMap;
import java.util.function.Consumer;

import team6.models.InformationAndOrientationTemplate;
import team6.models.Organization;
import team6.models.Template;

public class InformationAndOrientationTemplateFactory {
	public static Template build(HashMap<String, String> row, Organization organization) {
		InformationAndOrientationTemplate informationAndOrientationTemplate = new InformationAndOrientationTemplate();
		HashMap<String, Consumer<String>> setters = new HashMap<String, Consumer<String>>();

		setters.put("processing_details", informationAndOrientationTemplate::setProcessingDetails);
		setters.put("update_record_id", informationAndOrientationTemplate::setUpdateRecordId);
		setters.put("client_validation_type_id", informationAndOrientationTemplate::setClientValidationtypeId);
		setters.put("client_validation_id", informationAndOrientationTemplate::setClientValidationId);
		setters.put("client_birth_dt", informationAndOrientationTemplate::setClientBirthDt);
		setters.put("postal_cd", informationAndOrientationTemplate::setPostalCd);
		setters.put("start_dttm", informationAndOrientationTemplate::setStartDttm);
		setters.put("service_language_id", informationAndOrientationTemplate::setServiceLanguageId);
		setters.put("service_official_language_id", informationAndOrientationTemplate::setServiceOfficialLanguageId);
		setters.put("institution_type_id", informationAndOrientationTemplate::setInstitutiontypeId);
		setters.put("service_referred_by_id", informationAndOrientationTemplate::setServiceReferredByid);
		setters.put("orientation_service_id", informationAndOrientationTemplate::setOrientationServiceId);
		setters.put("orientation_length_id", informationAndOrientationTemplate::setOrientationLengthId);
		setters.put("orientation_length_hours_no", informationAndOrientationTemplate::setOrientationLengthHoursNo);
		setters.put("orientation_length_minutes_no", informationAndOrientationTemplate::setOrientationLengthMinutesNo);
		setters.put("group_clients_no_id", informationAndOrientationTemplate::setGroupClientsNoId);
		setters.put("target_group_specific_ind", informationAndOrientationTemplate::setTargetGroupSpecificInd);
		setters.put("target_group_children_ind", informationAndOrientationTemplate::setTargetGroupChildrenInd);
		setters.put("target_group_youth_ind", informationAndOrientationTemplate::setTargetGroupYouthInd);
		setters.put("target_group_senior_ind", informationAndOrientationTemplate::setTargetGroupSeniorInd);
		setters.put("target_group_gender_ind", informationAndOrientationTemplate::setTargetGroupGenderInd);
		setters.put("target_group_refugee_ind", informationAndOrientationTemplate::setTargetGroupRefugeeInd);
		setters.put("target_group_ethnic_ind", informationAndOrientationTemplate::setTargetGroupEthnicInd);
		setters.put("target_group_hearing_ind", informationAndOrientationTemplate::setTargetGroupHearingInd);
		setters.put("target_group_visual_ind", informationAndOrientationTemplate::setTargetGroupVisualInd);
		setters.put("target_group_LGBTQ_ind", informationAndOrientationTemplate::setTargetGroupLGBTQInd);
		setters.put("target_group_families_parents_ind", informationAndOrientationTemplate::setTargetGroupFamiliesParentsind);
		setters.put("target_group_other_impairments_ind", informationAndOrientationTemplate::setTargetGroupOtherImpairmentsInd);
		setters.put("target_group_CWIT_in_regulated_profession_ind", informationAndOrientationTemplate::setTargetGroupCWITInRegulatedProfessionInd);
		setters.put("target_group_CWIT_in_regulated_trade_ind", informationAndOrientationTemplate::setTargetgroupCWITInRegulatedTradeInd);
		setters.put("target_group_official_language_minorities_ind", informationAndOrientationTemplate::setTargetGroupOfficialLanguageMinoritiesInd);
		setters.put("topic_overview_given_ind", informationAndOrientationTemplate::setTopicOverviewGivenInd);
		setters.put("topic_overview_referral_ind", informationAndOrientationTemplate::setTopicOverviewReferralInd);
		setters.put("topic_information_given_ind", informationAndOrientationTemplate::setTopicInformationGivenInd);
		setters.put("topic_information_referral_ind", informationAndOrientationTemplate::setTopicInformationReferralInd);
		setters.put("topic_rights_given_ind", informationAndOrientationTemplate::setTopicRightsGivenInd);
		setters.put("topic_rights_referral_ind", informationAndOrientationTemplate::setTopicRightsReferralInd);
		setters.put("topic_law_given_ind", informationAndOrientationTemplate::setTopicLawGivenInd);
		setters.put("topic_law_referral_ind", informationAndOrientationTemplate::setTopicLawreferralInd);
		setters.put("topic_documents_given_ind", informationAndOrientationTemplate::setTopicDocumentsGivenInd);
		setters.put("topic_documents_referral_ind", informationAndOrientationTemplate::setTopicDocumentsReferralInd);
		setters.put("topic_language_given_ind", informationAndOrientationTemplate::setTopicLanguageGivenInd);
		setters.put("topic_language_referral_ind", informationAndOrientationTemplate::setTopicLanguageReferralInd);
		setters.put("topic_income_given_ind", informationAndOrientationTemplate::setTopicIncomeGivenInd);
		setters.put("topic_income_referral_ind", informationAndOrientationTemplate::setTopicIncomeReferralInd);
		setters.put("topic_education_given_ind", informationAndOrientationTemplate::setTopicEducationGivenInd);
		setters.put("topic_education_referral_ind", informationAndOrientationTemplate::setTopicEducationReferralInd);
		setters.put("topic_housing_given_ind", informationAndOrientationTemplate::setTopicHousingGivenInd);
		setters.put("topic_housing_referral_ind", informationAndOrientationTemplate::setTopicHousingReferralInd);
		setters.put("topic_health_given_ind", informationAndOrientationTemplate::setTopicHealthGivenInd);
		setters.put("topic_health_referral_ind", informationAndOrientationTemplate::setTopicHealthReferralInd);
		setters.put("topic_money_given_ind", informationAndOrientationTemplate::setTopicMoneyGivenInd);
		setters.put("topic_money_referral_ind", informationAndOrientationTemplate::setTopicMoneyReferralInd);
		setters.put("topic_transportation_given_ind", informationAndOrientationTemplate::setTopicTransportationGivenInd);
		setters.put("topic_transportation_referral_ind", informationAndOrientationTemplate::setTopicTransportationReferralInd);
		setters.put("topic_media_given_ind", informationAndOrientationTemplate::setTopicMediaGivenInd);
		setters.put("topic_media_referral_ind", informationAndOrientationTemplate::setTopicMediaReferralInd);
		setters.put("topic_community_given_ind", informationAndOrientationTemplate::setTopicCommunityGivenInd);
		setters.put("topic_community_referral_ind", informationAndOrientationTemplate::setTopicCommunityReferralInd);
		setters.put("topic_citizenship_given_ind", informationAndOrientationTemplate::setTopicCitizenshipGivenInd);
		setters.put("topic_citizenship_referral_ind", informationAndOrientationTemplate::setTopicCitizenshipReferralInd);
		setters.put("topic_conflict_given_ind", informationAndOrientationTemplate::setTopicConflictGivenInd);
		setters.put("topic_conflict_referral_ind", informationAndOrientationTemplate::setTopicConflictReferralInd);
		setters.put("training_received_service_ind", informationAndOrientationTemplate::setTrainingReceivedServiceInd);
		setters.put("training_received_computer_ind", informationAndOrientationTemplate::setTrainingReceivedComputerInd);
		setters.put("training_received_document_ind", informationAndOrientationTemplate::setTrainingReceivedDocumentInd);
		setters.put("training_received_interpersonal_ind", informationAndOrientationTemplate::setTrainingReceivedInterpersonalInd);
		setters.put("training_received_leadership_ind", informationAndOrientationTemplate::setTrainingReceivedLeadershipInd);
		setters.put("training_received_numeracy_ind", informationAndOrientationTemplate::setTrainingReceivedNumeracyInd);
		setters.put("skill_received_service_ind", informationAndOrientationTemplate::setSkillReceivedServiceInd);
		setters.put("essential_skill_life_ind", informationAndOrientationTemplate::setEssentialSkillLifeInd);
		setters.put("essential_skill_responsabilities_ind", informationAndOrientationTemplate::setEssentialSkillResponsabilitiesInd);
		setters.put("support_received_ind", informationAndOrientationTemplate::setSupportReceivedInd);
		setters.put("childminding_ind", informationAndOrientationTemplate::setChildmindingInd);
		setters.put("childminding_NewcomerChildren[1]childminding_age_id", informationAndOrientationTemplate::setChildmindingNewcomerChildren1ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[1]childminding_type_id", informationAndOrientationTemplate::setChildmindingNewcomerChildren1ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[2]childminding_age_id", informationAndOrientationTemplate::setChildmindingNewcomerChildren2ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[2]childminding_type_id", informationAndOrientationTemplate::setChildmindingNewcomerChildren2ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[3]childminding_age_id", informationAndOrientationTemplate::setChildmindingNewcomerChildren3ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[3]childminding_type_id", informationAndOrientationTemplate::setChildmindingNewcomerChildren3ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[4]childminding_age_id", informationAndOrientationTemplate::setChildmindingNewcomerChildren4ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[4]childminding_type_id", informationAndOrientationTemplate::setChildmindingNewcomerChildren4ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[5]childminding_age_id", informationAndOrientationTemplate::setChildmindingNewcomerChildren5ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[5]childminding_type_id", informationAndOrientationTemplate::setChildmindingNewcomerChildren5ChildmindingTypeId);
		setters.put("transportation_ind", informationAndOrientationTemplate::setTransportationInd);
		setters.put("support_disability_ind", informationAndOrientationTemplate::setSupportDisabilityInd);
		setters.put("translation_ind", informationAndOrientationTemplate::setTranslationInd);
		setters.put("translation_language_from_id", informationAndOrientationTemplate::setTranslationLanguageFromId);
		setters.put("translation_language_to_id", informationAndOrientationTemplate::setTranslationLanguageToId);
		setters.put("interpretation_ind", informationAndOrientationTemplate::setInterpretationInd);
		setters.put("interpretation_language_from_id", informationAndOrientationTemplate::setInterpretationLanguageFromId);
		setters.put("interpretation_language_to_id", informationAndOrientationTemplate::setInterpretationLanguageToId);
		setters.put("counselling_ind", informationAndOrientationTemplate::setCounsellingInd);
		setters.put("end_dttm", informationAndOrientationTemplate::setEndDttm);
		setters.put("assessment_update_reason_id", informationAndOrientationTemplate::setAssessmentUpdateReasonId);

		for (String column : row.keySet()) {
			if (setters.containsKey(column)) {
				setters.get(column).accept(row.get(column));
			} else {
				throw new IllegalArgumentException();
			}
		}

		informationAndOrientationTemplate.setOrganization(organization);

		return informationAndOrientationTemplate;
	}
}
