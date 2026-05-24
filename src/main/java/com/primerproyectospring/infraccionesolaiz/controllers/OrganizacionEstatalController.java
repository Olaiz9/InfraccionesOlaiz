package com.primerproyectospring.infraccionesolaiz.controllers;

import com.primerproyectospring.infraccionesolaiz.entities.OrganizacionEstatal;
import com.primerproyectospring.infraccionesolaiz.services.OrganizacionEstatalServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/organizaciones")
public class OrganizacionEstatalController extends BaseControllerImpl<OrganizacionEstatal, OrganizacionEstatalServiceImpl> {
}
