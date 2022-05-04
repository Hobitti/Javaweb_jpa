package rest;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	public List<Ehdokas> readEhdokkaat() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Ehdokas> ehdokkaat = em.createQuery("SELECT a FROM Ehdokas a").getResultList();
		em.getTransaction().commit();
		System.out.println(ehdokkaat.get(0).getId());
		return ehdokkaat;
	}
	
	@GET
	@Path("/readEhdokas")
	@Produces(MediaType.TEXT_HTML)
	public String readEhdokas(@QueryParam("id") int id) {
		EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    List<Ehdokas> ehdokas = em.createQuery("select a from Ehdokas a WHERE a.id =" + id).getResultList();
	    em.getTransaction().commit();
	    
	    em.getTransaction().begin();
	    List<Kunta> kunnat = em.createQuery("select a from Kunta a").getResultList();
	    em.getTransaction().commit();
	    
	    em.getTransaction().begin();
	    List<Puolue> puolueet = em.createQuery("select a from Puolue a").getResultList();
	    em.getTransaction().commit();
	    
		String html = "<input type='hidden' name='id' value='" + ehdokas.get(0).getId() + "'>";
		html += "Nimi: <input type='text' name='nimi' value='" + ehdokas.get(0).getNimi() + "'>";
		
		html += "Kuvaus: <textarea name='kuvaus'>" + ehdokas.get(0).getKuvaus() + "</textarea>";
		
		html += "Slogan: <input type='text' name='slogan' value='" + ehdokas.get(0).getSlogan() + "'>";
		
		html += "<select name='kunta'>";
		for(Kunta kunta : kunnat) {
			if(ehdokas.get(0).getKunta() == kunta.getId()) {
				html += "<option value='" + kunta.getId() + "' selected>" + kunta.getNimi() + "</option>";
			} else {
				html += "<option value='" + kunta.getId() + "'>" + kunta.getNimi() + "</option>";
			}
		}
		html += "</select>";
		
		html += "<select name='puolue'>";
		for(Puolue puolue : puolueet) {
			if(ehdokas.get(0).getKunta() == puolue.getPuolueID()) {
				html += "<option value='" + puolue.getPuolueID() + "' selected>" + puolue.getNimi() + "</option>";
			} else {
				html += "<option value='" + puolue.getPuolueID() + "'>" + puolue.getNimi() + "</option>";
			}
		}
		html += "</select>";
		
		html += "<input type='submit'>";

		return html;
	}
	
	@PUT
	@Path("/muokkaaEhdokas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Ehdokas muokkaaEhdokas(Ehdokas ehdokas) {
		EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    Ehdokas e = em.find(Ehdokas.class, ehdokas.getId());
	    System.out.println(e.getId());
	    if(e != null) {
	    	em.merge(ehdokas);
	    }
	    //em.createQuery("update Ehdokas a SET a.nimi = '" + name + "', a.kuvaus = '" + desc + "', a.slogan = '" + slogan + "', a.kuntaId = '" + kuntaId + "', a.puolue = '" + puolueId + "' WHERE a.id = '" + id + "'");
	    em.getTransaction().commit();
		return e;
	}
	
	@GET
	@Path("/AddEhdokas")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_JSON)
	public String AddEhdokas() {
		String option;
		String html =
				"<form action='' method='post' >\r\n" + 
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
