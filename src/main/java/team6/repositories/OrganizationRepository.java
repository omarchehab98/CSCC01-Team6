package team6.repositories;

import org.springframework.data.repository.CrudRepository;

import team6.models.Organization;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface OrganizationRepository extends CrudRepository<Organization, Long> {

}
