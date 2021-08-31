import com.beanbeanjuice.cafeapi.CafeAPI;
import com.beanbeanjuice.cafeapi.cafebot.counting.CountingInformation;
import com.beanbeanjuice.cafeapi.exception.ConflictException;
import com.beanbeanjuice.cafeapi.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountingInformationTest {

    @Test
    @DisplayName("Counting Information API Test")
    public void testCountingInformationAPI() {
        CafeAPI cafeAPI = new CafeAPI("beanbeanjuice", System.getenv("API_PASSWORD"));

        // Makes sure the counting information for the guild is deleted beforehand.
        Assertions.assertTrue(cafeAPI.countingInformations().deleteGuildCountingInformation("605489113323536433"));

        // Makes sure the counting information for the guild does not exist.
        Assertions.assertThrows(NotFoundException.class, () -> cafeAPI.countingInformations().getGuildCountingInformation("605489113323536433"));

        // Makes sure the counting information for the guild can be created.
        Assertions.assertTrue(cafeAPI.countingInformations().createGuildCountingInformation("605489113323536433"));

        // Makes sure duplicate counting informations cannot be created.
        Assertions.assertThrows(ConflictException.class, () -> cafeAPI.countingInformations().createGuildCountingInformation("605489113323536433"));

        // Makes sure the counting information's highest number by default is 0.
        Assertions.assertEquals(0, cafeAPI.countingInformations().getGuildCountingInformation("605489113323536433").getHighestNumber());

        // Makes sure the counting information's last number by default is 0.
        Assertions.assertEquals(0, cafeAPI.countingInformations().getAllCountingInformation().get("605489113323536433").getLastNumber());

        // Makes sure the counting information's last user ID by default is "0".
        Assertions.assertEquals("0", cafeAPI.countingInformations().getGuildCountingInformation("605489113323536433").getLastUserID());

        // Makes sure the counting information can be updated.
        Assertions.assertTrue(cafeAPI.countingInformations().updateGuildCountingInformation("605489113323536433", new CountingInformation(
                133, 100, "178272524533104642")));

        // Confirms the new highest number is 133.
        Assertions.assertEquals(133, cafeAPI.countingInformations().getGuildCountingInformation("605489113323536433").getHighestNumber());

        // Confirms the new last number is 100.
        Assertions.assertEquals(100, cafeAPI.countingInformations().getGuildCountingInformation("605489113323536433").getLastNumber());

        // Confirms the new last user ID is "178272524533104642".
        Assertions.assertEquals("178272524533104642", cafeAPI.countingInformations().getGuildCountingInformation("605489113323536433").getLastUserID());

        // Makes sure the counting information can be deleted.
        Assertions.assertTrue(cafeAPI.countingInformations().deleteGuildCountingInformation("605489113323536433"));

        // Makes sure the counting information throws a NotFounException when trying to retrieve it again.
        Assertions.assertThrows(NotFoundException.class, () -> cafeAPI.countingInformations().getGuildCountingInformation("605489113323536433"));
    }
}
