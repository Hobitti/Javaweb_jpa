package rest;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.Dao;
import data.Ehdokas;

@Path("/ehdokasService")
public class EhdokkaatService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpavaalikone");

	@GET
	@Path("/readEhdokkaat")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Ehdokas> readEhdokkaat() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Ehdokas> ehdokkaat = em.createQuery("SELECT a FROM Ehdokas a").getResultList();
		em.getTransaction().commit();
		System.out.println(ehdokkaat.get(0).getNimi());
		return ehdokkaat;
	}
}
