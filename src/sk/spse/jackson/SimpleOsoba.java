package sk.spse.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({"meno", "priezvisko", "titul", "pohlavie", "datumNarodenia"})
public class SimpleOsoba {

    private final String meno;
    private final String priezvisko;
    private final String titul;
    private final Pohlavie pohlavie;
    private final LocalDate datumNarodenia;

    @JsonCreator  // Jackson tento konštruktor použije pri vytváraní objektu z JSON
    public SimpleOsoba(
            // mapovanie JSON atribútov na atribúty triedy
            @JsonProperty("meno") String meno,
            @JsonProperty("priezvisko") String priezvisko,
            @JsonProperty("titul") String titul,
            // Jackson automaticky skovertuje na enum alebo LocalDate
            @JsonProperty("pohlavie") Pohlavie pohlavie,
            @JsonProperty("datumNarodenia") LocalDate datumNarodenia
    ) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.titul = titul;
        this.pohlavie = pohlavie;
        this.datumNarodenia = datumNarodenia;
    }

    public String getMeno() {
        return meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public String getTitul() {
        return titul;
    }

    public Pohlavie getPohlavie() {
        return pohlavie;
    }

    public LocalDate getDatumNarodenia() {
        return datumNarodenia;
    }

    public String toString() {
        return meno + " " + priezvisko + ", " + getDatumNarodenia();
    }
}
