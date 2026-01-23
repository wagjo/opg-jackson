package sk.spse.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"ulica", "mesto"})
public record RecordAdresa (@JsonProperty("ulica") String ulica,
                           @JsonProperty("mesto") String mesto) {

    @Override
    public String toString() {
        return ulica + ", " + mesto;
    }
}