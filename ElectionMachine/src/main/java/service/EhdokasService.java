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
	
	@Context HttpServletRequest request;
	@Context HttpServletResponse response;
	/**made by kasmir
	 * reads the whole ehdokas db and sends it to showehdokkaat.sp
	 * @throws ServletException
	 * @throws IOException
	 */
	@GET
	@Path("/readehdokkaat")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void  readEhdokas() throws ServletException, IOException {
		//entitymanager for ehdokkaat
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ehdokkaat");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		//finds the stuff form db and makes it into a list
		List<ehdokkaat> list=em.createQuery("select a from ehdokkaat a").getResultList();
		em.getTransaction().commit();
		//turns the list into a request parameter
		request.setAttribute("ehdokkaatlist", list);
		//forwards the request and the user to showehdokkaat.jsp
		  RequestDispatcher rd=request.getRequestDispatcher("/showehdokkaat.jsp");
		  rd.forward(request, response);
		
	}
	//done by mohammed. finalized by kasmir and anton
	/**
	 * adds a new ehdokas to db
	 * @param EHDOKAS_ID id of ehdokas
	 * @param SUKUNIMI ehdokas lastname
	 * @param ETUNIMI ehdokas firstname
	 * @param PUOLUE ehdokas gov-party
	 * @param KOTIPAIKKAKUNTA ehdokas home-county
	 * @param IKA age of ehdokas
	 * @param MIKSI_EDUSKUNTAAN why him/her to the parlament
	 * @param MITA_ASIOITA_HALUAT_EDISTAA what the ehdokas wants to represent in gov
	 * @param AMMATTI ehdokas current job/diploma
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@POST
	@Path("/addehdokkaat")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	//class gets form params from ehdokkaatforms.html
	public void postEHDOKKAATByParams(@FormParam("EHDOKAS_ID") int EHDOKAS_ID,@FormParam("SUKUNIMI") String SUKUNIMI, @FormParam("ETUNIMI") String ETUNIMI,
			@FormParam("PUOLUE") String PUOLUE, @FormParam("KOTIPAIKKAKUNTA") String KOTIPAIKKAKUNTA,
			@FormParam("IKA") int IKA,

			@FormParam("MIKSI_EDUSKUNTAAN") String MIKSI_EDUSKUNTAAN,
			@FormParam("MITA_ASIOITA_HALUAT_EDISTAA") String MITA_ASIOITA_HALUAT_EDISTAA,
			@FormParam("AMMATTI") String AMMATTI,@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws ServletException, IOException {
		//new ehdokkaat
		ehdokkaat ehdokkaat = new ehdokkaat(EHDOKAS_ID,SUKUNIMI, ETUNIMI, PUOLUE, KOTIPAIKKAKUNTA, AMMATTI, MIKSI_EDUSKUNTAAN,
				MITA_ASIOITA_HALUAT_EDISTAA, IKA);
		//entitymanager ehdokkaat
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ehdokkaat");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		//add new ehdokas to the database
		em.persist(ehdokkaat);
		em.getTransaction().commit();
		//back to table
		readEhdokas();
		
	}
	/**made by mohammed
	 * this deletes an ehdokas
	 * @param EHDOKAS_ID gets EHDOKAS_ID from jsp showehdokkaat.jsp
	 * @throws ServletException
	 * @throws IOException
	 */
	@GET
	@Path("/deleteEhdokas/{EHDOKAS_ID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteEhdokas(@PathParam("EHDOKAS_ID") int EHDOKAS_ID) throws ServletException, IOException {
		//creates a entity ehdokkaat
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ehdokkaat");

		EntityManager em = emf.createEntityManager();
		//selects and ehdokas from db where id is the same as in pathparam
		ehdokkaat ehdokas = em.find(ehdokkaat.class, EHDOKAS_ID);
		em.getTransaction().begin();
		//removes the ehdokas from database
		em.remove(ehdokas);
		em.getTransaction().commit();
		readEhdokas();
	}
	/**made by mohammed
	 * gets one Ehdokas by id
	 * @param EHDOKAS_ID gets ID EHDOKAS_ID
	 * @return returns the info of one ehdokas
	 */
	@GET
	@Path("/getEhdokas/{EHDOKAS_ID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ehdokkaat getEhdokas(@PathParam("EHDOKAS_ID") int EHDOKAS_ID) {
		//entitymf ehdokas
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ehdokkaat");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		//gets ehdokas where ehdokas id is the same as in path param
		ehdokkaat f = em.find(ehdokkaat.class, EHDOKAS_ID);
		em.getTransaction().commit();
		return f;
	}
	/** made by mohammed. finalized to working condition by anton and kasmir
	 * updates an ehdokas and modifyis it
	 * @param EHDOKAS_ID id of ehdokas
	 * @param SUKUNIMI ehdokas lastname
	 * @param ETUNIMI ehdokas firstname
	 * @param PUOLUE ehdokas gov-party
	 * @param KOTIPAIKKAKUNTA ehdokas home-county
	 * @param IKA age of ehdokas
	 * @param MIKSI_EDUSKUNTAAN why him/her to the parlament
	 * @param MITA_ASIOITA_HALUAT_EDISTAA what the ehdokas wants to represent in gov
	 * @param AMMATTI ehdokas current job/diploma
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@POST
	@Path("/updateehdokas/{EHDOKAS_ID}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	//create class update and get form params from ehdokkaatforms.html
	public ehdokkaat updateehdokas(@FormParam("EHDOKAS_ID") int EHDOKAS_ID,@FormParam("SUKUNIMI") String SUKUNIMI, @FormParam("ETUNIMI") String ETUNIMI,
			@FormParam("PUOLUE") String PUOLUE, @FormParam("KOTIPAIKKAKUNTA") String KOTIPAIKKAKUNTA,
			@FormParam("IKA") int IKA,
			@FormParam("MIKSI_EDUSKUNTAAN") String MIKSI_EDUSKUNTAAN,
			@FormParam("MITA_ASIOITA_HALUAT_EDISTAA") String MITA_ASIOITA_HALUAT_EDISTAA,
			@FormParam("AMMATTI") String AMMATTI) throws ServletException, IOException {
		//new ehdokkaat for entitymf to add to db
		ehdokkaat ehdokkaat = new ehdokkaat(EHDOKAS_ID,SUKUNIMI, ETUNIMI, PUOLUE, KOTIPAIKKAKUNTA, AMMATTI, MIKSI_EDUSKUNTAAN,
				MITA_ASIOITA_HALUAT_EDISTAA, IKA);
		//make entitymanager called ehdokkkaat and persist it
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ehdokkaat");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		//find from ehdokkaat where id=what needs to be updated
		ehdokkaat f=em.find(ehdokkaat.class, ehdokkaat.getEHDOKAS_ID());
		if (f!=null) {
			//if update not null update the ehdokas in the db
			em.merge(ehdokkaat);
		}		em.getTransaction().commit();
		//back to reading the table
		readEhdokas();
		return null;

	}
}
