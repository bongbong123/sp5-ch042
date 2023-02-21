package config;

import client.Client;
import client.Client2;
import entity.MemberPrinter;
import controller.MemberSummaryPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import service.ChangePasswordService;
import service.MemberRegistrerService;

@Configuration
public class AppCtx {

    @Bean
    @Qualifier("infoPrinter")
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter2() {
        return new MemberSummaryPrinter();
    }


    @Bean
    @Scope("prototype")
    public Client client() {
        Client client = new Client();
        client.setHost("host");
        return client;
    }

    @Bean(initMethod = "connect", destroyMethod = "close")
    public Client2 clinet2(){
        Client2 client2 = new Client2();
        client2.setHost("host");
        return client2;
    }

//    @Bean
//    public VersionPrinter versionPrinter() {
//        VersionPrinter versionPrinter = new VersionPrinter();
//        versionPrinter.setMajorVersion(5);
//        versionPrinter.setMinorVersion(0);
//        return versionPrinter;
//    }
}
