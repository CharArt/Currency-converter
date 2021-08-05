
package ru.cbr.web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetLatestDateTimeResult" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getLatestDateTimeResult"
})
@XmlRootElement(name = "GetLatestDateTimeResponse")
public class GetLatestDateTimeResponse {

    @XmlElement(name = "GetLatestDateTimeResult", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar getLatestDateTimeResult;

    /**
     * Gets the value of the getLatestDateTimeResult property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGetLatestDateTimeResult() {
        return getLatestDateTimeResult;
    }

    /**
     * Sets the value of the getLatestDateTimeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGetLatestDateTimeResult(XMLGregorianCalendar value) {
        this.getLatestDateTimeResult = value;
    }

}
