package com.tourebalon.mock;

import com.tourebalon.mock.model.AprobacionCompra;
import com.tourebalon.mock.model.CompraValidacion;
import com.tourebalon.mock.model.EnumRespuestaValidacion;
import com.tourebalon.mock.model.RespuestaValidacion;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Random;

@Path("/tarjeta")
public class AplicaPagoResource {

    @POST
    @Path("/aprobarpago")
    @Produces("application/json")
    public RespuestaValidacion validarTarjeta(@RequestBody AprobacionCompra aprobacionCompra) {
        RespuestaValidacion respuesta = new RespuestaValidacion();
        respuesta.setCodigo(EnumRespuestaValidacion.RESPUESTA_EXITOSA.getCodigo());
        respuesta.setMensaje(EnumRespuestaValidacion.RESPUESTA_EXITOSA.name());
        respuesta.setUidPago(new Random().nextLong() + "");
        return respuesta;
    }
}