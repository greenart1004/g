package org.zerock.guestbook.service;

import org.zerock.guestbook.dto.Member2DTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Member2;

public interface Member2Service {

	Long register(Member2DTO dto1);
	
	PageResultDTO<Member2DTO, Member2> getList(PageRequestDTO requestDTO);

	Member2DTO get(Long mno);//
	
	void modify(Member2DTO memberDTO);//
	
    void removeWithReplies(Long mno);
	

	
	///////////////////////////////////////////////
	 default Member2 dtoToEntity(Member2DTO dto) {   // DTO - interface 에서 데이타를 받아서 바로 Entity 로변환하는부분 

	 System.out.println(dto);
	 Member2 entity = Member2.builder()
				.mno(dto.getMno())
				.idno(dto.getIdno())
				.password(dto.getPassword())
				.email(dto.getEmail())
				.build();
		 return entity;									
	 }
//////////////////////////////////////////////////////////////////////////////////////
	default Member2DTO entityToDto(Member2  entity){
		Member2DTO dto  = Member2DTO.builder()
		.mno(entity.getMno())
		.idno(entity.getIdno())
		.password(entity.getPassword())
		.email(entity.getEmail())
		.regDate(entity.getRegDate())
		.modDate(entity.getModDate())
		.build();
		return dto;
	}


}
