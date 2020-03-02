package dhbwka.wwi.vertsys.ws.spring.rest_serien_server.repository;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model.Season;
import dhbwka.wwi.vertsys.ws.spring.rest_serien_server.model.SeasonId;

public interface SeasonRepository extends CrudRepository<Season, SeasonId> {
    //List<Season> findByTitle(String title);
}