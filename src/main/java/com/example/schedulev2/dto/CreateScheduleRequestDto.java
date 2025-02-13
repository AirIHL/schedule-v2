package com.example.schedulev2.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private final String name;

    private final String title;

    private final String contents;

    public CreateScheduleRequestDto(String name, String title, String contents) {
        this.name = name;
        this.title = title;
        this.contents = contents;
    }
}
