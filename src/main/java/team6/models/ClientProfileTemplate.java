package team6.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ClientProfileTemplate extends Template {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@FriendlyName("Processing Details")
	private String processingDetails;
	@FriendlyName("Unique Identifier")
	private String clientValidationTypeId;
	@FriendlyName("Unique Identifier Value")
	private String clientValidationId;
	@FriendlyName("Date of Birth (YYYY-MM-DD)")
	private String clientBirthDt;
	@FriendlyName("Phone Number")
	private String phoneNo;
	@FriendlyName("Does the Client Have an Email Address")
	private String emailTxtInd;
	@FriendlyName("Email Address")
	private String emailTxt;
	@FriendlyName("Street Number")
	private String streetNo;
	@FriendlyName("Street Name")
	private String streetNme;
	@FriendlyName("Street Type")
	private String streetTypeId;
	@FriendlyName("Street Direction")
	private String streetDirectionId;
	@FriendlyName("Unit/Suite/Apt")
	private String unitTxt;
	@FriendlyName("City")
	private String cityTxt;
	@FriendlyName("Province")
	private String provinceId;
	@FriendlyName("Postal Code")
	private String postalTxt;
	@FriendlyName("Official Language of Preference")
	private String officialLanguageId;
	@FriendlyName("Consent for Future Research/Consultation")
	private String consentInd;
	@ManyToOne
    @JoinColumn(name = "organizationId")
    private Organization organization;

	public ClientProfileTemplate() {}

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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailTxtInd() {
		return emailTxtInd;
	}

	public void setEmailTxtInd(String emailTxtInd) {
		this.emailTxtInd = emailTxtInd;
	}

	public String getEmailTxt() {
		return emailTxt;
	}

	public void setEmailTxt(String emailTxt) {
		this.emailTxt = emailTxt;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getStreetNme() {
		return streetNme;
	}

	public void setStreetNme(String streetNme) {
		this.streetNme = streetNme;
	}

	public String getStreetTypeId() {
		return streetTypeId;
	}

	public void setStreetTypeId(String streetTypeId) {
		this.streetTypeId = streetTypeId;
	}

	public String getStreetDirectionId() {
		return streetDirectionId;
	}

	public void setStreetDirectionId(String streetDirectionId) {
		this.streetDirectionId = streetDirectionId;
	}

	public String getUnitTxt() {
		return unitTxt;
	}

	public void setUnitTxt(String unitTxt) {
		this.unitTxt = unitTxt;
	}

	public String getCityTxt() {
		return cityTxt;
	}

	public void setCityTxt(String cityTxt) {
		this.cityTxt = cityTxt;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getPostalTxt() {
		return postalTxt;
	}

	public void setPostalTxt(String postalTxt) {
		this.postalTxt = postalTxt;
	}

	public String getOfficialLanguageId() {
		return officialLanguageId;
	}

	public void setOfficialLanguageId(String officialLanguageId) {
		this.officialLanguageId = officialLanguageId;
	}

	public String getConsentInd() {
		return consentInd;
	}

	public void setConsentInd(String consentInd) {
		this.consentInd = consentInd;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Override
    public String toString() {
        return String.format("ClientProfileTemplate[id=%d, name='%s']%n", id, clientValidationId);
    }

}
