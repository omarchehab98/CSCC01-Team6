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

import team6.repositories.LTCourseSetupTemplateRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LTCourseSetUpTemplateTest {
	@Autowired
    private TestEntityManager entityManager;
	@Autowired
    private LTCourseSetupTemplateRepository lTCourseSetupTemplateRepository;

	@Test
	public void clientProfileTemplateTest() throws Exception {
		String heldOnOngoingBasisInd = "Yes";
		LTCourseSetupTemplate lTCourseSetupTemplate = new LTCourseSetupTemplate();
		lTCourseSetupTemplate.setHeldOnOngoingBasisInd(heldOnOngoingBasisInd);
		assertThat(lTCourseSetupTemplate.getHeldOnOngoingBasisInd(), equalTo(heldOnOngoingBasisInd));
	}

	@Test
	public void clientProfileTemplateOrganizationTest() throws Exception {
		Organization organization = new Organization();
		LTCourseSetupTemplate lTCourseSetupTemplate = new LTCourseSetupTemplate();
		lTCourseSetupTemplate.setOrganization(organization);
		assertThat(lTCourseSetupTemplate.getOrganization(), equalTo(organization));
	}

	@Test
	public void findById() throws Exception {
		String heldOnOngoingBasisInd = "Yes";
		LTCourseSetupTemplate lTCourseSetupTemplate = new LTCourseSetupTemplate();
		lTCourseSetupTemplate.setHeldOnOngoingBasisInd(heldOnOngoingBasisInd);
		entityManager.persist(lTCourseSetupTemplate);
        entityManager.flush();

        Optional<LTCourseSetupTemplate> found = lTCourseSetupTemplateRepository.findById(lTCourseSetupTemplate.getId());

        assertTrue(found.isPresent());
        assertThat(found.get().getHeldOnOngoingBasisInd(),
                equalTo(lTCourseSetupTemplate.getHeldOnOngoingBasisInd()));
	}
}
