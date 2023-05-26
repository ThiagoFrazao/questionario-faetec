package br.thiago.questionario;

import br.thiago.questionario.modelos.questoes.InserirPerguntaRequestBody;
import br.thiago.questionario.modelos.respostas.ResponderQuizRequestBody;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/questionario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionarioController {

    private final QuestionarioService service;

    public QuestionarioController(QuestionarioService service) {
        this.service = service;
    }


    @GET
    public Response getQuestionario() {
        try {
            return Response.ok().entity(this.service.recuperarQuestoes()).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/responder")
    public Response responderQuestionario(List<ResponderQuizRequestBody> respostaQuiz) {
        this.service.salvarResposta(respostaQuiz);
        return Response.noContent().build();
    }

    @POST
    @Path("/adicionar/pergunta")
    public Response adicionarPergunta(InserirPerguntaRequestBody novaPergunta) {
        this.service.salvarPergunta(novaPergunta);
        return Response.noContent().build();
    }

    @GET
    @Path("/graficos")
    public Response getGraficos() {
        try {
            return Response.ok().entity(this.service.recuperarGraficos()).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}