package com.example.pruebamarco.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebamarco.entity.Alumno;
import com.example.pruebamarco.service.Alumnoservice;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {
	

	@Autowired
	private Alumnoservice alumnoService;


	@GetMapping("/all")
	public ResponseEntity<List<Alumno>> getAlumno(){
		try {
			List<Alumno> lista = new ArrayList<>();
			lista = alumnoService.readAll();
			if(lista.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(lista, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> getAlumno(@PathVariable("id") int id){
		Alumno c = alumnoService.read(id);
		if(c.getId()>0) {
			return new ResponseEntity<>(c, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			alumnoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Alumno> save(@RequestBody Alumno alum){
		try {
			Alumno a = new Alumno();
			a.setNombres(alum.getNombres());
			a.setApellidos(alum.getApellidos());
			a.setGrado(alum.getGrado());
			a.setSeccion(alum.getSeccion());
			a.setNota1(alum.getNota1());
			a.setNota2(alum.getNota2());
			a.setNota3(alum.getNota3());
			a.setPromedio(alum.getPromedio());
			Alumno al = alumnoService.create(a);
			return new ResponseEntity<>(al, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Alumno> update(@RequestBody Alumno alum, @PathVariable("id") int id){
		try {
			Alumno a = alumnoService.read(id);
			if(a.getId()>0) {
				a.setNombres(alum.getNombres());
				a.setApellidos(alum.getApellidos());
				a.setGrado(alum.getGrado());
				a.setSeccion(alum.getSeccion());
				a.setNota1(alum.getNota1());
				a.setNota2(alum.getNota2());
				a.setNota3(alum.getNota3());
				a.setPromedio(alum.getPromedio());
				return new ResponseEntity<>(alumnoService.create(a),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}