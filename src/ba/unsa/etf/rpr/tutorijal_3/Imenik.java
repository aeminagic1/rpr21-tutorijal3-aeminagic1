package ba.unsa.etf.rpr.tutorijal_3;
import java.util.*;
import java.util.HashMap;

public class Imenik {
    private Map<String,TelefonskiBroj> brojevi=new HashMap<>();
    public void dodaj(String ime, TelefonskiBroj broj){
        brojevi.put(ime,broj);
    }
    public String dajBroj(String ime){
        return brojevi.get(ime).ispisi();

    }
    public String dajIme(TelefonskiBroj broj){
        for (Map.Entry<String,TelefonskiBroj> br: brojevi.entrySet()){
            if(broj.equals(br.getValue())) return br.getKey();
        }
        return "";
    }
    public String naSlovo(char s){
        String sve="";
        int b=1;
        for (Map.Entry<String,TelefonskiBroj> sveOsobe: brojevi.entrySet()){
            if(sveOsobe.getKey().charAt(0)==s){
                sve=sve+(b+". "+sveOsobe.getKey()+" - "+sveOsobe.getValue().ispisi()+"\n");
            }
        }
        return sve;
    }
    Set<String> izGrada(FiksniBroj.Grad g){
        Set<String> osobe=new TreeSet<>();
        for(Map.Entry<String,TelefonskiBroj> o:brojevi.entrySet()){
            if(o.getValue().ispisi().substring(0,3).equals(g.toString())){
                osobe.add(o.getKey());
            }
        }
        return osobe;
    }
    Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g){
        Comparator<TelefonskiBroj> comp=Comparator.comparing(TelefonskiBroj::ispisi);
        Set<TelefonskiBroj> brojeviOsoba=new TreeSet<>(comp);
        for (Map.Entry<String,TelefonskiBroj> brOs: brojevi.entrySet()){
            if(brOs.getValue().ispisi().substring(0,3).equals(g.toString())){
                brojeviOsoba.add(brOs.getValue());
            }
        }
        return  brojeviOsoba;
    }
}
