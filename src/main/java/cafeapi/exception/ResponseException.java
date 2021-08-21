package cafeapi.exception;

import org.jetbrains.annotations.NotNull;

/**
 * A {@link CafeException} used when a {@link cafeapi.requests.Request Request} responds with a status code of 500.
 *
 * @author beanbeanjuice
 */
public class ResponseException extends CafeException {

    /**
     * Creates a new {@link ResponseException}.
     * @param statusCode The {@link Integer statusCode} for the {@link CafeException}.
     * @param message The {@link String message} for the {@link CafeException}.
     */
    public ResponseException(@NotNull Integer statusCode, @NotNull String message) {
        super(statusCode, message);
    }

}
