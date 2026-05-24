package com.primerproyectospring.infraccionesolaiz.services;

import com.primerproyectospring.infraccionesolaiz.entities.OrganizacionEstatal;
import com.primerproyectospring.infraccionesolaiz.repositories.BaseRepository;
import com.primerproyectospring.infraccionesolaiz.repositories.OrganizacionEstatalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizacionEstatalServiceImpl extends BaseServiceImpl<OrganizacionEstatal, Long> implements OrganizacionEstatalService {
    @Autowired
    private OrganizacionEstatalRepository repository;
    public OrganizacionEstatalServiceImpl(BaseRepository<OrganizacionEstatal, Long> baseRepository) {
        super(baseRepository);
    }
}