package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uet.k59t.model.TempHumid;

/**
 * Created by Longlaptop on 11/2/2017.
 */
@Repository
public interface TempHumidRepository extends CrudRepository<TempHumid,Long> {
}
