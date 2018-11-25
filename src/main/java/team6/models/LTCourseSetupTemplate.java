package team6.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LTCourseSetupTemplate extends Template {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@FriendlyName("Processing Details")
	private String processingDetails;
	@FriendlyName("Update Record ID")
	private String updateRecordId;
	@FriendlyName("Course Code")
	private String courseCd;
	@FriendlyName("Notes")
	private String courseNote;
	@FriendlyName("Course Held On An Ongoing Basis")
	private String heldOnOngoingBasisInd;
	@FriendlyName("Official Language of  Course")
	private String officialLanguageId;
	@FriendlyName("Format of Training Provided")
	private String trainingFormatId;
	@FriendlyName("Classes Held At")
	private String trainingLocationId;
	@FriendlyName("In-Person Instruction (%)")
	private String inpersonInstructionPercentage;
	@FriendlyName("Online/Distance Instruction (%)")
	private String onlineDistancePercentage;
	@FriendlyName("Total Number of Spots in Course")
	private String totalSpotsNum;
	@FriendlyName("Number of IRCC-Funded Spots in Course")
	private String totalCicFundedSpotsNum;
	@FriendlyName("New Students Can Enrol in the Course")
	private String courseEnrolmentId;
	@FriendlyName("Support Services Available for Client in this Course")
	private String supportAvailableInd;
	@FriendlyName("Care for Newcomer Children")
	private String availableChildmindingInd;
	@FriendlyName("Transportation")
	private String availableTransportationInd;
	@FriendlyName("Provisions for Disabilities")
	private String availableSupportDisabilityInd;
	@FriendlyName("Course Start Date (YYYY-MM-DD)")
	private String startDt;
	@FriendlyName("Course End Date (YYYY-MM-DD)")
	private String endDt;
	@FriendlyName("Schedule: Morning")
	private String courseScheduleMorning;
	@FriendlyName("Schedule: Afternoon")
	private String courseScheduleAfternoon;
	@FriendlyName("Schedule: Evening")
	private String courseScheduleEvening;
	@FriendlyName("Schedule: Weekends")
	private String courseScheduleWeekends;
	@FriendlyName("Schedule: Anytime")
	private String courseScheduleAnytime;
	@FriendlyName("Schedule: Online")
	private String courseScheduleOnline;
	@FriendlyName("Instructional Hours Per Class")
	private String instructionalHoursPerClass;
	@FriendlyName("Classes Per Week")
	private String classesPerWeek;
	@FriendlyName("Weeks of Instruction")
	private String weeksOfInstruction;
	@FriendlyName("Weeks of Instruction Per Year")
	private String weeksOfInstructionPerYear;
	@FriendlyName("Dominant Focus of the Course")
	private String courseDominantFocusId;
	@FriendlyName("Course Directed at a Specific Target Group")
	private String targetGroupInd;
	@FriendlyName("Children (0-14 yrs)")
	private String targetGroupChildren;
	@FriendlyName("Youth (15-24 yrs)")
	private String targetGroupYouth;
	@FriendlyName("Senior")
	private String targetGroupSenior;
	@FriendlyName("Gender-specific")
	private String targetGroupGenderSpecific;
	@FriendlyName("Refugees")
	private String targetGroupRefugees;
	@FriendlyName("Official language minorities")
	private String targetGroupOfficialLanguageMinorities;
	@FriendlyName("Ethnic/cultural/linguistic group")
	private String targetGroupEthnic;
	@FriendlyName("Deaf or Hard of Hearing")
	private String targetGroupDeaf;
	@FriendlyName("Blind or Partially Sighted")
	private String targetGroupBlind;
	@FriendlyName("Clients with other impairments (physical, mental)")
	private String targetGroupOtherImpairments;
	@FriendlyName("Lesbian, Gay, Bisexual, Transgender, Queer (LGBTQ)")
	private String targetGroupLGBTQ;
	@FriendlyName("Families/Parents")
	private String targetGroupFamilies;
	@FriendlyName("Clients with international training in a regulated profession")
	private String targetGroupTrainingInRegulatedProfession;
	@FriendlyName("Clients with international training in a regulated trade")
	private String targetGroupTrainingInRegulatedTrade;
	@FriendlyName("Materials Used in Course")
	private String courseMaterialInd;
	@FriendlyName("Citizenship preparation")
	private String courseMaterialCitizenshipResource;
	@FriendlyName("PBLA language companion")
	private String courseMaterialPBLALanguageCompanion;
	@FriendlyName("Contact Name")
	private String contactNme;
	@FriendlyName("Street Number")
	private String streetNo;
	@FriendlyName("Street Name")
	private String streetNme;
	@FriendlyName("Street Type")
	private String streetTypeId;
	@FriendlyName("Street Direction")
	private String streetDirectionId;
	@FriendlyName("Unit/Suite")
	private String unitTxt;
	@FriendlyName("Province")
	private String provinceId;
	@FriendlyName("City")
	private String cityId;
	@FriendlyName("Postal Code (A#A#A#)")
	private String postalCd;
	@FriendlyName("Telephone Number (###-###-####)")
	private String phoneNo;
	@FriendlyName("Telephone Extension")
	private String phoneExtNo;
	@FriendlyName("Email Address")
	private String emailTxt;
	@FriendlyName("Listening Skill Level 1")
	private String languageCLBSkillListening1;
	@FriendlyName("Listening Skill Level 2")
	private String languageCLBSkillListening2;
	@FriendlyName("Listening Skill Level 3")
	private String languageCLBSkillListening3;
	@FriendlyName("Listening Skill Level 4")
	private String languageCLBSkillListening4;
	@FriendlyName("Listening Skill Level 5")
	private String languageCLBSkillListening5;
	@FriendlyName("Listening Skill Level 6")
	private String languageCLBSkillListening6;
	@FriendlyName("Listening Skill Level 7")
	private String languageCLBSkillListening7;
	@FriendlyName("Listening Skill Level 8")
	private String languageCLBSkillListening8;
	@FriendlyName("Listening Skill Level 9")
	private String languageCLBSkillListening9;
	@FriendlyName("Listening Skill Level 10")
	private String languageCLBSkillListening10;
	@FriendlyName("Listening Skill Level 11")
	private String languageCLBSkillListening11;
	@FriendlyName("Listening Skill Level 12")
	private String languageCLBSkillListening12;
	@FriendlyName("Speaking Skill Level 1")
	private String languageCLBSkillSpeaking1;
	@FriendlyName("Speaking Skill Level 2")
	private String languageCLBSkillSpeaking2;
	@FriendlyName("Speaking Skill Level 3")
	private String languageCLBSkillSpeaking3;
	@FriendlyName("Speaking Skill Level 4")
	private String languageCLBSkillSpeaking4;
	@FriendlyName("Speaking Skill Level 5")
	private String languageCLBSkillSpeaking5;
	@FriendlyName("Speaking Skill Level 6")
	private String languageCLBSkillSpeaking6;
	@FriendlyName("Speaking Skill Level 7")
	private String languageCLBSkillSpeaking7;
	@FriendlyName("Speaking Skill Level 8")
	private String languageCLBSkillSpeaking8;
	@FriendlyName("Speaking Skill Level 9")
	private String languageCLBSkillSpeaking9;
	@FriendlyName("Speaking Skill Level 10")
	private String languageCLBSkillSpeaking10;
	@FriendlyName("Speaking Skill Level 11")
	private String languageCLBSkillSpeaking11;
	@FriendlyName("Speaking Skill Level 12")
	private String languageCLBSkillSpeaking12;
	@FriendlyName("Reading Skill Level 1")
	private String languageCLBSkillReading1;
	@FriendlyName("Reading Skill Level 2")
	private String languageCLBSkillReading2;
	@FriendlyName("Reading Skill Level 3")
	private String languageCLBSkillReading3;
	@FriendlyName("Reading Skill Level 4")
	private String languageCLBSkillReading4;
	@FriendlyName("Reading Skill Level 5")
	private String languageCLBSkillReading5;
	@FriendlyName("Reading Skill Level 6")
	private String languageCLBSkillReading6;
	@FriendlyName("Reading Skill Level 7")
	private String languageCLBSkillReading7;
	@FriendlyName("Reading Skill Level 8")
	private String languageCLBSkillReading8;
	@FriendlyName("Reading Skill Level 9")
	private String languageCLBSkillReading9;
	@FriendlyName("Reading Skill Level 10")
	private String languageCLBSkillReading10;
	@FriendlyName("Reading Skill Level 11")
	private String languageCLBSkillReading11;
	@FriendlyName("Reading Skill Level 12")
	private String languageCLBSkillReading12;
	@FriendlyName("Reading Skill Level 13")
	private String languageCLBSkillReading13;
	@FriendlyName("Reading Skill Level 14")
	private String languageCLBSkillReading14;
	@FriendlyName("Reading Skill Level 15")
	private String languageCLBSkillReading15;
	@FriendlyName("Reading Skill Level 16")
	private String languageCLBSkillReading16;
	@FriendlyName("Reading Skill Level 17")
	private String languageCLBSkillReading17;
	@FriendlyName("Writing Skill Level 1")
	private String languageCLBSkillWriting1;
	@FriendlyName("Writing Skill Level 2")
	private String languageCLBSkillWriting2;
	@FriendlyName("Writing Skill Level 3")
	private String languageCLBSkillWriting3;
	@FriendlyName("Writing Skill Level 4")
	private String languageCLBSkillWriting4;
	@FriendlyName("Writing Skill Level 5")
	private String languageCLBSkillWriting5;
	@FriendlyName("Writing Skill Level 6")
	private String languageCLBSkillWriting6;
	@FriendlyName("Writing Skill Level 7")
	private String languageCLBSkillWriting7;
	@FriendlyName("Writing Skill Level 8")
	private String languageCLBSkillWriting8;
	@FriendlyName("Writing Skill Level 9")
	private String languageCLBSkillWriting9;
	@FriendlyName("Writing Skill Level 10")
	private String languageCLBSkillWriting10;
	@FriendlyName("Writing Skill Level 11")
	private String languageCLBSkillWriting11;
	@FriendlyName("Writing Skill Level 12")
	private String languageCLBSkillWriting12;
	@FriendlyName("Writing Skill Level 13")
	private String languageCLBSkillWriting13;
	@FriendlyName("Writing Skill Level 14")
	private String languageCLBSkillWriting14;
	@FriendlyName("Writing Skill Level 15")
	private String languageCLBSkillWriting15;
	@FriendlyName("Writing Skill Level 16")
	private String languageCLBSkillWriting16;
	@FriendlyName("Writing Skill Level 17")
	private String languageCLBSkillWriting17;
	@ManyToOne
    @JoinColumn(name = "organizationId")
    private Organization organization;

	public LTCourseSetupTemplate() {}

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
	
	public String getCourseCd() {
		return courseCd;
	}

	public void setCourseCd(String courseCd) {
		this.courseCd= courseCd;
	}
	
	public String getCourseNote() {
		return courseNote;
	}

	public void setCourseNote(String courseNote) {
		this.courseNote= courseNote;
	}
	
	public String getHeldOnOngoingBasisInd() {
		return heldOnOngoingBasisInd;
	}

	public void setHeldOnOngoingBasisInd(String heldOnOngoingBasisInd) {
		this.heldOnOngoingBasisInd= heldOnOngoingBasisInd;
	}
	
	public String getOfficialLanguageId() {
		return officialLanguageId;
	}

	public void setOfficialLanguageId(String officialLanguageId) {
		this.officialLanguageId= officialLanguageId;
	}
	
	public String getTrainingFormatId() {
		return trainingFormatId;
	}

	public void setTrainingFormatId(String trainingFormatId) {
		this.trainingFormatId= trainingFormatId;
	}
	
	public String getTrainingLocationId() {
		return trainingLocationId;
	}

	public void setTrainingLocationId(String trainingLocationId) {
		this.trainingLocationId= trainingLocationId;
	}
	
	public String getInpersonInstructionPercentage() {
		return inpersonInstructionPercentage;
	}

	public void setInpersonInstructionPercentage(String inpersonInstructionPercentage) {
		this.inpersonInstructionPercentage= inpersonInstructionPercentage;
	}
	
	public String getOnlineDistancePercentage() {
		return onlineDistancePercentage;
	}

	public void setOnlineDistancePercentage(String onlineDistancePercentage) {
		this.onlineDistancePercentage= onlineDistancePercentage;
	}
	
	public String getTotalSpotsNum() {
		return totalSpotsNum;
	}

	public void setTotalSpotsNum(String totalSpotsNum) {
		this.totalSpotsNum= totalSpotsNum;
	}
	
	public String getTotalCicFundedSpotsNum() {
		return totalCicFundedSpotsNum;
	}

	public void setTotalCicFundedSpotsNum(String totalCicFundedSpotsNum) {
		this.totalCicFundedSpotsNum= totalCicFundedSpotsNum;
	}
	
	public String getCourseEnrolmentId() {
		return courseEnrolmentId;
	}

	public void setCourseEnrolmentId(String courseEnrolmentId) {
		this.courseEnrolmentId= courseEnrolmentId;
	}
	
	public String getSupportAvailableInd() {
		return supportAvailableInd;
	}

	public void setSupportAvailableInd(String supportAvailableInd) {
		this.supportAvailableInd= supportAvailableInd;
	}	
	
	public String getAvailableChildmindingInd() {
		return availableChildmindingInd;
	}

	public void setAvailableChildmindingInd(String availableChildmindingInd) {
		this.availableChildmindingInd= availableChildmindingInd;
	}
	
	public String getAvailableTransportationInd() {
		return availableTransportationInd;
	}

	public void setAvailableTransportationInd(String availableTransportationInd) {
		this.availableTransportationInd= availableTransportationInd;
	}
	
	public String getAvailableSupportDisabilityInd() {
		return availableSupportDisabilityInd;
	}

	public void setAvailableSupportDisabilityInd(String availableSupportDisabilityInd) {
		this.availableSupportDisabilityInd= availableSupportDisabilityInd;
	}
	
	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt= startDt;
	}
	
	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt= endDt;
	}
	
	public String getCourseScheduleMorning() {
		return courseScheduleMorning;
	}

	public void setCourseScheduleMorning(String courseScheduleMorning) {
		this.courseScheduleMorning= courseScheduleMorning;
	}
	
	public String getCourseScheduleAfternoon() {
		return courseScheduleAfternoon;
	}

	public void setCourseScheduleAfternoon(String courseScheduleAfternoon) {
		this.courseScheduleAfternoon= courseScheduleAfternoon;
	}
	
	public String getCourseScheduleEvening() {
		return courseScheduleEvening;
	}

	public void setCourseScheduleEvening(String courseScheduleEvening) {
		this.courseScheduleEvening= courseScheduleEvening;
	}
	
	public String getCourseScheduleWeekends() {
		return courseScheduleWeekends;
	}

	public void setCourseScheduleWeekends(String courseScheduleWeekends) {
		this.courseScheduleWeekends= courseScheduleWeekends;
	}
	
	public String getCourseScheduleAnytime() {
		return courseScheduleAnytime;
	}

	public void setCourseScheduleAnytime(String courseScheduleAnytime) {
		this.courseScheduleAnytime= courseScheduleAnytime;
	}
	
	public String getCourseScheduleOnline() {
		return courseScheduleOnline;
	}

	public void setCourseScheduleOnline(String courseScheduleOnline) {
		this.courseScheduleOnline= courseScheduleOnline;
	}
	
	public String getInstructionalHoursPerClass() {
		return instructionalHoursPerClass;
	}

	public void setInstructionalHoursPerClass(String instructionalHoursPerClass) {
		this.instructionalHoursPerClass= instructionalHoursPerClass;
	}
	
	public String getClassesPerWeek() {
		return classesPerWeek;
	}

	public void setClassesPerWeek(String classesPerWeek) {
		this.classesPerWeek= classesPerWeek;
	}
	
	public String getWeeksOfInstruction() {
		return weeksOfInstruction;
	}

	public void setWeeksOfInstruction(String weeksOfInstruction) {
		this.weeksOfInstruction= weeksOfInstruction;
	}
	
	public String getWeeksOfInstructionPerYear() {
		return weeksOfInstructionPerYear;
	}

	public void setWeeksOfInstructionPerYear(String weeksOfInstructionPerYear) {
		this.weeksOfInstructionPerYear= weeksOfInstructionPerYear;
	}
	
	public String getCourseDominantFocusId() {
		return courseDominantFocusId;
	}

	public void setCourseDominantFocusId(String courseDominantFocusId) {
		this.courseDominantFocusId= courseDominantFocusId;
	}
	
	public String getTargetGroupInd() {
		return targetGroupInd;
	}

	public void setTargetGroupInd(String targetGroupInd) {
		this.targetGroupInd= targetGroupInd;
	}
	
	public String getTargetGroupChildren() {
		return targetGroupChildren;
	}

	public void setTargetGroupChildren(String targetGroupChildren) {
		this.targetGroupChildren= targetGroupChildren;
	}
	
	public String getTargetGroupYouth() {
		return targetGroupYouth;
	}

	public void setTargetGroupYouth(String targetGroupYouth) {
		this.targetGroupYouth= targetGroupYouth;
	}
	
	public String getTargetGroupSenior() {
		return targetGroupSenior;
	}

	public void setTargetGroupSenior(String targetGroupSenior) {
		this.targetGroupSenior= targetGroupSenior;
	}
	
	public String getTargetGroupGenderSpecific() {
		return targetGroupGenderSpecific;
	}

	public void setTargetGroupGenderSpecific(String targetGroupGenderSpecific) {
		this.targetGroupGenderSpecific= targetGroupGenderSpecific;
	}
	
	public String getTargetGroupRefugees() {
		return targetGroupRefugees;
	}

	public void setTargetGroupRefugees(String targetGroupRefugees) {
		this.targetGroupRefugees= targetGroupRefugees;
	}
	
	public String getTargetGroupOfficialLanguageMinorities() {
		return targetGroupOfficialLanguageMinorities;
	}

	public void setTargetGroupOfficialLanguageMinorities(String targetGroupOfficialLanguageMinorities) {
		this.targetGroupOfficialLanguageMinorities= targetGroupOfficialLanguageMinorities;
	}
	
	public String getTargetGroupEthnic() {
		return targetGroupEthnic;
	}

	public void setTargetGroupEthnic(String targetGroupEthnic) {
		this.targetGroupEthnic= targetGroupEthnic;
	}
	
	public String getTargetGroupDeaf() {
		return targetGroupDeaf;
	}

	public void setTargetGroupDeaf(String targetGroupDeaf) {
		this.targetGroupDeaf= targetGroupDeaf;
	}
	
	public String getTargetGroupBlind() {
		return targetGroupBlind;
	}

	public void setTargetGroupBlind(String targetGroupBlind) {
		this.targetGroupBlind= targetGroupBlind;
	}
	
	public String getTargetGroupOtherImpairments() {
		return targetGroupOtherImpairments;
	}

	public void setTargetGroupOtherImpairments(String targetGroupOtherImpairments) {
		this.targetGroupOtherImpairments= targetGroupOtherImpairments;
	}
	
	public String getTargetGroupLGBTQ() {
		return targetGroupLGBTQ;
	}

	public void setTargetGroupLGBTQ(String targetGroupLGBTQ) {
		this.targetGroupLGBTQ= targetGroupLGBTQ;
	}
	
	public String getTargetGroupFamilies() {
		return targetGroupFamilies;
	}

	public void setTargetGroupFamilies(String targetGroupFamilies) {
		this.targetGroupFamilies= targetGroupFamilies;
	}
	
	public String getTargetGroupTrainingInRegulatedProfession() {
		return targetGroupTrainingInRegulatedProfession;
	}

	public void setTargetGroupTrainingInRegulatedProfession(String targetGroupTrainingInRegulatedProfession) {
		this.targetGroupTrainingInRegulatedProfession= targetGroupTrainingInRegulatedProfession;
	}
	
	public String getTargetGroupTrainingInRegulatedTrade() {
		return targetGroupTrainingInRegulatedTrade;
	}

	public void setTargetGroupTrainingInRegulatedTrade(String targetGroupTrainingInRegulatedTrade) {
		this.targetGroupTrainingInRegulatedTrade= targetGroupTrainingInRegulatedTrade;
	}
	
	public String getCourseMaterialInd() {
		return courseMaterialInd;
	}

	public void setCourseMaterialInd(String courseMaterialInd) {
		this.courseMaterialInd= courseMaterialInd;
	}
	
	public String getCourseMaterialCitizenshipResource() {
		return courseMaterialCitizenshipResource;
	}

	public void setCourseMaterialCitizenshipResource(String courseMaterialCitizenshipResource) {
		this.courseMaterialCitizenshipResource= courseMaterialCitizenshipResource;
	}
	
	public String getCourseMaterialPBLALanguageCompanion() {
		return courseMaterialPBLALanguageCompanion;
	}

	public void setCourseMaterialPBLALanguageCompanion(String courseMaterialPBLALanguageCompanion) {
		this.courseMaterialPBLALanguageCompanion= courseMaterialPBLALanguageCompanion;
	}
	
	public String getContactNme() {
		return contactNme;
	}

	public void setContactNme(String contactNme) {
		this.contactNme= contactNme;
	}
	
	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo= streetNo;
	}
	
	public String getStreetNme() {
		return streetNme;
	}

	public void setStreetNme(String streetNme) {
		this.streetNme= streetNme;
	}
	
	public String getStreetTypeId() {
		return streetTypeId;
	}

	public void setStreetTypeId(String streetTypeId) {
		this.streetTypeId= streetTypeId;
	}
	
	public String getStreetDirectionId() {
		return streetDirectionId;
	}

	public void setStreetDirectionId(String streetDirectionId) {
		this.streetDirectionId= streetDirectionId;
	}
	
	public String getUnitTxt() {
		return unitTxt;
	}

	public void setUnitTxt(String unitTxt) {
		this.unitTxt= unitTxt;
	}
	
	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId= provinceId;
	}
	
	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId= cityId;
	}
	
	public String getPostalCd() {
		return postalCd;
	}

	public void setPostalCd(String postalCd) {
		this.postalCd= postalCd;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo= phoneNo;
	}

	public String getPhoneExtNo() {
		return phoneExtNo;
	}

	public void setPhoneExtNo(String phoneExtNo) {
		this.phoneExtNo= phoneExtNo;
	}
	
	public String getEmailTxt() {
		return emailTxt;
	}

	public void setEmailTxt(String emailTxt) {
		this.emailTxt= emailTxt;
	}
	
	public String getLanguageCLBSkillListening1() {
		return languageCLBSkillListening1;
	}

	public void setLanguageCLBSkillListening1(String languageCLBSkillListening1) {
		this.languageCLBSkillListening1= languageCLBSkillListening1;
	}
	
	public String getLanguageCLBSkillListening2() {
		return languageCLBSkillListening2;
	}

	public void setLanguageCLBSkillListening2(String languageCLBSkillListening2) {
		this.languageCLBSkillListening2= languageCLBSkillListening2;
	}
	
	public String getLanguageCLBSkillListening3() {
		return languageCLBSkillListening3;
	}

	public void setLanguageCLBSkillListening3(String languageCLBSkillListening3) {
		this.languageCLBSkillListening3= languageCLBSkillListening3;
	}
	
	public String getLanguageCLBSkillListening4() {
		return languageCLBSkillListening4;
	}

	public void setLanguageCLBSkillListening4(String languageCLBSkillListening4) {
		this.languageCLBSkillListening4= languageCLBSkillListening4;
	}
	
	public String getLanguageCLBSkillListening5() {
		return languageCLBSkillListening5;
	}

	public void setLanguageCLBSkillListening5(String languageCLBSkillListening5) {
		this.languageCLBSkillListening5= languageCLBSkillListening5;
	}
	
	public String getLanguageCLBSkillListening6() {
		return languageCLBSkillListening6;
	}

	public void setLanguageCLBSkillListening6(String languageCLBSkillListening6) {
		this.languageCLBSkillListening6= languageCLBSkillListening6;
	}
	
	public String getLanguageCLBSkillListening7() {
		return languageCLBSkillListening7;
	}

	public void setLanguageCLBSkillListening7(String languageCLBSkillListening7) {
		this.languageCLBSkillListening7= languageCLBSkillListening7;
	}
	
	public String getLanguageCLBSkillListening8() {
		return languageCLBSkillListening8;
	}

	public void setLanguageCLBSkillListening8(String languageCLBSkillListening8) {
		this.languageCLBSkillListening8= languageCLBSkillListening8;
	}
	
	public String getLanguageCLBSkillListening9() {
		return languageCLBSkillListening9;
	}

	public void setLanguageCLBSkillListening9(String languageCLBSkillListening9) {
		this.languageCLBSkillListening9= languageCLBSkillListening9;
	}
	
	public String getLanguageCLBSkillListening10() {
		return languageCLBSkillListening10;
	}

	public void setLanguageCLBSkillListening10(String languageCLBSkillListening10) {
		this.languageCLBSkillListening10= languageCLBSkillListening10;
	}
	
	public String getLanguageCLBSkillListening11() {
		return languageCLBSkillListening11;
	}

	public void setLanguageCLBSkillListening11(String languageCLBSkillListening11) {
		this.languageCLBSkillListening11= languageCLBSkillListening11;
	}
	
	public String getLanguageCLBSkillListening12() {
		return languageCLBSkillListening12;
	}

	public void setLanguageCLBSkillListening12(String languageCLBSkillListening12) {
		this.languageCLBSkillListening12= languageCLBSkillListening12;
	}
	
	public String getLanguageCLBSkillSpeaking1() {
		return languageCLBSkillSpeaking1;
	}

	public void setLanguageCLBSkillSpeaking1(String languageCLBSkillSpeaking1) {
		this.languageCLBSkillSpeaking1= languageCLBSkillSpeaking1;
	}
	
	public String getLanguageCLBSkillSpeaking2() {
		return languageCLBSkillSpeaking2;
	}

	public void setLanguageCLBSkillSpeaking2(String languageCLBSkillSpeaking2) {
		this.languageCLBSkillSpeaking2= languageCLBSkillSpeaking2;
	}
	
	public String getLanguageCLBSkillSpeaking3() {
		return languageCLBSkillSpeaking3;
	}

	public void setLanguageCLBSkillSpeaking3(String languageCLBSkillSpeaking3) {
		this.languageCLBSkillSpeaking3= languageCLBSkillSpeaking3;
	}
	
	public String getLanguageCLBSkillSpeaking4() {
		return languageCLBSkillSpeaking4;
	}

	public void setLanguageCLBSkillSpeaking4(String languageCLBSkillSpeaking4) {
		this.languageCLBSkillSpeaking4= languageCLBSkillSpeaking4;
	}
	
	public String getLanguageCLBSkillSpeaking5() {
		return languageCLBSkillSpeaking5;
	}

	public void setLanguageCLBSkillSpeaking5(String languageCLBSkillSpeaking5) {
		this.languageCLBSkillSpeaking5= languageCLBSkillSpeaking5;
	}
	
	public String getLanguageCLBSkillSpeaking6() {
		return languageCLBSkillSpeaking6;
	}

	public void setLanguageCLBSkillSpeaking6(String languageCLBSkillSpeaking6) {
		this.languageCLBSkillSpeaking6= languageCLBSkillSpeaking6;
	}
	
	public String getLanguageCLBSkillSpeaking7() {
		return languageCLBSkillSpeaking7;
	}

	public void setLanguageCLBSkillSpeaking7(String languageCLBSkillSpeaking7) {
		this.languageCLBSkillSpeaking7= languageCLBSkillSpeaking7;
	}
	
	public String getLanguageCLBSkillSpeaking8() {
		return languageCLBSkillSpeaking8;
	}

	public void setLanguageCLBSkillSpeaking8(String languageCLBSkillSpeaking8) {
		this.languageCLBSkillSpeaking8= languageCLBSkillSpeaking8;
	}
	
	public String getLanguageCLBSkillSpeaking9() {
		return languageCLBSkillSpeaking9;
	}

	public void setLanguageCLBSkillSpeaking9(String languageCLBSkillSpeaking9) {
		this.languageCLBSkillSpeaking9= languageCLBSkillSpeaking9;
	}
	
	public String getLanguageCLBSkillSpeaking10() {
		return languageCLBSkillSpeaking10;
	}

	public void setLanguageCLBSkillSpeaking10(String languageCLBSkillSpeaking10) {
		this.languageCLBSkillSpeaking10= languageCLBSkillSpeaking10;
	}
	
	public String getLanguageCLBSkillSpeaking11() {
		return languageCLBSkillSpeaking11;
	}

	public void setLanguageCLBSkillSpeaking11(String languageCLBSkillSpeaking11) {
		this.languageCLBSkillSpeaking11= languageCLBSkillSpeaking11;
	}
	
	public String getLanguageCLBSkillSpeaking12() {
		return languageCLBSkillSpeaking12;
	}

	public void setLanguageCLBSkillSpeaking12(String languageCLBSkillSpeaking12) {
		this.languageCLBSkillSpeaking12= languageCLBSkillSpeaking12;
	}
	
	public String getLanguageCLBSkillReading1() {
		return languageCLBSkillReading1;
	}

	public void setLanguageCLBSkillReading1(String languageCLBSkillReading1) {
		this.languageCLBSkillReading1= languageCLBSkillReading1;
	}
	
	public String getLanguageCLBSkillReading2() {
		return languageCLBSkillReading2;
	}

	public void setLanguageCLBSkillReading2(String languageCLBSkillReading2) {
		this.languageCLBSkillReading2= languageCLBSkillReading2;
	}
	
	public String getLanguageCLBSkillReading3() {
		return languageCLBSkillReading3;
	}

	public void setLanguageCLBSkillReading3(String languageCLBSkillReading3) {
		this.languageCLBSkillReading3= languageCLBSkillReading3;
	}
	
	public String getLanguageCLBSkillReading4() {
		return languageCLBSkillReading4;
	}

	public void setLanguageCLBSkillReading4(String languageCLBSkillReading4) {
		this.languageCLBSkillReading4= languageCLBSkillReading4;
	}
	
	public String getLanguageCLBSkillReading5() {
		return languageCLBSkillReading5;
	}

	public void setLanguageCLBSkillReading5(String languageCLBSkillReading5) {
		this.languageCLBSkillReading5= languageCLBSkillReading5;
	}
	
	public String getLanguageCLBSkillReading6() {
		return languageCLBSkillReading6;
	}

	public void setLanguageCLBSkillReading6(String languageCLBSkillReading6) {
		this.languageCLBSkillReading6= languageCLBSkillReading6;
	}
	
	public String getLanguageCLBSkillReading7() {
		return languageCLBSkillReading7;
	}

	public void setLanguageCLBSkillReading7(String languageCLBSkillReading7) {
		this.languageCLBSkillReading7= languageCLBSkillReading7;
	}
	
	public String getLanguageCLBSkillReading8() {
		return languageCLBSkillReading8;
	}

	public void setLanguageCLBSkillReading8(String languageCLBSkillReading8) {
		this.languageCLBSkillReading8= languageCLBSkillReading8;
	}
	
	public String getLanguageCLBSkillReading9() {
		return languageCLBSkillReading9;
	}

	public void setLanguageCLBSkillReading9(String languageCLBSkillReading9) {
		this.languageCLBSkillReading9= languageCLBSkillReading9;
	}
	
	public String getLanguageCLBSkillReading10() {
		return languageCLBSkillReading10;
	}

	public void setLanguageCLBSkillReading10(String languageCLBSkillReading10) {
		this.languageCLBSkillReading10= languageCLBSkillReading10;
	}
	
	public String getLanguageCLBSkillReading11() {
		return languageCLBSkillReading11;
	}

	public void setLanguageCLBSkillReading11(String languageCLBSkillReading11) {
		this.languageCLBSkillReading11= languageCLBSkillReading11;
	}
	
	public String getLanguageCLBSkillReading12() {
		return languageCLBSkillReading12;
	}

	public void setLanguageCLBSkillReading12(String languageCLBSkillReading12) {
		this.languageCLBSkillReading12= languageCLBSkillReading12;
	}

	public String getLanguageCLBSkillReading13() {
		return languageCLBSkillReading13;
	}

	public void setLanguageCLBSkillReading13(String languageCLBSkillReading13) {
		this.languageCLBSkillReading13= languageCLBSkillReading13;
	}

	public String getLanguageCLBSkillReading14() {
		return languageCLBSkillReading14;
	}

	public void setLanguageCLBSkillReading14(String languageCLBSkillReading14) {
		this.languageCLBSkillReading14= languageCLBSkillReading14;
	}

	public String getLanguageCLBSkillReading15() {
		return languageCLBSkillReading15;
	}

	public void setLanguageCLBSkillReading15(String languageCLBSkillReading15) {
		this.languageCLBSkillReading15= languageCLBSkillReading15;
	}

	public String getLanguageCLBSkillReading16() {
		return languageCLBSkillReading16;
	}

	public void setLanguageCLBSkillReading16(String languageCLBSkillReading16) {
		this.languageCLBSkillReading16= languageCLBSkillReading16;
	}

	public String getLanguageCLBSkillReading17() {
		return languageCLBSkillReading17;
	}

	public void setLanguageCLBSkillReading17(String languageCLBSkillReading17) {
		this.languageCLBSkillReading17= languageCLBSkillReading17;
	}
	
	public String getLanguageCLBSkillWriting1() {
		return languageCLBSkillWriting1;
	}

	public void setLanguageCLBSkillWriting1(String languageCLBSkillWriting1) {
		this.languageCLBSkillWriting1= languageCLBSkillWriting1;
	}
	
	public String getLanguageCLBSkillWriting2() {
		return languageCLBSkillWriting2;
	}

	public void setLanguageCLBSkillWriting2(String languageCLBSkillWriting2) {
		this.languageCLBSkillWriting2= languageCLBSkillWriting2;
	}
	
	public String getLanguageCLBSkillWriting3() {
		return languageCLBSkillWriting3;
	}

	public void setLanguageCLBSkillWriting3(String languageCLBSkillWriting3) {
		this.languageCLBSkillWriting3= languageCLBSkillWriting3;
	}
	
	public String getLanguageCLBSkillWriting4() {
		return languageCLBSkillWriting4;
	}

	public void setLanguageCLBSkillWriting4(String languageCLBSkillWriting4) {
		this.languageCLBSkillWriting4= languageCLBSkillWriting4;
	}
	
	public String getLanguageCLBSkillWriting5() {
		return languageCLBSkillWriting5;
	}

	public void setLanguageCLBSkillWriting5(String languageCLBSkillWriting5) {
		this.languageCLBSkillWriting5= languageCLBSkillWriting5;
	}
	
	public String getLanguageCLBSkillWriting6() {
		return languageCLBSkillWriting6;
	}

	public void setLanguageCLBSkillWriting6(String languageCLBSkillWriting6) {
		this.languageCLBSkillWriting6= languageCLBSkillWriting6;
	}
	
	public String getLanguageCLBSkillWriting7() {
		return languageCLBSkillWriting7;
	}

	public void setLanguageCLBSkillWriting7(String languageCLBSkillWriting7) {
		this.languageCLBSkillWriting7= languageCLBSkillWriting7;
	}
	
	public String getLanguageCLBSkillWriting8() {
		return languageCLBSkillWriting8;
	}

	public void setLanguageCLBSkillWriting8(String languageCLBSkillWriting8) {
		this.languageCLBSkillWriting8= languageCLBSkillWriting8;
	}
	
	public String getLanguageCLBSkillWriting9() {
		return languageCLBSkillWriting9;
	}

	public void setLanguageCLBSkillWriting9(String languageCLBSkillWriting9) {
		this.languageCLBSkillWriting9= languageCLBSkillWriting9;
	}
	
	public String getLanguageCLBSkillWriting10() {
		return languageCLBSkillWriting10;
	}

	public void setLanguageCLBSkillWriting10(String languageCLBSkillWriting10) {
		this.languageCLBSkillWriting10= languageCLBSkillWriting10;
	}
	
	public String getLanguageCLBSkillWriting11() {
		return languageCLBSkillWriting11;
	}

	public void setLanguageCLBSkillWriting11(String languageCLBSkillWriting11) {
		this.languageCLBSkillWriting11= languageCLBSkillWriting11;
	}
	
	public String getLanguageCLBSkillWriting12() {
		return languageCLBSkillWriting12;
	}

	public void setLanguageCLBSkillWriting12(String languageCLBSkillWriting12) {
		this.languageCLBSkillWriting12= languageCLBSkillWriting12;
	}

	public String getLanguageCLBSkillWriting13() {
		return languageCLBSkillWriting13;
	}

	public void setLanguageCLBSkillWriting13(String languageCLBSkillWriting13) {
		this.languageCLBSkillWriting13= languageCLBSkillWriting13;
	}

	public String getLanguageCLBSkillWriting14() {
		return languageCLBSkillWriting14;
	}

	public void setLanguageCLBSkillWriting14(String languageCLBSkillWriting14) {
		this.languageCLBSkillWriting14= languageCLBSkillWriting14;
	}

	public String getLanguageCLBSkillWriting15() {
		return languageCLBSkillWriting15;
	}

	public void setLanguageCLBSkillWriting15(String languageCLBSkillWriting15) {
		this.languageCLBSkillWriting15= languageCLBSkillWriting15;
	}

	public String getLanguageCLBSkillWriting16() {
		return languageCLBSkillWriting16;
	}

	public void setLanguageCLBSkillWriting16(String languageCLBSkillWriting16) {
		this.languageCLBSkillWriting16= languageCLBSkillWriting16;
	}

	public String getLanguageCLBSkillWriting17() {
		return languageCLBSkillWriting17;
	}

	public void setLanguageCLBSkillWriting17(String languageCLBSkillWriting17) {
		this.languageCLBSkillWriting17= languageCLBSkillWriting17;
	}
	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Override
    public String toString() {
        return String.format("LTCourseSetupTemplate[id=%d]%n", id);
    }

}
