package data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kunta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "KuntaID")
	private int id;
	
	@Column(name = "Nimi")
	private String nimi;
	
	@Column(name = "Num")
	private int num;
	
	private List<Ehdokas> ehdokkaat;
	
	public Kunta(int id, String nimi, int num) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.num = num;
	}
	
	public Kunta() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
