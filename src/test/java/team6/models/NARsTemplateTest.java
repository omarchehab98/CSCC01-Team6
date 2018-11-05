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

import team6.repositories.NARsTemplateRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NARsTemplateTest {
	@Autowired
    private TestEntityManager entityManager;
	@Autowired
    private NARsTemplateRepository narsTemplateRepository;

	@Test
	public void narsTemplateTest() throws Exception {
		String assessmentLanguage = "English";
		NARsTemplate narsTemplate = new NARsTemplate();
		narsTemplate.setAssessmentLanguageId(assessmentLanguage);
		assertThat(narsTemplate.getAssessmentLanguageId(), equalTo(assessmentLanguage));
	}

	@Test
	public void narsTemplateOrganizationTest() throws Exception {
		Organization organization = new Organization();
		NARsTemplate narsTemplate = new NARsTemplate();
		narsTemplate.setOrganization(organization);
		assertThat(narsTemplate.getOrganization(), equalTo(organization));
	}

	@Test
	public void findById() throws Exception {
		String assessmentLanguage = "English";
		NARsTemplate narsTemplate = new NARsTemplate();
		narsTemplate.setAssessmentLanguageId(assessmentLanguage);
		entityManager.persist(narsTemplate);
        entityManager.flush();

        Optional<NARsTemplate> found = narsTemplateRepository.findById(narsTemplate.getId());
        
        assertTrue(found.isPresent());
        assertThat(found.get().getAssessmentLanguageId(),
                equalTo(narsTemplate.getAssessmentLanguageId()));
	}

}
