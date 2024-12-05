package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Message extends PanacheEntity {
    private String message;
    private LocalDateTime dateTime;
    @ManyToOne
    private AppUser sender;
    @ManyToOne
    private AppUser receiver;

    public Message() {}

}
