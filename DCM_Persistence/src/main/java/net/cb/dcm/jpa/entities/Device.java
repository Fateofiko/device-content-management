package net.cb.dcm.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Devices")
@NamedQuery(name = "AllDevices", query = "select d from Device d")
public class Device {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(length=30)
	private String name;
	
	@Column(length=250)
	private String description;
	
	@Column(name="DEV_TYPE")
	private int devType; //(integer) � device type (1 � monitor, 2 � mobile device, 3�)
	
	private int size; //Size in inches
	
	@Column(length=50)
	private String model;
	
	@Column(length=40)
	private String ip;
	
//	@OneToMany(mappedBy = "publisher")
//	private List<Tag> books = new HashSet()<Tag>();
	
	@OneToMany(mappedBy="device")
	private List<DeviceTagRelation> tags;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getDevType() {
		return devType;
	}

	public void setDevType(int devType) {
		this.devType = devType;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
  public void addTag(Tag ioTag) {
    DeviceTagRelation loRel = new DeviceTagRelation();
    loRel.setDevice(this);
    loRel.setDeviceId(this.getId());
    
    loRel.setTag(ioTag);
    loRel.setTagId(ioTag.getId());
    if(this.tags == null)
       this.tags = new ArrayList<>();

    this.tags.add(loRel);
    // Also add the association object to the employee.
    ioTag.getDevices().add(loRel);
  }

public String getIp() {
	return ip;
}

public void setIp(String ip) {
	this.ip = ip;
}	
}

