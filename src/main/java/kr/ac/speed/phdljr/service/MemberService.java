package kr.ac.speed.phdljr.service;

import kr.ac.speed.phdljr.dto.response.MemberResponseDto;

import java.util.List;

public interface MemberService {
    List<MemberResponseDto> findAll();
    void createMembers();
    MemberResponseDto findMemberByNickname(String nickname);
}
