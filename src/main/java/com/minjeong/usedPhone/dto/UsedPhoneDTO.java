package com.minjeong.usedPhone.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsedPhoneDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String name;
    private String seller;
    private int price;
    private String imageUrl;
    private int number;

    // ID 없이 생성하기 위한 생성자
    public UsedPhoneDTO(String name, String seller, int price, String imageUrl, int number) {
        this.name = name;
        this.seller = seller;
        this.price = price;
        this.imageUrl = imageUrl;
        this.number = number;
    }
}
