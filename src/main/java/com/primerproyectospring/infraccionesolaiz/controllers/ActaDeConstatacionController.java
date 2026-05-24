package com.primerproyectospring.infraccionesolaiz.controllers;

import com.primerproyectospring.infraccionesolaiz.entities.ActaDeConstatacion;
import com.primerproyectospring.infraccionesolaiz.services.ActaDeConstatacionServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/actas")
public class ActaDeConstatacionController extends BaseControllerImpl<ActaDeConstatacion, ActaDeConstatacionServiceImpl> {}
