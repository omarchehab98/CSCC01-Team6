package team6.repositories;

import org.springframework.data.repository.CrudRepository;

import team6.models.Organization;
import team6.models.Query;

public interface QueryRepository extends CrudRepository<Query, Long>{

}
