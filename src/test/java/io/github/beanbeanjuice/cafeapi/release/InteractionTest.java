package io.github.beanbeanjuice.cafeapi.release;

import io.github.beanbeanjuice.cafeapi.CafeAPI;
import io.github.beanbeanjuice.cafeapi.cafebot.interactions.InteractionType;
import io.github.beanbeanjuice.cafeapi.exception.ConflictException;
import io.github.beanbeanjuice.cafeapi.exception.NotFoundException;
import io.github.beanbeanjuice.cafeapi.requests.RequestLocation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InteractionTest {

    @Test
    @DisplayName("Test Interactions API (SENDERS)")
    public void interactionSendersAPITest() {
        CafeAPI cafeAPI = new CafeAPI("beanbeanjuice", System.getenv("RELEASE_API_PASSWORD"), RequestLocation.RELEASE);

        // Makes sure to delete the user before-hand.
        Assertions.assertTrue(cafeAPI.INTERACTION.deleteUserInteractionsSent("817975989547040795"));

        // Makes sure that a NotFoundException is thrown when trying to get the user.
        Assertions.assertThrows(NotFoundException.class, () -> cafeAPI.INTERACTION.getUserInteractionsSent("817975989547040795"));

        // Makes sure it is able to create the user.
        Assertions.assertTrue(cafeAPI.INTERACTION.createUserInteractionsSent("817975989547040795"));

        // Makes sure a ConflictException is thrown when the same user is tried to be made again.
        Assertions.assertThrows(ConflictException.class, () -> cafeAPI.INTERACTION.createUserInteractionsSent("817975989547040795"));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.HUG, 10));
        Assertions.assertEquals(10, cafeAPI.INTERACTION.getAllInteractionSenders().get("817975989547040795").getHugAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.PUNCH, 11));
        Assertions.assertEquals(11, cafeAPI.INTERACTION.getUserInteractionsSent("817975989547040795").getPunchAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.KISS, 12));
        Assertions.assertEquals(12, cafeAPI.INTERACTION.getSpecificUserInteractionSentAmount("817975989547040795", InteractionType.KISS));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.BITE, 13));
        Assertions.assertEquals(13, cafeAPI.INTERACTION.getAllInteractionSenders().get("817975989547040795").getBiteAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.BLUSH, 14));
        Assertions.assertEquals(14, cafeAPI.INTERACTION.getUserInteractionsSent("817975989547040795").getBlushAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.CUDDLE, 15));
        Assertions.assertEquals(15, cafeAPI.INTERACTION.getSpecificUserInteractionSentAmount("817975989547040795", InteractionType.CUDDLE));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.NOM, 16));
        Assertions.assertEquals(16, cafeAPI.INTERACTION.getAllInteractionSenders().get("817975989547040795").getNomAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.POKE, 17));
        Assertions.assertEquals(17, cafeAPI.INTERACTION.getUserInteractionsSent("817975989547040795").getPokeAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.SLAP, 18));
        Assertions.assertEquals(18, cafeAPI.INTERACTION.getSpecificUserInteractionSentAmount("817975989547040795", InteractionType.SLAP));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.STAB, 19));
        Assertions.assertEquals(19, cafeAPI.INTERACTION.getAllInteractionSenders().get("817975989547040795").getStabAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.HMPH, 20));
        Assertions.assertEquals(20, cafeAPI.INTERACTION.getUserInteractionsSent("817975989547040795").getHmphAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.POUT, 21));
        Assertions.assertEquals(21, cafeAPI.INTERACTION.getSpecificUserInteractionSentAmount("817975989547040795", InteractionType.POUT));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.THROW, 22));
        Assertions.assertEquals(22, cafeAPI.INTERACTION.getAllInteractionSenders().get("817975989547040795").getThrowAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.SMILE, 23));
        Assertions.assertEquals(23, cafeAPI.INTERACTION.getUserInteractionsSent("817975989547040795").getSmileAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.STARE, 24));
        Assertions.assertEquals(24, cafeAPI.INTERACTION.getSpecificUserInteractionSentAmount("817975989547040795", InteractionType.STARE));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.TICKLE, 25));
        Assertions.assertEquals(25, cafeAPI.INTERACTION.getAllInteractionSenders().get("817975989547040795").getTickleAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.RAGE, 26));
        Assertions.assertEquals(26, cafeAPI.INTERACTION.getUserInteractionsSent("817975989547040795").getRageAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.YELL, 27));
        Assertions.assertEquals(27, cafeAPI.INTERACTION.getSpecificUserInteractionSentAmount("817975989547040795", InteractionType.YELL));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.HEADPAT, 28));
        Assertions.assertEquals(28, cafeAPI.INTERACTION.getAllInteractionSenders().get("817975989547040795").getHeadpatAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.CRY, 29));
        Assertions.assertEquals(29, cafeAPI.INTERACTION.getUserInteractionsSent("817975989547040795").getCryAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.DANCE, 30));
        Assertions.assertEquals(30, cafeAPI.INTERACTION.getSpecificUserInteractionSentAmount("817975989547040795", InteractionType.DANCE));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.DAB, 31));
        Assertions.assertEquals(31, cafeAPI.INTERACTION.getAllInteractionSenders().get("817975989547040795").getDabAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.BONK, 32));
        Assertions.assertEquals(32, cafeAPI.INTERACTION.getUserInteractionsSent("817975989547040795").getBonkAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.SLEEP, 33));
        Assertions.assertEquals(33, cafeAPI.INTERACTION.getSpecificUserInteractionSentAmount("817975989547040795", InteractionType.SLEEP));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.DIE, 34));
        Assertions.assertEquals(34, cafeAPI.INTERACTION.getAllInteractionSenders().get("817975989547040795").getDieAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.WELCOME, 35));
        Assertions.assertEquals(35, cafeAPI.INTERACTION.getUserInteractionsSent("817975989547040795").getWelcomeAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.LICK, 36));
        Assertions.assertEquals(36, cafeAPI.INTERACTION.getSpecificUserInteractionSentAmount("817975989547040795", InteractionType.LICK));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionSentAmount("817975989547040795", InteractionType.SHUSH, 37));
        Assertions.assertEquals(37, cafeAPI.INTERACTION.getAllInteractionSenders().get("817975989547040795").getShushAmount());

        // Deletes the user from the database.
        Assertions.assertTrue(cafeAPI.INTERACTION.deleteUserInteractionsSent("817975989547040795"));
    }

    @Test
    @DisplayName("Test Interactions API (RECEIVERS)")
    public void interactionReceiversAPITest() {
        CafeAPI cafeAPI = new CafeAPI("beanbeanjuice", System.getenv("API_PASSWORD"), RequestLocation.BETA);

        // Makes sure to delete the user before-hand.
        Assertions.assertTrue(cafeAPI.INTERACTION.deleteUserInteractionsReceived("817975989547040795"));

        // Makes sure a NotFoundException is thrown when trying to search for the user.
        Assertions.assertThrows(NotFoundException.class, () -> cafeAPI.INTERACTION.getUserInteractionsReceived("817975989547040795"));

        // Makes sure the user can be created.
        Assertions.assertTrue(cafeAPI.INTERACTION.createUserInteractionsReceived("817975989547040795"));

        // Makes sure a ConflictException is thrown when trying to make the user again.
        Assertions.assertThrows(ConflictException.class, () -> cafeAPI.INTERACTION.createUserInteractionsReceived("817975989547040795"));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.HUG, 90));
        Assertions.assertEquals(90, cafeAPI.INTERACTION.getAllInteractionReceivers().get("817975989547040795").getHugAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.PUNCH, 91));
        Assertions.assertEquals(91, cafeAPI.INTERACTION.getUserInteractionsReceived("817975989547040795").getPunchAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.KISS, 92));
        Assertions.assertEquals(92, cafeAPI.INTERACTION.getSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.KISS));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.BITE, 93));
        Assertions.assertEquals(93, cafeAPI.INTERACTION.getAllInteractionReceivers().get("817975989547040795").getBiteAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.BLUSH, 94));
        Assertions.assertEquals(94, cafeAPI.INTERACTION.getUserInteractionsReceived("817975989547040795").getBlushAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.CUDDLE, 95));
        Assertions.assertEquals(95, cafeAPI.INTERACTION.getSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.CUDDLE));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.NOM, 96));
        Assertions.assertEquals(96, cafeAPI.INTERACTION.getAllInteractionReceivers().get("817975989547040795").getNomAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.POKE, 97));
        Assertions.assertEquals(97, cafeAPI.INTERACTION.getUserInteractionsReceived("817975989547040795").getPokeAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.SLAP, 98));
        Assertions.assertEquals(98, cafeAPI.INTERACTION.getSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.SLAP));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.STAB, 99));
        Assertions.assertEquals(99, cafeAPI.INTERACTION.getAllInteractionReceivers().get("817975989547040795").getStabAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.HMPH, 80));
        Assertions.assertEquals(80, cafeAPI.INTERACTION.getUserInteractionsReceived("817975989547040795").getHmphAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.POUT, 81));
        Assertions.assertEquals(81, cafeAPI.INTERACTION.getSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.POUT));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.THROW, 82));
        Assertions.assertEquals(82, cafeAPI.INTERACTION.getAllInteractionReceivers().get("817975989547040795").getThrowAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.SMILE, 83));
        Assertions.assertEquals(83, cafeAPI.INTERACTION.getUserInteractionsReceived("817975989547040795").getSmileAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.STARE, 84));
        Assertions.assertEquals(84, cafeAPI.INTERACTION.getSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.STARE));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.TICKLE, 85));
        Assertions.assertEquals(85, cafeAPI.INTERACTION.getAllInteractionReceivers().get("817975989547040795").getTickleAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.RAGE, 86));
        Assertions.assertEquals(86, cafeAPI.INTERACTION.getUserInteractionsReceived("817975989547040795").getRageAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.YELL, 87));
        Assertions.assertEquals(87, cafeAPI.INTERACTION.getSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.YELL));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.HEADPAT, 88));
        Assertions.assertEquals(88, cafeAPI.INTERACTION.getAllInteractionReceivers().get("817975989547040795").getHeadpatAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.CRY, 89));
        Assertions.assertEquals(89, cafeAPI.INTERACTION.getUserInteractionsReceived("817975989547040795").getCryAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.DANCE, 70));
        Assertions.assertEquals(70, cafeAPI.INTERACTION.getSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.DANCE));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.DAB, 71));
        Assertions.assertEquals(71, cafeAPI.INTERACTION.getAllInteractionReceivers().get("817975989547040795").getDabAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.BONK, 72));
        Assertions.assertEquals(72, cafeAPI.INTERACTION.getUserInteractionsReceived("817975989547040795").getBonkAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.SLEEP, 73));
        Assertions.assertEquals(73, cafeAPI.INTERACTION.getSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.SLEEP));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.DIE, 74));
        Assertions.assertEquals(74, cafeAPI.INTERACTION.getAllInteractionReceivers().get("817975989547040795").getDieAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.WELCOME, 75));
        Assertions.assertEquals(75, cafeAPI.INTERACTION.getUserInteractionsReceived("817975989547040795").getWelcomeAmount());

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.LICK, 76));
        Assertions.assertEquals(76, cafeAPI.INTERACTION.getSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.LICK));

        Assertions.assertTrue(cafeAPI.INTERACTION.updateSpecificUserInteractionReceivedAmount("817975989547040795", InteractionType.SHUSH, 77));
        Assertions.assertEquals(77, cafeAPI.INTERACTION.getAllInteractionReceivers().get("817975989547040795").getShushAmount());

        // Deletes the user from the database.
        Assertions.assertTrue(cafeAPI.INTERACTION.deleteUserInteractionsReceived("817975989547040795"));
    }

}