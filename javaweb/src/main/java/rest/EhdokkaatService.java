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
import data.Kunta;
import data.Puolue;

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
	@GET
	@Path("/AddEhdokas")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_JSON)
	public String AddEhdokas() {
		String option;
		String html="<form action='' method='post' >\r\n" + 
				"	<input type='text' name='nimi' required>\r\n" + 
				"	<label for=\"nimi\">Ehdokkaan koko nimi</label><br>\r\n" + 
				"	\r\n" + 
				"	<input type='text' name='kuvaus' required>\r\n" + 
				"	<label for=\"kuvaus\">Kuvaus</label><br>\r\n" + 
				"	\r\n" + 
				"	<input type='text' name='slogan' required>\r\n" + 
				"	<label for=\"slogan\">Slogan</label><br>\r\n" + 
				"	\r\n" + 
				"	<Select name='puolue' id='puolue'>";		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Puolue> puolueet = em.createQuery("SELECT a FROM Puolue a").getResultList();
		em.getTransaction().commit();
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
		List<Kunta> kunnat = em2.createQuery("SELECT a FROM Kunta a").getResultList();
		em2.getTransaction().commit();
		
		for(Puolue puolue:puolueet) {
			option="<option value='"+puolue.getPuolueID()+"'>"+puolue.getLyhenne()+ "</option>";
			html=html+option;
		}
		html=html+"</Select> <label for=\"puolue\">Puolue</label> <br>	<Select name='kunta' id='kunta'>";
	
		for(Kunta kunta:kunnat) {
			option="<option value='"+kunta.getId()+"'>"+kunta.getNimi()+ "</option>";
			html=html+option;
		}
		html=html+"</Select> <label for=\"kunta\">Kunta</label><br>"
				+ "	<input type='submit' value='Lisää Ehdokas' ></form>";
		
		
		
		
		return html;
	}
}
