package top.cmarco.fireworksmechanics.utils;

import top.cmarco.fireworksmechanics.config.MainConfiguration;

import java.util.concurrent.ThreadLocalRandom;

public class RandomExplosionTrigger {
    private static MainConfiguration config;

    /**
     * @return If the random double is bigger than explode-fail-rate.
     */

    public static boolean failureTrigger() {
        return ThreadLocalRandom.current().nextDouble(0.00, 100.00) >= config.getExplodeFailRate();
    }

    public static boolean earlyExplodeTrigger() {
        return  ThreadLocalRandom.current().nextDouble(0.00, 100.00) >= config.getEarlyExplodeRate();
    }
}
