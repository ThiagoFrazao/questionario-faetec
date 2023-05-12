package br.thiago.questionario.exceptions.transactions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
public class DbTransactionExceptionProvider implements ExceptionMapper<DbTransactionException> {
    @Override
    public Response toResponse(DbTransactionException e) {
        return Response.serverError().entity(new ExceptionResponse(e.getMessage())).build();
    }

}
