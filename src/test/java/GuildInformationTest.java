import com.beanbeanjuice.cafeapi.CafeAPI;
import com.beanbeanjuice.cafeapi.cafebot.guilds.GuildInformationType;
import com.beanbeanjuice.cafeapi.exception.ConflictException;
import com.beanbeanjuice.cafeapi.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GuildInformationTest {

    @Test
    @DisplayName("Guild Information API Test")
    public void testGuildInformationAPI() {
        CafeAPI cafeAPI = new CafeAPI("beanbeanjuice", System.getenv("API_PASSWORD"));

        // Makes sure the guild is deleted beforehand.
        Assertions.assertTrue(cafeAPI.guildInformations().deleteGuildInformation("816880157490675732"));

        // Makes sure the guild does not exist.
        Assertions.assertThrows(NotFoundException.class, () -> cafeAPI.guildInformations().getGuildInformation("816880157490675732"));

        // Makes sure the guild can be created.
        Assertions.assertTrue(cafeAPI.guildInformations().createGuildInformation("816880157490675732"));

        // Makes sure the guild cannot be created as it already exists.
        Assertions.assertThrows(ConflictException.class, () -> cafeAPI.guildInformations().createGuildInformation("816880157490675732"));

        // Makes sure the prefix is default and can be changed.
        Assertions.assertEquals("!!", cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getPrefix());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.PREFIX, "beta!"));
        Assertions.assertEquals("beta!", cafeAPI.guildInformations().getGuildInformation("816880157490675732").getPrefix());

        // Makes sure the moderator role ID is default and can be changed.
        Assertions.assertEquals("0", cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getModeratorRoleID());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.MODERATOR_ROLE_ID, "738590591767543921"));
        Assertions.assertEquals("738590591767543921", cafeAPI.guildInformations().getGuildInformation("816880157490675732").getModeratorRoleID());

        // Makes sure the twitch channel ID is default and can be changed.
        Assertions.assertEquals("0", cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getTwitchChannelID());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.TWITCH_CHANNEL_ID, "856782983709458472"));
        Assertions.assertEquals("856782983709458472", cafeAPI.guildInformations().getGuildInformation("816880157490675732").getTwitchChannelID());

        // Makes sure the muted role ID is default and can be changed.
        Assertions.assertEquals("0", cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getMutedRoleID());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.MUTED_ROLE_ID, "856776166618300436"));
        Assertions.assertEquals("856776166618300436", cafeAPI.guildInformations().getGuildInformation("816880157490675732").getMutedRoleID());

        // Makes sure the live notifications role ID is default and can be changed.
        Assertions.assertEquals("0", cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getLiveNotificationsRoleID());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.LIVE_NOTIFICATIONS_ROLE_ID, "858231567196618772"));
        Assertions.assertEquals("858231567196618772", cafeAPI.guildInformations().getGuildInformation("816880157490675732").getLiveNotificationsRoleID());

        // Makes sure notify on update is default and can be changed.
        Assertions.assertEquals(true, cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getNotifyOnUpdate());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.NOTIFY_ON_UPDATE, "false"));
        Assertions.assertEquals(false, cafeAPI.guildInformations().getGuildInformation("816880157490675732").getNotifyOnUpdate());

        // Makes sure the update channel ID is default and can be changed.
        Assertions.assertEquals("0", cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getUpdateChannelID());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.UPDATE_CHANNEL_ID, "645490120052703239"));
        Assertions.assertEquals("645490120052703239", cafeAPI.guildInformations().getGuildInformation("816880157490675732").getUpdateChannelID());

        // Makes sure the counting channel ID is default and can be changed.
        Assertions.assertEquals("0", cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getCountingChannelID());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.COUNTING_CHANNEL_ID, "733203398337495041"));
        Assertions.assertEquals("733203398337495041", cafeAPI.guildInformations().getGuildInformation("816880157490675732").getCountingChannelID());

        // Makes sure the poll channel ID is default and can be changed.
        Assertions.assertEquals("0", cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getPollChannelID());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.POLL_CHANNEL_ID, "359760149683896320"));
        Assertions.assertEquals("359760149683896320", cafeAPI.guildInformations().getGuildInformation("816880157490675732").getPollChannelID());

        // Makes sure the raffle channel ID is default and can be changed.
        Assertions.assertEquals("0", cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getRaffleChannelID());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.RAFFLE_CHANNEL_ID, "813817485014990860"));
        Assertions.assertEquals("813817485014990860", cafeAPI.guildInformations().getGuildInformation("816880157490675732").getRaffleChannelID());

        // Makes sure the birthday channel ID is default and can be changed.
        Assertions.assertEquals("0", cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getBirthdayChannelID());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.BIRTHDAY_CHANNEL_ID, "500658624109084682"));
        Assertions.assertEquals("500658624109084682", cafeAPI.guildInformations().getGuildInformation("816880157490675732").getBirthdayChannelID());

        // Makes sure the welcome channel ID is default and can be changed.
        Assertions.assertEquals("0", cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getWelcomeChannelID());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.WELCOME_CHANNEL_ID, "877240864240443412"));
        Assertions.assertEquals("877240864240443412", cafeAPI.guildInformations().getGuildInformation("816880157490675732").getWelcomeChannelID());

        // Makes sure the log channel ID is default and can be changed.
        Assertions.assertEquals("0", cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getLogChannelID());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.LOG_CHANNEL_ID, "857024885968732181"));
        Assertions.assertEquals("857024885968732181", cafeAPI.guildInformations().getGuildInformation("816880157490675732").getLogChannelID());

        // Makes sure the venting channel ID is default and can be changed.
        Assertions.assertEquals("0", cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getVentingChannelID());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.VENTING_CHANNEL_ID, "125227483518861312"));
        Assertions.assertEquals("125227483518861312", cafeAPI.guildInformations().getGuildInformation("816880157490675732").getVentingChannelID());

        // Makes sure the AI response status is default and can be changed.
        Assertions.assertEquals(false, cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getAiResponseStatus());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.AI_RESPONSE, "1"));
        Assertions.assertEquals(true, cafeAPI.guildInformations().getGuildInformation("816880157490675732").getAiResponseStatus());

        // Makes sure the daily channel ID is default and can be changed.
        Assertions.assertEquals("0", cafeAPI.guildInformations().getAllGuildInformation().get("816880157490675732").getDailyChannelID());
        Assertions.assertTrue(cafeAPI.guildInformations().updateGuildInformation("816880157490675732", GuildInformationType.DAILY_CHANNEL_ID, "606222472274116676"));
        Assertions.assertEquals("606222472274116676", cafeAPI.guildInformations().getGuildInformation("816880157490675732").getDailyChannelID());

        // Makes sure the guild "bruh" doesn't exist.
        Assertions.assertThrows(NotFoundException.class, () -> cafeAPI.guildInformations().updateGuildInformation("bruh", GuildInformationType.NOTIFY_ON_UPDATE, "false"));

        // Makes sure the guild is deleted beforehand.
        Assertions.assertTrue(cafeAPI.guildInformations().deleteGuildInformation("816880157490675732"));

        // Makes sure the guild does not exist.
        Assertions.assertThrows(NotFoundException.class, () -> cafeAPI.guildInformations().getGuildInformation("816880157490675732"));

    }

}
