package com.leoric.habit.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "time_blocks")
public class TimeBlock {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    private DayTemplate dayTemplate;

    @OneToMany(mappedBy = "timeBlock", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HabitTemplate> habitTemplates = new ArrayList<>();
}