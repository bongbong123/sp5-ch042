package entity;

import exception.WrongIdPasswordException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class Member {

    private Long id;
    private final String email;
    private String password;
    private String name;
    private LocalDateTime registerDateTime;

    public Member(String email, String password, String name, LocalDateTime regDateTime){
        this.email = email;
        this.password = password;
        this.name = name;
        this.registerDateTime = regDateTime;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if(!password.equals(oldPassword)){
            throw new WrongIdPasswordException();
        }

        this.password = newPassword;
    }

}
