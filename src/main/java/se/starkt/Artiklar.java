package se.starkt;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Created by
 *
 * @author nicklas on 2017-03-29.
 */
public class Artiklar {

    /**
     * The file usually contains ~17000 items
     */
    private @Getter @NonNull
    ArrayList<Artikel> artiklar = new ArrayList<Artikel>(18000);

    private @Getter @Setter
    String skapadTid;

    Artiklar(){

    }

    public void add(Artikel artikel){
        artiklar.add(artikel);
    }

    public int antal(){
        return artiklar.size();
    }
}
