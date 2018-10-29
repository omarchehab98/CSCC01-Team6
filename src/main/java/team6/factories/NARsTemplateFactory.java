package team6.factories;

import java.util.HashMap;
import java.util.function.Consumer;

import team6.models.TemplateInterface;
import team6.models.NARsTemplate;

public class NARsTemplateFactory implements TemplateFactory {

	private static HashMap<String, Consumer<String>> NARsSetters;
	private static NARsTemplate template;
	private static NARsTemplateFactory instance;

	private NARsTemplateFactory() {}

	private static NARsTemplate populateSetters() {
		NARsSetters = new HashMap<String, Consumer<String>>();
		template = new NARsTemplate();
		// Add the setters
		NARsSetters.put("processing_details", template::setProcessingDetails);
		NARsSetters.put("update_record_id", template::setUpdateRecordId);
		NARsSetters.put("client_validation_type_id", template::setClientValidationTypeId);
		NARsSetters.put("client_validation_id", template::setClientValidationId);
		NARsSetters.put("client_birth_dt", template::setClientBirthDt);
		NARsSetters.put("postal_cd", template::setPostalCd);
		NARsSetters.put("assessment_start_dt", template::setAssessmentStartDt);
		NARsSetters.put("assessment_language_id", template::setAssessmentLanguageId);
		NARsSetters.put("preferred_official_language_id", template::setPreferredOfficialLanguageId);
		NARsSetters.put("institution_type_id", template::setInstitutionTypeId);
		NARsSetters.put("assessment_referral_id", template::setAssessmentReferralId);
		NARsSetters.put("knwl_life_needs_ind", template::setKnwlLifeNeedsInd);
		NARsSetters.put("knwl_life_referrals_ind", template::setKnwlLifeReferralsInd);
		NARsSetters.put("knwl_comm_gov_svcs_needs_ind", template::setKnwlCommGovSvcsNeedsInd);
		NARsSetters.put("knwl_comm_gov_svcs_referrals_ind", template::setKnwlCommGovSvcsReferralsInd);
		NARsSetters.put("knwl_working_needs_ind", template::setKnwlWorkingNeedsInd);
		NARsSetters.put("knwl_working_referrals_ind", template::setKnwlWorkingReferralsInd);
		NARsSetters.put("knwl_education_needs_ind", template::setKnwlEducationNeedsInd);
		NARsSetters.put("knwl_education_needs_referrals_ind", template::setKnwlEducationNeedsReferralsInd);
		NARsSetters.put("social_networks_needs_ind", template::setSocialNetworksNeedsInd);
		NARsSetters.put("social_networks_referrals_ind", template::setSocialNetworksReferralsInd);
		NARsSetters.put("professional_networks_needs_ind", template::setProfessionalNetworksNeedsInd);
		NARsSetters.put("professional_networks_referrals_ind", template::setProfessionalNetworksReferralsInd);
		NARsSetters.put("local_community_svcs_needs_ind", template::setLocalCommunitySvcsNeedsInd);
		NARsSetters.put("local_community_svcs_referrals_ind", template::setLocalCommunitySvcsReferralsInd);
		NARsSetters.put("community_involvement_needs_ind", template::setCommunityInvolvementNeedsInd);
		NARsSetters.put("community_involvement_referrals_ind", template::setCommunityInvolvementReferralsInd);
		NARsSetters.put("language_skills_needs_ind", template::setLanguageSkillsNeedsInd);
		NARsSetters.put("language_skills_referrals_ind", template::setLanguageSkillsReferralsInd);
		NARsSetters.put("language_skills_needs_reason_id", template::setLanguageSkillsNeedsReasonId);
		NARsSetters.put("other_skills_needs_ind", template::setOtherSkillsNeedsInd);
		NARsSetters.put("other_skills_referrals_ind", template::setOtherSkillsReferralsInd);
		NARsSetters.put("other_skills_needs_reason_id", template::setOtherSkillsNeedsReasonId);
		NARsSetters.put("find_employment_needs_ind", template::setFindEmploymentNeedsInd);
		NARsSetters.put("find_employment_referrals_ind", template::setFindEmploymentReferralsInd);
		NARsSetters.put("find_employment_period_id", template::setFindEmploymentPeriodId);
		NARsSetters.put("canadian_employment_experience_id", template::setCanadianEmploymentExperienceId);
		NARsSetters.put("intended_work_noc_group_id", template::setIntendedWorkNocGroupId);
		NARsSetters.put("intention_credentials_licence_ind", template::setIntentionCredentialsLicenceInd);
		NARsSetters.put("intention_canadian_citizen_ind", template::setIntentionCanadianCitizenInd);
		NARsSetters.put("support_required_services_required", template::setSupportRequiredServicesRequired);
		NARsSetters.put("childminding_required_ind", template::setChildmindingRequiredInd);
		NARsSetters.put("transportation_required_ind", template::setTransportationRequiredInd);
		NARsSetters.put("support_disability_required_ind", template::setSupportDisabilityRequiredInd);
		NARsSetters.put("translation_required_ind", template::setTranslationRequiredInd);
		NARsSetters.put("interpretation_required_ind", template::setInterpretationRequiredInd);
		NARsSetters.put("counselling_required_ind", template::setCounsellingRequiredInd);
		NARsSetters.put("non_cic_program_needs_services_required", template::setNonCicProgramNeedsServicesRequired);
		NARsSetters.put("food_cloth_material_needs_ind", template::setFoodClothMaterialNeedsInd);
		NARsSetters.put("food_cloth_material_refs_ind", template::setFoodClothMaterialRefsInd);
		NARsSetters.put("housing_accommodation_needs_ind", template::setHousingAccommodationNeedsInd);
		NARsSetters.put("housing_accommodation_referrals_ind", template::setHousingAccommodationReferralsInd);
		NARsSetters.put("hlth_mental_wellness_needs_ind", template::setHlthMentalWellnessNeedsInd);
		NARsSetters.put("hlth_mental_wellness_refs_ind", template::setHlthMentalWellnessRefsInd);
		NARsSetters.put("financial_needs_ind", template::setFinancialNeedsInd);
		NARsSetters.put("financial_referrals_ind", template::setFinancialReferralsInd);
		NARsSetters.put("family_support_needs_ind", template::setFamilySupportNeedsInd);
		NARsSetters.put("family_support_referrals_ind", template::setFamilySupportReferralsInd);
		NARsSetters.put("language_non_CIC_needs_ind", template::setLanguageNonCICNeedsInd);
		NARsSetters.put("language_non_CIC_referrals_ind", template::setLanguageNonCICReferralsInd);
		NARsSetters.put("edu_skills_devt_needs_ind", template::setEduSkillsDevtNeedsInd);
		NARsSetters.put("edu_skills_devt_referrals_ind", template::setEduSkillsDevtReferralsInd);
		NARsSetters.put("employment_related_needs_ind", template::setEmploymentRelatedNeedsInd);
		NARsSetters.put("employment_related_referrals_ind", template::setEmploymentRelatedReferralsInd);
		NARsSetters.put("legal_info_services_needs_ind", template::setLegalInfoServicesNeedsInd);
		NARsSetters.put("legal_info_services_referrals_ind", template::setLegalInfoServicesReferralsInd);
		NARsSetters.put("community_services_needs_ind", template::setCommunityServicesNeedsInd);
		NARsSetters.put("community_services_referrals_ind", template::setCommunityServicesReferralsInd);
		NARsSetters.put("support_received_ind", template::setSupportReceivedInd);
		NARsSetters.put("childminding_ind", template::setChildmindingInd);
		NARsSetters.put("childminding_NewcomerChildren[1]childminding_age_id", template::setChildmindingNewcomerChildren1ChildmindingAgeId);
		NARsSetters.put("childminding_NewcomerChildren[1]childminding_type_id", template::setChildmindingNewcomerChildren1ChildmindingTypeId);
		NARsSetters.put("childminding_NewcomerChildren[2]childminding_age_id", template::setChildmindingNewcomerChildren2ChildmindingAgeId);
		NARsSetters.put("childminding_NewcomerChildren[2]childminding_type_id", template::setChildmindingNewcomerChildren2ChildmindingTypeId);
		NARsSetters.put("childminding_NewcomerChildren[3]childminding_age_id", template::setChildmindingNewcomerChildren3ChildmindingAgeId);
		NARsSetters.put("childminding_NewcomerChildren[3]childminding_type_id", template::setChildmindingNewcomerChildren3ChildmindingTypeId);
		NARsSetters.put("childminding_NewcomerChildren[4]childminding_age_id", template::setChildmindingNewcomerChildren4ChildmindingAgeId);
		NARsSetters.put("childminding_NewcomerChildren[4]childminding_type_id", template::setChildmindingNewcomerChildren4ChildmindingTypeId);
		NARsSetters.put("childminding_NewcomerChildren[5]childminding_age_id", template::setChildmindingNewcomerChildren5ChildmindingAgeId);
		NARsSetters.put("childminding_NewcomerChildren[5]childminding_type_id", template::setChildmindingNewcomerChildren5ChildmindingTypeId);
		NARsSetters.put("transportation_ind", template::setTransportationInd);
		NARsSetters.put("support_disability_ind", template::setSupportDisabilityInd);
		NARsSetters.put("translation_ind", template::setTranslationInd);
		NARsSetters.put("translation_language_from_id", template::setTranslationLanguageFromId);
		NARsSetters.put("translation_language_to_id", template::setTranslationLanguageToId);
		NARsSetters.put("interpretation_ind", template::setInterpretationInd);
		NARsSetters.put("interpretation_language_from_id", template::setInterpretationLanguageFromId);
		NARsSetters.put("interpretation_language_to_id", template::setInterpretationLanguageToId);
		NARsSetters.put("counselling_ind", template::setCounsellingInd);
		NARsSetters.put("settlement_plan_ind", template::setSettlementPlanInd);
		NARsSetters.put("assessment_completed_dt", template::setAssessmentCompletedDt);
		NARsSetters.put("assessment_update_reason_id", template::setAssessmentUpdateReasonId);
		
		return template;
	}

	public static NARsTemplateFactory getInstance() {
		if (instance == null) {
			return new NARsTemplateFactory();
		}
		return instance;
	}

	public static TemplateInterface build(HashMap<String, String> row) {
		if (template != null) {
			template = null;
			@SuppressWarnings("unused")
			NARsTemplate template = populateSetters();
		} else {
			@SuppressWarnings("unused")
			NARsTemplate template = populateSetters();
		}
		
		for (String column : row.keySet()) {
			if (NARsSetters.containsKey(column)) { 
				NARsSetters.get(column).accept(row.get(column)); 
			} else {
				throw new IllegalArgumentException();
			}
		}
		return template;
	}

}
