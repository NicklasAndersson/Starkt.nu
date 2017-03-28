package se.starkt;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by
 *
 * @author nicklas on 2017-03-28.
 */
public class ArtiklarHandler extends DefaultHandler {
    ArrayList<Artikel> artiklar = new ArrayList<Artikel>();

    //As we read any XML element we will push that in this stack
    private Stack elementStack = new Stack();

    //As we complete one user block in XML, we will push the User instance in userList
    private Stack objectStack = new Stack();


    @Override
    public void startDocument() throws SAXException {

    }

    //Artikel artikel;

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        elementStack.push(qName);

        //System.out.println("Start Element :" + qName);
        if (qName.equalsIgnoreCase("artikel")) {
            Artikel artikel = new Artikel();
            objectStack.push(artikel);
        }
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        elementStack.pop();
        if (qName.equalsIgnoreCase("artikel")) {
            Object object = objectStack.pop();
            artiklar.add((Artikel) object);
        }

    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        if (value.length() == 0) {
            //DO NOTHING

        } else if ("nr".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setNr(Long.parseLong(value));
        } else if ("artikelid".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setArtikelid(Long.parseLong(value));
        } else if ("varnummer".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setVarnummer(Long.parseLong(value));
        } else if ("namn".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setNamn(value);
        } else if ("namn2".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setNamn2(value);
        } else if ("prisinklmoms".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setPrisinklmoms(new BigDecimal(value));
        } else if ("volymiml".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setVolymiml(new BigDecimal(value));
        } else if ("prisPerLiter".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setPrisPerLiter(new BigDecimal(value));
        } else if ("saljstart".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setSaljstart(value);
        } else if ("utgått".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setUtgått(Integer.parseInt(value));
        } else if ("varugrupp".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setVarugrupp(value);
        } else if ("typ".equalsIgnoreCase(currentElement())) {

        } else if ("stil".equalsIgnoreCase(currentElement())) {

        } else if ("forpackning".equalsIgnoreCase(currentElement())) {

        } else if ("forslutning".equalsIgnoreCase(currentElement())) {

        } else if ("ursprung".equalsIgnoreCase(currentElement())) {

        } else if ("ursprunglandnamn".equalsIgnoreCase(currentElement())) {

        } else if ("producent".equalsIgnoreCase(currentElement())) {

        } else if ("leverantor".equalsIgnoreCase(currentElement())) {

        } else if ("argang".equalsIgnoreCase(currentElement())) {

        } else if ("provadargang".equalsIgnoreCase(currentElement())) {

        } else if ("alkoholhalt".equalsIgnoreCase(currentElement())) {

        } else if ("sortiment".equalsIgnoreCase(currentElement())) {

        } else if ("sortimentText".equalsIgnoreCase(currentElement())) {

        } else if ("ekologisk".equalsIgnoreCase(currentElement())) {

        } else if ("etiskt".equalsIgnoreCase(currentElement())) {

        } else if ("koscher".equalsIgnoreCase(currentElement())) {

        } else if ("ravarorBeskrivning".equalsIgnoreCase(currentElement())) {

        }


    }

    /**
     * Utility method for getting the current element in processing
     */
    private String currentElement() {
        return (String) this.elementStack.peek();
    }
}
