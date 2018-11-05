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

import team6.repositories.ClientProfileTemplateRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientProfileTemplateTest {
	@Autowired
    private TestEntityManager entityManager;
	@Autowired
    private ClientProfileTemplateRepository clientProfileTemplateRepository;

	@Test
	public void clientProfileTemplateTest() throws Exception {
		String city = "Toronto";
		ClientProfileTemplate clientProfileTemplate = new ClientProfileTemplate();
		clientProfileTemplate.setCityTxt(city);
		assertThat(clientProfileTemplate.getCityTxt(), equalTo(city));
	}

	@Test
	public void clientProfileTemplateOrganizationTest() throws Exception {
		Organization organization = new Organization();
		ClientProfileTemplate clientProfileTemplate = new ClientProfileTemplate();
		clientProfileTemplate.setOrganization(organization);
		assertThat(clientProfileTemplate.getOrganization(), equalTo(organization));
	}

	@Test
	public void findById() throws Exception {
		String city = "Toronto";
		ClientProfileTemplate clientProfileTemplate = new ClientProfileTemplate();
		clientProfileTemplate.setCityTxt(city);
		entityManager.persist(clientProfileTemplate);
        entityManager.flush();

        Optional<ClientProfileTemplate> found = clientProfileTemplateRepository.findById(clientProfileTemplate.getId());

        assertTrue(found.isPresent());
        assertThat(found.get().getCityTxt(),
                equalTo(clientProfileTemplate.getCityTxt()));
	}

}
