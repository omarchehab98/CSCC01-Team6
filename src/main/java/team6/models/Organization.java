package team6.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;;

@Entity
/**
 * Contains the following attributes: id : Long name : String
 */
public class Organization {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String country;
	private String administrativeArea;
	private String locality;
	private String postalCode;
	private String thoroughfare;
	private String premise;
	@OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
	private Set<NARsTemplate> nARsTemplates;

	@OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
	private Set<ClientProfileTemplate> clientProfileTemplate;

	public Organization() {
	}

	public Organization(Long id, String name, String country, String administrativeArea, String locality,
			String postalCode, String thoroughfare, String premise) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.administrativeArea = administrativeArea;
		this.locality = locality;
		this.postalCode = postalCode;
		this.thoroughfare = thoroughfare;
		this.premise = premise;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param administrativeArea the administrative area to set
	 */
	public void setAdministrativeArea(String administrativeArea) {
		this.administrativeArea = administrativeArea;
	}

	/**
	 * @return the administrative area
	 */
	public String getAdministrativeArea() {
		return administrativeArea;
	}

	/**
	 * @param locality the locality to set
	 */
	public void setLocality(String locality) {
		this.locality = locality;
	}

	/**
	 * @return the locality
	 */
	public String getLocality() {
		return locality;
	}

	/**
	 * @param postalCode the postal code to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the postal code
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param thoroughfare the thoroughfare to set
	 */
	public void setThoroughfare(String thoroughfare) {
		this.thoroughfare = thoroughfare;
	}

	/**
	 * @return the thoroughfare
	 */
	public String getThoroughfare() {
		return thoroughfare;
	}

	/**
	 * @param premise the premise to set
	 */
	public void setPremise(String premise) {
		this.premise = premise;
	}

	/**
	 * @return the premise
	 */
	public String getPremise() {
		return premise;
	}

	public Set<NARsTemplate> getNARsTemplates() {
		return this.nARsTemplates;
	}

	public void setNARsTemplates(Set<NARsTemplate> nARsTemplates) {
		this.nARsTemplates = nARsTemplates;
	}

	public Set<ClientProfileTemplate> getClientProfileTemplate() {
		return this.clientProfileTemplate;
	}

	public void setClientProfileTemplate(Set<ClientProfileTemplate> clientProfileTemplate) {
		this.clientProfileTemplate = clientProfileTemplate;
	}

	@Override
	public String toString() {
		return String.format("Organization [id=%d, name='%s']%n", id, name);
	}
}
