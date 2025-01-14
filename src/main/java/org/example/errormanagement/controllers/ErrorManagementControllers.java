package org.example.errormanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.*;

@Controller
public class ErrorManagementControllers {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/error404")
    public String error404() {
        throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
    }

    @GetMapping("/error401")
    public String error401() {
        throw new ResponseStatusException(UNAUTHORIZED, "No autorizado para acceder a esta página.");
    }

    @GetMapping("/error403")
    public String error403() {
        throw new ResponseStatusException(FORBIDDEN, "Acceso denegado a este recurso.");
    }

    @GetMapping("/error500")
    public String error500() {
        throw new ResponseStatusException(INTERNAL_SERVER_ERROR, "Error interno en el servidor.");
    }
}
