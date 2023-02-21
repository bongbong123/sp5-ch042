package controller;

import dao.MemberDao;
import entity.Member;
import entity.MemberPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("infoPrinter")
public class MemberInfoPrinter {

    private MemberDao memberDao;
    private MemberPrinter printer;

    public void printMemberInfo(String email) {
        Member member = memberDao.selectaByEmail(email);
        if(member == null) {
            System.out.println("데이터 없음");
            return;
        }
        printer.print(member);
        System.out.println();
    }

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Autowired
//    @Qualifier("infoPrinter")
    public void setPrinter(MemberPrinter printer) {
        this.printer = printer;
    }
}
