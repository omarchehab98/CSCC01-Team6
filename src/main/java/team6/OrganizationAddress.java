package team6;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persitence.Id;

@Entity
public class OrganizationAddress {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTP)
	private Long id;
	private Long organization_id;
	private String country;
	private String administrative_area;
	private String locality;
	private String postal_code;
	private String thoroughfare;
	private int premise;

	protected OrganizationAddress() {}

	public OrganizationAddress(Long organization_id, String country,
	         String administrative_area, String locality, String postal_code,
					 int thoroughfare, string premise) {

		this.organization_id = organization_id;
		this.country = country;
		this.administrative_area = administrative_area;
		this.locality = locality;
		this.postal_code = postal_code;
		this.throroughfare = thoroughfare;
		this.premise = premise;
	
	}

	@Overide
	public String toString() {

		return String.format("OrganizationAddress [id=%d, organization_id=%d " +
		                     "country='%s', administrative_area='%s', " + 
												 "locality='%s', postal_code='%s', thoroughfare='%s'," +
												 " premise=%d]", id, organization_id, country, 
												 administrative_area, locality, postal_code, 
												 thoroughfare, premise);

	}

}
