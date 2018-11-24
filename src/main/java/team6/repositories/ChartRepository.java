package team6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import team6.models.Chart;

public interface ChartRepository extends JpaRepository<Chart, Long> {

}
