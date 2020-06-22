package spi.mvc.com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spi.mvc.com.data.model.RRHH;
import spi.mvc.com.data.model.SpiDatos;

@Repository
public interface RRHHRepository extends CrudRepository<RRHH, Long> {
	
	@Query("SELECT u FROM RRHH u WHERE u.idspi=:idspi")
	List<RRHH> Listaporspirrhh(SpiDatos idspi);

}
