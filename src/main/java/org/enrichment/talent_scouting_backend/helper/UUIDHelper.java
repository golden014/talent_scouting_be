package org.enrichment.talent_scouting_backend.helper;

import java.security.SecureRandom;
import java.util.UUID;

public class UUIDHelper
{
    private static final SecureRandom secureRandom = new SecureRandom();

    //generate a UUID and returned it as a string
    public static String generateUUID() {
        UUID uuid = new UUID(secureRandom.nextLong(), secureRandom.nextLong());
        return uuid.toString();
    }
}
