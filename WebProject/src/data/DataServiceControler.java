package data;

import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import model.*;

/**
 * @author Nemanja
 * Sep 4, 2018
 */
public class DataServiceControler {

	@Path("/dataControl")
	public class FileDataService {

		@Context
		HttpServletRequest request;
		@Context
		ServletContext ctx;

		@GET
		@Path("/getVolonteri")
		@Produces(MediaType.APPLICATION_JSON)
		public Collection<Volonter> getVolonteri() {
			return getData().getVolonterValues();
		}
		
		@POST
		@Path("/addVolonter")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response addVolonter(Volonter v) {
			if(getData().korisnickoImePostoji(v.getKorIme())) {
				return Response.status(Status.CONFLICT).entity("{\"msg\":\"Duplicate username\"}").build();
			}
			else if(getData().emailPostoji(v.getEmail())) {
				return Response.status(Status.CONFLICT).entity("{\"msg\":\"Duplicate email\"}").build();
			}
			getData().getVolonteri().put(v.getKorIme(), v);
			getData().writeAllData();
			return Response.ok().build();
		}
		
		@POST
		@Path("/modifyVolonter")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response modifyVolonter(Volonter v) {
			if(getData().korisnickoImePostoji(v.getKorIme())) {
				getData().getVolonteri().put(v.getKorIme(), v);
				getData().writeAllData();
				return Response.ok().build();
			}
			return Response.status(Status.NOT_FOUND).entity("{\"msg\":\"User not found\"}").build();
		}
		
		@POST
		@Path("/checkValidity")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response checkValidity(Volonter v) {
			if(getData().loginUspresan(v)) {
				return Response.ok().build();
			}
			else {
				return Response.status(Status.NOT_FOUND).entity("{\"msg\":\"Volonter not found\"}").build();
			}
		}
		
		/*@POST
		@Path("/checkUsername")
		@Produces(MediaType.APPLICATION_JSON)
		public Response checkUsername(String username) {
		    boolean valid = getFileData().usernameExists(username);
		    return Response.ok().entity("{\"isValid\":" + valid + "}").build();
		}
		
		@POST
		@Path("/checkEmail")
		@Produces(MediaType.APPLICATION_JSON)
		public Response checkEmail(String email) {
		    boolean valid = getFileData().emailExists(email);
		    return Response.ok().entity("{\"isValid\":" + valid + "}").build();
		}*/
		
		@GET
		@Path("/getTeritorije")
		@Produces(MediaType.APPLICATION_JSON)
		public Collection<Teritorija> getTeritorije() {
			return getData().getTeritorijaValues();
		}
		
		@POST
		@Path("/addTeritorija")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response addTeritorija(Teritorija t) {
			if(getData().teritorijaPostoji(t.getNaziv())) {
				return Response.status(Status.CONFLICT).entity("{\"msg\":\"Teritorija already exists\"}").build();
			}
			getData().getTeritorije().put(t.getNaziv(), t);
			getData().writeAllData();
			return Response.ok().build();
		}
		
		@POST
		@Path("/updateTeritorija")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response updateTeritorija(Teritorija t) {
			if(getData().teritorijaPostoji(t.getNaziv())) {
				getData().getTeritorije().put(t.getNaziv(), t);
				getData().writeAllData();
				return Response.ok().build();
			}
			return Response.status(Status.NOT_FOUND).entity("{\"msg\":\"Error updating teritorija\"}").build();
		}
		
		@POST
		@Path("/deleteTeritorija")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response deleteTeritorija(Teritorija t) {
			if(getData().teritorijaPostoji(t.getNaziv())) {
				getData().getTeritorije().remove(t.getNaziv());
				getData().writeAllData();
				return Response.ok().build();
			}
			return Response.status(Status.NOT_FOUND).entity("{\"msg\":\"Error updating teritorija\"}").build();
		}
		
		@GET
		@Path("/getKomentari")
		@Produces(MediaType.APPLICATION_JSON)
		public Collection<Komentar> getKomentari() {
			return getData().getKomentarValues();
		}
		
		@POST
		@Path("/addKomentar")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response addKomentar(Komentar k) {
			getData().getKomentari().put(k.getId(), k);
			getData().writeAllData();
			return Response.ok().build();
		}
		
		@GET
		@Path("/getVanredneSituacije")
		@Produces(MediaType.APPLICATION_JSON)
		public Collection<VanrednaSituacija> getVanredneSituacije() {
			return getData().getVanrednaSituacijaValues();
		}
		
		@POST
		@Path("/addVanrednaSituacija")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response addVanrednaSituacija(VanrednaSituacija vs) {
			if(getData().idPostoji(vs.getId())) {
				return Response.status(Status.CONFLICT).entity("{\"msg\":\"Duplicate id\"}").build();
			}
			getData().getVanredneSit().put(vs.getId(), vs);
			getData().writeAllData();
			return Response.ok().build();
		}
		
		@POST
		@Path("/updateVanrednaSituacija")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response updateVanrednaSituacija(VanrednaSituacija v) {
			if(getData().idPostoji(v.getId())) {
				getData().getVanredneSit().put(v.getId(), v);
				getData().writeAllData();
				return Response.ok().build();
			}
			return Response.status(Status.NOT_FOUND).entity("{\"msg\":\"Error updating vanredna situacija\"}").build();
		}

		private DataControl getData() {
			DataControl dc = (DataControl) ctx.getAttribute("dataControl");
			if (dc == null) {
				dc = new DataControl(ctx.getRealPath(""));
				ctx.setAttribute("dataControl", dc);
			} 
			return dc;
		}
	}
}
