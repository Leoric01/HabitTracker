package com.leoric.habit.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "day_templates")

public class DayTemplate {
    @Id
    @GeneratedValue
    private Long id;

    private String name; // pracovní den, home office, volno doma, volno mimo

    @OneToMany(mappedBy = "dayTemplate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimeBlock> timeBlocks = new ArrayList<>();
}