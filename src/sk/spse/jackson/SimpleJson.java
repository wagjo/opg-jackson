package sk.spse.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.util.List;

public class SimpleJson {

    public static void main(String[] args) throws Exception {

        // Hlavný objekt pre Jackson
        ObjectMapper mapper = new ObjectMapper();
        // Pridanie podpory pre java.time (LocalDate)
        mapper.registerModule(new JavaTimeModule());

        File file = new File("assets/osoby1.json");

        // Parsovanie sa vykoná tu
        List<SimpleOsoba> osoby = mapper.readValue(
                file,
                // Tu povieme Jacksonu akú štruktúru má json,
                // teda zoznam osôb - List v ktorm sú objekty SimpleOsoba
                new TypeReference<List<SimpleOsoba>>() {}
        );


        for (SimpleOsoba osoba : osoby) {
            System.out.println(osoba);
        }


        // pekné odsadenie (pretty print)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // Chceme zapísať dátum v ISO formáte
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // Zapísanie dát do súboru
        File output = new File("out/osoby1.json");
        mapper.writeValue(output,osoby);
    }
}
