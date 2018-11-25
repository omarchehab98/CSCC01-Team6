package team6.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import team6.models.Template.FriendlyName;

@Entity
public class InformationAndOrientationTemplate extends Template {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@FriendlyName("Processing Details")
	private String processingDetails;
	@FriendlyName("Update Record ID")
	private String updateRecordId;
	@FriendlyName("Unique Identifier")
	private String clientValidationtypeId;
	@FriendlyName("Unique Identifier Value")
	private String clientValidationId;
	@FriendlyName("Date of Birth (YYYY-MM-DD)")
	private String clientBirthDt;
	@FriendlyName("Postal Code where the service was received")
	private String postalCd;
	@FriendlyName("Start Date of Service (YYYY-MM-DD)")
	private String startDttm;
	@FriendlyName("Language of Service")
	private String serviceLanguageId;
	@FriendlyName("Official Language of Preference")
	private String serviceOfficialLanguageId;
	@FriendlyName("Type of Institution/Organization Where Client Received Services")
	private String institutiontypeId;
	@FriendlyName("Referred By")
	private String serviceReferredByid;
	@FriendlyName("Services Received")
	private String orientationServiceId;
	@FriendlyName("Total Length of Orientation")
	private String orientationLengthId;
	@FriendlyName("Total Length of Orientation: Hours")
	private String orientationLengthHoursNo;
	@FriendlyName("Total Length of Orientation: Minutes")
	private String orientationLengthMinutesNo;
	@FriendlyName("Number of Clients in Group")
	private String groupClientsNoId;
	@FriendlyName("Directed at a specific Target Group")
	private String targetGroupSpecificInd;
	@FriendlyName("Target Group: Children (0-14 yrs)")
	private String targetGroupChildrenInd;
	@FriendlyName("Target Group: Youth (15-24 yrs)")
	private String targetGroupYouthInd;
	@FriendlyName("Target Group: Seniors")
	private String targetGroupSeniorInd;
	@FriendlyName("Target Group: Gender-specific")
	private String targetGroupGenderInd;
	@FriendlyName("Target Group: Refugees")
	private String targetGroupRefugeeInd;
	@FriendlyName("Target Group: Ethnic/cultural/linguistic group")
	private String targetGroupEthnicInd;
	@FriendlyName("Target Group: Deaf or Hard of Hearing")
	private String targetGroupHearingInd;
	@FriendlyName("Target Group: Blind or Partially Sighted")
	private String targetGroupVisualInd;
	@FriendlyName("Target Group: Lesbian, Gay, Bisexual, Transgender, Queer (LGBTQ)")
	private String targetGroupLGBTQInd;
	@FriendlyName("Target Group: Families/Parents")
	private String targetGroupFamiliesParentsind;
	@FriendlyName("Target Group: Clients with other impairments (physical, mental)")
	private String targetGroupOtherImpairmentsInd;
	@FriendlyName("Target Group: Clients with international training in a regulated profession")
	private String targetGroupCWITInRegulatedProfessionInd;
	@FriendlyName("Target Group: Clients with international training in a regulated trade")
	private String targetgroupCWITInRegulatedTradeInd;
	@FriendlyName("Target Group: Official Language minorities")
	private String targetGroupOfficialLanguageMinoritiesInd;
	@FriendlyName("Overview of Canada")
	private String topicOverviewGivenInd;
	@FriendlyName("Overview of Canada Referrals")
	private String topicOverviewReferralInd;
	@FriendlyName("Sources of Information")
	private String topicInformationGivenInd;
	@FriendlyName("Sources of Information Referrals")
	private String topicInformationReferralInd;
	@FriendlyName("Rights and Freedoms")
	private String topicRightsGivenInd;
	@FriendlyName("Rights and Freedoms Referrals")
	private String topicRightsReferralInd;
	@FriendlyName("Canadian Law and Justice")
	private String topicLawGivenInd;
	@FriendlyName("Canadian Law and Justice Referrals")
	private String topicLawreferralInd;
	@FriendlyName("Important Documents")
	private String topicDocumentsGivenInd;
	@FriendlyName("Important Documents Referrals")
	private String topicDocumentsReferralInd;
	@FriendlyName("Improving English or French")
	private String topicLanguageGivenInd;
	@FriendlyName("Improving English or French Referrals")
	private String topicLanguageReferralInd;
	@FriendlyName("Employment and Income")
	private String topicIncomeGivenInd;
	@FriendlyName("Employment and Income Referrals")
	private String topicIncomeReferralInd;
	@FriendlyName("Education")
	private String topicEducationGivenInd;
	@FriendlyName("Education Referrals")
	private String topicEducationReferralInd;
	@FriendlyName("Housing")
	private String topicHousingGivenInd;
	@FriendlyName("Housing Referrals")
	private String topicHousingReferralInd;
	@FriendlyName("Health")
	private String topicHealthGivenInd;
	@FriendlyName("Health Referrals")
	private String topicHealthReferralInd;
	@FriendlyName("Money and Finances")
	private String topicMoneyGivenInd;
	@FriendlyName("Money and Finances Referrals")
	private String topicMoneyReferralInd;
	@FriendlyName("Transportation")
	private String topicTransportationGivenInd;
	@FriendlyName("Transportation Referrals")
	private String topicTransportationReferralInd;
	@FriendlyName("Communications and Media")
	private String topicMediaGivenInd;
	@FriendlyName("Communications and Media Referrals")
	private String topicMediaReferralInd;
	@FriendlyName("Community Engagement")
	private String topicCommunityGivenInd;
	@FriendlyName("Community Engagement Referrals")
	private String topicCommunityReferralInd;
	@FriendlyName("Becoming a Canadian Citizen")
	private String topicCitizenshipGivenInd;
	@FriendlyName("Becoming a Canadian Citizen Referrals")
	private String topicCitizenshipReferralInd;
	@FriendlyName("Interpersonal Conflict")
	private String topicConflictGivenInd;
	@FriendlyName("Interpersonal Conflict Referrals")
	private String topicConflictReferralInd;
	@FriendlyName("Was Essential Skills and Aptitude Training Received as Part of this Service?")
	private String trainingReceivedServiceInd;
	@FriendlyName("Computer skills")
	private String trainingReceivedComputerInd;
	@FriendlyName("Document Use")
	private String trainingReceivedDocumentInd;
	@FriendlyName("Interpersonal Skills and Workplace Culture")
	private String trainingReceivedInterpersonalInd;
	@FriendlyName("Leadership Training")
	private String trainingReceivedLeadershipInd;
	@FriendlyName("Numeracy")
	private String trainingReceivedNumeracyInd;
	@FriendlyName("Was Life Skills or Responsibilities of Citizenship Information Received as Part of this Service?")
	private String skillReceivedServiceInd;
	@FriendlyName("Life Skills")
	private String essentialSkillLifeInd;
	@FriendlyName("Rights and Responsibilities of Citizenship (based on discover Canada)")
	private String essentialSkillResponsabilitiesInd;
	@FriendlyName("Support Services Received")
	private String supportReceivedInd;
	@FriendlyName("Care for Newcomer Children")
	private String childmindingInd;
	@FriendlyName("Child 1: Age")
	private String childmindingNewcomerChildren1ChildmindingAgeId;
	@FriendlyName("Child 1: Type of Care")
	private String childmindingNewcomerChildren1ChildmindingTypeId;
	@FriendlyName("Child 2: Age")
	private String childmindingNewcomerChildren2ChildmindingAgeId;
	@FriendlyName("Child 2: Type of Care")
	private String childmindingNewcomerChildren2ChildmindingTypeId;
	@FriendlyName("Child 3: Age")
	private String childmindingNewcomerChildren3ChildmindingAgeId;
	@FriendlyName("Child 3: Type of Care")
	private String childmindingNewcomerChildren3ChildmindingTypeId;
	@FriendlyName("Child 4: Age")
	private String childmindingNewcomerChildren4ChildmindingAgeId;
	@FriendlyName("Child 4: Type of Care")
	private String childmindingNewcomerChildren4ChildmindingTypeId;
	@FriendlyName("Child 5: Age")
	private String childmindingNewcomerChildren5ChildmindingAgeId;
	@FriendlyName("Child 5: Type of Care")
	private String childmindingNewcomerChildren5ChildmindingTypeId;
	@FriendlyName("Transportation")
	private String transportationInd;
	@FriendlyName("Provisions for Disabilities")
	private String supportDisabilityInd;
	@FriendlyName("Translation")
	private String translationInd;
	@FriendlyName("Between")
	private String translationLanguageFromId;
	@FriendlyName("And")
	private String translationLanguageToId;
	@FriendlyName("Interpretation")
	private String interpretationInd;
	@FriendlyName("Between")
	private String interpretationLanguageFromId;
	@FriendlyName("And")
	private String interpretationLanguageToId;
	@FriendlyName("Crisis Counselling")
	private String counsellingInd;
	@FriendlyName("End Date of Service (YYYY-MM-DD)")
	private String endDttm;
	@FriendlyName("Reason for update")
	private String assessmentUpdateReasonId;
	@ManyToOne
    @JoinColumn(name = "organizationId")
    private Organization organization;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProcessingDetails() {
		return processingDetails;
	}
	public void setProcessingDetails(String processingDetails) {
		this.processingDetails = processingDetails;
	}
	public String getUpdateRecordId() {
		return updateRecordId;
	}
	public void setUpdateRecordId(String updateRecordId) {
		this.updateRecordId = updateRecordId;
	}
	public String getClientValidationtypeId() {
		return clientValidationtypeId;
	}
	public void setClientValidationtypeId(String clientValidationtypeId) {
		this.clientValidationtypeId = clientValidationtypeId;
	}
	public String getClientValidationId() {
		return clientValidationId;
	}
	public void setClientValidationId(String clientValidationId) {
		this.clientValidationId = clientValidationId;
	}
	public String getClientBirthDt() {
		return clientBirthDt;
	}
	public void setClientBirthDt(String clientBirthDt) {
		this.clientBirthDt = clientBirthDt;
	}
	public String getPostalCd() {
		return postalCd;
	}
	public void setPostalCd(String postalCd) {
		this.postalCd = postalCd;
	}
	public String getStartDttm() {
		return startDttm;
	}
	public void setStartDttm(String startDttm) {
		this.startDttm = startDttm;
	}
	public String getServiceLanguageId() {
		return serviceLanguageId;
	}
	public void setServiceLanguageId(String serviceLanguageId) {
		this.serviceLanguageId = serviceLanguageId;
	}
	public String getServiceOfficialLanguageId() {
		return serviceOfficialLanguageId;
	}
	public void setServiceOfficialLanguageId(String serviceOfficialLanguageId) {
		this.serviceOfficialLanguageId = serviceOfficialLanguageId;
	}
	public String getInstitutiontypeId() {
		return institutiontypeId;
	}
	public void setInstitutiontypeId(String institutiontypeId) {
		this.institutiontypeId = institutiontypeId;
	}
	public String getServiceReferredByid() {
		return serviceReferredByid;
	}
	public void setServiceReferredByid(String serviceReferredByid) {
		this.serviceReferredByid = serviceReferredByid;
	}
	public String getOrientationServiceId() {
		return orientationServiceId;
	}
	public void setOrientationServiceId(String orientationServiceId) {
		this.orientationServiceId = orientationServiceId;
	}
	public String getOrientationLengthId() {
		return orientationLengthId;
	}
	public void setOrientationLengthId(String orientationLengthId) {
		this.orientationLengthId = orientationLengthId;
	}
	public String getOrientationLengthHoursNo() {
		return orientationLengthHoursNo;
	}
	public void setOrientationLengthHoursNo(String orientationLengthHoursNo) {
		this.orientationLengthHoursNo = orientationLengthHoursNo;
	}
	public String getOrientationLengthMinutesNo() {
		return orientationLengthMinutesNo;
	}
	public void setOrientationLengthMinutesNo(String orientationLengthMinutesNo) {
		this.orientationLengthMinutesNo = orientationLengthMinutesNo;
	}
	public String getGroupClientsNoId() {
		return groupClientsNoId;
	}
	public void setGroupClientsNoId(String groupClientsNoId) {
		this.groupClientsNoId = groupClientsNoId;
	}
	public String getTargetGroupSpecificInd() {
		return targetGroupSpecificInd;
	}
	public void setTargetGroupSpecificInd(String targetGroupSpecificInd) {
		this.targetGroupSpecificInd = targetGroupSpecificInd;
	}
	public String getTargetGroupChildrenInd() {
		return targetGroupChildrenInd;
	}
	public void setTargetGroupChildrenInd(String targetGroupChildrenInd) {
		this.targetGroupChildrenInd = targetGroupChildrenInd;
	}
	public String getTargetGroupYouthInd() {
		return targetGroupYouthInd;
	}
	public void setTargetGroupYouthInd(String targetGroupYouthInd) {
		this.targetGroupYouthInd = targetGroupYouthInd;
	}
	public String getTargetGroupSeniorInd() {
		return targetGroupSeniorInd;
	}
	public void setTargetGroupSeniorInd(String targetGroupSeniorInd) {
		this.targetGroupSeniorInd = targetGroupSeniorInd;
	}
	public String getTargetGroupGenderInd() {
		return targetGroupGenderInd;
	}
	public void setTargetGroupGenderInd(String targetGroupGenderInd) {
		this.targetGroupGenderInd = targetGroupGenderInd;
	}
	public String getTargetGroupRefugeeInd() {
		return targetGroupRefugeeInd;
	}
	public void setTargetGroupRefugeeInd(String targetGroupRefugeeInd) {
		this.targetGroupRefugeeInd = targetGroupRefugeeInd;
	}
	public String getTargetGroupEthnicInd() {
		return targetGroupEthnicInd;
	}
	public void setTargetGroupEthnicInd(String targetGroupEthnicInd) {
		this.targetGroupEthnicInd = targetGroupEthnicInd;
	}
	public String getTargetGroupHearingInd() {
		return targetGroupHearingInd;
	}
	public void setTargetGroupHearingInd(String targetGroupHearingInd) {
		this.targetGroupHearingInd = targetGroupHearingInd;
	}
	public String getTargetGroupVisualInd() {
		return targetGroupVisualInd;
	}
	public void setTargetGroupVisualInd(String targetGroupVisualInd) {
		this.targetGroupVisualInd = targetGroupVisualInd;
	}
	public String getTargetGroupLGBTQInd() {
		return targetGroupLGBTQInd;
	}
	public void setTargetGroupLGBTQInd(String targetGroupLGBTQInd) {
		this.targetGroupLGBTQInd = targetGroupLGBTQInd;
	}
	public String getTargetGroupFamiliesParentsind() {
		return targetGroupFamiliesParentsind;
	}
	public void setTargetGroupFamiliesParentsind(String targetGroupFamiliesParentsind) {
		this.targetGroupFamiliesParentsind = targetGroupFamiliesParentsind;
	}
	public String getTargetGroupOtherImpairmentsInd() {
		return targetGroupOtherImpairmentsInd;
	}
	public void setTargetGroupOtherImpairmentsInd(String targetGroupOtherImpairmentsInd) {
		this.targetGroupOtherImpairmentsInd = targetGroupOtherImpairmentsInd;
	}
	public String getTargetGroupCWITInRegulatedProfessionInd() {
		return targetGroupCWITInRegulatedProfessionInd;
	}
	public void setTargetGroupCWITInRegulatedProfessionInd(String targetGroupCWITInRegulatedProfessionInd) {
		this.targetGroupCWITInRegulatedProfessionInd = targetGroupCWITInRegulatedProfessionInd;
	}
	public String getTargetgroupCWITInRegulatedTradeInd() {
		return targetgroupCWITInRegulatedTradeInd;
	}
	public void setTargetgroupCWITInRegulatedTradeInd(String targetgroupCWITInRegulatedTradeInd) {
		this.targetgroupCWITInRegulatedTradeInd = targetgroupCWITInRegulatedTradeInd;
	}
	public String getTargetGroupOfficialLanguageMinoritiesInd() {
		return targetGroupOfficialLanguageMinoritiesInd;
	}
	public void setTargetGroupOfficialLanguageMinoritiesInd(String targetGroupOfficialLanguageMinoritiesInd) {
		this.targetGroupOfficialLanguageMinoritiesInd = targetGroupOfficialLanguageMinoritiesInd;
	}
	public String getTopicOverviewGivenInd() {
		return topicOverviewGivenInd;
	}
	public void setTopicOverviewGivenInd(String topicOverviewGivenInd) {
		this.topicOverviewGivenInd = topicOverviewGivenInd;
	}
	public String getTopicOverviewReferralInd() {
		return topicOverviewReferralInd;
	}
	public void setTopicOverviewReferralInd(String topicOverviewReferralInd) {
		this.topicOverviewReferralInd = topicOverviewReferralInd;
	}
	public String getTopicInformationGivenInd() {
		return topicInformationGivenInd;
	}
	public void setTopicInformationGivenInd(String topicInformationGivenInd) {
		this.topicInformationGivenInd = topicInformationGivenInd;
	}
	public String getTopicInformationReferralInd() {
		return topicInformationReferralInd;
	}
	public void setTopicInformationReferralInd(String topicInformationReferralInd) {
		this.topicInformationReferralInd = topicInformationReferralInd;
	}
	public String getTopicRightsGivenInd() {
		return topicRightsGivenInd;
	}
	public void setTopicRightsGivenInd(String topicRightsGivenInd) {
		this.topicRightsGivenInd = topicRightsGivenInd;
	}
	public String getTopicRightsReferralInd() {
		return topicRightsReferralInd;
	}
	public void setTopicRightsReferralInd(String topicRightsReferralInd) {
		this.topicRightsReferralInd = topicRightsReferralInd;
	}
	public String getTopicLawGivenInd() {
		return topicLawGivenInd;
	}
	public void setTopicLawGivenInd(String topicLawGivenInd) {
		this.topicLawGivenInd = topicLawGivenInd;
	}
	public String getTopicLawreferralInd() {
		return topicLawreferralInd;
	}
	public void setTopicLawreferralInd(String topicLawreferralInd) {
		this.topicLawreferralInd = topicLawreferralInd;
	}
	public String getTopicDocumentsGivenInd() {
		return topicDocumentsGivenInd;
	}
	public void setTopicDocumentsGivenInd(String topicDocumentsGivenInd) {
		this.topicDocumentsGivenInd = topicDocumentsGivenInd;
	}
	public String getTopicDocumentsReferralInd() {
		return topicDocumentsReferralInd;
	}
	public void setTopicDocumentsReferralInd(String topicDocumentsReferralInd) {
		this.topicDocumentsReferralInd = topicDocumentsReferralInd;
	}
	public String getTopicLanguageGivenInd() {
		return topicLanguageGivenInd;
	}
	public void setTopicLanguageGivenInd(String topicLanguageGivenInd) {
		this.topicLanguageGivenInd = topicLanguageGivenInd;
	}
	public String getTopicLanguageReferralInd() {
		return topicLanguageReferralInd;
	}
	public void setTopicLanguageReferralInd(String topicLanguageReferralInd) {
		this.topicLanguageReferralInd = topicLanguageReferralInd;
	}
	public String getTopicIncomeGivenInd() {
		return topicIncomeGivenInd;
	}
	public void setTopicIncomeGivenInd(String topicIncomeGivenInd) {
		this.topicIncomeGivenInd = topicIncomeGivenInd;
	}
	public String getTopicIncomeReferralInd() {
		return topicIncomeReferralInd;
	}
	public void setTopicIncomeReferralInd(String topicIncomeReferralInd) {
		this.topicIncomeReferralInd = topicIncomeReferralInd;
	}
	public String getTopicEducationGivenInd() {
		return topicEducationGivenInd;
	}
	public void setTopicEducationGivenInd(String topicEducationGivenInd) {
		this.topicEducationGivenInd = topicEducationGivenInd;
	}
	public String getTopicEducationReferralInd() {
		return topicEducationReferralInd;
	}
	public void setTopicEducationReferralInd(String topicEducationReferralInd) {
		this.topicEducationReferralInd = topicEducationReferralInd;
	}
	public String getTopicHousingGivenInd() {
		return topicHousingGivenInd;
	}
	public void setTopicHousingGivenInd(String topicHousingGivenInd) {
		this.topicHousingGivenInd = topicHousingGivenInd;
	}
	public String getTopicHousingReferralInd() {
		return topicHousingReferralInd;
	}
	public void setTopicHousingReferralInd(String topicHousingReferralInd) {
		this.topicHousingReferralInd = topicHousingReferralInd;
	}
	public String getTopicHealthGivenInd() {
		return topicHealthGivenInd;
	}
	public void setTopicHealthGivenInd(String topicHealthGivenInd) {
		this.topicHealthGivenInd = topicHealthGivenInd;
	}
	public String getTopicHealthReferralInd() {
		return topicHealthReferralInd;
	}
	public void setTopicHealthReferralInd(String topicHealthReferralInd) {
		this.topicHealthReferralInd = topicHealthReferralInd;
	}
	public String getTopicMoneyGivenInd() {
		return topicMoneyGivenInd;
	}
	public void setTopicMoneyGivenInd(String topicMoneyGivenInd) {
		this.topicMoneyGivenInd = topicMoneyGivenInd;
	}
	public String getTopicMoneyReferralInd() {
		return topicMoneyReferralInd;
	}
	public void setTopicMoneyReferralInd(String topicMoneyReferralInd) {
		this.topicMoneyReferralInd = topicMoneyReferralInd;
	}
	public String getTopicTransportationGivenInd() {
		return topicTransportationGivenInd;
	}
	public void setTopicTransportationGivenInd(String topicTransportationGivenInd) {
		this.topicTransportationGivenInd = topicTransportationGivenInd;
	}
	public String getTopicTransportationReferralInd() {
		return topicTransportationReferralInd;
	}
	public void setTopicTransportationReferralInd(String topicTransportationReferralInd) {
		this.topicTransportationReferralInd = topicTransportationReferralInd;
	}
	public String getTopicMediaGivenInd() {
		return topicMediaGivenInd;
	}
	public void setTopicMediaGivenInd(String topicMediaGivenInd) {
		this.topicMediaGivenInd = topicMediaGivenInd;
	}
	public String getTopicMediaReferralInd() {
		return topicMediaReferralInd;
	}
	public void setTopicMediaReferralInd(String topicMediaReferralInd) {
		this.topicMediaReferralInd = topicMediaReferralInd;
	}
	public String getTopicCommunityGivenInd() {
		return topicCommunityGivenInd;
	}
	public void setTopicCommunityGivenInd(String topicCommunityGivenInd) {
		this.topicCommunityGivenInd = topicCommunityGivenInd;
	}
	public String getTopicCommunityReferralInd() {
		return topicCommunityReferralInd;
	}
	public void setTopicCommunityReferralInd(String topicCommunityReferralInd) {
		this.topicCommunityReferralInd = topicCommunityReferralInd;
	}
	public String getTopicCitizenshipGivenInd() {
		return topicCitizenshipGivenInd;
	}
	public void setTopicCitizenshipGivenInd(String topicCitizenshipGivenInd) {
		this.topicCitizenshipGivenInd = topicCitizenshipGivenInd;
	}
	public String getTopicCitizenshipReferralInd() {
		return topicCitizenshipReferralInd;
	}
	public void setTopicCitizenshipReferralInd(String topicCitizenshipReferralInd) {
		this.topicCitizenshipReferralInd = topicCitizenshipReferralInd;
	}
	public String getTopicConflictGivenInd() {
		return topicConflictGivenInd;
	}
	public void setTopicConflictGivenInd(String topicConflictGivenInd) {
		this.topicConflictGivenInd = topicConflictGivenInd;
	}
	public String getTopicConflictReferralInd() {
		return topicConflictReferralInd;
	}
	public void setTopicConflictReferralInd(String topicConflictReferralInd) {
		this.topicConflictReferralInd = topicConflictReferralInd;
	}
	public String getTrainingReceivedServiceInd() {
		return trainingReceivedServiceInd;
	}
	public void setTrainingReceivedServiceInd(String trainingReceivedServiceInd) {
		this.trainingReceivedServiceInd = trainingReceivedServiceInd;
	}
	public String getTrainingReceivedComputerInd() {
		return trainingReceivedComputerInd;
	}
	public void setTrainingReceivedComputerInd(String trainingReceivedComputerInd) {
		this.trainingReceivedComputerInd = trainingReceivedComputerInd;
	}
	public String getTrainingReceivedDocumentInd() {
		return trainingReceivedDocumentInd;
	}
	public void setTrainingReceivedDocumentInd(String trainingReceivedDocumentInd) {
		this.trainingReceivedDocumentInd = trainingReceivedDocumentInd;
	}
	public String getTrainingReceivedInterpersonalInd() {
		return trainingReceivedInterpersonalInd;
	}
	public void setTrainingReceivedInterpersonalInd(String trainingReceivedInterpersonalInd) {
		this.trainingReceivedInterpersonalInd = trainingReceivedInterpersonalInd;
	}
	public String getTrainingReceivedLeadershipInd() {
		return trainingReceivedLeadershipInd;
	}
	public void setTrainingReceivedLeadershipInd(String trainingReceivedLeadershipInd) {
		this.trainingReceivedLeadershipInd = trainingReceivedLeadershipInd;
	}
	public String getTrainingReceivedNumeracyInd() {
		return trainingReceivedNumeracyInd;
	}
	public void setTrainingReceivedNumeracyInd(String trainingReceivedNumeracyInd) {
		this.trainingReceivedNumeracyInd = trainingReceivedNumeracyInd;
	}
	public String getSkillReceivedServiceInd() {
		return skillReceivedServiceInd;
	}
	public void setSkillReceivedServiceInd(String skillReceivedServiceInd) {
		this.skillReceivedServiceInd = skillReceivedServiceInd;
	}
	public String getEssentialSkillLifeInd() {
		return essentialSkillLifeInd;
	}
	public void setEssentialSkillLifeInd(String essentialSkillLifeInd) {
		this.essentialSkillLifeInd = essentialSkillLifeInd;
	}
	public String getEssentialSkillResponsabilitiesInd() {
		return essentialSkillResponsabilitiesInd;
	}
	public void setEssentialSkillResponsabilitiesInd(String essentialSkillResponsabilitiesInd) {
		this.essentialSkillResponsabilitiesInd = essentialSkillResponsabilitiesInd;
	}
	public String getSupportReceivedInd() {
		return supportReceivedInd;
	}
	public void setSupportReceivedInd(String supportReceivedInd) {
		this.supportReceivedInd = supportReceivedInd;
	}
	public String getChildmindingInd() {
		return childmindingInd;
	}
	public void setChildmindingInd(String childmindingInd) {
		this.childmindingInd = childmindingInd;
	}
	public String getChildmindingNewcomerChildren1ChildmindingAgeId() {
		return childmindingNewcomerChildren1ChildmindingAgeId;
	}
	public void setChildmindingNewcomerChildren1ChildmindingAgeId(String childmindingNewcomerChildren1ChildmindingAgeId) {
		this.childmindingNewcomerChildren1ChildmindingAgeId = childmindingNewcomerChildren1ChildmindingAgeId;
	}
	public String getChildmindingNewcomerChildren1ChildmindingTypeId() {
		return childmindingNewcomerChildren1ChildmindingTypeId;
	}
	public void setChildmindingNewcomerChildren1ChildmindingTypeId(String childmindingNewcomerChildren1ChildmindingTypeId) {
		this.childmindingNewcomerChildren1ChildmindingTypeId = childmindingNewcomerChildren1ChildmindingTypeId;
	}
	public String getChildmindingNewcomerChildren2ChildmindingAgeId() {
		return childmindingNewcomerChildren2ChildmindingAgeId;
	}
	public void setChildmindingNewcomerChildren2ChildmindingAgeId(String childmindingNewcomerChildren2ChildmindingAgeId) {
		this.childmindingNewcomerChildren2ChildmindingAgeId = childmindingNewcomerChildren2ChildmindingAgeId;
	}
	public String getChildmindingNewcomerChildren2ChildmindingTypeId() {
		return childmindingNewcomerChildren2ChildmindingTypeId;
	}
	public void setChildmindingNewcomerChildren2ChildmindingTypeId(String childmindingNewcomerChildren2ChildmindingTypeId) {
		this.childmindingNewcomerChildren2ChildmindingTypeId = childmindingNewcomerChildren2ChildmindingTypeId;
	}
	public String getChildmindingNewcomerChildren3ChildmindingAgeId() {
		return childmindingNewcomerChildren3ChildmindingAgeId;
	}
	public void setChildmindingNewcomerChildren3ChildmindingAgeId(String childmindingNewcomerChildren3ChildmindingAgeId) {
		this.childmindingNewcomerChildren3ChildmindingAgeId = childmindingNewcomerChildren3ChildmindingAgeId;
	}
	public String getChildmindingNewcomerChildren3ChildmindingTypeId() {
		return childmindingNewcomerChildren3ChildmindingTypeId;
	}
	public void setChildmindingNewcomerChildren3ChildmindingTypeId(String childmindingNewcomerChildren3ChildmindingTypeId) {
		this.childmindingNewcomerChildren3ChildmindingTypeId = childmindingNewcomerChildren3ChildmindingTypeId;
	}
	public String getChildmindingNewcomerChildren4ChildmindingAgeId() {
		return childmindingNewcomerChildren4ChildmindingAgeId;
	}
	public void setChildmindingNewcomerChildren4ChildmindingAgeId(String childmindingNewcomerChildren4ChildmindingAgeId) {
		this.childmindingNewcomerChildren4ChildmindingAgeId = childmindingNewcomerChildren4ChildmindingAgeId;
	}
	public String getChildmindingNewcomerChildren4ChildmindingTypeId() {
		return childmindingNewcomerChildren4ChildmindingTypeId;
	}
	public void setChildmindingNewcomerChildren4ChildmindingTypeId(String childmindingNewcomerChildren4ChildmindingTypeId) {
		this.childmindingNewcomerChildren4ChildmindingTypeId = childmindingNewcomerChildren4ChildmindingTypeId;
	}
	public String getChildmindingNewcomerChildren5ChildmindingAgeId() {
		return childmindingNewcomerChildren5ChildmindingAgeId;
	}
	public void setChildmindingNewcomerChildren5ChildmindingAgeId(String childmindingNewcomerChildren5ChildmindingAgeId) {
		this.childmindingNewcomerChildren5ChildmindingAgeId = childmindingNewcomerChildren5ChildmindingAgeId;
	}
	public String getChildmindingNewcomerChildren5ChildmindingTypeId() {
		return childmindingNewcomerChildren5ChildmindingTypeId;
	}
	public void setChildmindingNewcomerChildren5ChildmindingTypeId(String childmindingNewcomerChildren5ChildmindingTypeId) {
		this.childmindingNewcomerChildren5ChildmindingTypeId = childmindingNewcomerChildren5ChildmindingTypeId;
	}
	public String getTransportationInd() {
		return transportationInd;
	}
	public void setTransportationInd(String transportationInd) {
		this.transportationInd = transportationInd;
	}
	public String getSupportDisabilityInd() {
		return supportDisabilityInd;
	}
	public void setSupportDisabilityInd(String supportDisabilityInd) {
		this.supportDisabilityInd = supportDisabilityInd;
	}
	public String getTranslationInd() {
		return translationInd;
	}
	public void setTranslationInd(String translationInd) {
		this.translationInd = translationInd;
	}
	public String getTranslationLanguageFromId() {
		return translationLanguageFromId;
	}
	public void setTranslationLanguageFromId(String translationLanguageFromId) {
		this.translationLanguageFromId = translationLanguageFromId;
	}
	public String getTranslationLanguageToId() {
		return translationLanguageToId;
	}
	public void setTranslationLanguageToId(String translationLanguageToId) {
		this.translationLanguageToId = translationLanguageToId;
	}
	public String getInterpretationInd() {
		return interpretationInd;
	}
	public void setInterpretationInd(String interpretationInd) {
		this.interpretationInd = interpretationInd;
	}
	public String getInterpretationLanguageFromId() {
		return interpretationLanguageFromId;
	}
	public void setInterpretationLanguageFromId(String interpretationLanguageFromId) {
		this.interpretationLanguageFromId = interpretationLanguageFromId;
	}
	public String getInterpretationLanguageToId() {
		return interpretationLanguageToId;
	}
	public void setInterpretationLanguageToId(String interpretationLanguageToId) {
		this.interpretationLanguageToId = interpretationLanguageToId;
	}
	public String getCounsellingInd() {
		return counsellingInd;
	}
	public void setCounsellingInd(String counsellingInd) {
		this.counsellingInd = counsellingInd;
	}
	public String getEndDttm() {
		return endDttm;
	}
	public void setEndDttm(String endDttm) {
		this.endDttm = endDttm;
	}
	public String getAssessmentUpdateReasonId() {
		return assessmentUpdateReasonId;
	}
	public void setAssessmentUpdateReasonId(String assessmentUpdateReasonId) {
		this.assessmentUpdateReasonId = assessmentUpdateReasonId;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	@Override
    public String toString() {
        return String.format("InformationAndOrietnationTemplate[id=%d, name='%s']%n", id, updateRecordId);
    }
}
