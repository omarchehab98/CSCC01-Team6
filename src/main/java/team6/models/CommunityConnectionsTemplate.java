package team6.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CommunityConnectionsTemplate extends Template {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@FriendlyName("Processing Details")
	private String processingDetails;
	@FriendlyName("Update Record ID")
	private String updateRecordId;
	@FriendlyName("Unique Identifier")
	private String clientValidationTypeId;
	@FriendlyName("Unique Identifier Value")
	private String clientValidationId;
	@FriendlyName("Date of Birth (YYYY-MM-DD)")
	private String clientBirthDt;
	@FriendlyName("Postal Code where the service was received")
	private String postalCd;
	@FriendlyName("Language of Service")
	private String serviceLangId;
	@FriendlyName("Official Language of Preference")
	private String preferredOfficialLangId;
	@FriendlyName("Referred By")
	private String assessmentReferralId;
	@FriendlyName("Activity Under Which Client Received Services")
	private String communityActivityId;
	@FriendlyName("Type of Institution/Organization Where Client Received Services")
	private String institutionTypeId;
	@FriendlyName("Type of Event Attended")
	private String eventsTypeAttendedId;
	@FriendlyName("Type of Service")
	private String serviceTypeId;
	@FriendlyName("Main Topic/Focus of the Service Received")
	private String topicsServiceId;
	@FriendlyName("Service Received")
	private String communityServiceId;
	@FriendlyName("Number of Unique Participants")
	private String groupClientsNoId;
	@FriendlyName("Did Volunteers from the Host Community Participate in the Activity")
	private String volunteersParticipateInd;
	@FriendlyName("Directed at a Specific Target Group")
	private String targetGroupSpecificInd;
	@FriendlyName("Target Group: Children (0-14 yrs)")
	private String targetGroupChildrenInd;
	@FriendlyName("Target Group: Youth (15-24 yrs)")
	private String targetGroupYouthInd;
	@FriendlyName("Target Group: Senior")
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
	private String targetGroupFamiliesParentsInd;
	@FriendlyName("Target Group: Other impairments (physical, mental)")
	private String targetGroupOtherImpairmentsInd;
	@FriendlyName("Target Group: Clients with international training in a regulated profession")
	private String targetGroupCWITInRegulatedProfessionInd;
	@FriendlyName("Target Group: Clients with international training in a regulated trade")
	private String targetGroupCWITInRegulatedTradeInd;
	@FriendlyName("Target Group: Official language minorities")
	private String targetGroupOfficialLanguageMinoritiesInd;
	@FriendlyName("Status of Service")
	private String serviceStatusId;
	@FriendlyName("Reason for Leaving Service")
	private String communityLeaveReasonId;
	@FriendlyName("Start Date (YYYY-MM-DD)")
	private String serviceStartDt;
	@FriendlyName("End Date (YYYY-MM-DD)")
	private String serviceEndDt;
	@FriendlyName("Projected End Date (YYYY-MM-DD)")
	private String serviceProjectedEndDt;
	@FriendlyName("Was Essential Skills and Aptitudes Training Received as Part of the Service?")
	private String trainingReceivedServiceInd;
	@FriendlyName("Computer Skills")
	private String trainingReceivedComputerInd;
	@FriendlyName("Document Use")
	private String trainingReceivedDocumentInd;
	@FriendlyName("Interpersonal Skills and Workplace Culture")
	private String trainingReceivedInterpersonalInd;
	@FriendlyName("Leadership Training")
	private String trainingReceivedLeadershipInd;
	@FriendlyName("Life Skills")
	private String trainingReceivedLifeSkillsInd;
	@FriendlyName("Numeracy")
	private String trainingReceivedNumeracyInd;
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
	private String translationLAndLanguageFromId;
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
	@FriendlyName("Total Length of Service: Hours")
	private String serviceLengthHoursNo;
	@FriendlyName("Total Length of Service: Minutes")
	private String serviceLengthMinutesNo;
	@FriendlyName("Reason for update")
	private String assessmentUpdateReasonId;
	@ManyToOne
	@JoinColumn(name = "organizationId")
	@FriendlyName("Organization")
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
	
	public String getClientValidationTypeId() {
		return clientValidationTypeId;
	}
	
	public void setClientValidationTypeId(String clientValidationTypeId) {
		this.clientValidationTypeId = clientValidationTypeId;
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
	
	public String getServiceLangId() {
		return serviceLangId;
	}
	
	public void setServiceLangId(String serviceLangId) {
		this.serviceLangId = serviceLangId;
	}
	
	public String getPreferredOfficialLangId() {
		return preferredOfficialLangId;
	}
	
	public void setPreferredOfficialLangId(String preferredOfficialLangId) {
		this.preferredOfficialLangId = preferredOfficialLangId;
	}
	
	public String getAssessmentReferralId() {
		return assessmentReferralId;
	}
	
	public void setAssessmentReferralId(String assessmentReferralId) {
		this.assessmentReferralId = assessmentReferralId;
	}
	
	public String getCommunityActivityId() {
		return communityActivityId;
	}
	
	public void setCommunityActivityId(String communityActivityId) {
		this.communityActivityId = communityActivityId;
	}
	
	public String getInstitutionTypeId() {
		return institutionTypeId;
	}
	
	public void setInstitutionTypeId(String institutionTypeId) {
		this.institutionTypeId = institutionTypeId;
	}
	
	public String getEventsTypeAttendedId() {
		return eventsTypeAttendedId;
	}
	
	public void setEventsTypeAttendedId(String eventsTypeAttendedId) {
		this.eventsTypeAttendedId = eventsTypeAttendedId;
	}
	
	public String getServiceTypeId() {
		return serviceTypeId;
	}
	
	public void setServiceTypeId(String serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	
	public String getTopicsServiceId() {
		return topicsServiceId;
	}
	
	public void setTopicsServiceId(String topicsServiceId) {
		this.topicsServiceId = topicsServiceId;
	}
	
	public String getCommunityServiceId() {
		return communityServiceId;
	}
	
	public void setCommunityServiceId(String communityServiceId) {
		this.communityServiceId = communityServiceId;
	}
	
	public String getGroupClientsNoId() {
		return groupClientsNoId;
	}
	
	public void setGroupClientsNoId(String groupClientsNoId) {
		this.groupClientsNoId = groupClientsNoId;
	}
	
	public String getVolunteersParticipateInd() {
		return volunteersParticipateInd;
	}
	
	public void setVolunteersParticipateInd(String volunteersParticipateInd) {
		this.volunteersParticipateInd = volunteersParticipateInd;
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
	
	public String getTargetGroupFamiliesParentsInd() {
		return targetGroupFamiliesParentsInd;
	}
	
	public void setTargetGroupFamiliesParentsInd(String targetGroupFamiliesParentsInd) {
		this.targetGroupFamiliesParentsInd = targetGroupFamiliesParentsInd;
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

	public String getTargetGroupCWITInRegulatedTradeInd() {
		return targetGroupCWITInRegulatedTradeInd;
	}

	public void setTargetGroupCWITInRegulatedTradeInd(String targetGroupCWITInRegulatedTradeInd) {
		this.targetGroupCWITInRegulatedTradeInd = targetGroupCWITInRegulatedTradeInd;
	}
	
	public String getTargetGroupOfficialLanguageMinoritiesInd() {
		return targetGroupOfficialLanguageMinoritiesInd;	
	}
	
	public void setTargetGroupOfficialLanguageMinoritiesInd(String targetGroupOfficialLanguageMinoritiesInd) {
		this.targetGroupOfficialLanguageMinoritiesInd = targetGroupOfficialLanguageMinoritiesInd;
	}
	
	public String getServiceStatusId() {
		return serviceStatusId;
	}
	
	public void setServiceStatusId(String serviceStatusId) {
		this.serviceStatusId = serviceStatusId;
	}
	
	public String getCommunityLeaveReasonId() {
		return communityLeaveReasonId;
	}
	
	public void setCommunityLeaveReasonId(String communityLeaveReasonId) {
		this.communityLeaveReasonId = communityLeaveReasonId;
	}
	
	public String getServiceStartDt() {
		return serviceStartDt;
	}
	
	public void setServiceStartDt(String serviceStartDt) {
		this.serviceStartDt = serviceStartDt;
	}
	
	public String getServiceEndDt() {
		return serviceEndDt;
	}
	
	public void setServiceEndDt(String serviceEndDt) {
		this.serviceEndDt = serviceEndDt;
	}
	
	public String getServiceProjectedEndDt() {
		return serviceProjectedEndDt;
	}
	
	public void setServiceProjectedEndDt(String serviceProjectedEndDt) {
		this.serviceProjectedEndDt = serviceProjectedEndDt;
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
	
	public String getTrainingReceivedLifeSkillsInd() {
		return trainingReceivedLifeSkillsInd;
	}
	
	public void setTrainingReceivedLifeSkillsInd(String trainingReceivedLifeSkillsInd) {
		this.trainingReceivedLifeSkillsInd = trainingReceivedLifeSkillsInd;
	}
	
	public String getTrainingReceivedNumeracyInd() {
		return trainingReceivedNumeracyInd;
	}
	
	public void setTrainingReceivedNumeracyInd(String trainingReceivedNumeracyInd) {
		this.trainingReceivedNumeracyInd = trainingReceivedNumeracyInd;
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
	
	public String getTranslationLAndLanguageFromId() {
		return translationLAndLanguageFromId;
	}
	
	public void setTranslationLAndLanguageFromId(String translationLAndLanguageFromId) {
		this.translationLAndLanguageFromId = translationLAndLanguageFromId;
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
	
	public String getServiceLengthHoursNo() {
		return serviceLengthHoursNo;
	}
	
	public void setServiceLengthHoursNo(String serviceLengthHoursNo) {
		this.serviceLengthHoursNo = serviceLengthHoursNo;
	}
	
	public String getServiceLengthMinutesNo() {
		return serviceLengthMinutesNo;
	}
	
	public void setServiceLengthMinutesNo(String serviceLengthMinutesNo) {
		this.serviceLengthMinutesNo = serviceLengthMinutesNo;
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

}
