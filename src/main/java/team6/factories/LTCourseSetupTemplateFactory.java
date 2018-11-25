package team6.factories;

import java.util.HashMap;
import java.util.function.Consumer;

import team6.models.LTCourseSetupTemplate;
import team6.models.Organization;
import team6.models.Template;

public class LTCourseSetupTemplateFactory {
	public static Template build(HashMap<String, String> row, Organization organization) {
		LTCourseSetupTemplate ltCourseSetupTemplate= new LTCourseSetupTemplate();
		HashMap<String, Consumer<String>> setters = new HashMap<String, Consumer<String>>();

		setters.put("processing_details", ltCourseSetupTemplate::setProcessingDetails);
		setters.put("update_record_id", ltCourseSetupTemplate::setUpdateRecordId);
		setters.put("course_cd", ltCourseSetupTemplate::setCourseCd);
		setters.put("course_note", ltCourseSetupTemplate::setCourseNote);
		setters.put("held_on_ongoing_basis_ind", ltCourseSetupTemplate::setHeldOnOngoingBasisInd);
		setters.put("official_language_id", ltCourseSetupTemplate::setOfficialLanguageId);
		setters.put("training_format_id", ltCourseSetupTemplate::setTrainingFormatId);
		setters.put("training_location_id", ltCourseSetupTemplate::setTrainingLocationId);
		setters.put("inperson_instruction_percentage", ltCourseSetupTemplate::setInpersonInstructionPercentage);
		setters.put("online_distance_percentage", ltCourseSetupTemplate::setOnlineDistancePercentage);
		setters.put("total_spots_num", ltCourseSetupTemplate::setTotalSpotsNum);
		setters.put("total_cic_funded_spots_num", ltCourseSetupTemplate::setTotalCicFundedSpotsNum);
		setters.put("course_enrolment_id", ltCourseSetupTemplate::setCourseEnrolmentId);
		setters.put("support_available_ind", ltCourseSetupTemplate::setSupportAvailableInd);
		setters.put("available_childminding_ind", ltCourseSetupTemplate::setAvailableChildmindingInd);
		setters.put("available_transportation_ind", ltCourseSetupTemplate::setAvailableTransportationInd);
		setters.put("available_support_disability_ind", ltCourseSetupTemplate::setAvailableSupportDisabilityInd);
		setters.put("start_dt", ltCourseSetupTemplate::setStartDt);
		setters.put("end_dt", ltCourseSetupTemplate::setEndDt);
		setters.put("course_schedule_morning", ltCourseSetupTemplate::setCourseScheduleMorning);
		setters.put("course_schedule_afternoon", ltCourseSetupTemplate::setCourseScheduleAfternoon);
		setters.put("course_schedule_evening", ltCourseSetupTemplate::setCourseScheduleEvening);
		setters.put("course_schedule_weekends", ltCourseSetupTemplate::setCourseScheduleWeekends);
		setters.put("course_schedule_anytime", ltCourseSetupTemplate::setCourseScheduleAnytime);
		setters.put("course_schedule_online", ltCourseSetupTemplate::setCourseScheduleOnline);
		setters.put("instructional_hours_per_class", ltCourseSetupTemplate::setInstructionalHoursPerClass);
		setters.put("classes_per_week", ltCourseSetupTemplate::setClassesPerWeek);
		setters.put("weeks_of_instruction", ltCourseSetupTemplate::setWeeksOfInstruction);
		setters.put("weeks_of_instruction_per_year", ltCourseSetupTemplate::setWeeksOfInstructionPerYear);
		setters.put("course_dominant_focus_id", ltCourseSetupTemplate::setCourseDominantFocusId);
		setters.put("target_group_ind", ltCourseSetupTemplate::setTargetGroupInd);
		setters.put("target_group_children", ltCourseSetupTemplate::setTargetGroupChildren);
		setters.put("target_group_youth", ltCourseSetupTemplate::setTargetGroupYouth);
		setters.put("target_group_senior", ltCourseSetupTemplate::setTargetGroupSenior);
		setters.put("target_group_gender_specific", ltCourseSetupTemplate::setTargetGroupGenderSpecific);
		setters.put("target_group_refugees", ltCourseSetupTemplate::setTargetGroupRefugees);
		setters.put("target_group_official_language_minorities", ltCourseSetupTemplate::setTargetGroupOfficialLanguageMinorities);
		setters.put("target_group_ethnic", ltCourseSetupTemplate::setTargetGroupEthnic);
		setters.put("target_group_deaf", ltCourseSetupTemplate::setTargetGroupDeaf);
		setters.put("target_group_blind", ltCourseSetupTemplate::setTargetGroupBlind);
		setters.put("target_group_other_impairments", ltCourseSetupTemplate::setTargetGroupOtherImpairments);
		setters.put("target_group_LGBTQ", ltCourseSetupTemplate::setTargetGroupLGBTQ);
		setters.put("target_group_families", ltCourseSetupTemplate::setTargetGroupFamilies);
		setters.put("target_group_training_in_regulated_profession", ltCourseSetupTemplate::setTargetGroupTrainingInRegulatedProfession);
		setters.put("target_group_training_in_regulated_trade", ltCourseSetupTemplate::setTargetGroupTrainingInRegulatedTrade);
		setters.put("course_material_ind", ltCourseSetupTemplate::setCourseMaterialInd);
		setters.put("course_material_citizenship_resource", ltCourseSetupTemplate::setCourseMaterialCitizenshipResource);
		setters.put("course_material_PBLA_language_companion", ltCourseSetupTemplate::setCourseMaterialPBLALanguageCompanion);
		setters.put("contact_nme", ltCourseSetupTemplate::setContactNme);
		setters.put("street_no", ltCourseSetupTemplate::setStreetNo);
		setters.put("street_nme", ltCourseSetupTemplate::setStreetNme);
		setters.put("street_type_id", ltCourseSetupTemplate::setStreetTypeId);
		setters.put("street_direction_id", ltCourseSetupTemplate::setStreetDirectionId);
		setters.put("unit_txt", ltCourseSetupTemplate::setUnitTxt);
		setters.put("province_id", ltCourseSetupTemplate::setProvinceId);
		setters.put("city_id", ltCourseSetupTemplate::setCityId);
		setters.put("postal_cd", ltCourseSetupTemplate::setPostalCd);
		setters.put("phone_no", ltCourseSetupTemplate::setPhoneNo);
		setters.put("phone_ext_no", ltCourseSetupTemplate::setPhoneExtNo);
		setters.put("email_txt", ltCourseSetupTemplate::setEmailTxt);
		setters.put("language_CLB_skill_listening_1", ltCourseSetupTemplate::setLanguageCLBSkillListening1);
		setters.put("language_CLB_skill_listening_2", ltCourseSetupTemplate::setLanguageCLBSkillListening2);
		setters.put("language_CLB_skill_listening_3", ltCourseSetupTemplate::setLanguageCLBSkillListening3);
		setters.put("language_CLB_skill_listening_4", ltCourseSetupTemplate::setLanguageCLBSkillListening4);
		setters.put("language_CLB_skill_listening_5", ltCourseSetupTemplate::setLanguageCLBSkillListening5);
		setters.put("language_CLB_skill_listening_6", ltCourseSetupTemplate::setLanguageCLBSkillListening6);
		setters.put("language_CLB_skill_listening_7", ltCourseSetupTemplate::setLanguageCLBSkillListening7);
		setters.put("language_CLB_skill_listening_8", ltCourseSetupTemplate::setLanguageCLBSkillListening8);
		setters.put("language_CLB_skill_listening_9", ltCourseSetupTemplate::setLanguageCLBSkillListening9);
		setters.put("language_CLB_skill_listening_10", ltCourseSetupTemplate::setLanguageCLBSkillListening10);
		setters.put("language_CLB_skill_listening_11", ltCourseSetupTemplate::setLanguageCLBSkillListening11);
		setters.put("language_CLB_skill_listening_12", ltCourseSetupTemplate::setLanguageCLBSkillListening12);
		setters.put("language_CLB_skill_speaking_1", ltCourseSetupTemplate::setLanguageCLBSkillSpeaking1);
		setters.put("language_CLB_skill_speaking_2", ltCourseSetupTemplate::setLanguageCLBSkillSpeaking2);
		setters.put("language_CLB_skill_speaking_3", ltCourseSetupTemplate::setLanguageCLBSkillSpeaking3);
		setters.put("language_CLB_skill_speaking_4", ltCourseSetupTemplate::setLanguageCLBSkillSpeaking4);
		setters.put("language_CLB_skill_speaking_5", ltCourseSetupTemplate::setLanguageCLBSkillSpeaking5);
		setters.put("language_CLB_skill_speaking_6", ltCourseSetupTemplate::setLanguageCLBSkillSpeaking6);
		setters.put("language_CLB_skill_speaking_7", ltCourseSetupTemplate::setLanguageCLBSkillSpeaking7);
		setters.put("language_CLB_skill_speaking_8", ltCourseSetupTemplate::setLanguageCLBSkillSpeaking8);
		setters.put("language_CLB_skill_speaking_9", ltCourseSetupTemplate::setLanguageCLBSkillSpeaking9);
		setters.put("language_CLB_skill_speaking_10", ltCourseSetupTemplate::setLanguageCLBSkillSpeaking10);
		setters.put("language_CLB_skill_speaking_11", ltCourseSetupTemplate::setLanguageCLBSkillSpeaking11);
		setters.put("language_CLB_skill_speaking_12", ltCourseSetupTemplate::setLanguageCLBSkillSpeaking12);
		setters.put("language_CLB_skill_reading_1", ltCourseSetupTemplate::setLanguageCLBSkillReading1);
		setters.put("language_CLB_skill_reading_2", ltCourseSetupTemplate::setLanguageCLBSkillReading2);
		setters.put("language_CLB_skill_reading_3", ltCourseSetupTemplate::setLanguageCLBSkillReading3);
		setters.put("language_CLB_skill_reading_4", ltCourseSetupTemplate::setLanguageCLBSkillReading4);
		setters.put("language_CLB_skill_reading_5", ltCourseSetupTemplate::setLanguageCLBSkillReading5);
		setters.put("language_CLB_skill_reading_6", ltCourseSetupTemplate::setLanguageCLBSkillReading6);
		setters.put("language_CLB_skill_reading_7", ltCourseSetupTemplate::setLanguageCLBSkillReading7);
		setters.put("language_CLB_skill_reading_8", ltCourseSetupTemplate::setLanguageCLBSkillReading8);
		setters.put("language_CLB_skill_reading_9", ltCourseSetupTemplate::setLanguageCLBSkillReading9);
		setters.put("language_CLB_skill_reading_10", ltCourseSetupTemplate::setLanguageCLBSkillReading10);
		setters.put("language_CLB_skill_reading_11", ltCourseSetupTemplate::setLanguageCLBSkillReading11);
		setters.put("language_CLB_skill_reading_12", ltCourseSetupTemplate::setLanguageCLBSkillReading12);
		setters.put("language_CLB_skill_reading_13", ltCourseSetupTemplate::setLanguageCLBSkillReading13);
		setters.put("language_CLB_skill_reading_14", ltCourseSetupTemplate::setLanguageCLBSkillReading14);
		setters.put("language_CLB_skill_reading_15", ltCourseSetupTemplate::setLanguageCLBSkillReading15);
		setters.put("language_CLB_skill_reading_16", ltCourseSetupTemplate::setLanguageCLBSkillReading16);
		setters.put("language_CLB_skill_reading_17", ltCourseSetupTemplate::setLanguageCLBSkillReading17);
		setters.put("language_CLB_skill_writing_1", ltCourseSetupTemplate::setLanguageCLBSkillWriting1);
		setters.put("language_CLB_skill_writing_2", ltCourseSetupTemplate::setLanguageCLBSkillWriting2);
		setters.put("language_CLB_skill_writing_3", ltCourseSetupTemplate::setLanguageCLBSkillWriting3);
		setters.put("language_CLB_skill_writing_4", ltCourseSetupTemplate::setLanguageCLBSkillWriting4);
		setters.put("language_CLB_skill_writing_5", ltCourseSetupTemplate::setLanguageCLBSkillWriting5);
		setters.put("language_CLB_skill_writing_6", ltCourseSetupTemplate::setLanguageCLBSkillWriting6);
		setters.put("language_CLB_skill_writing_7", ltCourseSetupTemplate::setLanguageCLBSkillWriting7);
		setters.put("language_CLB_skill_writing_8", ltCourseSetupTemplate::setLanguageCLBSkillWriting8);
		setters.put("language_CLB_skill_writing_9", ltCourseSetupTemplate::setLanguageCLBSkillWriting9);
		setters.put("language_CLB_skill_writing_10", ltCourseSetupTemplate::setLanguageCLBSkillWriting10);
		setters.put("language_CLB_skill_writing_11", ltCourseSetupTemplate::setLanguageCLBSkillWriting11);
		setters.put("language_CLB_skill_writing_12", ltCourseSetupTemplate::setLanguageCLBSkillWriting12);
		setters.put("language_CLB_skill_writing_13", ltCourseSetupTemplate::setLanguageCLBSkillWriting13);
		setters.put("language_CLB_skill_writing_14", ltCourseSetupTemplate::setLanguageCLBSkillWriting14);
		setters.put("language_CLB_skill_writing_15", ltCourseSetupTemplate::setLanguageCLBSkillWriting15);
		setters.put("language_CLB_skill_writing_16", ltCourseSetupTemplate::setLanguageCLBSkillWriting16);
		setters.put("language_CLB_skill_writing_17", ltCourseSetupTemplate::setLanguageCLBSkillWriting17);



		for (String column : row.keySet()) {
			if (setters.containsKey(column)) {
				setters.get(column).accept(row.get(column));
			} else {
				throw new IllegalArgumentException();
			}
		}

		ltCourseSetupTemplate.setOrganization(organization);

		return ltCourseSetupTemplate;
	}

}
