package org.api.recursos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.api.modelos.Productos;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Path("catalogo")
@Api(tags= {"JaxRs"})
@Produces(MediaType.APPLICATION_JSON)
@ApiResponses(value = {
		@ApiResponse(code=100, message="Continue"),
		@ApiResponse(code=101, message="Switching Protocols"),
		@ApiResponse(code=102, message="Processing"),
		@ApiResponse(code=200, message="OK"),
		@ApiResponse(code=201, message="Created"),
		@ApiResponse(code=202, message="Accepted"),
		@ApiResponse(code=203, message="Non-authoritative Information"),
		@ApiResponse(code=204, message="No Content"),
		@ApiResponse(code=205, message="Reset Content"),
		@ApiResponse(code=206, message="Partial Content"),
		@ApiResponse(code=207, message="Multi-Status"),
		@ApiResponse(code=208, message="Already Reported"),
		@ApiResponse(code=226, message="IM Used"),
		@ApiResponse(code=300, message="Multiple Choices"),
		@ApiResponse(code=301, message="Moved Permanently"),
		@ApiResponse(code=302, message="Found"),
		@ApiResponse(code=303, message="See Other"),
		@ApiResponse(code=304, message="Not Modified"),
		@ApiResponse(code=305, message="Use Proxy"),
		@ApiResponse(code=307, message="Temporary Redirect"),
		@ApiResponse(code=308, message="Permanent Redirect"),
		@ApiResponse(code=400, message="Bad Request"),
		@ApiResponse(code=401, message="Unauthorized"),
		@ApiResponse(code=402, message="Payment Required"),
		@ApiResponse(code=403, message="Forbidden"),
		@ApiResponse(code=404, message="Not Found"),
		@ApiResponse(code=405, message="Method Not Allowed"),
		@ApiResponse(code=406, message="Not Acceptable"),
		@ApiResponse(code=407, message="Proxy Authentication Required"),
		@ApiResponse(code=408, message="Request Timeout"),
		@ApiResponse(code=409, message="Conflict"),
		@ApiResponse(code=410, message="Gone"),
		@ApiResponse(code=411, message="Length Required"),
		@ApiResponse(code=412, message="Precondition Failed"),
		@ApiResponse(code=413, message="Payload Too Large"),
		@ApiResponse(code=414, message="Request-URI Too Long"),
		@ApiResponse(code=415, message="Unsupported Media Type"),
		@ApiResponse(code=416, message="Requested Range Not Satisfiable"),
		@ApiResponse(code=417, message="Expectation Failed"),
		@ApiResponse(code=418, message="I'm a teapot"),
		@ApiResponse(code=421, message="Misdirected Request"),
		@ApiResponse(code=422, message="Unprocessable Entity"),
		@ApiResponse(code=423, message="Locked"),
		@ApiResponse(code=424, message="Failed Dependency"),
		@ApiResponse(code=426, message="Upgrade Required"),
		@ApiResponse(code=428, message="Precondition Required"),
		@ApiResponse(code=429, message="Too Many Requests"),
		@ApiResponse(code=431, message="Request Header Fields Too Large"),
		@ApiResponse(code=444, message="Connection Closed Without Response"),
		@ApiResponse(code=451, message="Unavailable For Legal Reasons"),
		@ApiResponse(code=499, message="Client Closed Request"),
		@ApiResponse(code=500, message="Internal Server Error"),
		@ApiResponse(code=501, message="Not Implemented"),
		@ApiResponse(code=502, message="Bad Gateway"),
		@ApiResponse(code=503, message="Service Unavailable"),
		@ApiResponse(code=504, message="Gateway Timeout"),
		@ApiResponse(code=505, message="HTTP Version Not Supported"),
		@ApiResponse(code=506, message="Variant Also Negotiates"),
		@ApiResponse(code=507, message="Insufficient Storage"),
		@ApiResponse(code=508, message="Loop Detected"),
		@ApiResponse(code=510, message="Not Extended"),
		@ApiResponse(code=511, message="Network Authentication Required"),
		@ApiResponse(code=599, message="Network Connect Timeout Error")
	})
public class Catologo {
	
	public List<Productos> listado_productos (){
		
		List<Productos> pro = new ArrayList<Productos>();
		
		pro.add(new Productos(1, "Leche", 1800));
		pro.add(new Productos(2, "Huevos", 9800));
		pro.add(new Productos(3, "Pan", 2500));
		
		return pro;		
	}
	
	@ApiOperation(value="Obtiene una lista de Productos", consumes=MediaType.APPLICATION_JSON,produces=MediaType.APPLICATION_XML)
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Productos> get(){
		return listado_productos ();				
	}
	
	
	@ApiOperation(value="Adiciona un producto a una lista de Productos", consumes=MediaType.APPLICATION_JSON,produces=MediaType.APPLICATION_JSON)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Productos> post(Productos producto){
		
		List<Productos> pro = listado_productos ();
		
		pro.add(new Productos(producto.getId(), producto.getNombre(), producto.getPrecio()));
		
		return pro;				
	}

	@ApiOperation(value="Captura parametros por url y adiciona un producto a la lista de Productos", consumes=MediaType.APPLICATION_JSON,produces=MediaType.APPLICATION_JSON)
	@POST
	@Path("url/{id}&{nombre}&{precio}")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Productos> post_url(
			@PathParam("id") int id,
			@PathParam("nombre") String nombre,
			@PathParam("precio") double precio) {
		
		List<Productos> pro = listado_productos ();
		
		pro.add(new Productos(id, nombre, precio));
		
		return pro;				
	}
	
	@ApiOperation(value="Devuelve un tipo Response con una lista de Productos", consumes=MediaType.APPLICATION_JSON,produces=MediaType.APPLICATION_JSON)	
    @POST
    @Path("/response")    
    public Response postStudentRecord(List<Productos> pro){

        return Response.status(201).entity(pro).type(MediaType.APPLICATION_JSON).build();
    }
    
	@ApiOperation(value="Actualiza un producto de la lista de Productos", consumes=MediaType.APPLICATION_JSON,produces=MediaType.APPLICATION_JSON)
	@PUT
	public List<Productos> put(Productos pro) {
		
		List<Productos> lista_prod = listado_productos ();
		
    	for (Productos examenes : lista_prod) {
    		
    		if (examenes.getId() == pro.getId()) {
    			
    			examenes.setPrecio(pro.getPrecio());
    		}    		
    	}
    	
		return lista_prod;
	}
	
	
	@ApiOperation(value="Elimina un producto de la lista de Productos", consumes=MediaType.APPLICATION_JSON,produces=MediaType.APPLICATION_JSON)
	@DELETE
	public List<Productos> delete(Productos pro) {

		List<Productos> lista_prod = listado_productos ();
		
    	for (Iterator<Productos> iterator_pro =  lista_prod.iterator(); iterator_pro.hasNext(); ) {
    		
    		Productos dato = iterator_pro.next();
    		
    		if(dato.getId() == pro.getId()) {
    			iterator_pro.remove();
    		}   		
    	
    		}
		return lista_prod;
	}
	

}