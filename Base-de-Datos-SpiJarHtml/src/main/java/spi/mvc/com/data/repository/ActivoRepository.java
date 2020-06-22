package spi.mvc.com.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spi.mvc.com.data.model.Activo;

@Repository
public interface ActivoRepository extends CrudRepository<Activo, Long> {

}
