package uk.co.hexeption.rsinfinitybooster;

import org.junit.jupiter.api.Test;
import uk.co.hexeption.rsinfinitybooster.config.ServerConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServerConfigTest {
    @Test
    void cardEnergyDefaultsMatchConfiguredGameplayCosts() {
        ServerConfig config = new ServerConfig();

        assertEquals(4000, config.getInfinityCard().getEnergyUsage());
        assertEquals(8000, config.getDimensionCard().getEnergyUsage());
    }
}
