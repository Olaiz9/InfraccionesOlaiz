package com.primerproyectospring.infraccionesolaiz.controllers;

import com.primerproyectospring.infraccionesolaiz.entities.TipoRuta;
import com.primerproyectospring.infraccionesolaiz.services.TipoRutaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/tipos-ruta")
public class TipoRutaController extends BaseControllerImpl<TipoRuta, TipoRutaServiceImpl> {
}