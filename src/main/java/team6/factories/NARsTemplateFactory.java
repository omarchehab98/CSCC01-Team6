package team6.factories;

import java.util.HashMap;
import java.util.function.Consumer;

import team6.models.NARsTemplate;
import team6.models.Organization;
import team6.models.Template;

public class NARsTemplateFactory {
	public static Template build(HashMap<String, String> row, Organization organization) {
		NARsTemplate narsTemplate = new NARsTemplate();
		HashMap<String, Consumer<String>> setters = new HashMap<String, Consumer<String>>();

		setters.put("processing_details", narsTemplate::setProcessingDetails);
		setters.put("update_record_id", narsTemplate::setUpdateRecordId);
		setters.put("client_validation_type_id", narsTemplate::setClientValidationTypeId);
		setters.put("client_validation_id", narsTemplate::setClientValidationId);
		setters.put("client_birth_dt", narsTemplate::setClientBirthDt);
		setters.put("postal_cd", narsTemplate::setPostalCd);
		setters.put("assessment_start_dt", narsTemplate::setAssessmentStartDt);
		setters.put("assessment_language_id", narsTemplate::setAssessmentLanguageId);
		setters.put("preferred_official_language_id", narsTemplate::setPreferredOfficialLanguageId);
		setters.put("institution_type_id", narsTemplate::setInstitutionTypeId);
		setters.put("assessment_referral_id", narsTemplate::setAssessmentReferralId);
		setters.put("knwl_life_needs_ind", narsTemplate::setKnwlLifeNeedsInd);
		setters.put("knwl_life_referrals_ind", narsTemplate::setKnwlLifeReferralsInd);
		setters.put("knwl_comm_gov_svcs_needs_ind", narsTemplate::setKnwlCommGovSvcsNeedsInd);
		setters.put("knwl_comm_gov_svcs_referrals_ind", narsTemplate::setKnwlCommGovSvcsReferralsInd);
		setters.put("knwl_working_needs_ind", narsTemplate::setKnwlWorkingNeedsInd);
		setters.put("knwl_working_referrals_ind", narsTemplate::setKnwlWorkingReferralsInd);
		setters.put("knwl_education_needs_ind", narsTemplate::setKnwlEducationNeedsInd);
		setters.put("knwl_education_needs_referrals_ind", narsTemplate::setKnwlEducationNeedsReferralsInd);
		setters.put("social_networks_needs_ind", narsTemplate::setSocialNetworksNeedsInd);
		setters.put("social_networks_referrals_ind", narsTemplate::setSocialNetworksReferralsInd);
		setters.put("professional_networks_needs_ind", narsTemplate::setProfessionalNetworksNeedsInd);
		setters.put("professional_networks_referrals_ind", narsTemplate::setProfessionalNetworksReferralsInd);
		setters.put("local_community_svcs_needs_ind", narsTemplate::setLocalCommunitySvcsNeedsInd);
		setters.put("local_community_svcs_referrals_ind", narsTemplate::setLocalCommunitySvcsReferralsInd);
		setters.put("community_involvement_needs_ind", narsTemplate::setCommunityInvolvementNeedsInd);
		setters.put("community_involvement_referrals_ind", narsTemplate::setCommunityInvolvementReferralsInd);
		setters.put("language_skills_needs_ind", narsTemplate::setLanguageSkillsNeedsInd);
		setters.put("language_skills_referrals_ind", narsTemplate::setLanguageSkillsReferralsInd);
		setters.put("language_skills_needs_reason_id", narsTemplate::setLanguageSkillsNeedsReasonId);
		setters.put("other_skills_needs_ind", narsTemplate::setOtherSkillsNeedsInd);
		setters.put("other_skills_referrals_ind", narsTemplate::setOtherSkillsReferralsInd);
		setters.put("other_skills_needs_reason_id", narsTemplate::setOtherSkillsNeedsReasonId);
		setters.put("find_employment_needs_ind", narsTemplate::setFindEmploymentNeedsInd);
		setters.put("find_employment_referrals_ind", narsTemplate::setFindEmploymentReferralsInd);
		setters.put("find_employment_period_id", narsTemplate::setFindEmploymentPeriodId);
		setters.put("canadian_employment_experience_id", narsTemplate::setCanadianEmploymentExperienceId);
		setters.put("intended_work_noc_group_id", narsTemplate::setIntendedWorkNocGroupId);
		setters.put("intention_credentials_licence_ind", narsTemplate::setIntentionCredentialsLicenceInd);
		setters.put("intention_canadian_citizen_ind", narsTemplate::setIntentionCanadianCitizenInd);
		setters.put("support_required_services_required", narsTemplate::setSupportRequiredServicesRequired);
		setters.put("childminding_required_ind", narsTemplate::setChildmindingRequiredInd);
		setters.put("transportation_required_ind", narsTemplate::setTransportationRequiredInd);
		setters.put("support_disability_required_ind", narsTemplate::setSupportDisabilityRequiredInd);
		setters.put("translation_required_ind", narsTemplate::setTranslationRequiredInd);
		setters.put("interpretation_required_ind", narsTemplate::setInterpretationRequiredInd);
		setters.put("counselling_required_ind", narsTemplate::setCounsellingRequiredInd);
		setters.put("non_cic_program_needs_services_required", narsTemplate::setNonCicProgramNeedsServicesRequired);
		setters.put("food_cloth_material_needs_ind", narsTemplate::setFoodClothMaterialNeedsInd);
		setters.put("food_cloth_material_refs_ind", narsTemplate::setFoodClothMaterialRefsInd);
		setters.put("housing_accommodation_needs_ind", narsTemplate::setHousingAccommodationNeedsInd);
		setters.put("housing_accommodation_referrals_ind", narsTemplate::setHousingAccommodationReferralsInd);
		setters.put("hlth_mental_wellness_needs_ind", narsTemplate::setHlthMentalWellnessNeedsInd);
		setters.put("hlth_mental_wellness_refs_ind", narsTemplate::setHlthMentalWellnessRefsInd);
		setters.put("financial_needs_ind", narsTemplate::setFinancialNeedsInd);
		setters.put("financial_referrals_ind", narsTemplate::setFinancialReferralsInd);
		setters.put("family_support_needs_ind", narsTemplate::setFamilySupportNeedsInd);
		setters.put("family_support_referrals_ind", narsTemplate::setFamilySupportReferralsInd);
		setters.put("language_non_CIC_needs_ind", narsTemplate::setLanguageNonCICNeedsInd);
		setters.put("language_non_CIC_referrals_ind", narsTemplate::setLanguageNonCICReferralsInd);
		setters.put("edu_skills_devt_needs_ind", narsTemplate::setEduSkillsDevtNeedsInd);
		setters.put("edu_skills_devt_referrals_ind", narsTemplate::setEduSkillsDevtReferralsInd);
		setters.put("employment_related_needs_ind", narsTemplate::setEmploymentRelatedNeedsInd);
		setters.put("employment_related_referrals_ind", narsTemplate::setEmploymentRelatedReferralsInd);
		setters.put("legal_info_services_needs_ind", narsTemplate::setLegalInfoServicesNeedsInd);
		setters.put("legal_info_services_referrals_ind", narsTemplate::setLegalInfoServicesReferralsInd);
		setters.put("community_services_needs_ind", narsTemplate::setCommunityServicesNeedsInd);
		setters.put("community_services_referrals_ind", narsTemplate::setCommunityServicesReferralsInd);
		setters.put("support_received_ind", narsTemplate::setSupportReceivedInd);
		setters.put("childminding_ind", narsTemplate::setChildmindingInd);
		setters.put("childminding_NewcomerChildren[1]childminding_age_id",
				narsTemplate::setChildmindingNewcomerChildren1ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[1]childminding_type_id",
				narsTemplate::setChildmindingNewcomerChildren1ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[2]childminding_age_id",
				narsTemplate::setChildmindingNewcomerChildren2ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[2]childminding_type_id",
				narsTemplate::setChildmindingNewcomerChildren2ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[3]childminding_age_id",
				narsTemplate::setChildmindingNewcomerChildren3ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[3]childminding_type_id",
				narsTemplate::setChildmindingNewcomerChildren3ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[4]childminding_age_id",
				narsTemplate::setChildmindingNewcomerChildren4ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[4]childminding_type_id",
				narsTemplate::setChildmindingNewcomerChildren4ChildmindingTypeId);
		setters.put("childminding_NewcomerChildren[5]childminding_age_id",
				narsTemplate::setChildmindingNewcomerChildren5ChildmindingAgeId);
		setters.put("childminding_NewcomerChildren[5]childminding_type_id",
				narsTemplate::setChildmindingNewcomerChildren5ChildmindingTypeId);
		setters.put("transportation_ind", narsTemplate::setTransportationInd);
		setters.put("support_disability_ind", narsTemplate::setSupportDisabilityInd);
		setters.put("translation_ind", narsTemplate::setTranslationInd);
		setters.put("translation_language_from_id", narsTemplate::setTranslationLanguageFromId);
		setters.put("translation_language_to_id", narsTemplate::setTranslationLanguageToId);
		setters.put("interpretation_ind", narsTemplate::setInterpretationInd);
		setters.put("interpretation_language_from_id", narsTemplate::setInterpretationLanguageFromId);
		setters.put("interpretation_language_to_id", narsTemplate::setInterpretationLanguageToId);
		setters.put("counselling_ind", narsTemplate::setCounsellingInd);
		setters.put("settlement_plan_ind", narsTemplate::setSettlementPlanInd);
		setters.put("assessment_completed_dt", narsTemplate::setAssessmentCompletedDt);
		setters.put("assessment_update_reason_id", narsTemplate::setAssessmentUpdateReasonId);

		for (String column : row.keySet()) {
			if (setters.containsKey(column)) {
				setters.get(column).accept(row.get(column));
			} else {
				throw new IllegalArgumentException();
			}
		}

		narsTemplate.setOrganization(organization);

		return narsTemplate;
	}

}
