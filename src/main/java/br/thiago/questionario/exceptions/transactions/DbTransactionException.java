package br.thiago.questionario.exceptions.transactions;

public class DbTransactionException extends RuntimeException {
        public DbTransactionException(String message) {
            super(message);
        }

}