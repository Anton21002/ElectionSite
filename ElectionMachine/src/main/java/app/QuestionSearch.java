package app;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

public class QuestionSearch {
	@GET
	@Path("")
	public void Search ()
	{	
	EntityManager em=emf.createEntityManager();
    em.getTransaction().begin();
    Kid kid=em.find(Kid.class, 2);
    em.getTransaction().commit();
    request.setAttribute("kid", kid);
    RequestDispatcher rd=request.getRequestDispatcher("./jsp/readonekidnotfish.jsp");
	rd.forward(request, response);
}}
//SELECT * from Kysymukset where Kysymus LIKE %searchinp(var)%
