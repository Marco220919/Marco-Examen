package com.example.pruebamarco.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebamarco.entity.Alumno;
import com.example.pruebamarco.service.Alumnoservice;

@Service
public class AlumnoServiceimpl implements Alumnoservice{
	@Autowired
	private com.example.pruebamarco.repository.AlumnoRepository alumnoRepository;
	
	@Override
	public List<Alumno> readAll() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAll();
	}

	@Override
	public Alumno read(int id) {
		// TODO Auto-generated method stub
		return alumnoRepository.findById(id).get();
	}

	@Override
	public Alumno create(Alumno alumno) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(alumno);
	}

	@Override
	public Alumno update(Alumno alumno) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(alumno);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		alumnoRepository.deleteById(id);
	}

}
