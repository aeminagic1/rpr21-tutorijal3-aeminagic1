package ba.unsa.etf.rpr.tutorijal_3;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj{
    public enum Grad {
        SARAJEVO("033"),TUZLA("035"),ZENICA("032"),BUGOJNO("030"),ODZAK("031"),LIVNO("034"),
        MOSTAR("036"), BIHAC("037"), GORAZDE("038"), GRUDE("039"),
        BRCKO("049"), MRKONJIC_GRAD("050"), BANJA_LUKA("052"), PRIJEDOR("052"),
        DOBOJ("053"), SAMAC("054"), BIJELJINA("055"), ZVORNIK("056"),
        PALE("057"), FOCA("058"), TREBINJE("059");

        private final String opis;
        Grad(String opis) {
            this.opis=opis;
        }

        @Override
        public String toString() {
            return opis;
        }
    }
    private Grad grad;
    private String broj;
    public FiksniBroj(Grad grad, String broj){
        this.grad=grad;
        this.broj=broj;
    }
    public String ispisi(){
        return grad.toString()+"/"+broj;
    }
    @Override
    public int hashCode() {
        return Objects.hash(grad, broj);
    }

    @Override
    public final boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof FiksniBroj a))
            return false;

        return broj.equals(a.broj);
    }

}
