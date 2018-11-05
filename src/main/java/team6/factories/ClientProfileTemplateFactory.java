package team6.factories;

import java.util.HashMap;
import java.util.function.Consumer;

import team6.models.ClientProfileTemplate;
import team6.models.Organization;
import team6.models.Template;

public class ClientProfileTemplateFactory {
	public static Template build(HashMap<String, String> row, Organization organization) {
		ClientProfileTemplate clientProfileTemplate = new ClientProfileTemplate();
		HashMap<String, Consumer<String>> setters = new HashMap<String, Consumer<String>>();

		setters.put("processing_details", clientProfileTemplate::setProcessingDetails);
		setters.put("client_validation_type_id", clientProfileTemplate::setClientValidationTypeId);
		setters.put("client_validation_id", clientProfileTemplate::setClientValidationId);
		setters.put("client_birth_dt", clientProfileTemplate::setClientBirthDt);
		setters.put("phone_no", clientProfileTemplate::setPhoneNo);
		setters.put("email_txt_ind", clientProfileTemplate::setEmailTxtInd);
		setters.put("email_txt", clientProfileTemplate::setEmailTxt);
		setters.put("street_no", clientProfileTemplate::setStreetNo);
		setters.put("street_nme", clientProfileTemplate::setStreetNme);
		setters.put("street_type_id", clientProfileTemplate::setStreetTypeId);
		setters.put("street_direction_id", clientProfileTemplate::setStreetDirectionId);
		setters.put("unit_txt", clientProfileTemplate::setUnitTxt);
		setters.put("city_txt", clientProfileTemplate::setCityTxt);
		setters.put("province_id", clientProfileTemplate::setProvinceId);
		setters.put("postal_txt", clientProfileTemplate::setPostalTxt);
		setters.put("official_language_id", clientProfileTemplate::setOfficialLanguageId);
		setters.put("consent_ind", clientProfileTemplate::setConsentInd);

		for (String column : row.keySet()) {
			if (setters.containsKey(column)) {
				setters.get(column).accept(row.get(column));
			} else {
				throw new IllegalArgumentException();
			}
		}

		clientProfileTemplate.setOrganization(organization);

		return clientProfileTemplate;
	}

}
