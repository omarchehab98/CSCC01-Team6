package team6.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LTClientExitTemplate extends Template {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@FriendlyName("Processing Details")
	private String processingDetails;
	@FriendlyName("Update Record ID")
	private String updateRecordId;
	@FriendlyName("Unique Identifier Type")
	private String clientValidationTypeId;
	@FriendlyName("Unique Identifier Value")
	private String clientValidationId;
	@FriendlyName("Client Date of Birth (YYYY-MM-DD)")
	private String clientBirthDt;
	@FriendlyName("Course Code")
	private String courseCd;
	@FriendlyName("Client's Training Status")
	private String trainingStatusId;
	@FriendlyName("Date Client Exited Course (YYYY-MM-DD)")
	private String exitCourseDt;
	@FriendlyName("Reason for Exiting course")
	private String exitCourseReasonId;
	@FriendlyName("Listening CLB Level")
	private String listeningCLBLevelId;
	@FriendlyName("Speaking CLB Level")
	private String speakingCLBLevelId;
	@FriendlyName("Reading CLB Level")
	private String readingCLBLevelId;
	@FriendlyName("Writing CLB Level")
	private String writingCLBLevelId;
	@FriendlyName("Was a Certificate issued to the client?")
	private String certificateIssuedInd;
	@FriendlyName("Listening level indicated on Certificate")
	private String certificateListeningLevelId;
	@FriendlyName("Speaking level indicated on Certificate")
	private String certificateSpeakingLevelId;
	@FriendlyName("Support services received")
	private String supportReceivedInd;
	@FriendlyName("Care for newcomer children")
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
	@FriendlyName("Provisions for disabilities")
	private String supportDisabilityInd;
	@FriendlyName("Translation")
	private String translationInd;
	@FriendlyName("Translation language Between")
	private String translationLanguageFromId;
	@FriendlyName("Translation language And")
	private String translationLanguageToId;
	@FriendlyName("Interpretation")
	private String interpretationInd;
	@FriendlyName("Between")
	private String interpretationLanguageFromId;
	@FriendlyName("And")
	private String interpretationLanguageToId;
	@FriendlyName("Crisis Counselling")
	private String counsellingInd;
	@FriendlyName("Reason for update")
	private String assessmentUpdateReasonId;
	@ManyToOne
	@JoinColumn(name = "organizationId")
	@FriendlyName("Organization")
    private Organization organization;

	public LTClientExitTemplate() {}

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
		this.updateRecordId= updateRecordId;
	}

	public String getClientValidationTypeId() {
		return clientValidationTypeId;
	}

	public void setClientValidationTypeId(String clientValidationTypeId) {
		this.clientValidationTypeId= clientValidationTypeId;
	}

	public String getClientValidationId() {
		return clientValidationId;
	}

	public void setClientValidationId(String clientValidationId) {
		this.clientValidationId= clientValidationId;
	}

	public String getClientBirthDt() {
		return clientBirthDt;
	}

	public void setClientBirthDt(String clientBirthDt) {
		this.clientBirthDt= clientBirthDt;
	}

	public String getCourseCd() {
		return courseCd;
	}

	public void setCourseCd(String courseCd) {
		this.courseCd= courseCd;
	}
	
	public String getTrainingStatusId() {
		return trainingStatusId;
	}

	public void setTrainingStatusId(String trainingStatusId) {
		this.trainingStatusId= trainingStatusId;
	}
	
	public String getExitCourseDt() {
		return exitCourseDt;
	}

	public void setExitCourseDt(String exitCourseDt) {
		this.exitCourseDt= exitCourseDt;
	}
	
	public String getExitCourseReasonId() {
		return exitCourseReasonId;
	}

	public void setExitCourseReasonId(String exitCourseReasonId) {
		this.exitCourseReasonId= exitCourseReasonId;
	}
	
	public String getListeningCLBLevelId() {
		return listeningCLBLevelId;
	}

	public void setListeningCLBLevelId(String listeningCLBLevelId) {
		this.listeningCLBLevelId= listeningCLBLevelId;
	}
	
	public String getSpeakingCLBLevelId() {
		return speakingCLBLevelId;
	}

	public void setSpeakingCLBLevelId(String speakingCLBLevelId) {
		this.speakingCLBLevelId= speakingCLBLevelId;
	}
	
	public String getReadingCLBLevelId() {
		return readingCLBLevelId;
	}

	public void setReadingCLBLevelId(String readingCLBLevelId) {
		this.readingCLBLevelId= readingCLBLevelId;
	}
	
	public String getWritingCLBLevelId() {
		return writingCLBLevelId;
	}

	public void setWritingCLBLevelId(String writingCLBLevelId) {
		this.writingCLBLevelId= writingCLBLevelId;
	}
	
	public String getCertificateIssuedInd() {
		return certificateIssuedInd;
	}

	public void setCertificateIssuedInd(String certificateIssuedInd) {
		this.certificateIssuedInd= certificateIssuedInd;
	}
	
	public String getCertificateListeningLevelId() {
		return certificateListeningLevelId;
	}

	public void setCertificateListeningLevelId(String certificateListeningLevelId) {
		this.certificateListeningLevelId= certificateListeningLevelId;
	}
	
	public String getCertificateSpeakingLevelId() {
		return certificateSpeakingLevelId;
	}

	public void setCertificateSpeakingLevelId(String certificateSpeakingLevelId) {
		this.certificateSpeakingLevelId= certificateSpeakingLevelId;
	}

	public String getSupportReceivedInd() {
		return supportReceivedInd;
	}

	public void setSupportReceivedInd(String supportReceivedInd) {
		this.supportReceivedInd= supportReceivedInd;
	}

	public String getChildmindingInd() {
		return childmindingInd;
	}

	public void setChildmindingInd(String childmindingInd) {
		this.childmindingInd= childmindingInd;
	}

	public String getChildmindingNewcomerChildren1ChildmindingAgeId() {
		return childmindingNewcomerChildren1ChildmindingAgeId;
	}

	public void setChildmindingNewcomerChildren1ChildmindingAgeId(String childmindingNewcomerChildren1ChildmindingAgeId) {
		this.childmindingNewcomerChildren1ChildmindingAgeId= childmindingNewcomerChildren1ChildmindingAgeId;
	}

	public String getChildmindingNewcomerChildren1ChildmindingTypeId() {
		return childmindingNewcomerChildren1ChildmindingTypeId;
	}

	public void setChildmindingNewcomerChildren1ChildmindingTypeId(String childmindingNewcomerChildren1ChildmindingTypeId) {
		this.childmindingNewcomerChildren1ChildmindingTypeId= childmindingNewcomerChildren1ChildmindingTypeId;
	}

	public String getChildmindingNewcomerChildren2ChildmindingAgeId() {
		return childmindingNewcomerChildren2ChildmindingAgeId;
	}

	public void setChildmindingNewcomerChildren2ChildmindingAgeId(String childmindingNewcomerChildren2ChildmindingAgeId) {
		this.childmindingNewcomerChildren2ChildmindingAgeId= childmindingNewcomerChildren2ChildmindingAgeId;
	}

	public String getChildmindingNewcomerChildren2ChildmindingTypeId() {
		return childmindingNewcomerChildren2ChildmindingTypeId;
	}

	public void setChildmindingNewcomerChildren2ChildmindingTypeId(String childmindingNewcomerChildren2ChildmindingTypeId) {
		this.childmindingNewcomerChildren2ChildmindingTypeId= childmindingNewcomerChildren2ChildmindingTypeId;
	}
	public String getChildmindingNewcomerChildren3ChildmindingAgeId() {
		return childmindingNewcomerChildren3ChildmindingAgeId;
	}

	public void setChildmindingNewcomerChildren3ChildmindingAgeId(String childmindingNewcomerChildren3ChildmindingAgeId) {
		this.childmindingNewcomerChildren3ChildmindingAgeId= childmindingNewcomerChildren3ChildmindingAgeId;
	}

	public String getChildmindingNewcomerChildren3ChildmindingTypeId() {
		return childmindingNewcomerChildren3ChildmindingTypeId;
	}

	public void setChildmindingNewcomerChildren3ChildmindingTypeId(String childmindingNewcomerChildren3ChildmindingTypeId) {
		this.childmindingNewcomerChildren3ChildmindingTypeId= childmindingNewcomerChildren3ChildmindingTypeId;
	}
	public String getChildmindingNewcomerChildren4ChildmindingAgeId() {
		return childmindingNewcomerChildren4ChildmindingAgeId;
	}

	public void setChildmindingNewcomerChildren4ChildmindingAgeId(String childmindingNewcomerChildren4ChildmindingAgeId) {
		this.childmindingNewcomerChildren4ChildmindingAgeId= childmindingNewcomerChildren4ChildmindingAgeId;
	}

	public String getChildmindingNewcomerChildren4ChildmindingTypeId() {
		return childmindingNewcomerChildren4ChildmindingTypeId;
	}

	public void setChildmindingNewcomerChildren4ChildmindingTypeId(String childmindingNewcomerChildren4ChildmindingTypeId) {
		this.childmindingNewcomerChildren4ChildmindingTypeId= childmindingNewcomerChildren4ChildmindingTypeId;
	}
	public String getChildmindingNewcomerChildren5ChildmindingAgeId() {
		return childmindingNewcomerChildren5ChildmindingAgeId;
	}

	public void setChildmindingNewcomerChildren5ChildmindingAgeId(String childmindingNewcomerChildren5ChildmindingAgeId) {
		this.childmindingNewcomerChildren5ChildmindingAgeId= childmindingNewcomerChildren5ChildmindingAgeId;
	}

	public String getChildmindingNewcomerChildren5ChildmindingTypeId() {
		return childmindingNewcomerChildren5ChildmindingTypeId;
	}

	public void setChildmindingNewcomerChildren5ChildmindingTypeId(String childmindingNewcomerChildren5ChildmindingTypeId) {
		this.childmindingNewcomerChildren5ChildmindingTypeId= childmindingNewcomerChildren5ChildmindingTypeId;
	}

	public String getTransportationInd() {
		return transportationInd;
	}

	public void setTransportationInd(String transportationInd) {
		this.transportationInd= transportationInd;
	}

	public String getSupportDisabilityInd() {
		return supportDisabilityInd;
	}

	public void setSupportDisabilityInd(String supportDisabilityInd) {
		this.supportDisabilityInd= supportDisabilityInd;
	}

	public String getTranslationInd() {
		return translationInd;
	}

	public void setTranslationInd(String translationInd) {
		this.translationInd= translationInd;
	}

	public String getTranslationLanguageFromId() {
		return translationLanguageFromId;
	}

	public void setTranslationLanguageFromId(String translationLanguageFromId) {
		this.translationLanguageFromId= translationLanguageFromId;
	}

	public String getTranslationLanguageToId() {
		return translationLanguageToId;
	}

	public void setTranslationLanguageToId(String translationLanguageToId) {
		this.translationLanguageToId= translationLanguageToId;
	}

	public String getInterpretationInd() {
		return interpretationInd;
	}

	public void setInterpretationInd(String interpretationInd) {
		this.interpretationInd= interpretationInd;
	}

	public String getInterpretationLanguageFromId() {
		return interpretationLanguageFromId;
	}

	public void setInterpretationLanguageFromId(String interpretationLanguageFromId) {
		this.interpretationLanguageFromId= interpretationLanguageFromId;
	}

	public String getInterpretationLanguageToId() {
		return interpretationLanguageToId;
	}

	public void setInterpretationLanguageToId(String interpretationLanguageToId) {
		this.interpretationLanguageToId= interpretationLanguageToId;
	}

	public String getCounsellingInd() {
		return counsellingInd;
	}

	public void setCounsellingInd(String counsellingInd) {
		this.counsellingInd= counsellingInd;
	}

	public String getAssessmentUpdateReasonId() {
		return assessmentUpdateReasonId;
	}

	public void setAssessmentUpdateReasonId(String assessmentUpdateReasonId) {
		this.assessmentUpdateReasonId= assessmentUpdateReasonId;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Override
    public String toString() {
        return String.format("LTClientEnrolTemplate[id=%d, name='%s']%n", id, clientValidationId);
    }

}
