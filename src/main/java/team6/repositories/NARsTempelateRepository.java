package team6.repositories;

import org.springframework.data.repository.CrudRepository;

import team6.models.NARsTemplate;

public interface NARsTempelateRepository extends TemplateRepositoryInterface, CrudRepository<NARsTemplate, Long>{

}
