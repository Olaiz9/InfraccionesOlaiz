package services;

import entities.Conductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BaseRepository;
import repositories.ConductorRepository;

@Service
public class ConductorServiceImpl extends BaseServiceImpl<Conductor, Long> implements ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    public ConductorServiceImpl(BaseRepository<Conductor, Long> baseRepository) {
        super(baseRepository);
    }
}
