package com.softserve.edu.ita.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ElementDAOImpl<E> implements ElementDao<E> {
	private Class<E> elementClass;

	public ElementDAOImpl(Class<E> elementClass) {
		this.elementClass = elementClass;
	}

	@Override
	public void addElement(E element) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPATravelAgency");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(element);
		tx.commit();
		em.close();
		emf.close();

	}

	@Override
	public void updateElement(E element) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPATravelAgency");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(element);
		tx.commit();
		em.close();
		emf.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public E getElementByID(Long elementId) {
		EntityManager em = null;
		try {
			em = EntityManagerUtil.getConnection();
			E fetch = em.find(elementClass, elementId);
			return fetch;
			/*
			 * Query q = (Query) em
			 * .createNamedQuery("select m from Class<E> m where m.id=:id");
			 * ((javax.persistence.Query) q).setParameter("id", elementId);
			 * Class<E> pm = (Class<E>) ((javax.persistence.Query) q)
			 * .getSingleResult();
			 */

		} finally {
			if ((em != null) && (em.isOpen())) {
				em.close();
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAllElements() {
		EntityManager em = null;
		em = EntityManagerUtil.getConnection();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<E> cq = cb.createQuery(elementClass);
		Root<E> entity = cq.from(elementClass);
		cq.select(entity);
		TypedQuery<E> q = em.createQuery(cq);
		List<E> result = q.getResultList();
		em.close();
		return result;
		/*
		 * try { em = EntityManagerUtil.getConnection(); elements =
		 * em.createNativeQuery(arg0, arg1); } finally { if ((session != null)
		 * && (session.isOpen())) { session.close(); } } return elements;
		 */
	}

	@Override
	public void deleteElement(E element) {
		EntityManager em = null;
		try {
			em = EntityManagerUtil.getConnection();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(element);
			tx.commit();
		} finally {
			if ((em != null) && (em.isOpen())) {
				em.close();
			}
		}
	}
}
