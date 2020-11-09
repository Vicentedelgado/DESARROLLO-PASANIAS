package spi.mvc.com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spi.mvc.com.data.model.AsignacionEquipo;
import spi.mvc.com.data.model.RRHH;

@Repository
public interface AsignacionEquipoRepository extends CrudRepository<AsignacionEquipo, Long> {

	@Query("select e from AsignacionEquipo e where e.idusuario.cedula=:cedula")
	List<AsignacionEquipo> filtrocedula(String cedula);
	@Query("select e from AsignacionEquipo e where e.idusuario=:idusuario")
	List<AsignacionEquipo> filtrousuario(RRHH idusuario);
	@Query("select e from AsignacionEquipo e where e.idasignacionequipo=:idasignacionequipo")
	List<AsignacionEquipo> filtrarnum(Long idasignacionequipo);

}
