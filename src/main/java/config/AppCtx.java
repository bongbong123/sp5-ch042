package config;

import dao.MemberDao;
import entity.MemberInfoPrinter;
import entity.MemberListPrinter;
import entity.MemberPrinter;
import entity.MemberSummaryPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.ChangePasswordService;
import service.MemberRegistrerService;

@Configuration
public class AppCtx {

    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public MemberRegistrerService memberRegistrerService(){
        return new MemberRegistrerService(memberDao());
    }

    @Bean
    public ChangePasswordService changePwdSvc(){
        ChangePasswordService pwdSvc = new ChangePasswordService();
        pwdSvc.setMemberDao(memberDao());
        return pwdSvc;
    }

    @Bean
    @Qualifier("pinter")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter2() {
        return new MemberSummaryPrinter();
    }

    @Bean
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter();
    }

    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setPrinter(memberPrinter2());
        return infoPrinter;
    }
}
