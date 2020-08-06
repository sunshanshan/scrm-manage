
package com.platform.modules.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "in0",
    "in1",
    "in2",
    "in3",
    "in4",
    "in5"
})
@XmlRootElement(name = "getHrmUserInfoXML")
public class GetHrmUserInfoXML {

    @XmlElement(required = true, nillable = true)
    protected String in0;
    @XmlElement(required = true, nillable = true)
    protected String in1;
    @XmlElement(required = true, nillable = true)
    protected String in2;
    @XmlElement(required = true, nillable = true)
    protected String in3;
    @XmlElement(required = true, nillable = true)
    protected String in4;
    @XmlElement(required = true, nillable = true)
    protected String in5;

    public String getIn0() {
        return in0;
    }

    public void setIn0(String value) {
        this.in0 = value;
    }

    public String getIn1() {
        return in1;
    }

    public void setIn1(String value) {
        this.in1 = value;
    }

    public String getIn2() {
        return in2;
    }

    public void setIn2(String value) {
        this.in2 = value;
    }

    public String getIn3() {
        return in3;
    }

    public void setIn3(String value) {
        this.in3 = value;
    }

    public String getIn4() {
        return in4;
    }

    public void setIn4(String value) {
        this.in4 = value;
    }

    public String getIn5() {
        return in5;
    }

    public void setIn5(String value) {
        this.in5 = value;
    }

}
