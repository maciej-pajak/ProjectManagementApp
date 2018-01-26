package pl.maciejpajak.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tasks")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String topic;
    
    @NotBlank
    private String description;
    
    @ManyToOne
    private Project project;
    
    @ManyToOne
    private Status status;
    
    @ManyToOne
    private Priority priority;
    
    @ManyToOne
    private User user;

}
