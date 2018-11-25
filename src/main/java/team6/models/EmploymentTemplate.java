package team6.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import team6.models.Template.FriendlyName;

@Entity
public class EmploymentTemplate extends Template {
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
	@FriendlyName("Registration in an employment intervention")
	private String sessionResultIntnInd;
	@FriendlyName("A referral to")
	private String sessionReferralId;
	@FriendlyName("Language of Service")
	private String sessionServiceLangId;
	@FriendlyName("Official Language of Preference")
	private String sessionOfficialLangId;
	@FriendlyName("Type of Institution/Organization Where Client Received Services")
	private String institutionTypeId;
	@FriendlyName("Referred By")
	private String assessmentReferralId;
	@FriendlyName("Referral Date (YYYY-MM-DD)")
	private String sessionReferralDt;
	@FriendlyName("Employment Status")
	private String sessionEmploymentStatusId;
	@FriendlyName("Education Status")
	private String sessionEducationStatusId;
	@FriendlyName("Occupation in Canada")
	private String sessionCurrentOccupationId;
	@FriendlyName("Intended Occupation")
	private String sessionIntendedOccupationId;
	@FriendlyName("Intervention Type")
	private String interventionTypeId;
	@FriendlyName("Long Term Intervention: Intervention Received")
	private String interventionReceivedId;
	@FriendlyName("Long Term Intervention: Status of Intervention")
	private String interventionStatusId;
	@FriendlyName("Long Term Intervention: Reason For Leaving Intervention")
	private String interventionLeaveReasonId;
	@FriendlyName("Long Term Intervention: Start Date (YYYY-MM-DD)")
	private String interventionStartDt;
	@FriendlyName("Long Term Intervention: End Date (YYYY-MM-DD)")
	private String interventionEndDt;
	@FriendlyName("Long Term Intervention: Size of Employer")
	private String employerSizeId;
	@FriendlyName("Long Term Intervention: Placement Was")
	private String placementTypeId;
	@FriendlyName("Long Term Intervention: Hours Per Week")
	private String workingHoursId;
	@FriendlyName("Long Term Intervention: Client Met Mentor Regularly at")
	private String mentoringLocationId;
	@FriendlyName("Long Term Intervention: Average Hours/Week in Contact with Mentor")
	private String mentoringHoursId;
	@FriendlyName("Long Term Intervention: Profession/Trade For Which Services Were Received")
	private String interventionProfessionId;
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
	@FriendlyName("Short Term Intervention: Service Received")
	private String shortTermService1ServiceReceivedId;
	@FriendlyName("Short Term Intervention: Date (YYYY-MM-DD)")
	private String shortTermService1EntryDt;
	@FriendlyName("Short Term Intervention: Service Received")
	private String shortTermService2ServiceReceivedid;
	@FriendlyName("Short Term Intervention: Date (YYYY-MM-DD)")
	private String shortTermService2EntryDt;
	@FriendlyName("Short Term Intervention: Service Received")
	private String shortTermService3ServiceReceivedId;
	@FriendlyName("Short Term Intervention: Date (YYYY-MM-DD)")
	private String shortTermService3EntryDt;
	@FriendlyName("Short Term Intervention: Service Received")
	private String shortTermService4ServiceReceivedId;
	@FriendlyName("Short Term Intervention: Date (YYYY-MM-DD)")
	private String shortTermService4EntryDt;
	@FriendlyName("Short Term Intervention: Service Received")
	private String shortTermService5ServiceReceivedId;
	@FriendlyName("Short Term Intervention: Date (YYYY-MM-DD)")
	private String shortTermService5Entrydt;
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
	private String translationLanguagefromid;
	@FriendlyName("And")
	private String translationLanguageToId;
	@FriendlyName("Interpretation")
	private String interpretationInd;
	@FriendlyName("Between")
	private String interpretationLanguagefromId;
	@FriendlyName("And")
	private String interpretationLanguageToId;
	@FriendlyName("Crisis Counselling")
	private String counsellingInd;
	@FriendlyName("Time Spent With Client/Addressing Client's Employment Needs: Hours")
	private String completeHoursSpentNo;
	@FriendlyName("Time Spent With Client/Addressing Client's Employment Needs: Minutes")
	private String completeMinutesSpentno;
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
	public String getSessionResultIntnInd() {
		return sessionResultIntnInd;
	}
	public void setSessionResultIntnInd(String sessionResultIntnInd) {
		this.sessionResultIntnInd = sessionResultIntnInd;
	}
	public String getSessionReferralId() {
		return sessionReferralId;
	}
	public void setSessionReferralId(String sessionReferralId) {
		this.sessionReferralId = sessionReferralId;
	}
	public String getSessionServiceLangId() {
		return sessionServiceLangId;
	}
	public void setSessionServiceLangId(String sessionServiceLangId) {
		this.sessionServiceLangId = sessionServiceLangId;
	}
	public String getSessionOfficialLangId() {
		return sessionOfficialLangId;
	}
	public void setSessionOfficialLangId(String sessionOfficialLangId) {
		this.sessionOfficialLangId = sessionOfficialLangId;
	}
	public String getInstitutionTypeId() {
		return institutionTypeId;
	}
	public void setInstitutionTypeId(String institutionTypeId) {
		this.institutionTypeId = institutionTypeId;
	}
	public String getAssessmentReferralId() {
		return assessmentReferralId;
	}
	public void setAssessmentReferralId(String assessmentReferralId) {
		this.assessmentReferralId = assessmentReferralId;
	}
	public String getSessionReferralDt() {
		return sessionReferralDt;
	}
	public void setSessionReferralDt(String sessionReferralDt) {
		this.sessionReferralDt = sessionReferralDt;
	}
	public String getSessionEmploymentStatusId() {
		return sessionEmploymentStatusId;
	}
	public void setSessionEmploymentStatusId(String sessionEmploymentStatusId) {
		this.sessionEmploymentStatusId = sessionEmploymentStatusId;
	}
	public String getSessionEducationStatusId() {
		return sessionEducationStatusId;
	}
	public void setSessionEducationStatusId(String sessionEducationStatusId) {
		this.sessionEducationStatusId = sessionEducationStatusId;
	}
	public String getSessionCurrentOccupationId() {
		return sessionCurrentOccupationId;
	}
	public void setSessionCurrentOccupationId(String sessionCurrentOccupationId) {
		this.sessionCurrentOccupationId = sessionCurrentOccupationId;
	}
	public String getSessionIntendedOccupationId() {
		return sessionIntendedOccupationId;
	}
	public void setSessionIntendedOccupationId(String sessionIntendedOccupationId) {
		this.sessionIntendedOccupationId = sessionIntendedOccupationId;
	}
	public String getInterventionTypeId() {
		return interventionTypeId;
	}
	public void setInterventionTypeId(String interventionTypeId) {
		this.interventionTypeId = interventionTypeId;
	}
	public String getInterventionReceivedId() {
		return interventionReceivedId;
	}
	public void setInterventionReceivedId(String interventionReceivedId) {
		this.interventionReceivedId = interventionReceivedId;
	}
	public String getInterventionStatusId() {
		return interventionStatusId;
	}
	public void setInterventionStatusId(String interventionStatusId) {
		this.interventionStatusId = interventionStatusId;
	}
	public String getInterventionLeaveReasonId() {
		return interventionLeaveReasonId;
	}
	public void setInterventionLeaveReasonId(String interventionLeaveReasonId) {
		this.interventionLeaveReasonId = interventionLeaveReasonId;
	}
	public String getInterventionStartDt() {
		return interventionStartDt;
	}
	public void setInterventionStartDt(String interventionStartDt) {
		this.interventionStartDt = interventionStartDt;
	}
	public String getInterventionEndDt() {
		return interventionEndDt;
	}
	public void setInterventionEndDt(String interventionEndDt) {
		this.interventionEndDt = interventionEndDt;
	}
	public String getEmployerSizeId() {
		return employerSizeId;
	}
	public void setEmployerSizeId(String employerSizeId) {
		this.employerSizeId = employerSizeId;
	}
	public String getPlacementTypeId() {
		return placementTypeId;
	}
	public void setPlacementTypeId(String placementTypeId) {
		this.placementTypeId = placementTypeId;
	}
	public String getWorkingHoursId() {
		return workingHoursId;
	}
	public void setWorkingHoursId(String workingHoursId) {
		this.workingHoursId = workingHoursId;
	}
	public String getMentoringLocationId() {
		return mentoringLocationId;
	}
	public void setMentoringLocationId(String mentoringLocationId) {
		this.mentoringLocationId = mentoringLocationId;
	}
	public String getMentoringHoursId() {
		return mentoringHoursId;
	}
	public void setMentoringHoursId(String mentoringHoursId) {
		this.mentoringHoursId = mentoringHoursId;
	}
	public String getInterventionProfessionId() {
		return interventionProfessionId;
	}
	public void setInterventionProfessionId(String interventionProfessionId) {
		this.interventionProfessionId = interventionProfessionId;
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
	public String getShortTermService1ServiceReceivedId() {
		return shortTermService1ServiceReceivedId;
	}
	public void setShortTermService1ServiceReceivedId(String shortTermService1ServiceReceivedId) {
		this.shortTermService1ServiceReceivedId = shortTermService1ServiceReceivedId;
	}
	public String getShortTermService1EntryDt() {
		return shortTermService1EntryDt;
	}
	public void setShortTermService1EntryDt(String shortTermService1EntryDt) {
		this.shortTermService1EntryDt = shortTermService1EntryDt;
	}
	public String getShortTermService2ServiceReceivedid() {
		return shortTermService2ServiceReceivedid;
	}
	public void setShortTermService2ServiceReceivedid(String shortTermService2ServiceReceivedid) {
		this.shortTermService2ServiceReceivedid = shortTermService2ServiceReceivedid;
	}
	public String getShortTermService2EntryDt() {
		return shortTermService2EntryDt;
	}
	public void setShortTermService2EntryDt(String shortTermService2EntryDt) {
		this.shortTermService2EntryDt = shortTermService2EntryDt;
	}
	public String getShortTermService3ServiceReceivedId() {
		return shortTermService3ServiceReceivedId;
	}
	public void setShortTermService3ServiceReceivedId(String shortTermService3ServiceReceivedId) {
		this.shortTermService3ServiceReceivedId = shortTermService3ServiceReceivedId;
	}
	public String getShortTermService3EntryDt() {
		return shortTermService3EntryDt;
	}
	public void setShortTermService3EntryDt(String shortTermService3EntryDt) {
		this.shortTermService3EntryDt = shortTermService3EntryDt;
	}
	public String getShortTermService4ServiceReceivedId() {
		return shortTermService4ServiceReceivedId;
	}
	public void setShortTermService4ServiceReceivedId(String shortTermService4ServiceReceivedId) {
		this.shortTermService4ServiceReceivedId = shortTermService4ServiceReceivedId;
	}
	public String getShortTermService4EntryDt() {
		return shortTermService4EntryDt;
	}
	public void setShortTermService4EntryDt(String shortTermService4EntryDt) {
		this.shortTermService4EntryDt = shortTermService4EntryDt;
	}
	public String getShortTermService5ServiceReceivedId() {
		return shortTermService5ServiceReceivedId;
	}
	public void setShortTermService5ServiceReceivedId(String shortTermService5ServiceReceivedId) {
		this.shortTermService5ServiceReceivedId = shortTermService5ServiceReceivedId;
	}
	public String getShortTermService5Entrydt() {
		return shortTermService5Entrydt;
	}
	public void setShortTermService5Entrydt(String shortTermService5Entrydt) {
		this.shortTermService5Entrydt = shortTermService5Entrydt;
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
	public String getTranslationLanguagefromid() {
		return translationLanguagefromid;
	}
	public void setTranslationLanguagefromid(String translationLanguagefromid) {
		this.translationLanguagefromid = translationLanguagefromid;
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
	public String getInterpretationLanguagefromId() {
		return interpretationLanguagefromId;
	}
	public void setInterpretationLanguagefromId(String interpretationLanguagefromId) {
		this.interpretationLanguagefromId = interpretationLanguagefromId;
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
	public String getCompleteHoursSpentNo() {
		return completeHoursSpentNo;
	}
	public void setCompleteHoursSpentNo(String completeHoursSpentNo) {
		this.completeHoursSpentNo = completeHoursSpentNo;
	}
	public String getCompleteMinutesSpentno() {
		return completeMinutesSpentno;
	}
	public void setCompleteMinutesSpentno(String completeMinutesSpentno) {
		this.completeMinutesSpentno = completeMinutesSpentno;
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
        return String.format("EmploymentTemplate[id=%d, name='%s']%n", id, updateRecordId);
    }
}
