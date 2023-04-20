package dev.huffstler.searobinclassic.parse;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import dev.huffstler.searobinclassic.rules.Rules;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataImporter {

    public DataImporter(){}

    final CsvMapper mapper = new CsvMapper();
    final Rules calc = new Rules();

    public Map<String, Float> getScoreboard(File file) throws IOException {

        System.out.println("In dataimporter");

        Map<String, Float> scoreboard = new HashMap<>();
        Map<String, List<Float>> anglerTotals = new HashMap<>();

        CsvSchema schema = mapper.schemaFor(Haul.class);

        // Might not work as single string, not sure how it handles
        String doc = Files.readString(file.toPath());

        System.out.println(doc);

        try (MappingIterator<Haul> it = mapper.readerFor(Haul.class).with(schema).readValues(doc)){

            var results = it.readAll();

            // calculate scores now that we have all the data imported
            for (var haul : results){
                var haulScore = calc.getScore(haul);

                // add to array if angler already caught something...
                // create new Map entry if this is their first catch
                if (anglerTotals.containsKey(haul.angler)){
                    // audit logging here
                    anglerTotals.get(haul.getAngler()).add(haulScore);
                } else {
                    // audit logging here
                    anglerTotals.put(haul.getAngler(), List.of(haulScore));
                }
            }


        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        // finally, add the scores of all individual fish together, per angler and return as a Map<String, Float>
        for (String anglerName : anglerTotals.keySet()){
            // audit logging here
            scoreboard.put(anglerName, anglerTotals.get(anglerName).stream().reduce(Float::sum).orElse(0f));
        }

        return scoreboard;
    }

}
