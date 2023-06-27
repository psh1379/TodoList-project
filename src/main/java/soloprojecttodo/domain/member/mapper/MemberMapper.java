package soloprojecttodo.domain.member.mapper;

import org.mapstruct.Mapper;
import soloprojecttodo.domain.member.dto.MemberDto;
import soloprojecttodo.domain.member.entity.Member;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberSignUpToMember(MemberDto.SignUpDto signUpDto);
    MemberDto.MemberResponseDto memberToMemberResponse(Member member);
    Member memberPatchToMember(MemberDto.MemberPatchDto patchDto);
}
