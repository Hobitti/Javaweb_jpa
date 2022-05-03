package rest;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
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
	@DELETE
	@Path("/deleteEhdokas/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Ehdokas> deleteFish(@PathParam("id") int id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Ehdokas f=em.find(Ehdokas.class, id);
		if (f!=null) {
			em.remove(f);//The actual delete line
		}
		em.getTransaction().commit();
		//Calling the method readEhdokas() of this service
		List<Ehdokas> list=readEhdokkaat();		
		return list;
	}	
	@GET
	@Path("/deleteEhdokas/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteEhdokasByGet(@PathParam("id") int id, 
			@Context HttpServletRequest request,
			@Context HttpServletResponse response
			) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Ehdokas f=em.find(Ehdokas.class, id);
		if (f!=null) {
			em.remove(f);//The actual delete line
		}
		em.getTransaction().commit();
		//Calling the method readEhdokas() of this service
		List<Ehdokas> list=readEhdokkaat();		
		
//		RequestDispatcher rd=request.getRequestDispatcher("/jsp/ehdokasform.jsp");
//		request.setAttribute("ehdokaslist", list);
//		try {
//			rd.forward(request, response);
//		} catch (ServletException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
