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

import team6.repositories.LTClientEnrolTemplateRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LTClientEnrolTemplateTest {
	@Autowired
    private TestEntityManager entityManager;
	@Autowired
    private LTClientEnrolTemplateRepository lTClientEnrolTemplateRepository;

	@Test
	public void clientProfileTemplateTest() throws Exception {
		String course = "Numeracy";
		LTClientEnrolTemplate lTClientEnrolTemplate = new LTClientEnrolTemplate();
		lTClientEnrolTemplate.setCourseCd(course);
		assertThat(lTClientEnrolTemplate.getCourseCd(), equalTo(course));
	}

	@Test
	public void clientProfileTemplateOrganizationTest() throws Exception {
		Organization organization = new Organization();
		LTClientEnrolTemplate lTClientEnrolTemplate = new LTClientEnrolTemplate();
		lTClientEnrolTemplate.setOrganization(organization);
		assertThat(lTClientEnrolTemplate.getOrganization(), equalTo(organization));
	}

	@Test
	public void findById() throws Exception {
		String course = "Numeracy";
		LTClientEnrolTemplate lTClientEnrolTemplate = new LTClientEnrolTemplate();
		lTClientEnrolTemplate.setCourseCd(course);
		entityManager.persist(lTClientEnrolTemplate);
        entityManager.flush();

        Optional<LTClientEnrolTemplate> found = lTClientEnrolTemplateRepository.findById(lTClientEnrolTemplate.getId());

        assertTrue(found.isPresent());
        assertThat(found.get().getCourseCd(),
                equalTo(lTClientEnrolTemplate.getCourseCd()));
	}
}
