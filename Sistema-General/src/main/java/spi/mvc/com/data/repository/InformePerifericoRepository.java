package spi.mvc.com.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spi.mvc.com.data.model.InformePeriferico;
@Repository
public interface InformePerifericoRepository extends CrudRepository<InformePeriferico, Long> {
	@Query("select e from InformePeriferico e where e.idinforme=:idinforme")
	List<InformePeriferico> filtrarnum(Long idinforme);
}
