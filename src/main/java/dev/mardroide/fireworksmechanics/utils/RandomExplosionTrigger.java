package dev.mardroide.fireworksmechanics.utils;

import dev.mardroide.fireworksmechanics.config.MainConfiguration;

import java.util.concurrent.ThreadLocalRandom;

public class RandomExplosionTrigger {
    public static boolean failureTrigger() {
        return ThreadLocalRandom.current().nextDouble(0.00, 100.00) >= MainConfiguration.getExplodeFailRate();
    }

    public static boolean boostFailureTrigger() {
        return ThreadLocalRandom.current().nextDouble(0.00, 100.00) >= MainConfiguration.getBoostFailRate();
    }

    public static boolean earlyExplodeTrigger() {
        return ThreadLocalRandom.current().nextDouble(0.00, 100.00) >= MainConfiguration.getEarlyExplodeRate();
    }
}