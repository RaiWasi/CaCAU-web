//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.12.03 at 10:24:08 PM CET 
//


package com.airbus.alten.cacau.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="fin" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="fd" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="swpn" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="hwpn" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "EQUIPMENT")
public class EQUIPMENT {

    @XmlAttribute(name = "fin", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String fin;
    @XmlAttribute(name = "fd")
    @XmlSchemaType(name = "anySimpleType")
    protected String fd;
    @XmlAttribute(name = "name")
    @XmlSchemaType(name = "anySimpleType")
    protected String name;
    @XmlAttribute(name = "swpn", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String swpn;
    @XmlAttribute(name = "hwpn", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String hwpn;

    /**
     * Gets the value of the fin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFin() {
        return fin;
    }

    /**
     * Sets the value of the fin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFin(String value) {
        this.fin = value;
    }

    /**
     * Gets the value of the fd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFd() {
        return fd;
    }

    /**
     * Sets the value of the fd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFd(String value) {
        this.fd = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the swpn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwpn() {
        return swpn;
    }

    /**
     * Sets the value of the swpn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwpn(String value) {
        this.swpn = value;
    }

    /**
     * Gets the value of the hwpn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHwpn() {
        return hwpn;
    }

    /**
     * Sets the value of the hwpn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHwpn(String value) {
        this.hwpn = value;
    }

}
