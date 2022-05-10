package app;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.http.HttpServlet;
@Entity
public class ehdokkaat {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int EHDOKAS_ID;
	private int IKA;
	private String SUKUNIMI,ETUNIMI,PUOLUE,KOTIPAIKKAKUNTA,MIKSI_EDUSKUNTAAN , MITA_ASIOITA_HALUAT_EDISTAA,AMMATTI;
	public ehdokkaat() {
		super();
	}
	public ehdokkaat(int EHDOKAS_ID,String AMMATTI, String ETUNIMI, int IKA,String KOTIPAIKKAKUNTA, String MIKSI_EDUSKUNTAAN, String MITA_ASIOITA_HALUAT_EDISTAA,  String PUOLUE,String SUKUNIMI) {
		super();
		this.EHDOKAS_ID = EHDOKAS_ID;
		this.SUKUNIMI = SUKUNIMI;
		this.ETUNIMI = ETUNIMI;
		this.PUOLUE = PUOLUE;
		this.KOTIPAIKKAKUNTA = KOTIPAIKKAKUNTA;
		this.IKA = IKA;
		this.MIKSI_EDUSKUNTAAN = MIKSI_EDUSKUNTAAN;
		this.MITA_ASIOITA_HALUAT_EDISTAA = MITA_ASIOITA_HALUAT_EDISTAA;
		this.AMMATTI = AMMATTI;
	}
	public ehdokkaat(int EHDOKAS_ID,String SUKUNIMI, String ETUNIMI, String PUOLUE, String KOTIPAIKKAKUNTA, String MIKSI_EDUSKUNTAAN,
			String MITA_ASIOITA_HALUAT_EDISTAA, String AMMATTI,  int IKA) {
		this.EHDOKAS_ID=EHDOKAS_ID;
		this.SUKUNIMI = SUKUNIMI;
		this.ETUNIMI = ETUNIMI;
		this.PUOLUE = PUOLUE;
		this.KOTIPAIKKAKUNTA = KOTIPAIKKAKUNTA;
		this.MIKSI_EDUSKUNTAAN = MIKSI_EDUSKUNTAAN;
		this.MITA_ASIOITA_HALUAT_EDISTAA = MITA_ASIOITA_HALUAT_EDISTAA;
		this.AMMATTI = AMMATTI;
		this.IKA = IKA;
		
	}
	public ehdokkaat(String SUKUNIMI, String ETUNIMI, String PUOLUE, String KOTIPAIKKAKUNTA, String MIKSI_EDUSKUNTAAN,
			String MITA_ASIOITA_HALUAT_EDISTAA, String AMMATTI,  int IKA) {
		super();
		this.SUKUNIMI = SUKUNIMI;
		this.ETUNIMI = ETUNIMI;
		this.PUOLUE = PUOLUE;
		this.KOTIPAIKKAKUNTA = KOTIPAIKKAKUNTA;
		this.MIKSI_EDUSKUNTAAN = MIKSI_EDUSKUNTAAN;
		this.MITA_ASIOITA_HALUAT_EDISTAA = MITA_ASIOITA_HALUAT_EDISTAA;
		this.AMMATTI = AMMATTI;
		this.IKA = IKA;
		
	}
	public int getEHDOKAS_ID() {
		return EHDOKAS_ID;
	}
	public void setEHDOKAS_ID(int eHDOKAS_ID) {
		EHDOKAS_ID = eHDOKAS_ID;
	}
	public int getIKA() {
		return IKA;
	}
	public void setIKA(int iKA) {
		IKA = iKA;
	}
	public String getSUKUNIMI() {
		return SUKUNIMI;
	}
	public void setSUKUNIMI(String sUKUNIMI) {
		SUKUNIMI = sUKUNIMI;
	}
	public String getETUNIMI() {
		return ETUNIMI;
	}
	public void setETUNIMI(String eTUNIMI) {
		ETUNIMI = eTUNIMI;
	}
	public String getPUOLUE() {
		return PUOLUE;
	}
	public void setPUOLUE(String pUOLUE) {
		PUOLUE = pUOLUE;
	}
	public String getKOTIPAIKKAKUNTA() {
		return KOTIPAIKKAKUNTA;
	}
	public void setKOTIPAIKKAKUNTA(String kOTIPAIKKAKUNTA) {
		KOTIPAIKKAKUNTA = kOTIPAIKKAKUNTA;
	}
	public String getMIKSI_EDUSKUNTAAN() {
		return MIKSI_EDUSKUNTAAN;
	}
	public void setMIKSI_EDUSKUNTAAN(String mIKSI_EDUSKUNTAAN) {
		MIKSI_EDUSKUNTAAN = mIKSI_EDUSKUNTAAN;
	}
	public String getMITA_ASIOITA_HALUAT_EDISTAA() {
		return MITA_ASIOITA_HALUAT_EDISTAA;
	}
	public void setMITA_ASIOITA_HALUAT_EDISTAA(String mITA_ASIOITA_HALUAT_EDISTAA) {
		MITA_ASIOITA_HALUAT_EDISTAA = mITA_ASIOITA_HALUAT_EDISTAA;
	}
	public String getAMMATTI() {
		return AMMATTI;
	}
	public void setAMMATTI(String aMMATTI) {
		AMMATTI = aMMATTI;
	}
	
	

}
