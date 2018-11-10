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

import team6.repositories.CommunityConnectionsTemplateRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommunityConnectionsTemplateTest {
	@Autowired
    private TestEntityManager entityManager;
	@Autowired
    private CommunityConnectionsTemplateRepository communityConnectionsTemplateRepository;

	@Test
	public void narsTemplateTest() throws Exception {
		String preferredLanguage = "French";
		CommunityConnectionsTemplate communityConnectionsTemplate = new CommunityConnectionsTemplate();
		communityConnectionsTemplate.setPreferredOfficialLangId(preferredLanguage);
		assertThat(communityConnectionsTemplate.getPreferredOfficialLangId(), equalTo(preferredLanguage));
	}

	@Test
	public void narsTemplateOrganizationTest() throws Exception {
		Organization organization = new Organization();
		CommunityConnectionsTemplate communityConnectionsTemplate = new CommunityConnectionsTemplate();
		communityConnectionsTemplate.setOrganization(organization);
		assertThat(communityConnectionsTemplate.getOrganization(), equalTo(organization));
	}

	@Test
	public void findById() throws Exception {
		String preferredLanguage = "French";
		CommunityConnectionsTemplate communityConnectionsTemplate = new CommunityConnectionsTemplate();
		communityConnectionsTemplate.setPreferredOfficialLangId(preferredLanguage);
		entityManager.persist(communityConnectionsTemplate);
        entityManager.flush();

        Optional<CommunityConnectionsTemplate> found = communityConnectionsTemplateRepository.findById(communityConnectionsTemplate.getId());
        
        assertTrue(found.isPresent());
        assertThat(found.get().getPreferredOfficialLangId(),
                equalTo(communityConnectionsTemplate.getPreferredOfficialLangId()));
	}
}
