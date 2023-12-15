package it.pagopa.interop.signalhub.history.cleanup.exception;

public class PDNDBatchAlreadyExistException extends RuntimeException {

    public PDNDBatchAlreadyExistException() {
        super("Batch already in running");
    }
}
