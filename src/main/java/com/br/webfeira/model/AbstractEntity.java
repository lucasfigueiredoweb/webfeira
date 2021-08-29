package com.br.webfeira.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

@MappedSuperclass
public abstract class AbstractEntity {
	
	@Id
	@Type(type = "pg-uuid")
	@Column(name="ID")
    private UUID id;

    public AbstractEntity() {
        this.id = UUID.randomUUID();
    }
}
