package ync.pyb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import ync.pyb.entity.Member;
import ync.pyb.entity.MemberRole;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepoTests {

    @Autowired
    private MemberRepo memberRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertDummies() {


        IntStream.rangeClosed(1, 5).forEach(i -> {
            Member member = Member.builder()
                    .memberId(Long.valueOf(i))
                    .memberEmail("user" + i + "@gmail.com")
                    .memberPassword(passwordEncoder.encode("1234"))
                    .memberPhone("010-" + String.format("%04d", i) + "-" + String.format("%04d", i))
                    .build();
            member.addMemberRole(MemberRole.USER);
            memberRepo.save(member);
        });
    }
}
