package cafeapi.cafebot.welcomes;

import cafeapi.exception.*;
import cafeapi.requests.Request;
import cafeapi.requests.RequestBuilder;
import cafeapi.requests.RequestRoute;
import cafeapi.requests.RequestType;
import com.fasterxml.jackson.databind.JsonNode;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A class used for the {@link Welcomes} API.
 */
public class Welcomes {

    private String apiKey;

    /**
     * Creates a new class used for {@link Welcomes} API requests.
     * @param apiKey The API key used for authorization.
     */
    public Welcomes(@NotNull String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Retrieves an {@link ArrayList} of {@link GuildWelcome} containing all Guild Welcomes in the {@link cafeapi.CafeAPI CafeAPI}.
     * @return The {@link ArrayList} of {@link GuildWelcome}.
     * @throws AuthorizationException Thrown when the api key is unauthorized.
     * @throws ResponseException Thrown when there is a generic server-side exception.
     */
    @NotNull
    public ArrayList<GuildWelcome> getAllGuildWelcomes() throws AuthorizationException, ResponseException {
        ArrayList<GuildWelcome> guildWelcomes = new ArrayList<>();

        Request request = new RequestBuilder(RequestRoute.CAFEBOT, RequestType.GET)
                .setRoute("/welcomes")
                .setAuthorization(apiKey)
                .build();

        for (JsonNode guildWelcome : request.getData().get("welcomes")) {
            guildWelcomes.add(new GuildWelcome(
                    guildWelcome.get("guild_id").asText(),
                    guildWelcome.get("description").asText(),
                    guildWelcome.get("thumbnail_url").asText(),
                    guildWelcome.get("image_url").asText(),
                    guildWelcome.get("message").asText()
            ));
        }

        return guildWelcomes;
    }

    /**
     * Retrieves a {@link GuildWelcome} from the {@link cafeapi.CafeAPI CafeAPI}.
     * @param guildID The {@link String guildID} to retrieve the {@link GuildWelcome} for.
     * @return The {@link GuildWelcome} retrieved.
     * @throws AuthorizationException Thrown when the API key is invalid.
     * @throws ResponseException Thrown when there is a generic server-side exception.
     * @throws NotFoundException Thrown when the guild ID is not found.
     */
    @NotNull
    public GuildWelcome getGuildWelcome(@NotNull String guildID) throws AuthorizationException, ResponseException, NotFoundException {
        Request request = new RequestBuilder(RequestRoute.CAFEBOT, RequestType.GET)
                .setRoute("/welcomes/" + guildID)
                .setAuthorization(apiKey)
                .build();

        JsonNode guildWelcome = request.getData().get("welcome");

        return new GuildWelcome(
                guildWelcome.get("guild_id").asText(),
                guildWelcome.get("description").asText(),
                guildWelcome.get("thumbnail_url").asText(),
                guildWelcome.get("image_url").asText(),
                guildWelcome.get("message").asText()
        );
    }

    /**
     * Updates a {@link GuildWelcome} in the {@link cafeapi.CafeAPI CafeAPI}.
     * @param guildWelcome The new {@link GuildWelcome}.
     * @return True, if updating the {@link GuildWelcome} was successful.
     * @throws AuthorizationException Thrown when the API key is invalid.
     * @throws NotFoundException Thrown when the guild ID is not found.
     * @throws ResponseException Thrown when there is a generic server-side exception.
     */
    @NotNull
    public Boolean updateGuildWelcome(@NotNull GuildWelcome guildWelcome)
    throws AuthorizationException, NotFoundException, ResponseException {
        Request request = new RequestBuilder(RequestRoute.CAFEBOT, RequestType.PATCH)
                .setRoute("/welcomes/" + guildWelcome.getGuildID())
                .addParameter("description", guildWelcome.getDescription())
                .addParameter("thumbnail_url", guildWelcome.getThumbnailURL())
                .addParameter("image_url", guildWelcome.getImageURL())
                .addParameter("message", guildWelcome.getMessage())
                .setAuthorization(apiKey)
                .build();

        return request.getStatusCode() == 200;
    }

    /**
     * Creates a new {@link GuildWelcome} for the {@link cafeapi.CafeAPI CafeAPI}.
     * @param guildWelcome The new {@link GuildWelcome} to add.
     * @return True if the {@link GuildWelcome} was successfully added.
     * @throws AuthorizationException Thrown when the API key is invalid.
     * @throws ConflictException Thrown when the provided guild ID already exists.
     * @throws ResponseException Thrown when there is a generic server-side exception.
     * @throws UndefinedVariableException Thrown when a variable is undefined.
     */
    @NotNull
    public Boolean createGuildWelcome(@NotNull GuildWelcome guildWelcome)
    throws AuthorizationException, ConflictException, ResponseException, UndefinedVariableException {
        Request request = new RequestBuilder(RequestRoute.CAFEBOT, RequestType.POST)
                .setRoute("/welcomes/" + guildWelcome.getGuildID())
                .addParameter("description", guildWelcome.getDescription())
                .addParameter("thumbnail_url", guildWelcome.getThumbnailURL())
                .addParameter("image_url", guildWelcome.getImageURL())
                .addParameter("message", guildWelcome.getMessage())
                .setAuthorization(apiKey)
                .build();

        return request.getStatusCode() == 201;
    }

    /**
     * Deletes a {@link GuildWelcome} from the {@link cafeapi.CafeAPI CafeAPI}.
     * @param guildID The {@link String} ID of the {@link GuildWelcome} to delete.
     * @return True if successfully deleted.
     * @throws AuthorizationException Thrown when the API key is invalid.
     * @throws ResponseException Thrown when there is a generic server-side exception.
     */
    @NotNull
    public Boolean deleteGuildWelcome(@NotNull String guildID)
    throws AuthorizationException, ResponseException {
        Request request = new RequestBuilder(RequestRoute.CAFEBOT, RequestType.DELETE)
                .setRoute("/welcomes/" + guildID)
                .setAuthorization(apiKey)
                .build();

        return request.getStatusCode() == 200;
    }

}
