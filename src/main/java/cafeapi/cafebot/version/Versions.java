package cafeapi.cafebot.version;

import cafeapi.api.CafeAPI;
import cafeapi.exception.AuthorizationException;
import cafeapi.exception.ResponseException;
import cafeapi.exception.TeaPotException;
import cafeapi.exception.UndefinedVariableException;
import cafeapi.requests.Request;
import cafeapi.requests.RequestBuilder;
import cafeapi.requests.RequestRoute;
import cafeapi.requests.RequestType;
import org.jetbrains.annotations.NotNull;

/**
 * A class used for handling CafeBot {@link Versions} in the {@link cafeapi.CafeAPI CafeAPI}.
 *
 * @author beanbeanjuice
 */
public class Versions implements CafeAPI {

    private String apiKey;

    /**
     * Creates a new {@link Versions} object.
     * @param apiKey The {@link String apiKey} used for authorization.
     */
    public Versions(@NotNull String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Retrieves the current {@link String botVersion}.
     * @return The current {@link String botVersion} from the {@link cafeapi.CafeAPI CafeAPI}.
     * @throws AuthorizationException Thrown when the {@link String apiKey} is invalid.
     * @throws ResponseException Thrown when there is a generic server-side {@link cafeapi.exception.CafeException CafeException}.
     */
    @NotNull
    public String getCurrentCafeBotVersion()
    throws AuthorizationException, ResponseException {
        Request request = new RequestBuilder(RequestRoute.CAFEBOT, RequestType.GET)
                .setRoute("/cafeBot")
                .setAuthorization(apiKey)
                .build();

        return  request.getData().get("bot_information").get("version").asText();
    }

    /**
     * Updates the current {@link String botVersion} in the {@link cafeapi.CafeAPI CafeAPI}.
     * @param versionNumber The {@link String versionNumber} to update it to.
     * @return True, if the {@link String versionNumber} was successfully updated.
     * @throws AuthorizationException Thrown when the {@link String apiKey} is invalid.
     * @throws ResponseException Thrown when there is a generic server-side {@link cafeapi.exception.CafeException CafeException}.
     * @throws UndefinedVariableException Thrown when a variable is undefined.
     * @throws TeaPotException Thrown when you forget to add "v" to the beginning of the version number.
     */
    @NotNull
    public Boolean updateCurrentCafeBotVersion(@NotNull String versionNumber)
    throws AuthorizationException, ResponseException, UndefinedVariableException, TeaPotException {
        if (!versionNumber.startsWith("v")) {
            throw new TeaPotException("Version Number Must Start with 'v'.");
        }

        Request request = new RequestBuilder(RequestRoute.CAFEBOT, RequestType.PATCH)
                .setRoute("/cafeBot")
                .addParameter("version", versionNumber)
                .setAuthorization(apiKey)
                .build();

        return request.getStatusCode() == 200;
    }

    /**
     * Updates the {@link String apiKey}.
     * @param apiKey The new {@link String apiKey}.
     */
    @Override
    public void updateAPIKey(@NotNull String apiKey) {
        this.apiKey = apiKey;
    }
}
