package controllers;

import entities.Conductor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.ConductorServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/conductores")
public class ConductorController extends BaseControllerImpl<Conductor, ConductorServiceImpl> {
}
