package com.noticiero.demo.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsDTOResponse {

    private Long id;
    private String titulo;
    private String imageUrl;
    private String content;
    private Long userId;
    private Long categoryId;

}
