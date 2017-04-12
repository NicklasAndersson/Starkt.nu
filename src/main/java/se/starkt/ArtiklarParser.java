package se.starkt;

import lombok.Getter;
import model.Artikel;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Stack;

/**
 * The parser is almost certainly giving you the whole string but it is over multiple calls to characters().
 * characters() will be called any number of times to deliver the contents of an element; it could be one character at a time.
 * You need to keep a String (or StringBuilder...) and add to it each time characters() is called.
 * You don't know you have the whole element content until endElement() is called.
 *
 * Created by
 *
 * @author nicklas on 2017-03-28.
 */
public class ArtiklarParser extends DefaultHandler {
    private @Getter
    ArrayList<Artikel> artiklar = new ArrayList<>(18000); //Typical size of xml

    private @Getter
    String setSkapadTid;

    //As we read any XML element we will push that in this stack
    private Stack elementStack = new Stack();

    //As we complete one user block in XML, we will push the User instance in userList
    private Stack objectStack = new Stack();

    //Holds the content of the current object
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {

    }


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


        String value = stringBuilder.toString().trim();

        if (qName.equalsIgnoreCase("artikel")) {
            Object object = objectStack.pop();
            artiklar.add((Artikel) object);
        }else if ("nr".equalsIgnoreCase(currentElement())) {
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
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setTyp(value);
        } else if ("stil".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setStil(value);
        } else if ("forpackning".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setForpackning(value);
        } else if ("forslutning".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setForslutning(value);
        } else if ("ursprung".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setUrsprung(value);
        } else if ("ursprunglandnamn".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setUrsprunglandnamn(value);
        } else if ("producent".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setProducent(value);
        } else if ("leverantor".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setLeverantor(value);
        } else if ("argang".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setArgang(value);
        } else if ("provadargang".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setProvadargang(value);
        } else if ("alkoholhalt".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setAlkoholhalt(value);
        } else if ("sortiment".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setSortiment(value);
        } else if ("sortimentText".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setSortimentText(value);
        } else if ("ekologisk".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setEkologisk(Integer.parseInt(value));
        } else if ("etiskt".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setEtiskt(Integer.parseInt(value));
        } else if ("koscher".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setKoscher(Integer.parseInt(value));
        } else if ("ravarorBeskrivning".equalsIgnoreCase(currentElement())) {
            Artikel artikel = (Artikel) objectStack.peek();
            artikel.setRavarorBeskrivning(value);
        } else if ("skapad-tid".equalsIgnoreCase(currentElement())){
            setSkapadTid = new String(value);
        }

        elementStack.pop();
        stringBuilder = new StringBuilder();

    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        //String value = new String(ch, start, length).trim();
        stringBuilder.append(ch,start,length);
        /*if (value.length() == 0) {
            //DO NOTHING
            return;
        } else {




        }*/
    }

    /**
     * Utility method for getting the current element in processing
     */
    private String currentElement() {
        return (String) this.elementStack.peek();
    }
}
