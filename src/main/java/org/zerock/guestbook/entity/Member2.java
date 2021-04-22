package org.zerock.guestbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member2 extends BaseEntity{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;
    
    @Column(length = 50, nullable = false)
    private String idno;
    
    @Column(length = 50, nullable = false)
    private String password;
    
    @Column(length = 50, nullable = false)
    private String email;

	public void changeEmail(String email) {
		this.email = email;		
	}

	public void changeIdno(String idno) {
		this.idno = idno;			
	}
    
}