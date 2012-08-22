package pe.com.bbva.model.entity;

public class Multitabla implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private MultitablaId id;
    private String valor1;
    private String valor2;
    private String valor3;
    private String valor4;

    public Multitabla() {
    }

    public Multitabla(MultitablaId id) {
        this.id = id;
    }

    public Multitabla(MultitablaId id, String valor1, String valor2,
            String valor3, String valor4) {
        this.id = id;
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.valor3 = valor3;
        this.valor4 = valor4;
    }

    public MultitablaId getId() {
        return this.id;
    }

    public void setId(MultitablaId id) {
        this.id = id;
    }

    public String getValor1() {
        return this.valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public String getValor2() {
        return this.valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }

    public String getValor3() {
        return this.valor3;
    }

    public void setValor3(String valor3) {
        this.valor3 = valor3;
    }

    public String getValor4() {
        return this.valor4;
    }

    public void setValor4(String valor4) {
        this.valor4 = valor4;
    }
}
