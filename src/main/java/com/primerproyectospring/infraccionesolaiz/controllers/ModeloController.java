package com.primerproyectospring.infraccionesolaiz.controllers;

import com.primerproyectospring.infraccionesolaiz.entities.Modelo;
import com.primerproyectospring.infraccionesolaiz.services.ModeloServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/modelos")
public class ModeloController extends BaseControllerImpl<Modelo, ModeloServiceImpl> {
}
