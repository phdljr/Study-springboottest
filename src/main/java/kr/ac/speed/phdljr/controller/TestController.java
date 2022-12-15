package kr.ac.speed.phdljr.controller;

import kr.ac.speed.phdljr.dto.response.MemberResponseDto;
import kr.ac.speed.phdljr.entity.Member;
import kr.ac.speed.phdljr.repository.MemberRepository;
import kr.ac.speed.phdljr.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController // 모든 요청을 json으로 보낸다.
@RequiredArgsConstructor
public class TestController {

    private final MemberService memberService;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/member")
    public List<MemberResponseDto> getMember(){
        List<MemberResponseDto> members = memberService.findAll();
        return members;
    }

    @GetMapping("/inputmember")
    public String inputMember(){
        memberService.createMembers();
        return "ok";
    }

    @GetMapping("/member/{nickname}")
    public MemberResponseDto findMember(@PathVariable("nickname") String nickname){
        MemberResponseDto dto = memberService.findMemberByNickname(nickname);
        return dto;
    }
}
