package spi.mvc.com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spi.mvc.com.data.model.InformeEquipo;

@Repository
public interface InformeEquipoRepository extends CrudRepository<InformeEquipo, Long> {
	@Query("select e from InformeEquipo e where e.idinformeequipo=:idinformeequipo")
	List<InformeEquipo> filtrarnum(Long idinformeequipo);
}
