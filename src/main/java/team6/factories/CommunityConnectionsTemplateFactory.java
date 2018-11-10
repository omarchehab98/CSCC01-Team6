package team6.factories;

import java.util.HashMap;
import java.util.function.Consumer;

import team6.models.CommunityConnectionsTemplate;
import team6.models.Organization;
import team6.models.Template;

public class CommunityConnectionsTemplateFactory {
	public static Template build(HashMap<String, String> row, Organization organization) {
		CommunityConnectionsTemplate communityConnectionsTemplate = new CommunityConnectionsTemplate();
		HashMap<String, Consumer<String>> setters = new HashMap<String, Consumer<String>>();

		setters.put("", communityConnectionsTemplate::setProcessingDetails);
		setters.put("", communityConnectionsTemplate::setUpdateRecordId);
		setters.put("", communityConnectionsTemplate::setClientValidationTypeId);
		setters.put("", communityConnectionsTemplate::setClientValidationId);
		setters.put("", communityConnectionsTemplate::setClientBirthDt);
		setters.put("", communityConnectionsTemplate::setPostalCd);
		setters.put("", communityConnectionsTemplate::setServiceLangId);
		setters.put("", communityConnectionsTemplate::setPreferredOfficialLangId);
		setters.put("", communityConnectionsTemplate::setAssessmentReferralId);
		setters.put("", communityConnectionsTemplate::setCommunityActivityId);
		setters.put("", communityConnectionsTemplate::setInstitutionTypeId);
		setters.put("", communityConnectionsTemplate::setEventsTypeAttendedId);
		setters.put("", communityConnectionsTemplate::setServiceTypeId);
		setters.put("", communityConnectionsTemplate::setTopicsServiceId);
		setters.put("", communityConnectionsTemplate::setCommunityServiceId);
		setters.put("", communityConnectionsTemplate::setGroupClientsNoId);
		setters.put("", communityConnectionsTemplate::setVolunteersParticipateInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupSpecificInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupChildrenInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupYouthInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupSeniorInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupGenderInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupRefugeeInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupEthnicInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupHearingInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupVisualInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupLGBTQInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupFamiliesParentsInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupOtherImpairmentsInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupCWITInRegulatedProfessionInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupCWITInRegulatedTradeInd);
		setters.put("", communityConnectionsTemplate::setTargetGroupOfficialLanguageMinoritiesInd);
		setters.put("", communityConnectionsTemplate::setServiceStatusId);
		setters.put("", communityConnectionsTemplate::setCommunityLeaveReasonId);
		setters.put("", communityConnectionsTemplate::setServiceStartDt);
		setters.put("", communityConnectionsTemplate::setServiceEndDt);
		setters.put("", communityConnectionsTemplate::setServiceProjectedEndDt);
		setters.put("", communityConnectionsTemplate::setTrainingReceivedServiceInd);
		setters.put("", communityConnectionsTemplate::setTrainingReceivedComputerInd);
		setters.put("", communityConnectionsTemplate::setTrainingReceivedDocumentInd);
		setters.put("", communityConnectionsTemplate::setTrainingReceivedInterpersonalInd);
		setters.put("", communityConnectionsTemplate::setTrainingReceivedLeadershipInd);
		setters.put("", communityConnectionsTemplate::setTrainingReceivedLifeSkillsInd);
		setters.put("", communityConnectionsTemplate::setTrainingReceivedNumeracyInd);
		setters.put("", communityConnectionsTemplate::setSupportReceivedInd);
		setters.put("", communityConnectionsTemplate::setChildmindingInd);
		setters.put("", communityConnectionsTemplate::setChildmindingNewcomerChildren1ChildmindingAgeId);
		setters.put("", communityConnectionsTemplate::setChildmindingNewcomerChildren1ChildmindingTypeId);
		setters.put("", communityConnectionsTemplate::setChildmindingNewcomerChildren2ChildmindingAgeId);
		setters.put("", communityConnectionsTemplate::setChildmindingNewcomerChildren2ChildmindingTypeId);
		setters.put("", communityConnectionsTemplate::setChildmindingNewcomerChildren3ChildmindingAgeId);
		setters.put("", communityConnectionsTemplate::setChildmindingNewcomerChildren3ChildmindingTypeId);
		setters.put("", communityConnectionsTemplate::setChildmindingNewcomerChildren4ChildmindingAgeId);
		setters.put("", communityConnectionsTemplate::setChildmindingNewcomerChildren4ChildmindingTypeId);
		setters.put("", communityConnectionsTemplate::setChildmindingNewcomerChildren5ChildmindingAgeId);
		setters.put("", communityConnectionsTemplate::setChildmindingNewcomerChildren5ChildmindingTypeId);
		setters.put("", communityConnectionsTemplate::setTransportationInd);
		setters.put("", communityConnectionsTemplate::setSupportDisabilityInd);
		setters.put("", communityConnectionsTemplate::setTranslationInd);
		setters.put("", communityConnectionsTemplate::setTranslationLAndLanguageFromId);
		setters.put("", communityConnectionsTemplate::setTranslationLanguageToId);
		setters.put("", communityConnectionsTemplate::setInterpretationInd);
		setters.put("", communityConnectionsTemplate::setInterpretationLanguageFromId);
		setters.put("", communityConnectionsTemplate::setInterpretationLanguageToId);
		setters.put("", communityConnectionsTemplate::setCounsellingInd);
		setters.put("", communityConnectionsTemplate::setServiceLengthHoursNo);
		setters.put("", communityConnectionsTemplate::setServiceLengthMinutesNo);
		setters.put("", communityConnectionsTemplate::setAssessmentUpdateReasonId);

		for (String column : row.keySet()) {
			if (setters.containsKey(column)) {
				setters.get(column).accept(row.get(column));
			} else {
				throw new IllegalArgumentException();
			}
		}

		communityConnectionsTemplate.setOrganization(organization);

		return communityConnectionsTemplate;
	}
}
