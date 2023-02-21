package service;

import dao.MemberDao;
import entity.Member;
import exception.MemberNotFoundException;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Component
public class ChangePasswordService {
    private MemberDao memberDao;

    public void changePassword(String email, String oldPwd, String newPwd) {
        Member member = memberDao.selectaByEmail(email);
        if(member == null){
            throw new MemberNotFoundException();
        }

        member.changePassword(oldPwd, newPwd);
        memberDao.update(member);
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
}
