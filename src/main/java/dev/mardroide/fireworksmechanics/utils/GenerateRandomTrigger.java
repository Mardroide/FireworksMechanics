package dev.mardroide.fireworksmechanics.utils;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandomTrigger {
    double random = ThreadLocalRandom.current().nextDouble(0.00, 100.00);

    public double getRandom() {
        return random;
    }
}
