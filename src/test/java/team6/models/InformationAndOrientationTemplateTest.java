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

import team6.repositories.InformationAndOrientationTemplateRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InformationAndOrientationTemplateTest {
	@Autowired
    private TestEntityManager entityManager;
	@Autowired
    private InformationAndOrientationTemplateRepository informationAndOrientationTemplateRepository;

	@Test
	public void informationAndOrientationTemplateTest() throws Exception {
		String language = "English";
		InformationAndOrientationTemplate informationAndOrientationTemplate = new InformationAndOrientationTemplate();
		informationAndOrientationTemplate.setServiceLanguageId(language);
		assertThat(informationAndOrientationTemplate.getServiceLanguageId(), equalTo(language));
	}

	@Test
	public void informationAndOrientationTemplateOrganizationTest() throws Exception {
		Organization organization = new Organization();
		InformationAndOrientationTemplate clientProfileTemplate = new InformationAndOrientationTemplate();
		clientProfileTemplate.setOrganization(organization);
		assertThat(clientProfileTemplate.getOrganization(), equalTo(organization));
	}

	@Test
	public void findById() throws Exception {
		String language = "English";
		InformationAndOrientationTemplate informationAndOrientationTemplate = new InformationAndOrientationTemplate();
		informationAndOrientationTemplate.setServiceLanguageId(language);
		entityManager.persist(informationAndOrientationTemplate);
        entityManager.flush();

        Optional<InformationAndOrientationTemplate> found = informationAndOrientationTemplateRepository.findById(informationAndOrientationTemplate.getId());

        assertTrue(found.isPresent());
        assertThat(found.get().getServiceLanguageId(),
                equalTo(informationAndOrientationTemplate.getServiceLanguageId()));
	}
}
