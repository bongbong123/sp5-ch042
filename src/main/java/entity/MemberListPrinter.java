package entity;

import dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
    @Qualifier("printer")
    public void setPrinter(MemberPrinter printer) {
        this.printer = printer;
    }
}
