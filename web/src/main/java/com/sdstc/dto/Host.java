package com.sdstc.dto;

import cn.hutool.Hutool;
import cn.hutool.core.util.XmlUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class Host {
    @JacksonXmlProperty(localName = "Name")
    private String name;
    @JacksonXmlProperty(localName = "Installation")
    private String installation;
    @JacksonXmlProperty(localName = "HostPurposes")
    private List<HostPurpose> hostPurposes = new ArrayList<>();

    @JacksonXmlProperty(localName = "Location")
    private String location;
    @JacksonXmlProperty(localName = "MIListener")
    private String miListener;
    @JacksonXmlProperty(localName = "Priority")
    private String priority;
    @JacksonXmlProperty(localName = "SslEnabled")
    private String sslEnabled;
    @JacksonXmlProperty(localName = "Status")
    private String status;
    @JacksonXmlProperty(localName = "Attributes")
    private List<Attribute> atributes = new ArrayList<>();
    @JacksonXmlProperty(localName = "Description")
    private String description;
    @JacksonXmlProperty(localName = "Pools")
    private List<PoolID> pools = new ArrayList<>();

    @Data
    static class HostPurpose {
        @JacksonXmlProperty(localName = "HostPurpose")
        private String hostPurpose;

        public HostPurpose() {

        }

        public HostPurpose(String hostPurpose) {
            this.hostPurpose = hostPurpose;
        }
    }

    @Data
    static class Attribute {
        @JacksonXmlProperty(localName = "Attribute")
        private String attribute;

        public Attribute() {

        }

        public Attribute(String attribute) {
            this.attribute = attribute;
        }
    }

    @Data
    static class PoolID {
        @JacksonXmlProperty(localName = "PoolID")
        private String poolID;

        public PoolID() {

        }

        public PoolID(String poolID) {
            this.poolID = poolID;
        }
    }


    public static void main(String[] args) {
        Host host = new Host();
        host.setName("zhang");
        host.getHostPurposes().add(new HostPurpose("LoadGenerator"));
        host.getAtributes().add(new Attribute("Host memory:High"));
        host.getAtributes().add(new Attribute("Host strength:Medium"));
        host.getPools().add(new PoolID("1000"));

        try {
            XmlMapper xmlMapper = new XmlMapper();
            String value = xmlMapper.writeValueAsString(host);
            System.out.println(value);
            Host host2 = xmlMapper.readValue(value,Host.class);
            System.out.println(host2.getAtributes());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
