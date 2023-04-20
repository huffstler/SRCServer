package dev.huffstler.searobinclassic.parse;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataImporterTest {

    @Test
    void testImportDataFromCustomCSV(){
        ClassLoader cl = getClass().getClassLoader();
        var encoded = cl.getResource("test.csv").getFile();
        var decoded = URLDecoder.decode(encoded, StandardCharsets.UTF_8);
        File f = new File(decoded);

        DataImporter di = new DataImporter();

        try {
            var scoreboard = di.getScoreboard(f);
            System.out.printf(
                """
                Scoreboard:
                %s
                """,
            scoreboard);

            assertEquals(1157.0f, scoreboard.get("nick"));
            assertEquals(0f, scoreboard.get("derek"));
            assertEquals(625.0f, scoreboard.get("pat"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
