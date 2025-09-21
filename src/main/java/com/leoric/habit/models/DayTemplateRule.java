package com.leoric.habit.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "day_template_rules")
public class DayTemplateRule {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @ManyToOne
    private User user;

    @ManyToOne
    private DayTemplate template;
}