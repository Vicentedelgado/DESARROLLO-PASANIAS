package spi.mvc.com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spi.mvc.com.data.model.SpiDatos;
import spi.mvc.com.data.model.Zona;
@Repository
public interface SpiDatosRepository extends CrudRepository<SpiDatos, Long> {
	
	@Query("SELECT u FROM SpiDatos u WHERE u.idspi=:idspi")
	List<SpiDatos> Listaporspi(Long idspi);
	
	@Query("SELECT u FROM SpiDatos u WHERE u.idzona=:idzona")
	public List<SpiDatos> FindByZona(Zona idzona);

}
