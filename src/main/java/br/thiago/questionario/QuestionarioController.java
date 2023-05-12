package br.thiago.questionario;

import br.thiago.questionario.modelos.InserirPerguntaRequestBody;
import br.thiago.questionario.modelos.ResponderQuizRequestBody;
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

    private final QuestionarioService service;

    public QuestionarioController(QuestionarioService service) {
        this.service = service;
    }


    @GET
    public Response getQuestionario() {
        return Response.ok().entity(this.service.recuperarQuestoes()).build();
    }

    @POST
    public Response responderQuestionario(ResponderQuizRequestBody usuarioResposta) {
        this.service.salvarResposta(usuarioResposta);
        return Response.noContent().build();
    }

    @POST
    @Path("/adicionar/pergunta")
    public Response adicionarPergunta(InserirPerguntaRequestBody novaPergunta) {
        this.service.salvarPergunta(novaPergunta);
        return Response.noContent().build();
    }

}