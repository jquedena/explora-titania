package pe.com.bbva.model.entity;

public class MultitablaId implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String codMult;
    private String codElem;

    public MultitablaId() {
    }

    public MultitablaId(String codMult, String codElem) {
        this.codMult = codMult;
        this.codElem = codElem;
    }

    public String getCodMult() {
        return this.codMult;
    }

    public void setCodMult(String codMult) {
        this.codMult = codMult;
    }

    public String getCodElem() {
        return this.codElem;
    }

    public void setCodElem(String codElem) {
        this.codElem = codElem;
    }

    @Override
    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof MultitablaId)) {
            return false;
        }
        MultitablaId castOther = (MultitablaId) other;

        return ((this.getCodMult().equalsIgnoreCase(castOther.getCodMult())) || (this.getCodMult() != null
                && castOther.getCodMult() != null && this.getCodMult().equalsIgnoreCase(
                castOther.getCodMult())))
                && ((this.getCodElem().equalsIgnoreCase(castOther.getCodElem())) || (this.getCodElem() != null
                && castOther.getCodElem() != null && this.getCodElem().equalsIgnoreCase(castOther.getCodElem())));
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 37 * result
                + (getCodMult() == null ? 0 : this.getCodMult().hashCode());
        result = 37 * result
                + (getCodElem() == null ? 0 : this.getCodElem().hashCode());
        return result;
    }
}
