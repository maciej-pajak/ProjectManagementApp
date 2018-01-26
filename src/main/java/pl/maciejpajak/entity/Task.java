package pl.maciejpajak.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String topic;
    
    @NotBlank
    private String description;
    
    @ManyToOne // TODO
    private Project project;
    
    @ManyToOne // TODO
    private Status status;
    
    @ManyToOne
    private Priority priority;
    
    @ManyToOne
    private User user;

}
