package sk.spse.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"ulica", "mesto"})
public class Adresa {

    private final String ulica;
    private final String mesto;

    @JsonCreator
    public Adresa(
            @JsonProperty("ulica") String ulica,
            @JsonProperty("mesto") String mesto
    ) {
        this.ulica = ulica;
        this.mesto = mesto;
    }

    public String getUlica() { return ulica; }
    public String getMesto() { return mesto; }

    @Override
    public String toString() {
        return ulica + ", " + mesto;
    }
}