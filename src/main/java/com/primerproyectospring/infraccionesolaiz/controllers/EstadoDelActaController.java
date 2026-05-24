package com.primerproyectospring.infraccionesolaiz.controllers;

import com.primerproyectospring.infraccionesolaiz.entities.EstadoDelActa;
import com.primerproyectospring.infraccionesolaiz.services.EstadoDelActaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/estados-acta")
public class EstadoDelActaController extends BaseControllerImpl<EstadoDelActa, EstadoDelActaServiceImpl> {
}
