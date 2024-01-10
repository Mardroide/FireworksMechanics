package dev.mardroide.fireworksmechanics.utils;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomTrigger {
    public static double randomTrigger() {
        return ThreadLocalRandom.current().nextDouble(0.00, 100.00);
    }
}
