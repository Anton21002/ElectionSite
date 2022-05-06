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
}
