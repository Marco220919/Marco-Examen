package com.example.pruebamarco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pruebamarco.entity.Alumno;

@Repository

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

}
