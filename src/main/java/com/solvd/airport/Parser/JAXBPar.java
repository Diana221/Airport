package com.solvd.airport.Parser;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBPar {
    public static void writeXML(Object obj, File path, Class...clazz) throws JAXBException {
        JAXBContext jctx = JAXBContext.newInstance(clazz);
        Marshaller marshaller = jctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(obj, path);

    }

    public static Object readXML(File path, Class... clazz) throws JAXBException {
        JAXBContext jctx = JAXBContext.newInstance(clazz);
        Unmarshaller unMarshaller = jctx.createUnmarshaller();
        return unMarshaller.unmarshal(path);
    }

}
