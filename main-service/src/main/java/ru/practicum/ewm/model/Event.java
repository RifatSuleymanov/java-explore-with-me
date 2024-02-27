package ru.practicum.ewm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Valid
@Table(name = "events", schema = "public")
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2000)
    @NotBlank
    private String annotation;

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    private Integer confirmedRequests;

    @Column(nullable = false)
    private LocalDateTime eventDate;

    @OneToOne
    @JoinColumn(name = "initiator_id", referencedColumnName = "id")
    private User initiator;

    @Column(nullable = false)
    private Boolean paid;

    @Column(nullable = false, length = 120)
    private String title;

    @Transient
    private Long views;

    @Column(nullable = false, name = "created_On")
    private LocalDateTime createdOn;

    @Column(nullable = false, length = 7000)
    @NotBlank
    private String description;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @Column(nullable = false)
    @PositiveOrZero
    private Integer participantLimit;

    private LocalDateTime publishedOn;

    @Column(nullable = false)
    private Boolean requestModeration;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EventState state;
}