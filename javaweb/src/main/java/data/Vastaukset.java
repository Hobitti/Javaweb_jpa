
package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vastaukset {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VastausID")
	private int id;
	
	@Column(name = "KysymysID")
	private int kysymysId;
	@Id
	@Column(name = "EhdokasID")
	private int ehdokasId;
	
	@Column(name = "Vastasi")
	private int vastasi;
	
	@Column(name = "Perustelu")
	private String perustelu;

public Vastaukset(int id, int ehdokasId, int kysymysId, int vastasi, String perustelu) {
	super();
	this.id = id;
	this.ehdokasId = ehdokasId;
	this.kysymysId = kysymysId;
	this.vastasi = vastasi;
	this.perustelu = perustelu;
//	this.average = average;
}
	
	public Vastaukset() {
		//todo
	}
	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getEhdokasId() {
		return ehdokasId;
	}
	
	public void setEhdokasId(int ehdokasId) {
		this.ehdokasId = ehdokasId;
	}
	
	public int getKysymysId() {
		return kysymysId;
	}
	
	public void setKysymysId(int kysymysId) {
		this.kysymysId = kysymysId;
	}
	
	public int getVastasi() {
		return vastasi;
	}
	
	public void setVastasi(int vastasi) {
		this.vastasi = vastasi;
	}
	
	public String getPerustelu() {
		return perustelu;
	}
	
	public void setPerustelu(String perustelu) {
		this.perustelu = perustelu;
	}
	
//	public float getAverage() {
//		return average;
//	}
//	
//	public void setAverage(float average) {
//		this.average = average;
//	}
}	
