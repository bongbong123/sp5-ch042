package dao;

import entity.Member;
import exception.MemberNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class MemberDao {

    private static long nextId = 0;

    private Map<String, Member> map = new HashMap<>();

    public Member selectaByEmail(String email){
        return map.get(email);
    }

    public void insert(Member member){
        member.setId(++nextId);
        map.put(member.getEmail(),member);
    }

    public void update(Member member){
        map.put(member.getEmail(), member);
    }
}
