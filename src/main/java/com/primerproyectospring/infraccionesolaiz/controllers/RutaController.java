package com.primerproyectospring.infraccionesolaiz.controllers;

import com.primerproyectospring.infraccionesolaiz.entities.Ruta;
import com.primerproyectospring.infraccionesolaiz.services.RutaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/rutas")
public class RutaController extends BaseControllerImpl<Ruta, RutaServiceImpl> {
}
