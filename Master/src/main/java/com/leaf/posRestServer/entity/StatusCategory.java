package com.leaf.posRestServer.entity;

import javax.persistence.*;

/**
 * @author : Rusiru on 03-Dec-17.
 */
@Entity
@Table(name = "status_category")
public class StatusCategory {

    private Long id;
    private String code;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "code", nullable = false, length = 15 ,unique = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "description", nullable = false, length = 150)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
