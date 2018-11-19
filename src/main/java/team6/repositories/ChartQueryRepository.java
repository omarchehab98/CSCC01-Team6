package team6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import team6.models.ChartQuery;

public interface ChartQueryRepository extends JpaRepository<ChartQuery, Long> {

}
