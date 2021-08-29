package com.br.webfeira.model;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

import lombok.NoArgsConstructor;

@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractEntity {
	
	@Id @Type(type = "pg-uuid")
    private UUID id;

    public AbstractEntity() {
        this.id = UUID.randomUUID();
    }
}
