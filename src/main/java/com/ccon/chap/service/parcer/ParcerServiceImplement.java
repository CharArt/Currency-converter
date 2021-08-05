package com.ccon.chap.service.parcer;

import com.ccon.chap.dto.CursDynamic;
import com.ccon.chap.dto.ValuteCursOnDate;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.cbr.web.DailyInfo;
import ru.cbr.web.DailyInfoSoap;
import ru.cbr.web.EnumValutesResponse;
import ru.cbr.web.GetCursOnDateResponse;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class ParcerServiceImplement implements ParcerService {


    @Override
    public List<CursDynamic> getCursDynamicList() {
        DailyInfo service = new DailyInfo();
        DailyInfoSoap port = service.getDailyInfoSoap();

        EnumValutesResponse.EnumValutesResult valutesResult = port.enumValutes(false);
        Element elementValutes = (Element) valutesResult.getAny();
        NodeList listValutes = elementValutes.getElementsByTagName("EnumValutes");

        List<CursDynamic> cursDynamicList = new ArrayList<>();
        for (int i = 0; i < listValutes.getLength(); i++) {
            CursDynamic cursDynamic = new CursDynamic();

            Node nodeEnumValutes = listValutes.item(i);
            Element elementEnumValutes = (Element) nodeEnumValutes;
//-------------------------------------------------------------------------------------------------------------------------------------
            Node vCodeNode = elementEnumValutes.getElementsByTagName("Vcode").item(0);
            String vCodeStringShort = "Null";
            if (vCodeNode != null) {
                String vCodeString = vCodeNode.getTextContent();
                vCodeStringShort = vCodeString.trim();
            }
            cursDynamic.setvCode(vCodeStringShort);
//-------------------------------------------------------------------------------------------------------------------------------------
            Node vNameNode = elementEnumValutes.getElementsByTagName("Vname").item(0);
            String vNameStringShort = "Null";
            if (vNameNode != null) {
                String vNameString = vNameNode.getTextContent();
                vNameStringShort = vNameString.trim();
            }
            cursDynamic.setvName(vNameStringShort);
//-------------------------------------------------------------------------------------------------------------------------------------
            Node vEngNameNode = elementEnumValutes.getElementsByTagName("VEngname").item(0);
            String vEngNameStringShort = "Null";
            if (vEngNameNode != null) {
                String vEngNameString = vEngNameNode.getTextContent();
                vEngNameStringShort = vEngNameString.trim();
            }
            cursDynamic.setvEngName(vEngNameStringShort);
//-------------------------------------------------------------------------------------------------------------------------------------
            Node vNomNode = elementEnumValutes.getElementsByTagName("Vnom").item(0);
            String vNomStringShort = "Null";
            if (vNomNode != null) {
                String vNomString = vNomNode.getTextContent();
                vNomStringShort = vNomString.trim();
            }
            cursDynamic.setvNom(vNomStringShort);
//-------------------------------------------------------------------------------------------------------------------------------------
            Node vCommonCodeNode = elementEnumValutes.getElementsByTagName("VcommonCode").item(0);
            String vCommonCodeStringShort = "Null";
            if (vCommonCodeNode != null) {
                String vCommonCodeString = vCommonCodeNode.getTextContent();
                vCommonCodeStringShort = vCommonCodeString.trim();
            }
            cursDynamic.setvCharCode(vCommonCodeStringShort);
//-------------------------------------------------------------------------------------------------------------------------------------
            Node vNumCodeNode = elementEnumValutes.getElementsByTagName("VnumCode").item(0);
            String vNumCodeStringShort = "Null";
            if (vNumCodeNode != null) {
                String vNumCodeString = vNumCodeNode.getTextContent();
                vNumCodeStringShort = vNumCodeString.trim();
            }
            cursDynamic.setvNumCode(vNumCodeStringShort);
//-------------------------------------------------------------------------------------------------------------------------------------
            Node vCharCodeNode = elementEnumValutes.getElementsByTagName("VcharCode").item(0);
            String vcharCodeStringShort = "Null";
            if (vCharCodeNode != null) {
                String vCharCodeString = vCharCodeNode.getTextContent();
                vcharCodeStringShort = vCharCodeString.trim();
            }
            cursDynamic.setvCharCode(vcharCodeStringShort);
//-------------------------------------------------------------------------------------------------------------------------------------
            cursDynamicList.add(i, cursDynamic);
        }
        return cursDynamicList;
    }

    @Override
    public List<ValuteCursOnDate> getValuteCursOnDateList(List<LocalDateTime> listDate) throws DatatypeConfigurationException {
        DailyInfo service = new DailyInfo();
        DailyInfoSoap port = service.getDailyInfoSoap();

        List<ValuteCursOnDate> valuteCursOnDateList = new ArrayList<>();
        for (LocalDateTime localDateTime : listDate) {

            GregorianCalendar date = new GregorianCalendar(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);

            GetCursOnDateResponse.GetCursOnDateResult result = port.getCursOnDate(xmlDate);
            Element element = (Element) result.getAny();
            NodeList list = element.getElementsByTagName("ValuteCursOnDate");

            for (int i = 0; i < list.getLength(); i++) {
                ValuteCursOnDate valuteCursOnDate = new ValuteCursOnDate();
                Node nodeValute = list.item(i);
                Element elementValute = (Element) nodeValute;
//-------------------------------------------------------------------------------------------------------------------------------------
                Node vNameNode = elementValute.getElementsByTagName("Vname").item(0);
                String vName = vNameNode.getTextContent();
                String vNameShort = vName.trim();
                valuteCursOnDate.setName(vNameShort);
//-------------------------------------------------------------------------------------------------------------------------------------
                Node vNomNode = elementValute.getElementsByTagName("Vnom").item(0);
                String vNom = vNomNode.getTextContent();
                String vNomShort = vNom.trim();
                valuteCursOnDate.setNom(vNomShort);
//-------------------------------------------------------------------------------------------------------------------------------------
                Node vCursNode = elementValute.getElementsByTagName("Vcurs").item(0);
                String vCurs = vCursNode.getTextContent();
                String vCursShort = vCurs.trim();
                valuteCursOnDate.setCurs(vCursShort);
//-------------------------------------------------------------------------------------------------------------------------------------
                Node vCodeNode = elementValute.getElementsByTagName("Vcode").item(0);
                String vCode = vCodeNode.getTextContent();
                String vCodeShort = vCode.trim();
                valuteCursOnDate.setCode(vCodeShort);
//-------------------------------------------------------------------------------------------------------------------------------------
                Node vchCodeNode = elementValute.getElementsByTagName("VchCode").item(0);
                String vChCode = vchCodeNode.getTextContent();
                String vChCodeShort = vChCode.trim();
                valuteCursOnDate.setChCode(vChCodeShort);
//-------------------------------------------------------------------------------------------------------------------------------------
                valuteCursOnDate.setDate(localDateTime);
//-------------------------------------------------------------------------------------------------------------------------------------
                valuteCursOnDateList.add(valuteCursOnDate);
            }
        }
        return valuteCursOnDateList;
    }

    @Override
    public boolean equalsCursDynamicWithoutNull(CursDynamic cursDynamic) {
        return cursDynamic.getvCode().equals("Null") &&
                cursDynamic.getvName().equals("Null") &&
                cursDynamic.getvEngName().equals("Null") &&
                cursDynamic.getvNom().equals("Null") &&
                cursDynamic.getvNumCode().equals("Null") &&
                cursDynamic.getvCharCode().equals("Null");
    }

    @Override
    public boolean equalsValuteCursOnDateWithoutNull(ValuteCursOnDate valuteCursOnDate) {
        return valuteCursOnDate.getName().equals("Null") &&
                valuteCursOnDate.getNom().equals("Null") &&
                valuteCursOnDate.getCurs().equals("Null") &&
                valuteCursOnDate.getCode().equals("Null") &&
                valuteCursOnDate.getChCode().equals("Null");
    }
}