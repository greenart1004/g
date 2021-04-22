package org.zerock.guestbook.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private String email1;

    private String password1;

    private String name1;

	private LocalDateTime regDate1, modDate1;
   

}
