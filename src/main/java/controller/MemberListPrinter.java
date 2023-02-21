package controller;

import dao.MemberDao;
import entity.MemberPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("listPrinter")
public class MemberListPrinter {
    private MemberDao memberDao;
    private MemberPrinter printer;

    public MemberListPrinter() {
    }

    public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
        this.memberDao = memberDao;
        this.printer = printer;
    }
    @Autowired
//    @Qualifier("listPrinter")
    public void setPrinter(MemberPrinter printer) {
        this.printer = printer;
    }
}
