package se.starkt.service;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;
import model.Artikel;
import org.springframework.stereotype.Service;
import se.starkt.ArtiklarParser;

@Service
@CommonsLog
public class ArtiklarService {

    final static int size = 1024;
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
        SimpleDateFormat sdp = new SimpleDateFormat("yyyyMMdd'T'HHmmssS");
        ArtiklarParser parser = null;
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            parser = new ArtiklarParser();


            String fAddress = "https://www.systembolaget.se/api/assortment/products/xml";

            URLConnection uCon = null;

            InputStream is = null;
            try {
                URL url;
                byte[] buf;
                int byteRead, byteWritten = 0;
                url = new URL(fAddress);


                uCon = url.openConnection();
                is = uCon.getInputStream();
                //buf = new byte[size];

                saxParser.parse(is, parser);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


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
