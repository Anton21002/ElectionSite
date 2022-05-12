package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import app.ehdokkaat;
import java.util.ArrayList;
import java.util.List;
@Path("/EhdokasService")

public class EhdokasService {
	
	
	
	@GET
	@Path("/readehdokkaat")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void  readEhdokas(@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ehdokkaat");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<ehdokkaat> list=em.createQuery("select a from ehdokkaat a").getResultList();
		em.getTransaction().commit();
		//return list;
		request.setAttribute("ehdokkaatlist", list);
		  RequestDispatcher rd=request.getRequestDispatcher("/showehdokkaat.jsp");
		  rd.forward(request, response);
		
	}
	@POST
	@Path("/addehdokkaat")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)

	public void postEHDOKKAATByParams(@FormParam("EHDOKAS_ID") int EHDOKAS_ID,@FormParam("SUKUNIMI") String SUKUNIMI, @FormParam("ETUNIMI") String ETUNIMI,
			@FormParam("PUOLUE") String PUOLUE, @FormParam("KOTIPAIKKAKUNTA") String KOTIPAIKKAKUNTA,
			@FormParam("IKA") int IKA,

			@FormParam("MIKSI_EDUSKUNTAAN") String MIKSI_EDUSKUNTAAN,
			@FormParam("MITA_ASIOITA_HALUAT_EDISTAA") String MITA_ASIOITA_HALUAT_EDISTAA,
			@FormParam("AMMATTI") String AMMATTI,@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		ehdokkaat ehdokkaat = new ehdokkaat(EHDOKAS_ID,SUKUNIMI, ETUNIMI, PUOLUE, KOTIPAIKKAKUNTA, AMMATTI, MIKSI_EDUSKUNTAAN,
				MITA_ASIOITA_HALUAT_EDISTAA, IKA);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ehdokkaat");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(ehdokkaat);
		em.getTransaction().commit();
		
	}

	@GET
	@Path("/deleteEhdokas/{EHDOKAS_ID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteEhdokas(@PathParam("EHDOKAS_ID") int EHDOKAS_ID) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ehdokkaat");

		EntityManager em = emf.createEntityManager();
		ehdokkaat ehdokas = em.find(ehdokkaat.class, EHDOKAS_ID);
		em.getTransaction().begin();
		em.remove(ehdokas);
		em.getTransaction().commit();
		
	}

	@GET
	@Path("/getEhdokas/{EHDOKAS_ID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ehdokkaat getEhdokas(@PathParam("EHDOKAS_ID") int EHDOKAS_ID) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ehdokkaat");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		ehdokkaat f = em.find(ehdokkaat.class, EHDOKAS_ID);
		em.getTransaction().commit();
		return f;
	}
	
	@POST
	@Path("/updateehdokas/{EHDOKAS_ID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public ehdokkaat updateehdokas(@FormParam("EHDOKAS_ID") int EHDOKAS_ID,@FormParam("SUKUNIMI") String SUKUNIMI, @FormParam("ETUNIMI") String ETUNIMI,
			@FormParam("PUOLUE") String PUOLUE, @FormParam("KOTIPAIKKAKUNTA") String KOTIPAIKKAKUNTA,
			@FormParam("IKA") int IKA,

			@FormParam("MIKSI_EDUSKUNTAAN") String MIKSI_EDUSKUNTAAN,
			@FormParam("MITA_ASIOITA_HALUAT_EDISTAA") String MITA_ASIOITA_HALUAT_EDISTAA,
			@FormParam("AMMATTI") String AMMATTI) {
		ehdokkaat ehdokkaat = new ehdokkaat(EHDOKAS_ID,SUKUNIMI, ETUNIMI, PUOLUE, KOTIPAIKKAKUNTA, AMMATTI, MIKSI_EDUSKUNTAAN,
				MITA_ASIOITA_HALUAT_EDISTAA, IKA);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ehdokkaat");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		ehdokkaat f=em.find(ehdokkaat.class, ehdokkaat.getEHDOKAS_ID());
		if (f!=null) {
			em.merge(ehdokkaat);
		}		em.getTransaction().commit();
		return null;

	}
}
