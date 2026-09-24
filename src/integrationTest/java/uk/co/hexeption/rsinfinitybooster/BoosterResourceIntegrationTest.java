package uk.co.hexeption.rsinfinitybooster;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BoosterResourceIntegrationTest {
    @Test
    void boosterDeclaresDependencyAndPackagesBothCardRecipes() throws IOException {
        String metadata = read("fabric.mod.json");
        String infinityRecipe = read("data/rsinfinitybooster/recipes/infinity_card.json");
        String dimensionRecipe = read("data/rsinfinitybooster/recipes/dimension_card.json");

        assertTrue(metadata.contains("\"id\": \"rsinfinitybooster\""));
        assertTrue(metadata.contains("\"refinedstorage\": \">=1.12.4-fabric.1\""));
        assertTrue(metadata.contains("uk.co.hexeption.rsinfinitybooster.RSInfinityBooster"));
        assertTrue(infinityRecipe.contains("rsinfinitybooster:infinity_card"));
        assertTrue(dimensionRecipe.contains("rsinfinitybooster:dimension_card"));
    }

    private static String read(String resource) throws IOException {
        try (InputStream stream = BoosterResourceIntegrationTest.class.getClassLoader().getResourceAsStream(resource)) {
            if (stream == null) {
                throw new IOException("Missing packaged resource: " + resource);
            }
            return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
