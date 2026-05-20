package services;

import entities.Licencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BaseRepository;
import repositories.LicenciaRepository;

@Service
public class LicenciaServiceImpl extends BaseServiceImpl<Licencia, Long> implements LicenciaService {

    @Autowired
    private LicenciaRepository licenciaRepository;

    public LicenciaServiceImpl(BaseRepository<Licencia, Long> baseRepository) {
        super(baseRepository);
    }
}
