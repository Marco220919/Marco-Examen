package com.example.pruebamarco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2292027153046928174L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String nombres;
	private String apellidos;
	private String grado;
	private String seccion;
	private int nota1;
	private int nota2;
	private int nota3;
	private int promedio;
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	
	}

	
}
