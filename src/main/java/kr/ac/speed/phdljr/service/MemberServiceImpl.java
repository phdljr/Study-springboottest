package kr.ac.speed.phdljr.service;

import kr.ac.speed.phdljr.dto.response.MemberResponseDto;
import kr.ac.speed.phdljr.entity.Member;
import kr.ac.speed.phdljr.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public List<MemberResponseDto> findAll() {
        List<Member> members = memberRepository.findAll();

        List<MemberResponseDto> resultDto = new ArrayList<>();
        members.forEach(member -> {
            MemberResponseDto memberDto = MemberResponseDto.builder()
                    .nickname(member.getNickname())
                    .build();
            resultDto.add(memberDto);
        });
        return resultDto;
    }

    @Override
    public void createMembers() {
        IntStream.rangeClosed(1, 3).forEach(i -> {
            Member member = Member.builder()
                    .nickname("test" + i)
                    .password("1111" + i)
                    .build();
            memberRepository.save(member);
        });
    }

    @Override
    public MemberResponseDto findMemberByNickname(String nickname) {
        Optional<Member> findMember = memberRepository.findMemberByNickname(nickname);
        if(findMember.isEmpty()){
            log.info("No Member");
            return null;
        }
        Member member = findMember.get();
        MemberResponseDto resultDto = MemberResponseDto.builder()
                .nickname(member.getNickname())
                .build();
        return resultDto;
    }
}
