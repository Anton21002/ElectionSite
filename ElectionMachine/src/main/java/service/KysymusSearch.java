package service;
import java.io.IOException;
import java.io.PrintWriter;
	import java.util.List;
	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;
	import javax.persistence.Query;
 import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
	import javax.ws.rs.FormParam;
	import javax.ws.rs.GET;
	import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.appengine.repackaged.com.google.gson.Gson;

import app.dao.FitKysymys;




	@Path("/KysymusSearch")
public class KysymusSearch {
		
		String SrchReqStr;
		@GET
		@Path("/startsearch")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		public String Search (PrintWriter out,@FormParam("SearchData")String SrchReqStr,@Context HttpServletRequest request,@Context HttpServletResponse response) throws ServletException, IOException
		{
		
		
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("Ehdokaat");
		EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    Query q=em.createQuery("SELECT k from Kysymukset k where k.Kysymus LIKE paramName");
		q.setParameter("paramName","%"+SrchReqStr+"%" );
	    em.getTransaction().commit();
	    List<FitKysymys> list=q.getResultList();
	    String a=new Gson().toJson(list);
	    RequestDispatcher rd=request.getRequestDispatcher(".jsp/Searchtab.jsp");
		rd.forward(request, response);
		return a;
		
			
			
		

	    //PrintFitting(out, list);
	   
	}
	}
