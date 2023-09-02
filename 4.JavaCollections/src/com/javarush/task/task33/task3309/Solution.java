package com.javarush.task.task33.task3309;

/*
Комментарий внутри xml
*/


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        //Конвертация объекта в XML
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();

        //XML вывод с отступами
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);

        //Построчно обрабатываем XML и формируем результат
        String[] lines = writer.toString().split("\n");
        String result = "";
        for (String line : lines) {
            //Добавляем коммент перед тэгом, если такой имеется
            if (line.contains("<" + tagName)) {
                String spaces = line.substring(0, line.indexOf("<"));
                result += (spaces + "<!--" + comment + "-->" + "\n");
            }
            result += (line + "\n");
        }
        return result;
    }

    public static void main(String[] args) throws JAXBException {
        First first = new First();
        first.strings.add("some string1");
        first.strings.add("some string2");
        first.strings.add("[CDATA[need CDATA because of < and >]]");
        System.out.println(toXmlWithComment(first, "second", "it's a comment"));
    }

    @XmlRootElement
    @XmlType(name = "first")
    public static class First {
        @XmlElement(name = "second")
        List<String> strings = new ArrayList<>();

        public First() {
        }
    }
}
