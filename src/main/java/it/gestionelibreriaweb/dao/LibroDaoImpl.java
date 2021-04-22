package it.gestionelibreriaweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.gestionelibreriaweb.model.Libro;

public class LibroDaoImpl implements ILibroDao {

	private EntityManager entityManager;

	@Override
	public List<Libro> list() throws Exception {
		TypedQuery<Libro> query = entityManager.createQuery("from Libro ", Libro.class);
		return query.getResultList();
	}

	@Override
	public Libro get(Long idInput) throws Exception {
		if (idInput < 1) {
			throw new Exception("Errore inserimento id get libro.");
		}
		return entityManager.find(Libro.class, idInput);
	}

	@Override
	public void update(Libro LibroInput) throws Exception {
		if (LibroInput == null) {
			throw new Exception("Errore inserimento input update libro.");
		}
		entityManager.merge(LibroInput);
	}

	@Override
	public void insert(Libro LibroInput) throws Exception {
		if (LibroInput == null) {
			throw new Exception("Errore inserimento input insert libro.");
		}
		entityManager.persist(LibroInput);
	}

	@Override
	public void delete(Libro LibroInput) throws Exception {
		if (LibroInput == null) {
			throw new Exception("Errore inserimento input delete libro.");
		}
		entityManager.remove(entityManager.merge(LibroInput));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
