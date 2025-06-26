package com.minjeong.usedPhone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsedPhoneResponseDTO {
    private Long id;
    private String name;
    private String seller;
    private int price;
    private String imageUrl;
    private String number;
}
