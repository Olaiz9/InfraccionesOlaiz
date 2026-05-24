package com.primerproyectospring.infraccionesolaiz.controllers;

import com.primerproyectospring.infraccionesolaiz.entities.Licencia;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.primerproyectospring.infraccionesolaiz.services.LicenciaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/licencias")
public class LicenciaController extends BaseControllerImpl<Licencia, LicenciaServiceImpl> {
}