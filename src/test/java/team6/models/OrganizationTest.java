package team6.models;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrganizationTest {
    @Test
    public void organizationTest() throws Exception {
        String name = "Ontario Council of Agencies Serving Immigrants";
        Organization organization = new Organization(null, name);
        assertThat(organization.getName(), equalTo(name));
    }
}
