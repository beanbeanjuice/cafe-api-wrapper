package com.beanbeanjuice.cafeapi.exception;

import com.beanbeanjuice.cafeapi.requests.Request;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link CafeException} used when a {@link com.beanbeanjuice.cafeapi.requests.Request Request} responds with a status code of 500.
 *
 * @author beanbeanjuice
 */
public class ResponseException extends CafeException {

    /**
     * Creates a new {@link ResponseException}.
     * @param request The {@link Request} that threw the {@link CafeException}.
     */
    public ResponseException(@NotNull Request request) {
        super(request);
    }

}