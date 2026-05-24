package com.primerproyectospring.infraccionesolaiz.controllers;

import com.primerproyectospring.infraccionesolaiz.entities.Marca;
import com.primerproyectospring.infraccionesolaiz.services.MarcaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/marcas")
public class MarcaController extends BaseControllerImpl<Marca, MarcaServiceImpl> {
}
