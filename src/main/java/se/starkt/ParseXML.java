package se.starkt;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class ParseXML {


    public static void main(String argv[]) {
        Artiklar artiklar = null;
        long starttime = System.currentTimeMillis();
        System.out.println("Start " + starttime);

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            ArtiklarHandler handler = new ArtiklarHandler();
            artiklar = handler.getArtiklar();

            saxParser.parse("20170323.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done " + System.currentTimeMillis() + " Diff " + (System.currentTimeMillis() - starttime));
        System.out.println(artiklar.antal());
        System.out.println(artiklar.getSkapadTid());
        /*for (Artikel a : list) {
            System.out.println(a);
        }*/
    }

}
