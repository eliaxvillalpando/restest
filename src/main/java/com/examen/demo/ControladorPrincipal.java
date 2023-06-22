package com.examen.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ControladorPrincipal {

    @Autowired
    Incidencia incidenciaServicio;
    @Autowired
    Operador operadorServicio;

    @Autowired
    OperadorRepository operadorRepository;

    @Autowired
    IncidenciaRepository incidenciaRepository;

    @PostMapping("/app/crear-operador")
    public Operador crearOperador(@RequestParam(value = "nombre") String nombre) {

        return new Operador(nombre);
    }

    @PostMapping("/app/crear-incidencia")
    public Incidencia crearInicidencia(@RequestParam(value = "id_operador") int operador,
            @RequestParam(value = "fecha") Date fecha,
            @RequestParam(value = "estatus") boolean estatus) {

        return new Incidencia(operador, fecha, estatus);
    }

    @GetMapping("/app/incidencias/{fecha}")
    public String traerIncidenciasPorFecha(@RequestParam(value = "fecha") Date fecha) {

        List<Incidencia> incidencias = incidenciaRepository.findAll();

        for (Incidencia incidencia : incidencias) {
            if (incidencia.getFecha() == fecha) {
                incidencias.add(incidencia);
            }
        }

        return incidencias.toString();

    }

    @GetMapping("/app/incidencias/abiertas")
    public String traerIncidenciasAbiertas() {

        List<Incidencia> incidenciasAbiertas = incidenciaRepository.findAll();

        for (Incidencia incidencia : incidenciasAbiertas) {
            if (!incidenciaServicio.isEstatus()) {
                incidenciasAbiertas.add(incidencia);
            }
        }

        return incidenciasAbiertas.toString();

    }

    @GetMapping("/app/incidencias/{operador}")
    public String traerIncidenciasPorNombreOperador(@RequestParam(value = "nombre") String nombre) {

        List<Incidencia> incidenciasOperador = incidenciaRepository.findAll();
        Operador operadorBuscado = operadorRepository.encuentraPorNombre(nombre);

        int id_Operador = operadorBuscado.getId();

        for (Incidencia incidencia : incidenciasOperador) {
            if (incidencia.getId_operador() == id_Operador) {
                incidenciasOperador.add(incidencia);
            }
        }

        return incidenciasOperador.toString();

    }

    @GetMapping("/app/listar/incidencias")
    public List<Incidencia> getAllIncidencias() {
        return incidenciaRepository.findAll();
    }

    @GetMapping("/app/incidencias/numero-cerradas")
    public int traerIncidenciasCerradas() {

        List<Incidencia> incidenciasCerradas = incidenciaRepository.findAll();
        int contador = 0;

        for (Incidencia incidencia : incidenciasCerradas) {
            if (incidenciaServicio.isEstatus() == false) {
                contador++;
            }
        }

        return contador;

    }

}
