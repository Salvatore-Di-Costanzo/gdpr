package it.agilae.gdpr.dao.core.data.dao.exception;

public class DaoException extends CoreException {

    private static final long serialVersionUID = 3188860127276464785L;

    /**
     * Constructor
     */
    public DaoException() {
        super();
    }

    /**
     * Constructor
     *
     * @param message
     */
    public DaoException(String message) {
        super(message);
    }

    /**
     * Constructor
     *
     * @param message
     * @param cause
     */
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

}
