//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.12.04 à 07:08:25 PM IST 
//


package com.jeremy.jba4.rss;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies a web service that supports the rssCloud interface which can be implemented in HTTP-POST, XML-RPC or SOAP 1.1. 
 * Its purpose is to allow processes to register with a cloud to be notified of updates to the channel, implementing a lightweight publish-subscribe protocol for RSS feeds.
 * 
 * <p>Classe Java pour tCloud complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tCloud">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="domain" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="port" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="path" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="registerProcedure" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="protocol" use="required" type="{}tCloudProtocol" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCloud")
public class TCloud {

    @XmlAttribute(name = "domain", required = true)
    protected String domain;
    @XmlAttribute(name = "port", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger port;
    @XmlAttribute(name = "path", required = true)
    protected String path;
    @XmlAttribute(name = "registerProcedure", required = true)
    protected String registerProcedure;
    @XmlAttribute(name = "protocol", required = true)
    protected TCloudProtocol protocol;

    /**
     * Obtient la valeur de la propriété domain.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Définit la valeur de la propriété domain.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomain(String value) {
        this.domain = value;
    }

    /**
     * Obtient la valeur de la propriété port.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPort() {
        return port;
    }

    /**
     * Définit la valeur de la propriété port.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPort(BigInteger value) {
        this.port = value;
    }

    /**
     * Obtient la valeur de la propriété path.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * Définit la valeur de la propriété path.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

    /**
     * Obtient la valeur de la propriété registerProcedure.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegisterProcedure() {
        return registerProcedure;
    }

    /**
     * Définit la valeur de la propriété registerProcedure.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegisterProcedure(String value) {
        this.registerProcedure = value;
    }

    /**
     * Obtient la valeur de la propriété protocol.
     * 
     * @return
     *     possible object is
     *     {@link TCloudProtocol }
     *     
     */
    public TCloudProtocol getProtocol() {
        return protocol;
    }

    /**
     * Définit la valeur de la propriété protocol.
     * 
     * @param value
     *     allowed object is
     *     {@link TCloudProtocol }
     *     
     */
    public void setProtocol(TCloudProtocol value) {
        this.protocol = value;
    }

}
