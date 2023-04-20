package tools2;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/")

@Consumes(MediaType.APPLICATION_JSON)

@Produces(MediaType.APPLICATION_JSON)
public class service {
	@PersistenceContext
    EntityManager em;
	int res ;
	@POST
	@Path("/calc")
	
	public  Response calculation (calc obj )
	{
	
		switch (obj.getOp())
		{
		case "-":
			res = obj.getNum1() - obj.getNum2();
			break;
		case "+" :
			res = obj.getNum1()+obj.getNum2();
			break;
		case "/":
			res = obj.getNum1()/obj.getNum2();
			break;
		case"*":
			res = obj.getNum1()*obj.getNum2();
			break;
		default : 
			return Response.status(400).entity("Error").build();
		}
		em.persist(obj);
		return Response.ok().entity(" res = " + res).build();
	}
	
	@GET
	@Path("/calculations")
	public Response getRes()
	{
		List<calc> L = em.createQuery("SELECT op FROM calc op" , calc.class).getResultList();
		
		return Response.ok().entity(L).build();
		
		
	}
	

}
