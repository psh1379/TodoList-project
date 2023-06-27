package soloprojecttodo.domain.member.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class MemberDto {

    @Getter
    public class SignUpDto {
        @NotBlank
        private String email;
        @NotBlank
        private String password;
        @NotBlank
        private String nickname;
    }

    @Getter
    public class MemberPatchDto {
        @NotBlank
        private long memberId;
        private String email;
        private String password;
        private String nickname;

        public void setMemberId(long memberId) {
            this.memberId = memberId;
        }
    }

    @Getter
    public class MemberResponseDto {

        private long memberId;
        private String email;
        private String nickname;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
    }
}
