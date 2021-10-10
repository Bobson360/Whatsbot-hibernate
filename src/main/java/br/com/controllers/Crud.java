package br.com.controllers;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface Crud<T> {
	public T save(T value) throws SQLIntegrityConstraintViolationException;

	public T find(int id);

	public List<T> findAll();
	
	public T update(int id);

	public void destroy(int id);
	
}
