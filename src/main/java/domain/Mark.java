package domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Aleksei_Ivshin
 *
 */
@Entity
 @Table(name="mark")
public class Mark implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6437859440145961767L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name="name")
	private String name;

	@Column(name="deleted")
	private int deleted;

	public Mark() {
	}

	public Mark(long id, String name) {
		this.id = id;
		this.name = name;
		this.deleted=0;
	}


	public Mark(String name) {
		this.name = name;
		this.deleted=0;
	}

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

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

}
