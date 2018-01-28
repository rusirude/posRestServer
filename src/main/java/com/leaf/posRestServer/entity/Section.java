package com.leaf.posRestServer.entity;

import javax.persistence.*;

/**
 * Created by Rusiru on 13-Jan-18.
 */
@Entity
@Table(name = "section")
public class Section {

    private Long id;
    private String code;
    private String description;
    private Status status;
    private Integer canDelete;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "code", nullable = false, length = 15,unique = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "description", nullable = false,length = 150)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Column(name = "can_delete", nullable = false,length = 150)
    public Integer getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Integer canDelete) {
        this.canDelete = canDelete;
    }
}
