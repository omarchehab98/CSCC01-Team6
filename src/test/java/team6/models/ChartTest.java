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

import team6.repositories.ChartRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ChartTest {
	@Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ChartRepository chartRepository;

    @Test
    public void reportTest() throws Exception {
        String name = "Speakers Per Language";
        Chart chart = new Chart();
        chart.setName(name);
        assertThat(chart.getName(), equalTo(name));
    }

    @Test
    public void whenFindById_thenReturnName() {
        // given
    	String name = "Speakers Per Language";
        Chart chart = new Chart();
        chart.setName(name);
        entityManager.persist(chart);
        entityManager.flush();
    
        // when
        Optional<Chart> found = chartRepository.findById(chart.getId());

        // then
        assertTrue(found.isPresent());
        assertThat(found.get().getName(),
            equalTo(chart.getName()));
    }
}
