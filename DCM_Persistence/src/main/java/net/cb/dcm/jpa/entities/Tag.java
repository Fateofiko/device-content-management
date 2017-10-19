package net.cb.dcm.jpa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TAGS")
@NamedQuery(name = "AllTags", query = "select t from Tag t")
public class Tag {
	@Id
    @GeneratedValue
    private long id;
	
    @Column(unique=true, length=30)
    private String name;
    @Column(length=250)
    private String description;
	private boolean system;
	
	@OneToMany(mappedBy="tag")
	private List<DeviceTagRelation> devices;

    public long getId() {
        return id;
    }

    public void setId(long newId) {
        this.id = newId;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isSystem() {
		return system;
	}

	public void setSystem(boolean system) {
		this.system = system;
	}

	public List<DeviceTagRelation> getDevices() {
		return devices;
	}

	public void setDevices(List<DeviceTagRelation> devices) {
		this.devices = devices;
	}
}
