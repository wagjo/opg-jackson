package sk.spse.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.time.LocalDate;

@JsonPropertyOrder({"meno", "priezvisko", "titul", "pohlavie", "datumNarodenia"})
public record RecordOsoba (@JsonProperty("meno") String meno,
                           @JsonProperty("priezvisko") String priezvisko,
                           @JsonProperty("titul") String titul,
                           @JsonProperty("pohlavie") Pohlavie pohlavie,
                           @JsonProperty("datumNarodenia") LocalDate datumNarodenia,
                           @JsonUnwrapped @JsonProperty("adresa") RecordAdresa adresa) {
    public String toString() {
        return meno + " " + priezvisko + ", " + datumNarodenia() + ": " + adresa;
    }
}
