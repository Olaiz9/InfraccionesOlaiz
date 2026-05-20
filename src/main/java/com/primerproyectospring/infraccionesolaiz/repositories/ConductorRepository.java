package repositories;

import entities.Conductor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends BaseRepository<Conductor, Long> {
}
