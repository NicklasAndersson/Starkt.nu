package se.starkt.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import model.Artikel;
import org.springframework.stereotype.Service;
import se.starkt.ArtiklarParser;

@Service
@Slf4j
public class ArtiklarService {

    private final String basePath = "/Users/nicklas/temp/systembolaget/";
    final static int size = 1024;

    private final ObjectMapper objectMapper;

    public ArtiklarService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * The file usually contains ~17000 items
     */
    private @Getter
    @NonNull
    ArrayList<Artikel> artiklar;

    private @Getter
    @Setter
    String skapadTid;

    public void populateArtiklarService() {
        SimpleDateFormat sdp = new SimpleDateFormat("yyyyMMdd'T'HHmmssS");
        ArtiklarParser parser = null;
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            parser = new ArtiklarParser();

            String fAddress = "https://www.systembolaget.se/api/assortment/products/xml";

            URLConnection uCon = null;

            InputStream is = null;
            log.debug("Getting file");
            try {
                URL url;
                byte[] buf;
                int byteRead, byteWritten = 0;
                url = new URL(fAddress);

                uCon = url.openConnection();
                is = uCon.getInputStream();
                log.debug("Got file");
                //buf = new byte[size];

                saxParser.parse(is, parser);
                log.debug("Done parsing");
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
            log.debug("Done! got " + artiklar.size() + " items");
        }
    }

    public void saveAsJsonFiles() {
        log.debug("Saving files");
        Collections.sort(artiklar);
        int pos = 0;
        for (Artikel a : artiklar) {
            if (pos <= 100) {
                try {
                    Files.write(Paths.get(basePath + "/top/" + pos + ".json"), objectMapper.writeValueAsString(a).getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            pos++;

            try {
                Files.write(Paths.get(basePath + "/artikel/" + a.getArtikelid().toString() + ".json"), objectMapper.writeValueAsString(a).getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.debug("Files saved");
    }

    public int antal() {
        return artiklar.size();
    }
}
