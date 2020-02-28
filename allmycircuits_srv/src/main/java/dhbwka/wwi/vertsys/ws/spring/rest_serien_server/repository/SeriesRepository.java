package dhbwka.wwi.vertsys.ws.spring.rest_serien_server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model.Series;

public interface SeriesRepository extends CrudRepository<Series, Long> {
    List<Series> findByTitle(String title);
}