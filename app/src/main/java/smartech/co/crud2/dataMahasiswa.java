package smartech.co.crud2;

public class dataMahasiswa {
    private String ID;
    private String NAMA;
    private String FAKULTAS;
    private String JURUSAN;
    private String SEMESTER;

    public dataMahasiswa(){

    }

    public dataMahasiswa(String ID, String NAMA, String FAKULTAS, String JURUSAN, String SEMESTER ){
        this.ID = ID;
        this.NAMA = NAMA;
        this.FAKULTAS = FAKULTAS;
        this.JURUSAN = JURUSAN;
        this.SEMESTER = SEMESTER;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }

    public void setFAKULTAS(String FAKULTAS) {
        this.FAKULTAS = FAKULTAS;
    }

    public void setJURUSAN(String JURUSAN) {
        this.JURUSAN = JURUSAN;
    }

    public void setSEMESTER(String SEMESTER) {
        this.SEMESTER = SEMESTER;
    }

    public String getID() {
        return ID;
    }

    public String getNAMA() {
        return NAMA;
    }

    public String getFAKULTAS() {
        return FAKULTAS;
    }

    public String getJURUSAN() {
        return JURUSAN;
    }

    public String getSEMESTER() {
        return SEMESTER;
    }
}
