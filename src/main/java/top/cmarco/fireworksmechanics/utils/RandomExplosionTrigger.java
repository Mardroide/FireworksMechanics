package top.cmarco.fireworksmechanics.utils;

import top.cmarco.fireworksmechanics.config.MainConfiguration;

import java.util.concurrent.ThreadLocalRandom;

public class RandomExplosionTrigger {
    private MainConfiguration config;

    /**
     * @return If the random double is bigger than explode-fail-rate.
     */

    public boolean failureTrigger() {
        return ThreadLocalRandom.current().nextDouble(0.00, 100.00) >= config.getExplodeFailRate();
    }
}
