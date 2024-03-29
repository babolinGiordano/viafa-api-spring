package com.babo.bmbtrasporti.viafa.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "travel")
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade={ CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.PERSIST })
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne(cascade={ CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.PERSIST })
    @JoinColumn(name = "truck_id")
    private Truck truck;

    @ManyToOne(cascade={ CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.PERSIST })
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "departure")
    private String departure;

    @Column(name = "destination")
    private String destination;

    @Column(name = "tot_km")
    private int totKm;

    @Column(name = "rate")
    private int rate;

    @Column(name = "travel_date")
    private LocalDateTime travelDate;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;
}
