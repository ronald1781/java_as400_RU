package modelo;

public class Alertaoc {

    String CODCIA, CODSUC, CODLIN,CODFAB,NOMLIN, CODART, CODORI,NOMORI, CODMAR,NOMMAR, TIPACT, FLGPRC, USRPRC, JOBPRC, STSPRC,IPXPRC,USERID;
    int NROOCP, CANINI, CANFIN, DEVINI, DEVFIN, JDTPRC,JTMPRC;
    public Alertaoc() {
    }
    public Alertaoc(String FLGPRC, String USRPRC, String JOBPRC, int JDTPRC, int JTMPRC,String IPXPRC) {
        this.FLGPRC = FLGPRC;
        this.USRPRC = USRPRC;
        this.JOBPRC = JOBPRC;
        this.JDTPRC = JDTPRC;
        this.JTMPRC = JTMPRC;
        this.IPXPRC = IPXPRC;
    }

    public Alertaoc(String CODLIN,String CODFAB, String CODART, String CODMAR, String TIPACT, int NROOCP, int CANINI, int CANFIN) {
        this.CODLIN = CODLIN;
        this.CODFAB=CODFAB;
        this.CODART = CODART;
        this.CODMAR = CODMAR;
        this.TIPACT = TIPACT;
        this.NROOCP = NROOCP;
        this.CANINI = CANINI;
        this.CANFIN = CANFIN;
    }
    
    public Alertaoc(String CODLIN,String CODFAB, String NOMLIN, String CODART, String CODORI, String NOMORI, String CODMAR, String NOMMAR, String TIPACT) {
        this.CODLIN = CODLIN;
        this.CODFAB=CODFAB;
        this.NOMLIN = NOMLIN;
        this.CODART = CODART;
        this.CODORI = CODORI;
        this.NOMORI = NOMORI;
        this.CODMAR = CODMAR;
        this.NOMMAR = NOMMAR;
        this.TIPACT = TIPACT;
    }

    public Alertaoc(String CODCIA, String CODFAB,String CODSUC, String CODLIN, String CODART, String CODORI, String CODMAR, String TIPACT, String FLGPRC, String USRPRC, String LOSTS, int LONROOCP, int CANINI, int DEVINI, int DEVFIN, int JDTPRC) {
        this.CODCIA = CODCIA;        
        this.CODFAB=CODFAB;
        this.CODSUC = CODSUC;
        this.CODLIN = CODLIN;
        this.CODART = CODART;
        this.CODORI = CODORI;
        this.CODMAR = CODMAR;
        this.TIPACT = TIPACT;
        this.FLGPRC = FLGPRC;
        this.USRPRC = USRPRC;
        this.STSPRC = LOSTS;
        this.NROOCP = LONROOCP;
        this.CANINI = CANINI;
        this.DEVINI = DEVINI;
        this.DEVFIN = DEVFIN;
        this.JDTPRC = JDTPRC;
    }

    public String getCODCIA() {
        return CODCIA;
    }

    public void setCODCIA(String CODCIA) {
        this.CODCIA = CODCIA;
    }

    public String getCODSUC() {
        return CODSUC;
    }

    public void setCODSUC(String CODSUC) {
        this.CODSUC = CODSUC;
    }

    public String getCODLIN() {
        return CODLIN;
    }

    public void setCODLIN(String CODLIN) {
        this.CODLIN = CODLIN;
    }

    public String getCODART() {
        return CODART;
    }

    public void setCODART(String CODART) {
        this.CODART = CODART;
    }

    public String getCODORI() {
        return CODORI;
    }

    public void setCODORI(String CODORI) {
        this.CODORI = CODORI;
    }

    public String getCODMAR() {
        return CODMAR;
    }

    public void setCODMAR(String CODMAR) {
        this.CODMAR = CODMAR;
    }

    public String getTIPACT() {
        return TIPACT;
    }

    public void setTIPACT(String TIPACT) {
        this.TIPACT = TIPACT;
    }

    public String getFLGPRC() {
        return FLGPRC;
    }

    public void setFLGPRC(String FLGPRC) {
        this.FLGPRC = FLGPRC;
    }

    public String getUSRPRC() {
        return USRPRC;
    }

    public void setUSRPRC(String USRPRC) {
        this.USRPRC = USRPRC;
    }

    public String getJOBPRC() {
        return JOBPRC;
    }

    public void setJOBPRC(String JOBPRC) {
        this.JOBPRC = JOBPRC;
    }

    public String getSTSPRC() {
        return STSPRC;
    }

    public void setSTSPRC(String STSPRC) {
        this.STSPRC = STSPRC;
    }

    public int getNROOCP() {
        return NROOCP;
    }

    public void setNROOCP(int LONROOCP) {
        this.NROOCP = LONROOCP;
    }

    public int getCANINI() {
        return CANINI;
    }

    public void setCANINI(int CANINI) {
        this.CANINI = CANINI;
    }

    public int getCANFIN() {
        return CANFIN;
    }

    public void setCANFIN(int CANFIN) {
        this.CANFIN = CANFIN;
    }

    public int getDEVINI() {
        return DEVINI;
    }

    public void setDEVINI(int DEVINI) {
        this.DEVINI = DEVINI;
    }

    public int getDEVFIN() {
        return DEVFIN;
    }

    public void setDEVFIN(int DEVFIN) {
        this.DEVFIN = DEVFIN;
    }

    public int getJDTPRC() {
        return JDTPRC;
    }

    public void setJDTPRC(int JDTPRC) {
        this.JDTPRC = JDTPRC;
    }

    public String getNOMLIN() {
        return NOMLIN;
    }

    public void setNOMLIN(String NOMLIN) {
        this.NOMLIN = NOMLIN;
    }

    public String getNOMORI() {
        return NOMORI;
    }

    public void setNOMORI(String NOMORI) {
        this.NOMORI = NOMORI;
    }

    public String getNOMMAR() {
        return NOMMAR;
    }

    public void setNOMMAR(String NOMMAR) {
        this.NOMMAR = NOMMAR;
    }

    public String getCODFAB() {
        return CODFAB;
    }

    public void setCODFAB(String CODFAB) {
        this.CODFAB = CODFAB;
    }

    public int getJTMPRC() {
        return JTMPRC;
    }

    public void setJTMPRC(int JTMPRC) {
        this.JTMPRC = JTMPRC;
    }

    public String getIPXPRC() {
        return IPXPRC;
    }

    public void setIPXPRC(String IPXPRC) {
        this.IPXPRC = IPXPRC;
    }

    public Alertaoc(String USERID) {
        this.USERID = USERID;
    }

    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }
    


}
