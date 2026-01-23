package sk.spse.jackson;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.util.List;

public class RecordCsv {

    public static void main(String[] args) throws Exception {

        // Hlavný objekt pre Jackson
        CsvMapper mapper = new CsvMapper();
        // Pridanie podpory pre java.time (LocalDate)
        mapper.registerModule(new JavaTimeModule());

        File file = new File("assets/osoby2.csv");

        // Definovanie schémy podľa hlavičky CSV
        // Jackson použije názvy stĺpcov z hlavičky CSV na mapovanie
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        List<RecordOsoba> osoby = null;

        // Načítanie z CSV súboru
        try (MappingIterator<RecordOsoba> it = mapper.readerFor(RecordOsoba.class)
                .with(schema)
                .readValues(file)) {

            osoby = it.readAll();

        }


        for (RecordOsoba osoba : osoby) {
            System.out.println(osoba);
        }


        // Chceme zapísať dátum v ISO formáte
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // Definovanie CSV schémy pre zápis
        CsvSchema schemaOut = mapper
                .schemaFor(RecordOsoba.class)
                .withHeader(); // pridať riadok s hlavičkou CSV

        // Zápis CSV súboru
        File output = new File("out/osoby2.csv");
        mapper.writer(schemaOut).writeValue(output, osoby);
    }
}
