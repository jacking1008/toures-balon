package com.touresbalon.api.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.openapitools.configuration.OpenAPIDocumentationConfig;

import com.touresbalon.api.domain.Error;
import com.touresbalon.api.domain.HospedajeException;
import com.touresbalon.api.domain.ProductoException;
import com.touresbalon.api.domain.ProductosGETAllRS;
import com.touresbalon.api.domain.ProductosPSTRq;
import com.touresbalon.api.domain.ProductosPSTRs;
import com.touresbalon.api.domain.TransporteException;
import com.touresbalon.api.service.ProductoService;

import io.opentracing.Span;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/productos")
public class ProductoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

	@Inject
	OpenAPIDocumentationConfig tracer;
	
	@Inject
	ProductoService productoService;
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Crear paquete de productos", nickname = "productosPST", notes = "Crear paquete de productos", response = ProductosPSTRs.class, tags={ "Productos", })
	public Response productosPST(@RequestBody ProductosPSTRq productosPSTRq) {
		ProductosPSTRs productosPSTRs = new ProductosPSTRs();
		Span span = tracer.getTracer().buildSpan("Crear Reserva").start();
    	span.setTag("url", "/productos");
    	span.setTag("http.method", "POST");
		try {
			productosPSTRs=productoService.crearProducto(productosPSTRq.getProducto());
			span.setTag("http.status_code", 200);
    		span.finish();
        	return Response.status(Response.Status.OK).entity(productosPSTRs).type(MediaType.APPLICATION_JSON).build();
    	}catch (ProductoException e) {
    		Error error=new Error();
    		error.setCode("0");
    		error.setMessage(e.getMessage());
    		span.setTag("http.status_code", 409);
    		span.finish();
			return Response.status(Response.Status.CONFLICT).entity(error).type(MediaType.APPLICATION_JSON).build();
		}
    	catch (Exception e) {
    		span.setTag("http.status_code", 500);
    		span.finish();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).type(MediaType.APPLICATION_JSON).build();
		}
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response productosGETAll(@QueryParam(value = "idProducto") Long idProducto,@QueryParam(value= "idCliente") Long cliente) {
		ProductosGETAllRS productosGETAllRS = new ProductosGETAllRS();
		Span span = tracer.getTracer().buildSpan("Consultar Productos").start();
    	span.setTag("url", "/productos");
    	span.setTag("http.method", "GET");
		try {
			productosGETAllRS.setProductos(productoService.listarProductos(cliente, idProducto));
			span.setTag("http.status_code", 200);
    		span.finish();
        	return Response.status(Response.Status.OK).entity(productosGETAllRS).type(MediaType.APPLICATION_JSON).build();
    	}catch (HospedajeException e) {
    		Error error=new Error();
    		error.setCode("0");
    		error.setMessage(e.getMessage());
    		span.setTag("http.status_code", 409);
    		span.finish();
			return Response.status(Response.Status.NOT_FOUND).entity(error).type(MediaType.APPLICATION_JSON).build();
		}
    	catch (Exception e) {
    		span.setTag("http.status_code", 500);
    		span.finish();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).type(MediaType.APPLICATION_JSON).build();
		}
	}
}
