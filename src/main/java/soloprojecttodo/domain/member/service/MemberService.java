package soloprojecttodo.domain.member.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import soloprojecttodo.domain.member.entity.Member;
import soloprojecttodo.domain.member.repository.MemberRepository;
import soloprojecttodo.global.exception.BusinessLogicException;
import soloprojecttodo.global.exception.ExceptionCode;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public Member createMember(Member member) {
        verifyExistsEmail(member.getEmail());

        return memberRepository.save(member);
    }


    public Member findMember(long memberId) {

        return memberRepository.findById(memberId).orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }


    public Member updateMember(Member member) {
        verifiedMember(member.getMemberId());

        return memberRepository.save(member);
    }


    public void deleteMember(long memberId) {
        verifiedMember(memberId);

        memberRepository.deleteById(memberId);
    }

    // 유효한 회원인지 확인
    public void verifiedMember(long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        member.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    // 이메일 중복 확인
    public void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);

        if (member.isPresent()) throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}
