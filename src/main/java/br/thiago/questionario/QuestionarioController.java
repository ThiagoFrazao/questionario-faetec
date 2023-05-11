package br.thiago.questionario;

import br.thiago.questionario.modelos.QuizQuestionario;
import jakarta.json.Json;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/questionario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionarioController {


    @GET
    public Response getQuestionario() {
        return Response.ok().entity(Json.createValue("Teste")).build();
    }

    @POST
    public Response responderQuestionario() {
        return Response.ok().entity(Json.createValue("Teste")).build();
    }

    @POST
    @Path("/adicionar/pergunta")
    public Response adicionarPergunta(QuizQuestionario novaPergunta) {
        return Response.ok().entity(novaPergunta).build();
    }

}
