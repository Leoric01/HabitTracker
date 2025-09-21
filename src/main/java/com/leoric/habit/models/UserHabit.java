package com.leoric.habit.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_habits")
public class UserHabit {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private boolean completed;

    @ManyToOne
    private UserDay userDay;

    @ManyToOne
    private TimeBlock timeBlock;
}