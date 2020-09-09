package spi.mvc.com.data.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spi.mvc.com.data.model.Activo;
import spi.mvc.com.data.model.Tipo;

@Repository
public interface ActivoRepository extends CrudRepository<Activo, Long> {
	
	@Query("SELECT u FROM Activo u WHERE u.idtipo=:idtipo")
	public List<Activo> Buscarportipo(Tipo idtipo);
	
	

}
