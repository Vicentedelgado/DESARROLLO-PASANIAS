package spi.mvc.com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spi.mvc.com.data.model.AsignacionPeriferico;

@Repository
public interface AsignacionPerifericoRepository extends CrudRepository<AsignacionPeriferico, Long> {

	@Query("select e from AsignacionPeriferico e where e.idusuario.cedula=:cedula")
	List<AsignacionPeriferico> filtrarcedula(String cedula);
	@Query("select e from AsignacionPeriferico e where e.idasignacion=:idasignacion")
	List<AsignacionPeriferico> filtrarnum(Long idasignacion);
	
	
}
