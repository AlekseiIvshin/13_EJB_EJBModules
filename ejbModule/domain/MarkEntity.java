package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MarkEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_car_mark")
	private int id;
	
	@Column
	private String name;

	@Column
	private int deleted;
	
	public MarkEntity(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	} 
	
}
