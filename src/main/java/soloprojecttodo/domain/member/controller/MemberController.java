package soloprojecttodo.domain.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soloprojecttodo.domain.member.dto.MemberDto;
import soloprojecttodo.domain.member.entity.Member;
import soloprojecttodo.domain.member.mapper.MemberMapper;
import soloprojecttodo.domain.member.service.MemberService;
import soloprojecttodo.global.dto.SingleResponseDto;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    /*
    USER-01: 회원가입
    */
    @PostMapping("/signup")
    public ResponseEntity signUp(@Valid @RequestBody MemberDto.SignUpDto requestBody) {
//        Member member = memberMapper.memberSignUpToMember(requestBody);
//        Member createMember = memberService.createMember(member);
        Member member = memberService.createMember(memberMapper.memberSignUpToMember(requestBody));
        MemberDto.MemberResponseDto response = memberMapper.memberToMemberResponse(member);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    /*
    USER-02: User 조회
     */
    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        Member member = memberService.findMember(memberId);
        MemberDto.MemberResponseDto response = memberMapper.memberToMemberResponse(member);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }

    /*
    USER-03: User 정보 수정
     */
    @PatchMapping("{member-id")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @Valid @RequestBody MemberDto.MemberPatchDto requestBody) {
        requestBody.setMemberId(memberId);
        Member member = memberService.updateMember(memberMapper.memberPatchToMember(requestBody));

        return new ResponseEntity(new SingleResponseDto<>(member), HttpStatus.OK);
    }

    @DeleteMapping("{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
