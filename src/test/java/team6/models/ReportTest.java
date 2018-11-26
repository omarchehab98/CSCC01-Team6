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

import team6.repositories.ReportRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReportTest {
	@Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ReportRepository reportRepository;

    @Test
    public void reportTest() throws Exception {
        String name = "number of enlish speakers by id";
        Report report = new Report();
        report.setName(name);
        assertThat(report.getName(), equalTo(name));
    }

    @Test
    public void whenFindById_thenReturnName() {
        // given
    	String name = "number of enlish speakers by id";
        Report report = new Report();
        report.setName(name);
        entityManager.persist(report);
        entityManager.flush();
    
        // when
        Optional<Report> found = reportRepository.findById(report.getId());

        // then
        assertTrue(found.isPresent());
        assertThat(found.get().getName(),
            equalTo(report.getName()));
    }
}
