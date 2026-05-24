package com.primerproyectospring.infraccionesolaiz.controllers;

import com.primerproyectospring.infraccionesolaiz.entities.Vehiculo;
import com.primerproyectospring.infraccionesolaiz.services.VehiculoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/vehiculos")
public class VehiculoController extends BaseControllerImpl<Vehiculo, VehiculoServiceImpl> {
}
