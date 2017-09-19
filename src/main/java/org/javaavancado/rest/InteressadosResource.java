package org.javaavancado.rest;

import org.javaavancado.data.InteressadosRepository;
import org.javaavancado.model.Interessados;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("interessados")
public class InteressadosResource {

    @Inject
    private InteressadosRepository rep;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Interessados> getAll(){
        return rep.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Interessados entity) {
        rep.save(entity);
        return Response.ok().status(Response.Status.CREATED).build();
    }

}
