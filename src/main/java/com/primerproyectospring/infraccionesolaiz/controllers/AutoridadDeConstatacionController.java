package com.primerproyectospring.infraccionesolaiz.controllers;

import com.primerproyectospring.infraccionesolaiz.entities.AutoridadDeConstatacion;
import com.primerproyectospring.infraccionesolaiz.services.AutoridadDeConstatacionServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autoridades")
public class AutoridadDeConstatacionController extends BaseControllerImpl<AutoridadDeConstatacion, AutoridadDeConstatacionServiceImpl> {
}