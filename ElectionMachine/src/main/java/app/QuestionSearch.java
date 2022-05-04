package app;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import app.dao.FitKysymys;




@Path("/kysymussearch")
public class QuestionSearch {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ElectionMachine");
	String SrchReqStr;	
	@Path("/startsearch")
	public void Search (PrintWriter out,String SrchReqStr)
	{
	
	EntityManager em=emf.createEntityManager();
    em.getTransaction().begin();
    Query q=em.createQuery("SELECT k from Kysymukset k where k.Kysymus LIKE %paramName%");
	q.setParameter("paramName",SrchReqStr );
    List<FitKysymys> list=q.getResultList();
    em.getTransaction().commit();
    em.close();
    //RequestDispatcher rd=q.getRequestDispatcher("./jsp/Searchtab.jsp");
	PrintFitting(out, list);
}
@Path("/")
	//SELECT * from Kysymukset where Kysymus LIKE %searchinp(var)%
public void PrintFitting (PrintWriter out,List<FitKysymys> list) {
	for (int i=0;list!=null && i<list.size();i++) {
		FitKysymys k=list.get(i);
		out.println(k+"<br>");
		for (FitKysymys f : k.getFitKysymus()) {
			out.println(f+" caught by lure "+f.getFitKysymus()+"<br>");
		}
	}
	
}
}