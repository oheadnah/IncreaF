package com.main19.server.member.dto;

import com.main19.server.posting.scrap.dto.ScrapResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;


public class MemberDto {
	@Getter
	@AllArgsConstructor
	public static class Post {
		@NotBlank
		private String userName;
		@Email
		private String email;
		private String location; // todo 이거 프론트에서 받을건지 정하기
		private String profileText;
		private String password; // todo password를 어떻게 받아올지 프론트와 논의

		public void updateMember(String userName, String email, String location, String profileText, String password) {
			this.userName = userName;
			this.email = email;
			this.location = location;
			this.profileText = profileText;
			this.password = password;
		}
	}

	@Getter
	public static class Patch {
		private long memberId;
		private String userName;
		private String profileText;
		private String location;

		public void setMemberId(long memberId) {
			this.memberId = memberId;
		}

		@Builder
		public Patch(String userName, String profileText, String location) {
			this.userName = userName;
			this.profileText = profileText;
			this.location = location;
		}
	}

	@Getter
	public static class Response {
		private long memberId;
		private String userName;
		private String email;
		private String location;
		private String profileImage;
		private String profileText;
		private List<ScrapResponseDto> scrapPostingList;

		@Builder
		public Response(long memberId, String userName, String email, String location, String profileImage, String profileText, List<ScrapResponseDto> scrapPostingList) {
			this.memberId = memberId;
			this.userName = userName;
			this.email = email;
			this.location = location;
			this.profileImage = profileImage;
			this.profileText = profileText;
			this.scrapPostingList = scrapPostingList;
		}
	}
}
