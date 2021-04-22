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
public class Member2DTO {

    private Long mno;
    
    private String idno;
    
    private String password;
    
    private String email;

	private LocalDateTime regDate, modDate;
   

}