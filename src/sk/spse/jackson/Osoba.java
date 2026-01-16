package sk.spse.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.time.LocalDate;

@JsonPropertyOrder({"meno", "priezvisko", "titul", "pohlavie", "datumNarodenia"})
public class Osoba {

    private final String meno;
    private final String priezvisko;
    private final String titul;
    private final Pohlavie pohlavie;
    private final LocalDate datumNarodenia;

    // JsonUnwrapped znamená, že v JSONe budú hodnoty z adresy
    // a nie samostatný vnorený objekt
    @JsonUnwrapped
    private final Adresa adresa;

    @JsonCreator  // Jackson tento konštruktor použije pri vytváraní objektu z JSON
    public Osoba(
            // mapovanie JSON atribútov na atribúty triedy
            @JsonProperty("meno") String meno,
            @JsonProperty("priezvisko") String priezvisko,
            @JsonProperty("titul") String titul,
            // Jackson automaticky skovertuje na enum alebo LocalDate
            @JsonProperty("pohlavie") Pohlavie pohlavie,
            @JsonProperty("datumNarodenia") LocalDate datumNarodenia,
            // Jackson podľa anotácii v trieda Adresa bude vedieť,
            // ktoré atribúty z JSONu treba vložiť do adresy
            @JsonProperty("adresa") Adresa adresa
    ) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.titul = titul;
        this.pohlavie = pohlavie;
        this.datumNarodenia = datumNarodenia;
        this.adresa = adresa;
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
        return meno + " " + priezvisko + ", " + getDatumNarodenia() + ": " + adresa;
    }

    public Adresa getAdresa() {
        return adresa;
    }


}
