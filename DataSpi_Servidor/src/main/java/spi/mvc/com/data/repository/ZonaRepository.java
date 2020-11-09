package spi.mvc.com.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spi.mvc.com.data.model.Zona;

@Repository
public interface ZonaRepository extends CrudRepository<Zona, Long> {

}
