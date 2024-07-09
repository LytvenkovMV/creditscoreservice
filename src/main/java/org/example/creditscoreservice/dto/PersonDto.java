package org.example.creditscoreservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    @JsonProperty(value = "inn", required = true)
    private String inn;

    @JsonProperty(value = "full_name")
    private String fullName;

    @JsonProperty(value = "credit_score", required = true)
    private String creditScore;

    @JsonProperty(value = "phone")
    private String phone;

    @JsonProperty(value = "email")
    private String email;
}
