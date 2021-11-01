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
        StringBuilder sve= new StringBuilder();
        int b=1;
        for (Map.Entry<String,TelefonskiBroj> sveOsobe: brojevi.entrySet()){
            if(sveOsobe.getKey().charAt(0)==s){
                sve.append(b).append(". ").append(sveOsobe.getKey()).append(" - ").append(sveOsobe.getValue().ispisi()).append("\n");
            }
        }
        return sve.toString();
    }
    Set<String> izGrada(){
        Set<String> osobe=new TreeSet<>();
        for(Map.Entry<String,TelefonskiBroj> o:brojevi.entrySet()){
            if(o.getValue().ispisi().substring(0,3).equals(FiksniBroj.Grad.SARAJEVO.toString())){
                osobe.add(o.getKey());
            }
        }
        return osobe;
    }
    Set<TelefonskiBroj> izGradaBrojevi(){
        Comparator<TelefonskiBroj> comp=Comparator.comparing(TelefonskiBroj::ispisi);
        Set<TelefonskiBroj> brojeviOsoba=new TreeSet<>(comp);
        for (Map.Entry<String,TelefonskiBroj> brOs: brojevi.entrySet()){
            if(brOs.getValue().ispisi().substring(0,3).equals(FiksniBroj.Grad.SARAJEVO.toString())){
                brojeviOsoba.add(brOs.getValue());
            }
        }
        return  brojeviOsoba;
    }
}
