package com.example.demo.dto;

import com.example.demo.models.Club;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotEmpty(message = "Location cannot be empty")
    private String location;
    @NotEmpty(message = "Photo URL cannot be empty")
    private String photoUrl;
    @NotEmpty(message = "Type cannot be empty")
    private String type;
    @NotEmpty(message = "Details cannot be empty")
    private String details;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    private Club club;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
}
