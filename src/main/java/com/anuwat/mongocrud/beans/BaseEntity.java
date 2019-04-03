package com.anuwat.mongocrud.beans;

import org.bson.types.ObjectId;

import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;
import dev.morphia.annotations.Version;

public abstract class BaseEntity {
	 
    @Id
    @Property("id")
    protected ObjectId id;
 
    @Version
    @Property("version")
    private Long version;
 
    public BaseEntity() {
        super();
    }
 
    public ObjectId getId() {
        return id;
    }
 
    public void setId(ObjectId id) {
        this.id = id;
    }
 
    public Long getVersion() {
        return version;
    }
 
    public void setVersion(Long version) {
        this.version = version;
    }

	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", version=" + version + "]";
	}
 
}