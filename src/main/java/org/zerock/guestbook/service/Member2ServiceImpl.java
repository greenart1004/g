package org.zerock.guestbook.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.Member2DTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Member2;
import org.zerock.guestbook.entity.QMember2;
import org.zerock.guestbook.repository.Member2Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
@RequiredArgsConstructor
public class Member2ServiceImpl  implements Member2Service {

private final Member2Repository member2Repository;
	
    @Override
    public Long register(Member2DTO dto) {                      //// register()
    	log.info("DTO------------------------" + dto);
//    	log.info(dto);
    	Member2 entity = dtoToEntity(dto);
    	log.info(entity);                                      
    	member2Repository.save(entity);
    	return entity.getMno();    
    	}
   ////////////////////////////////////////////// 

    @Override
    public PageResultDTO<Member2DTO, Member2> getList(PageRequestDTO requestDTO) {  // getList()
    	Pageable pageable = requestDTO.getPageable(Sort.by("mno").descending());
    	
    	BooleanBuilder booleanBuilder = getSearch(requestDTO);  // 검색조건처리
    	
    	Page<Member2> result = member2Repository.findAll(booleanBuilder, pageable); // Querydsl 사용
    	
//    	Page<Member2> result = repository.findAll(pageable);
    	
    	Function<Member2, Member2DTO> fn = (entity -> entityToDto(entity));
    	
    	return new PageResultDTO<>(result, fn );   
	}
    

	@Override
    public Member2DTO get(Long mno) {
    	
    	Optional<Member2> result = member2Repository.findById(mno);
    	
    	return result.isPresent() ? entityToDto(result.get()) : null;
    }

    
    @Override
    public void removeWithReplies(Long mno) {
    	
    	member2Repository.deleteById(mno);
    }
    
    
    @Override
    public void modify(Member2DTO dto) {
    	
    	Optional<Member2> result = member2Repository.findById(dto.getMno());
    	
    	if(result.isPresent()) {
    		
    		Member2 entity = result.get();
    		
    		entity.changeIdno(dto.getIdno());
    		
    		entity.changeEmail(dto.getEmail());
    	
    		member2Repository.save(entity);    	
    	}
    }
    
    //////////////////////////////
    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
    	String type = requestDTO.getType();
    	   	
    	BooleanBuilder booleanBuilder = new BooleanBuilder();

    	if(type == null || type.trim().length() == 0) {    //검색 조건이 없는 경우
    		return booleanBuilder;
    	}

    	QMember2 qMember2 =QMember2.member2;
    	String keyword = requestDTO.getKeyword();
    	BooleanExpression expression = qMember2.mno.gt(0L);       //mno > 0 조건만 생성
    	booleanBuilder.and(expression);

    	//검색조건을 작성하기
	    BooleanBuilder conditionBuilder = new BooleanBuilder();
	    
	    if(type.contains("i")) {
	    	conditionBuilder.or(qMember2.idno.contains(keyword));
	    }
//	    if(type.contains("c")) {
//	    	conditionBuilder.or(qMember2.password.contains(keyword));
//	    }
	    if(type.contains("e")) {
	    	conditionBuilder.or(qMember2.email.contains(keyword));
	    }
	    
	    //모든 조건 통합
		    booleanBuilder.and(conditionBuilder);
		    return booleanBuilder;
	  }
    
    
}  