package ec.edu.ups.pweb.services;



import java.util.List;

import ec.edu.ups.pweb.business.GestionCarrosLocal;
import ec.edu.ups.pweb.model.Carro;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("carros")
public class CarroServices {

	@Inject
	private GestionCarrosLocal gCarros;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Carro carro) {
		try{
			gCarros.guardarCarros(carro);
			ErrorMessage error = new ErrorMessage(1, "OK");
			return Response.status(Response.Status.CREATED)
					.entity(error)
					.build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Carro carro) {
		try{
			gCarros.actualizarCarro(carro);
			return Response.ok(carro).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String borrar(@QueryParam("placa") String placa) {
		try{
			gCarros.borrarCarro(placa);
			return "OK";
		}catch (Exception e) {
			// TODO: handle exception
			return "Error";
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response leer(@QueryParam("placa") String placa, @QueryParam("modelo") String modelo) {
		try{
			System.out.println("placa " +  placa + " modelo=" + modelo);
			Carro car = gCarros.getCarroPorPlaca(placa);
			return Response.ok(car).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Carro no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Path("{placa}/{modelo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response leer2(@PathParam("placa") String placa, @PathParam("modelo") String modelo) {
		try{
			System.out.println("placa " +  placa + " modelo=" + modelo);
			Carro car = gCarros.getCarroPorPlaca(placa);
			return Response.ok(car).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Carro no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getCarros(){
		List<Carro> carros = gCarros.getCarros();
		if(carros.size()>0)
			return Response.ok(carros).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran carros");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	
}
