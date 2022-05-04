package data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kunta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "KuntaID")
	private int KuntaID;
	private String Nimi;
	private int Num;
	/*
	 * @Column(name = "Nimi") private String Nimi;
	 * 
	 * @Column(name = "Num") private int Num;
	 * 
	 * @OneToMany(mappedBy = "kunta") private List<Ehdokas> ehdokkaat;
	 */
	
	public Kunta(int KuntaID, String Nimi, int Num) {
		super();
		this.KuntaID = KuntaID;
		this.Nimi = Nimi;
		this.Num = Num;
	}
	
	public Kunta() {
		
	}

	public int getId() {
		return KuntaID;
	}

	public void setId(int KuntaID) {
		this.KuntaID = KuntaID;
	}

	public String getNimi() {
		return Nimi;
	}

	public void setNimi(String Nimi) {
		this.Nimi = Nimi;
	}

	public int getNum() {
		return Num;
	}

	public void setNum(int Num) {
		this.Num = Num;
	}

}