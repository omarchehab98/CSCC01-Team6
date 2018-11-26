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

import team6.repositories.LTClientExitTemplateRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LTClientExitTemplateTest {
	@Autowired
    private TestEntityManager entityManager;
	@Autowired
    private LTClientExitTemplateRepository lTClientExitTemplateRepository;

	@Test
	public void clientProfileTemplateTest() throws Exception {
		String ExitCourseReason = "Completed";
		LTClientExitTemplate lTClientExitTemplate = new LTClientExitTemplate();
		lTClientExitTemplate.setExitCourseReasonId(ExitCourseReason);
		assertThat(lTClientExitTemplate.getExitCourseReasonId(), equalTo(ExitCourseReason));
	}

	@Test
	public void clientProfileTemplateOrganizationTest() throws Exception {
		Organization organization = new Organization();
		LTClientExitTemplate lTClientExitTemplate = new LTClientExitTemplate();
		lTClientExitTemplate.setOrganization(organization);
		assertThat(lTClientExitTemplate.getOrganization(), equalTo(organization));
	}

	@Test
	public void findById() throws Exception {
		String ExitCourseReason = "Completed";
		LTClientExitTemplate lTClientExitTemplate = new LTClientExitTemplate();
		lTClientExitTemplate.setExitCourseReasonId(ExitCourseReason);
		entityManager.persist(lTClientExitTemplate);
        entityManager.flush();

        Optional<LTClientExitTemplate> found = lTClientExitTemplateRepository.findById(lTClientExitTemplate.getId());

        assertTrue(found.isPresent());
        assertThat(found.get().getExitCourseReasonId(),
                equalTo(lTClientExitTemplate.getExitCourseReasonId()));
	}
}
