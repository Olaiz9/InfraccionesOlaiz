package com.primerproyectospring.infraccionesolaiz.controllers;

import com.primerproyectospring.infraccionesolaiz.entities.TipoDeInfraccion;
import com.primerproyectospring.infraccionesolaiz.services.TipoDeInfraccionServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/tipos-infraccion")
public class TipoDeInfraccionController extends BaseControllerImpl<TipoDeInfraccion, TipoDeInfraccionServiceImpl> {
}
