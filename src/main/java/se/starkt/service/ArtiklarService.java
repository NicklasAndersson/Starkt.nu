package se.starkt.service;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.stereotype.Service;
import se.starkt.Artikel;
import se.starkt.ArtiklarParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

/**
 * Created by
 *
 * @author nicklas on 2017-03-29.
 */
@Service
public class ArtiklarService {

    /**
     * The file usually contains ~17000 items
     */
    private @Getter
    @NonNull
    ArrayList<Artikel> artiklar;

    private @Getter
    @Setter
    String skapadTid;

    public ArtiklarService() {
        ArtiklarParser parser = null;
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            parser = new ArtiklarParser();

            saxParser.parse("20170323.xml", parser);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (parser != null) {
            artiklar = parser.getArtiklar();
        }
    }


    public Artikel getArtikel(Long id) {
        for (Artikel a : artiklar) {
            if (a.getNr().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public int antal() {
        return artiklar.size();
    }
}
