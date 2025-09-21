package com.leoric.habit.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "habit_templates")
public class HabitTemplate {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private TimeBlock timeBlock;
}