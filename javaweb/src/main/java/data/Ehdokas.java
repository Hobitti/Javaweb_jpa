package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ehdokas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EhdokasID;
	private String Nimi;
	private int KuntaID;
	private String Slogan;
	private int PuolueID;
	private String Kuvaus;
//	private String kuntaS;
//	private String puolueS;

	public Ehdokas(int id, String nimi, int kunta, String slogan, int puolue, String kuvaus) {
		super();
		this.EhdokasID = id;
		this.Nimi = nimi;
		this.KuntaID = kunta;
		this.Slogan = slogan;
		this.PuolueID = puolue;
		this.Kuvaus = kuvaus;
	}
	
	public Ehdokas() {
	// todo	
	}
	
	public String getKuvaus() {
		return Kuvaus;
	}
	
	public void setKuvaus(String kuvaus) {
		this.Kuvaus = kuvaus;
	}
	
	public int getId() {
		return EhdokasID;
	}
	
	public void setId(int id) {
		this.EhdokasID = id;
	}
	
	public String getNimi() {
		return Nimi;
	}
	
	public void setNimi(String nimi) {
		this.Nimi = nimi;
	}
	
	public int getKunta() {
		return KuntaID;
	}
	
	public void setKunta(int kunta) {
		this.KuntaID = kunta;
	}
	
//	public String getKuntaS() {
//		return kuntaS;
//	}
//	
//	public void setKuntaS(String kuntaS) {
//		this.kuntaS = kuntaS;
//	}
	
	public String getSlogan() {
		return Slogan;
	}
	
	public void setSlogan(String slogan) {
		this.Slogan = slogan;
	}
	
	public int getPuolue() {
		return PuolueID;
	}
	
	public void setPuolue(int puolue) {
		this.PuolueID = puolue;
	}
	
//	public String getPuolueS() {
//		return puolueS;
//	}
//	
//	public void setPuolueS(String puolueS) {
//		this.puolueS = puolueS;
//	}

}
