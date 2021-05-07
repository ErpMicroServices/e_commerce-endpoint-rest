package org.erpmicroservices.e_commerce.endpoint.rest.repositories;

import org.erpmicroservices.e_commerce.endpoint.rest.models.UserLogin;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface UserLoginRepository extends PagingAndSortingRepository<UserLogin, UUID> {

}
