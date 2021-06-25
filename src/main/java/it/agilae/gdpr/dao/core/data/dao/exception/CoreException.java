package it.agilae.gdpr.dao.core.data.dao.exception;

import java.io.Serializable;

public class CoreException extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     */
    public CoreException() {
        super();
    }


    /**
     * Constructor
     *
     * @param message
     */
    public CoreException(String message) {
        super(message);
    }

    /**
     * Constructor
     *
     * @param message
     * @param cause
     */
    public CoreException(String message, Throwable cause) {
        super(message, cause);
    }

}

