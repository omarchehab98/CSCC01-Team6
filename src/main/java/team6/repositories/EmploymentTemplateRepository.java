package team6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import team6.models.EmploymentTemplate;

public interface EmploymentTemplateRepository extends JpaRepository<EmploymentTemplate, Long> {

}
