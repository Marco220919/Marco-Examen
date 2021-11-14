package com.example.pruebamarco.service;

import java.util.List;

import com.example.pruebamarco.entity.Alumno;

public interface Alumnoservice {

	List<Alumno> readAll();
	Alumno read(int id);
	Alumno create(Alumno alumno);
	Alumno update(Alumno alumno);
	void delete(int id);	
}
