package team6.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NARsTemplate implements TemplateInterface {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String processingDetails;
    private String updateRecordId;
    private String clientValidationTypeId;
    private String clientValidationId;
    private String clientBirthDt;
    private String postalCd;
    private String assessmentStartDt;
    private String assessmentLanguageId;
    private String preferredOfficialLanguageId;
    private String institutionTypeId;
    private String assessmentReferralId;
    private String knwlLifeNeedsInd;
    private String knwlLifeReferralsInd;
    private String knwlCommGovSvcsNeedsInd;
    private String knwlCommGovSvcsReferralsInd;
    private String knwlWorkingNeedsInd;
    private String knwlWorkingReferralsInd;
    private String knwlEducationNeedsInd;
    private String knwlEducationNeedsReferralsInd;
    private String socialNetworksNeedsInd;
    private String socialNetworksReferralsInd;
    private String professionalNetworksNeedsInd;
    private String professionalNetworksReferralsInd;
    private String localCommunitySvcsNeedsInd;
    private String localCommunitySvcsReferralsInd;
    private String communityInvolvementNeedsInd;
    private String communityInvolvementReferralsInd;
    private String languageSkillsNeedsInd;
    private String languageSkillsReferralsInd;
    private String languageSkillsNeedsReasonId;
    private String otherSkillsNeedsInd;
    private String otherSkillsReferralsInd;
    private String otherSkillsNeedsReasonId;
    private String findEmploymentNeedsInd;
    private String findEmploymentReferralsInd;
    private String findEmploymentPeriodId;
    private String canadianEmploymentExperienceId;
    private String intendedWorkNocGroupId;
    private String intentionCredentialsLicenceInd;
    private String intentionCanadianCitizenInd;
    private String supportRequiredServicesRequired;
    private String childmindingRequiredInd;
    private String transportationRequiredInd;
    private String supportDisabilityRequiredInd;
    private String translationRequiredInd;
    private String interpretationRequiredInd;
    private String counsellingRequiredInd;
    private String nonCicProgramNeedsServicesRequired;
    private String foodClothMaterialNeedsInd;
    private String foodClothMaterialRefsInd;
    private String housingAccommodationNeedsInd;
    private String housingAccommodationReferralsInd;
    private String hlthMentalWellnessNeedsInd;
    private String hlthMentalWellnessRefsInd;
    private String financialNeedsInd;
    private String financialReferralsInd;
    private String familySupportNeedsInd;
    private String familySupportReferralsInd;
    private String languageNonCICNeedsInd;
    private String languageNonCICReferralsInd;
    private String eduSkillsDevtNeedsInd;
    private String eduSkillsDevtReferralsInd;
    private String employmentRelatedNeedsInd;
    private String employmentRelatedReferralsInd;
    private String legalInfoServicesNeedsInd;
    private String legalInfoServicesReferralsInd;
    private String communityServicesNeedsInd;
    private String communityServicesReferralsInd;
    private String supportReceivedInd;
    private String childmindingInd;
    private String childmindingNewcomerChildren1ChildmindingAgeId;
    private String childmindingNewcomerChildren1ChildmindingTypeId;
    private String childmindingNewcomerChildren2ChildmindingAgeId;
    private String childmindingNewcomerChildren2ChildmindingTypeId;
    private String childmindingNewcomerChildren3ChildmindingAgeId;
    private String childmindingNewcomerChildren3ChildmindingTypeId;
    private String childmindingNewcomerChildren4ChildmindingAgeId;
    private String childmindingNewcomerChildren4ChildmindingTypeId;
    private String childmindingNewcomerChildren5ChildmindingAgeId;
    private String childmindingNewcomerChildren5ChildmindingTypeId;
    private String transportationInd;
    private String supportDisabilityInd;
    private String translationInd;
    private String translationLanguageFromId;
    private String translationLanguageToId;
    private String interpretationInd;
    private String interpretationLanguageFromId;
    private String interpretationLanguageToId;
    private String counsellingInd;
    private String settlementPlanInd;
    private String assessmentCompletedDt;
    private String assessmentUpdateReasonId;

    public NARsTemplate() {
    }

    public String getProcessingDetails() {
        return this.processingDetails;
    }

    public void setProcessingDetails(String processingDetails) {
        this.processingDetails = processingDetails;
    }

    public String getUpdateRecordId() {
        return this.updateRecordId;
    }

    public void setUpdateRecordId(String updateRecordId) {
        this.updateRecordId = updateRecordId;
    }

    public String getClientValidationTypeId() {
        return this.clientValidationTypeId;
    }

    public void setClientValidationTypeId(String clientValidationTypeId) {
        this.clientValidationTypeId = clientValidationTypeId;
    }

    public String getClientValidationId() {
        return this.clientValidationId;
    }

    public void setClientValidationId(String clientValidationId) {
        this.clientValidationId = clientValidationId;
    }

    public String getClientBirthDt() {
        return this.clientBirthDt;
    }

    public void setClientBirthDt(String clientBirthDt) {
        this.clientBirthDt = clientBirthDt;
    }

    public String getPostalCd() {
        return this.postalCd;
    }

    public void setPostalCd(String postalCd) {
        this.postalCd = postalCd;
    }

    public String getAssessmentStartDt() {
        return this.assessmentStartDt;
    }

    public void setAssessmentStartDt(String assessmentStartDt) {
        this.assessmentStartDt = assessmentStartDt;
    }

    public String getAssessmentLanguageId() {
        return this.assessmentLanguageId;
    }

    public void setAssessmentLanguageId(String assessmentLanguageId) {
        this.assessmentLanguageId = assessmentLanguageId;
    }

    public String getPreferredOfficialLanguageId() {
        return this.preferredOfficialLanguageId;
    }

    public void setPreferredOfficialLanguageId(String preferredOfficialLanguageId) {
        this.preferredOfficialLanguageId = preferredOfficialLanguageId;
    }

    public String getInstitutionTypeId() {
        return this.institutionTypeId;
    }

    public void setInstitutionTypeId(String institutionTypeId) {
        this.institutionTypeId = institutionTypeId;
    }

    public String getAssessmentReferralId() {
        return this.assessmentReferralId;
    }

    public void setAssessmentReferralId(String assessmentReferralId) {
        this.assessmentReferralId = assessmentReferralId;
    }

    public String getKnwlLifeNeedsInd() {
        return this.knwlLifeNeedsInd;
    }

    public void setKnwlLifeNeedsInd(String knwlLifeNeedsInd) {
        this.knwlLifeNeedsInd = knwlLifeNeedsInd;
    }

    public String getKnwlLifeReferralsInd() {
        return this.knwlLifeReferralsInd;
    }

    public void setKnwlLifeReferralsInd(String knwlLifeReferralsInd) {
        this.knwlLifeReferralsInd = knwlLifeReferralsInd;
    }

    public String getKnwlCommGovSvcsNeedsInd() {
        return this.knwlCommGovSvcsNeedsInd;
    }

    public void setKnwlCommGovSvcsNeedsInd(String knwlCommGovSvcsNeedsInd) {
        this.knwlCommGovSvcsNeedsInd = knwlCommGovSvcsNeedsInd;
    }

    public String getKnwlCommGovSvcsReferralsInd() {
        return this.knwlCommGovSvcsReferralsInd;
    }

    public void setKnwlCommGovSvcsReferralsInd(String knwlCommGovSvcsReferralsInd) {
        this.knwlCommGovSvcsReferralsInd = knwlCommGovSvcsReferralsInd;
    }

    public String getKnwlWorkingNeedsInd() {
        return this.knwlWorkingNeedsInd;
    }

    public void setKnwlWorkingNeedsInd(String knwlWorkingNeedsInd) {
        this.knwlWorkingNeedsInd = knwlWorkingNeedsInd;
    }

    public String getKnwlWorkingReferralsInd() {
        return this.knwlWorkingReferralsInd;
    }

    public void setKnwlWorkingReferralsInd(String knwlWorkingReferralsInd) {
        this.knwlWorkingReferralsInd = knwlWorkingReferralsInd;
    }

    public String getKnwlEducationNeedsInd() {
        return this.knwlEducationNeedsInd;
    }

    public void setKnwlEducationNeedsInd(String knwlEducationNeedsInd) {
        this.knwlEducationNeedsInd = knwlEducationNeedsInd;
    }

    public String getKnwlEducationNeedsReferralsInd() {
        return this.knwlEducationNeedsReferralsInd;
    }

    public void setKnwlEducationNeedsReferralsInd(String knwlEducationNeedsReferralsInd) {
        this.knwlEducationNeedsReferralsInd = knwlEducationNeedsReferralsInd;
    }

    public String getSocialNetworksNeedsInd() {
        return this.socialNetworksNeedsInd;
    }

    public void setSocialNetworksNeedsInd(String socialNetworksNeedsInd) {
        this.socialNetworksNeedsInd = socialNetworksNeedsInd;
    }

    public String getSocialNetworksReferralsInd() {
        return this.socialNetworksReferralsInd;
    }

    public void setSocialNetworksReferralsInd(String socialNetworksReferralsInd) {
        this.socialNetworksReferralsInd = socialNetworksReferralsInd;
    }

    public String getProfessionalNetworksNeedsInd() {
        return this.professionalNetworksNeedsInd;
    }

    public void setProfessionalNetworksNeedsInd(String professionalNetworksNeedsInd) {
        this.professionalNetworksNeedsInd = professionalNetworksNeedsInd;
    }

    public String getProfessionalNetworksReferralsInd() {
        return this.professionalNetworksReferralsInd;
    }

    public void setProfessionalNetworksReferralsInd(String professionalNetworksReferralsInd) {
        this.professionalNetworksReferralsInd = professionalNetworksReferralsInd;
    }

    public String getLocalCommunitySvcsNeedsInd() {
        return this.localCommunitySvcsNeedsInd;
    }

    public void setLocalCommunitySvcsNeedsInd(String localCommunitySvcsNeedsInd) {
        this.localCommunitySvcsNeedsInd = localCommunitySvcsNeedsInd;
    }

    public String getLocalCommunitySvcsReferralsInd() {
        return this.localCommunitySvcsReferralsInd;
    }

    public void setLocalCommunitySvcsReferralsInd(String localCommunitySvcsReferralsInd) {
        this.localCommunitySvcsReferralsInd = localCommunitySvcsReferralsInd;
    }

    public String getCommunityInvolvementNeedsInd() {
        return this.communityInvolvementNeedsInd;
    }

    public void setCommunityInvolvementNeedsInd(String communityInvolvementNeedsInd) {
        this.communityInvolvementNeedsInd = communityInvolvementNeedsInd;
    }

    public String getCommunityInvolvementReferralsInd() {
        return this.communityInvolvementReferralsInd;
    }

    public void setCommunityInvolvementReferralsInd(String communityInvolvementReferralsInd) {
        this.communityInvolvementReferralsInd = communityInvolvementReferralsInd;
    }

    public String getLanguageSkillsNeedsInd() {
        return this.languageSkillsNeedsInd;
    }

    public void setLanguageSkillsNeedsInd(String languageSkillsNeedsInd) {
        this.languageSkillsNeedsInd = languageSkillsNeedsInd;
    }

    public String getLanguageSkillsReferralsInd() {
        return this.languageSkillsReferralsInd;
    }

    public void setLanguageSkillsReferralsInd(String languageSkillsReferralsInd) {
        this.languageSkillsReferralsInd = languageSkillsReferralsInd;
    }

    public String getLanguageSkillsNeedsReasonId() {
        return this.languageSkillsNeedsReasonId;
    }

    public void setLanguageSkillsNeedsReasonId(String languageSkillsNeedsReasonId) {
        this.languageSkillsNeedsReasonId = languageSkillsNeedsReasonId;
    }

    public String getOtherSkillsNeedsInd() {
        return this.otherSkillsNeedsInd;
    }

    public void setOtherSkillsNeedsInd(String otherSkillsNeedsInd) {
        this.otherSkillsNeedsInd = otherSkillsNeedsInd;
    }

    public String getOtherSkillsReferralsInd() {
        return this.otherSkillsReferralsInd;
    }

    public void setOtherSkillsReferralsInd(String otherSkillsReferralsInd) {
        this.otherSkillsReferralsInd = otherSkillsReferralsInd;
    }

    public String getOtherSkillsNeedsReasonId() {
        return this.otherSkillsNeedsReasonId;
    }

    public void setOtherSkillsNeedsReasonId(String otherSkillsNeedsReasonId) {
        this.otherSkillsNeedsReasonId = otherSkillsNeedsReasonId;
    }

    public String getFindEmploymentNeedsInd() {
        return this.findEmploymentNeedsInd;
    }

    public void setFindEmploymentNeedsInd(String findEmploymentNeedsInd) {
        this.findEmploymentNeedsInd = findEmploymentNeedsInd;
    }

    public String getFindEmploymentReferralsInd() {
        return this.findEmploymentReferralsInd;
    }

    public void setFindEmploymentReferralsInd(String findEmploymentReferralsInd) {
        this.findEmploymentReferralsInd = findEmploymentReferralsInd;
    }

    public String getFindEmploymentPeriodId() {
        return this.findEmploymentPeriodId;
    }

    public void setFindEmploymentPeriodId(String findEmploymentPeriodId) {
        this.findEmploymentPeriodId = findEmploymentPeriodId;
    }

    public String getCanadianEmploymentExperienceId() {
        return this.canadianEmploymentExperienceId;
    }

    public void setCanadianEmploymentExperienceId(String canadianEmploymentExperienceId) {
        this.canadianEmploymentExperienceId = canadianEmploymentExperienceId;
    }

    public String getIntendedWorkNocGroupId() {
        return this.intendedWorkNocGroupId;
    }

    public void setIntendedWorkNocGroupId(String intendedWorkNocGroupId) {
        this.intendedWorkNocGroupId = intendedWorkNocGroupId;
    }

    public String getIntentionCredentialsLicenceInd() {
        return this.intentionCredentialsLicenceInd;
    }

    public void setIntentionCredentialsLicenceInd(String intentionCredentialsLicenceInd) {
        this.intentionCredentialsLicenceInd = intentionCredentialsLicenceInd;
    }

    public String getIntentionCanadianCitizenInd() {
        return this.intentionCanadianCitizenInd;
    }

    public void setIntentionCanadianCitizenInd(String intentionCanadianCitizenInd) {
        this.intentionCanadianCitizenInd = intentionCanadianCitizenInd;
    }

    public String getSupportRequiredServicesRequired() {
        return this.supportRequiredServicesRequired;
    }

    public void setSupportRequiredServicesRequired(String supportRequiredServicesRequired) {
        this.supportRequiredServicesRequired = supportRequiredServicesRequired;
    }

    public String getChildmindingRequiredInd() {
        return this.childmindingRequiredInd;
    }

    public void setChildmindingRequiredInd(String childmindingRequiredInd) {
        this.childmindingRequiredInd = childmindingRequiredInd;
    }

    public String getTransportationRequiredInd() {
        return this.transportationRequiredInd;
    }

    public void setTransportationRequiredInd(String transportationRequiredInd) {
        this.transportationRequiredInd = transportationRequiredInd;
    }

    public String getSupportDisabilityRequiredInd() {
        return this.supportDisabilityRequiredInd;
    }

    public void setSupportDisabilityRequiredInd(String supportDisabilityRequiredInd) {
        this.supportDisabilityRequiredInd = supportDisabilityRequiredInd;
    }

    public String getTranslationRequiredInd() {
        return this.translationRequiredInd;
    }

    public void setTranslationRequiredInd(String translationRequiredInd) {
        this.translationRequiredInd = translationRequiredInd;
    }

    public String getInterpretationRequiredInd() {
        return this.interpretationRequiredInd;
    }

    public void setInterpretationRequiredInd(String interpretationRequiredInd) {
        this.interpretationRequiredInd = interpretationRequiredInd;
    }

    public String getCounsellingRequiredInd() {
        return this.counsellingRequiredInd;
    }

    public void setCounsellingRequiredInd(String counsellingRequiredInd) {
        this.counsellingRequiredInd = counsellingRequiredInd;
    }

    public String getNonCicProgramNeedsServicesRequired() {
        return this.nonCicProgramNeedsServicesRequired;
    }

    public void setNonCicProgramNeedsServicesRequired(String nonCicProgramNeedsServicesRequired) {
        this.nonCicProgramNeedsServicesRequired = nonCicProgramNeedsServicesRequired;
    }

    public String getFoodClothMaterialNeedsInd() {
        return this.foodClothMaterialNeedsInd;
    }

    public void setFoodClothMaterialNeedsInd(String foodClothMaterialNeedsInd) {
        this.foodClothMaterialNeedsInd = foodClothMaterialNeedsInd;
    }

    public String getFoodClothMaterialRefsInd() {
        return this.foodClothMaterialRefsInd;
    }

    public void setFoodClothMaterialRefsInd(String foodClothMaterialRefsInd) {
        this.foodClothMaterialRefsInd = foodClothMaterialRefsInd;
    }

    public String getHousingAccommodationNeedsInd() {
        return this.housingAccommodationNeedsInd;
    }

    public void setHousingAccommodationNeedsInd(String housingAccommodationNeedsInd) {
        this.housingAccommodationNeedsInd = housingAccommodationNeedsInd;
    }

    public String getHousingAccommodationReferralsInd() {
        return this.housingAccommodationReferralsInd;
    }

    public void setHousingAccommodationReferralsInd(String housingAccommodationReferralsInd) {
        this.housingAccommodationReferralsInd = housingAccommodationReferralsInd;
    }

    public String getHlthMentalWellnessNeedsInd() {
        return this.hlthMentalWellnessNeedsInd;
    }

    public void setHlthMentalWellnessNeedsInd(String hlthMentalWellnessNeedsInd) {
        this.hlthMentalWellnessNeedsInd = hlthMentalWellnessNeedsInd;
    }

    public String getHlthMentalWellnessRefsInd() {
        return this.hlthMentalWellnessRefsInd;
    }

    public void setHlthMentalWellnessRefsInd(String hlthMentalWellnessRefsInd) {
        this.hlthMentalWellnessRefsInd = hlthMentalWellnessRefsInd;
    }

    public String getFinancialNeedsInd() {
        return this.financialNeedsInd;
    }

    public void setFinancialNeedsInd(String financialNeedsInd) {
        this.financialNeedsInd = financialNeedsInd;
    }

    public String getFinancialReferralsInd() {
        return this.financialReferralsInd;
    }

    public void setFinancialReferralsInd(String financialReferralsInd) {
        this.financialReferralsInd = financialReferralsInd;
    }

    public String getFamilySupportNeedsInd() {
        return this.familySupportNeedsInd;
    }

    public void setFamilySupportNeedsInd(String familySupportNeedsInd) {
        this.familySupportNeedsInd = familySupportNeedsInd;
    }

    public String getFamilySupportReferralsInd() {
        return this.familySupportReferralsInd;
    }

    public void setFamilySupportReferralsInd(String familySupportReferralsInd) {
        this.familySupportReferralsInd = familySupportReferralsInd;
    }

    public String getLanguageNonCICNeedsInd() {
        return this.languageNonCICNeedsInd;
    }

    public void setLanguageNonCICNeedsInd(String languageNonCICNeedsInd) {
        this.languageNonCICNeedsInd = languageNonCICNeedsInd;
    }

    public String getLanguageNonCICReferralsInd() {
        return this.languageNonCICReferralsInd;
    }

    public void setLanguageNonCICReferralsInd(String languageNonCICReferralsInd) {
        this.languageNonCICReferralsInd = languageNonCICReferralsInd;
    }

    public String getEduSkillsDevtNeedsInd() {
        return this.eduSkillsDevtNeedsInd;
    }

    public void setEduSkillsDevtNeedsInd(String eduSkillsDevtNeedsInd) {
        this.eduSkillsDevtNeedsInd = eduSkillsDevtNeedsInd;
    }

    public String getEduSkillsDevtReferralsInd() {
        return this.eduSkillsDevtReferralsInd;
    }

    public void setEduSkillsDevtReferralsInd(String eduSkillsDevtReferralsInd) {
        this.eduSkillsDevtReferralsInd = eduSkillsDevtReferralsInd;
    }

    public String getEmploymentRelatedNeedsInd() {
        return this.employmentRelatedNeedsInd;
    }

    public void setEmploymentRelatedNeedsInd(String employmentRelatedNeedsInd) {
        this.employmentRelatedNeedsInd = employmentRelatedNeedsInd;
    }

    public String getEmploymentRelatedReferralsInd() {
        return this.employmentRelatedReferralsInd;
    }

    public void setEmploymentRelatedReferralsInd(String employmentRelatedReferralsInd) {
        this.employmentRelatedReferralsInd = employmentRelatedReferralsInd;
    }

    public String getLegalInfoServicesNeedsInd() {
        return this.legalInfoServicesNeedsInd;
    }

    public void setLegalInfoServicesNeedsInd(String legalInfoServicesNeedsInd) {
        this.legalInfoServicesNeedsInd = legalInfoServicesNeedsInd;
    }

    public String getLegalInfoServicesReferralsInd() {
        return this.legalInfoServicesReferralsInd;
    }

    public void setLegalInfoServicesReferralsInd(String legalInfoServicesReferralsInd) {
        this.legalInfoServicesReferralsInd = legalInfoServicesReferralsInd;
    }

    public String getCommunityServicesNeedsInd() {
        return this.communityServicesNeedsInd;
    }

    public void setCommunityServicesNeedsInd(String communityServicesNeedsInd) {
        this.communityServicesNeedsInd = communityServicesNeedsInd;
    }

    public String getCommunityServicesReferralsInd() {
        return this.communityServicesReferralsInd;
    }

    public void setCommunityServicesReferralsInd(String communityServicesReferralsInd) {
        this.communityServicesReferralsInd = communityServicesReferralsInd;
    }

    public String getSupportReceivedInd() {
        return this.supportReceivedInd;
    }

    public void setSupportReceivedInd(String supportReceivedInd) {
        this.supportReceivedInd = supportReceivedInd;
    }

    public String getChildmindingInd() {
        return this.childmindingInd;
    }

    public void setChildmindingInd(String childmindingInd) {
        this.childmindingInd = childmindingInd;
    }

    public String getChildmindingNewcomerChildren1ChildmindingAgeId() {
        return this.childmindingNewcomerChildren1ChildmindingAgeId;
    }

    public void setChildmindingNewcomerChildren1ChildmindingAgeId(String childmindingNewcomerChildren1ChildmindingAgeId) {
        this.childmindingNewcomerChildren1ChildmindingAgeId = childmindingNewcomerChildren1ChildmindingAgeId;
    }

    public String getChildmindingNewcomerChildren1ChildmindingTypeId() {
        return this.childmindingNewcomerChildren1ChildmindingTypeId;
    }

    public void setChildmindingNewcomerChildren1ChildmindingTypeId(String childmindingNewcomerChildren1ChildmindingTypeId) {
        this.childmindingNewcomerChildren1ChildmindingTypeId = childmindingNewcomerChildren1ChildmindingTypeId;
    }

    public String getChildmindingNewcomerChildren2ChildmindingAgeId() {
        return this.childmindingNewcomerChildren2ChildmindingAgeId;
    }

    public void setChildmindingNewcomerChildren2ChildmindingAgeId(String childmindingNewcomerChildren2ChildmindingAgeId) {
        this.childmindingNewcomerChildren2ChildmindingAgeId = childmindingNewcomerChildren2ChildmindingAgeId;
    }

    public String getChildmindingNewcomerChildren2ChildmindingTypeId() {
        return this.childmindingNewcomerChildren2ChildmindingTypeId;
    }

    public void setChildmindingNewcomerChildren2ChildmindingTypeId(String childmindingNewcomerChildren2ChildmindingTypeId) {
        this.childmindingNewcomerChildren2ChildmindingTypeId = childmindingNewcomerChildren2ChildmindingTypeId;
    }

    public String getChildmindingNewcomerChildren3ChildmindingAgeId() {
        return this.childmindingNewcomerChildren3ChildmindingAgeId;
    }

    public void setChildmindingNewcomerChildren3ChildmindingAgeId(String childmindingNewcomerChildren3ChildmindingAgeId) {
        this.childmindingNewcomerChildren3ChildmindingAgeId = childmindingNewcomerChildren3ChildmindingAgeId;
    }

    public String getChildmindingNewcomerChildren3ChildmindingTypeId() {
        return this.childmindingNewcomerChildren3ChildmindingTypeId;
    }

    public void setChildmindingNewcomerChildren3ChildmindingTypeId(String childmindingNewcomerChildren3ChildmindingTypeId) {
        this.childmindingNewcomerChildren3ChildmindingTypeId = childmindingNewcomerChildren3ChildmindingTypeId;
    }

    public String getChildmindingNewcomerChildren4ChildmindingAgeId() {
        return this.childmindingNewcomerChildren4ChildmindingAgeId;
    }

    public void setChildmindingNewcomerChildren4ChildmindingAgeId(String childmindingNewcomerChildren4ChildmindingAgeId) {
        this.childmindingNewcomerChildren4ChildmindingAgeId = childmindingNewcomerChildren4ChildmindingAgeId;
    }

    public String getChildmindingNewcomerChildren4ChildmindingTypeId() {
        return this.childmindingNewcomerChildren4ChildmindingTypeId;
    }

    public void setChildmindingNewcomerChildren4ChildmindingTypeId(String childmindingNewcomerChildren4ChildmindingTypeId) {
        this.childmindingNewcomerChildren4ChildmindingTypeId = childmindingNewcomerChildren4ChildmindingTypeId;
    }

    public String getChildmindingNewcomerChildren5ChildmindingAgeId() {
        return this.childmindingNewcomerChildren5ChildmindingAgeId;
    }

    public void setChildmindingNewcomerChildren5ChildmindingAgeId(String childmindingNewcomerChildren5ChildmindingAgeId) {
        this.childmindingNewcomerChildren5ChildmindingAgeId = childmindingNewcomerChildren5ChildmindingAgeId;
    }

    public String getChildmindingNewcomerChildren5ChildmindingTypeId() {
        return this.childmindingNewcomerChildren5ChildmindingTypeId;
    }

    public void setChildmindingNewcomerChildren5ChildmindingTypeId(String childmindingNewcomerChildren5ChildmindingTypeId) {
        this.childmindingNewcomerChildren5ChildmindingTypeId = childmindingNewcomerChildren5ChildmindingTypeId;
    }

    public String getTransportationInd() {
        return this.transportationInd;
    }

    public void setTransportationInd(String transportationInd) {
        this.transportationInd = transportationInd;
    }

    public String getSupportDisabilityInd() {
        return this.supportDisabilityInd;
    }

    public void setSupportDisabilityInd(String supportDisabilityInd) {
        this.supportDisabilityInd = supportDisabilityInd;
    }

    public String getTranslationInd() {
        return this.translationInd;
    }

    public void setTranslationInd(String translationInd) {
        this.translationInd = translationInd;
    }

    public String getTranslationLanguageFromId() {
        return this.translationLanguageFromId;
    }

    public void setTranslationLanguageFromId(String translationLanguageFromId) {
        this.translationLanguageFromId = translationLanguageFromId;
    }

    public String getTranslationLanguageToId() {
        return this.translationLanguageToId;
    }

    public void setTranslationLanguageToId(String translationLanguageToId) {
        this.translationLanguageToId = translationLanguageToId;
    }

    public String getInterpretationInd() {
        return this.interpretationInd;
    }

    public void setInterpretationInd(String interpretationInd) {
        this.interpretationInd = interpretationInd;
    }

    public String getInterpretationLanguageFromId() {
        return this.interpretationLanguageFromId;
    }

    public void setInterpretationLanguageFromId(String interpretationLanguageFromId) {
        this.interpretationLanguageFromId = interpretationLanguageFromId;
    }

    public String getInterpretationLanguageToId() {
        return this.interpretationLanguageToId;
    }

    public void setInterpretationLanguageToId(String interpretationLanguageToId) {
        this.interpretationLanguageToId = interpretationLanguageToId;
    }

    public String getCounsellingInd() {
        return this.counsellingInd;
    }

    public void setCounsellingInd(String counsellingInd) {
        this.counsellingInd = counsellingInd;
    }

    public String getSettlementPlanInd() {
        return this.settlementPlanInd;
    }

    public void setSettlementPlanInd(String settlementPlanInd) {
        this.settlementPlanInd = settlementPlanInd;
    }

    public String getAssessmentCompletedDt() {
        return this.assessmentCompletedDt;
    }

    public void setAssessmentCompletedDt(String assessmentCompletedDt) {
        this.assessmentCompletedDt = assessmentCompletedDt;
    }

    public String getAssessmentUpdateReasonId() {
        return this.assessmentUpdateReasonId;
    }

    public void setAssessmentUpdateReasonId(String assessmentUpdateReasonId) {
        this.assessmentUpdateReasonId = assessmentUpdateReasonId;
    }
}