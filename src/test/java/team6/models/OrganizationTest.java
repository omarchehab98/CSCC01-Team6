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

import team6.repositories.OrganizationRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrganizationTest { 
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private OrganizationRepository organizationRepository;

    @Test
    public void organizationTest() throws Exception {
        String name = "Ontario Council of Agencies Serving Immigrants";
        Organization organization = new Organization(null, name, null, null, null, null, null);
        assertThat(organization.getName(), equalTo(name));
    }

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        String name = "Ontario Council of Agencies Serving Immigrants";
        Organization organization = new Organization(null, name);
        entityManager.persist(organization);
        entityManager.flush();
    
        // when
        Optional<Organization> found = organizationRepository.findById(organization.getId());

        // then
        assertTrue(found.isPresent());
        assertThat(found.get().getName(),
            equalTo(organization.getName()));
    }

}
