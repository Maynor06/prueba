package com.noticiero.demo.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsDTORequest {

    private String titulo;
    private String imageUrl;
    private String content;
    private Long userId;
    private Long categoryId;

}
