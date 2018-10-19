package team6.repositories;

import team6.models.OrganizationAddress;
import org.springframework.data.repository.CrudRepository;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface OrganizationAddressRepository extends CrudRepository<OrganizationAddress, Long> {

}
