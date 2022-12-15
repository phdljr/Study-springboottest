package kr.ac.speed.phdljr.repository;

import kr.ac.speed.phdljr.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findMemberByNickname(String nickname);
}
