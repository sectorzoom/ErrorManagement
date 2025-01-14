package org.example.errormanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.*;

@Controller
public class CalculatorControllers {

    @GetMapping("/suma/{num1}/{num2}")
    public String suma(@PathVariable int num1, @PathVariable int num2, Model model) {
        int resultado = num1 + num2;
        model.addAttribute("resultado", "La suma de " + num1 + " + " + num2 + " es: " + resultado);
        return "result";
    }

    @GetMapping("/division/{num1}/{num2}")
    public String division(@PathVariable int num1, @PathVariable int num2, Model model) {
        if (num2 == 0) {
            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, "No se puede dividir entre cero.");
        }
        int resultado = num1 / num2;
        model.addAttribute("resultado", "La división de " + num1 + " ÷ " + num2 + " es: " + resultado);
        return "result";
    }

    @GetMapping("/factorial/{num}")
    public String factorial(@PathVariable int num, Model model) {
        if (num < 0) {
            throw new ResponseStatusException(BAD_REQUEST, "No se permite factorial de números negativos.");
        }
        if (num > 100) {
            throw new ResponseStatusException(FORBIDDEN, "El cálculo del factorial para números mayores de 100 está restringido.");
        }
        model.addAttribute("resultado", "El factorial de " + num + " es: " + calcularFactorial(num));
        return "result";
    }

    private long calcularFactorial(int num) {
        long resultado = 1;
        for (int i = 2; i <= num; i++) {
            resultado *= i;
        }
        return resultado;
    }

    @GetMapping("/raiz/{num}")
    public String raiz(@PathVariable String num) {
        throw new ResponseStatusException(UNAUTHORIZED, "Acceso no autorizado para calcular la raíz cuadrada.");
    }
}
