package dev.huffstler.searobinclassic.parse;

import org.junit.jupiter.api.Test;
import java.io.File;

public class DataImporterTest {

    @Test
    void testImportDataFromCustomCSV(){
        ClassLoader cl = getClass().getClassLoader();
        File f = new File(cl.getResource("test.csv").getFile());

        System.out.println(f.getAbsolutePath());

        DataImporter di = new DataImporter();

        try {
            var scoreboard = di.getScoreboard(f);
            System.out.println(scoreboard.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
