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

import team6.repositories.ChartQueryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ChartQueryTest {
	@Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ChartQueryRepository chartQueryRepository;

    @Test
    public void testChartQuery() throws Exception {
        ChartQuery chartQuery = new ChartQuery();
        entityManager.persist(chartQuery);
        entityManager.flush();

        Optional<ChartQuery> found = chartQueryRepository.findById(chartQuery.getId());

        assertTrue(found.isPresent());
        assertThat(found.get().getId(),
            equalTo(chartQuery.getId()));
    }
}
