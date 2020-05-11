package by.gvu.jd2.ishop.dao.exception;

import java.sql.Connection;
import java.util.concurrent.BlockingQueue;

public final class ConnectionPoolException extends Exception {
    private static final long serialVersionUID = 1L;

    public ConnectionPoolException() {
        super();
    }

    public ConnectionPoolException(String message) {
        super(message);
    }

    public ConnectionPoolException(String message, Throwable cause) {
        super(message, cause);
    }
}
