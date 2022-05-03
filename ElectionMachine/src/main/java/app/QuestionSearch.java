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





public class QuestionSearch {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ElectionMachine");
	@GET
	@Path("")
	public void Search (PrintWriter out,String searchImport)
	{	
	EntityManager em=emf.createEntityManager();
    em.getTransaction().begin();
    Query q=em.createQuery("SELECT * from Kysymukset where Kysymus LIKE :paramName");
	q.setParameter("paramName", searchImport);
    List<FitKysymys> list=q.getResultList();
    em.getTransaction().commit();
    em.close();
    RequestDispatcher rd=q.getRequestDispatcher("./jsp/Searchtab.jsp");
	PrintFitting(out, list);
}
//SELECT * from Kysymukset where Kysymus LIKE %searchinp(var)%
public void PrintFitting (PrintWriter out,List<Kysymys> list) {
	
}

}