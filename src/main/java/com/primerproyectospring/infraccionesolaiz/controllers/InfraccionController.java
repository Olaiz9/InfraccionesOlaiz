package com.primerproyectospring.infraccionesolaiz.controllers;

import com.primerproyectospring.infraccionesolaiz.entities.Infraccion;
import com.primerproyectospring.infraccionesolaiz.services.InfraccionServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/infracciones")
public class InfraccionController extends BaseControllerImpl<Infraccion, InfraccionServiceImpl> {}