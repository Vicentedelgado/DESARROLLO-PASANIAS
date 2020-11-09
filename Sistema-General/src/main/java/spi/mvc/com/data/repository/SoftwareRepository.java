package spi.mvc.com.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spi.mvc.com.data.model.Software;

@Repository
public interface SoftwareRepository extends CrudRepository<Software, Long> {

}
