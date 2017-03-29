package se.starkt;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;


public class ParseXML {


    public static void main(String argv[]) {
        ArrayList<Artikel> list = null;
        long starttime = System.currentTimeMillis();
        System.out.println("Start " + starttime);

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            ArtiklarHandler handler = new ArtiklarHandler();
            list = handler.getArtiklar();

            saxParser.parse("20170323.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done " + System.currentTimeMillis() + " Diff " + (System.currentTimeMillis() - starttime));
        System.out.println(list.size());
        /*for (Artikel a : list) {
            System.out.println(a);
        }*/
    }

}
