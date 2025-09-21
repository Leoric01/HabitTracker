package com.leoric.habit.models;

import com.leoric.habit.models.constants.DayStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_days")
public class UserDay {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private DayStatus status;

    @ManyToOne
    private User user;

    @ManyToOne
    private DayTemplate chosenTemplate;

    @OneToMany(mappedBy = "userDay", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserHabit> habits = new ArrayList<>();
}