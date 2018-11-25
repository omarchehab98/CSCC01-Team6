package team6.models;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import team6.repositories.EmploymentTemplateRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmploymentTemplateTest {
	@Autowired
    private TestEntityManager entityManager;
	@Autowired
    private EmploymentTemplateRepository employmentTemplateRepository;

	@Test
	public void employmentTemplateTest() throws Exception {
		String postalCd = "HOH OHO";
		EmploymentTemplate employmentTemplate = new EmploymentTemplate();
		employmentTemplate.setPostalCd(postalCd);
		assertThat(employmentTemplate.getPostalCd(), equalTo(postalCd));
	}

	@Test
	public void employmentTemplateOrganizationTest() throws Exception {
		Organization organization = new Organization();
		EmploymentTemplate employmentTemplate = new EmploymentTemplate();
		employmentTemplate.setOrganization(organization);
		assertThat(employmentTemplate.getOrganization(), equalTo(organization));
	}

	@Test
	public void findById() throws Exception {
		String postalCd = "HOH OHO";
		EmploymentTemplate employmentTemplate = new EmploymentTemplate();
		employmentTemplate.setPostalCd(postalCd);
		entityManager.persist(employmentTemplate);
        entityManager.flush();

        Optional<EmploymentTemplate> found = employmentTemplateRepository.findById(employmentTemplate.getId());

        assertTrue(found.isPresent());
        assertThat(found.get().getPostalCd(),
                equalTo(employmentTemplate.getPostalCd()));
	}

}
