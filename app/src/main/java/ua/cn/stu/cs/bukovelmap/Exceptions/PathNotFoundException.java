package ua.cn.stu.cs.bukovelmap.Exceptions;

/**
 * Created by WarlordGrey on 14.12.2015.
 */
public class PathNotFoundException extends Exception {

    /**
     * Constructs a new {@code Exception} that includes the current stack trace.
     */
    public PathNotFoundException() {
        super();
    }

    /**
     * Constructs a new {@code Exception} with the current stack trace and the
     * specified detail message.
     *
     * @param detailMessage the detail message for this exception.
     */
    public PathNotFoundException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code Exception} with the current stack trace, the
     * specified detail message and the specified cause.
     *
     * @param detailMessage the detail message for this exception.
     * @param throwable
     */
    public PathNotFoundException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    /**
     * Constructs a new {@code Exception} with the current stack trace and the
     * specified cause.
     *
     * @param throwable the cause of this exception.
     */
    public PathNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
