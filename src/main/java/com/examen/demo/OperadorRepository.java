
package com.examen.demo;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OperadorRepository extends JpaRepository<Operador, Integer>{
    
    Operador encuentraPorNombre(String nombre);
    
}
