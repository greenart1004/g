package org.zerock.guestbook.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.guestbook.dto.Member2DTO;
import org.zerock.guestbook.entity.Member2;
import org.zerock.guestbook.repository.Member2Repository;
import org.zerock.guestbook.service.Member2Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/member/")
@Log4j2
@RequiredArgsConstructor
public class Member2Controller {

	private final Member2Service member2Service;
	
	@Autowired
	private Member2Repository member2Repository;
	
///////////////////////////////////////////////////////////////////////////
	@GetMapping("/M2register")
	public String register(){
	log.info("regiser get get get...");
	return "member/M2register";   //  member/register.html로 이동
	}
	
	@GetMapping("/index")
	public String index(){
		
	log.info("index get get get..." );

	return "index.html";  
	}
	
	@GetMapping("/M2loginform")
	public String registerget(){
	
	log.info("M2loginform get get get..." );

	
	return "member/M2loginform";
	}
	
	@PostMapping("/M2register")
	public String registerPost(Member2DTO member2DTO, RedirectAttributes redirectAttributes){
	
	log.info("post post post postdto1..." + member2DTO);
	//새로 추가된 엔티티의 번호
	Long idno = member2Service.register(member2DTO);
	
	log.info("post post post post " + idno);
	
		return "member/M2loginform";
	}

	@PostMapping("/M2loginform")
	public String loginformPost(String loginUsername,String loginPassword,Model model){
				
	log.info("member2DTO.1111111111111111.." + loginUsername );
	log.info("member2DTO.1111111111111111.." + loginPassword );
	
	Member2 mem = member2Repository.findByIdno(loginUsername);	
	
	log.info("member2DTO.1111111111111111.." + mem );
		if(mem == null) {
			log.info("mem.getPassword())   2222222222" );
			return "member/M2loginform";
		//	return "redirect:/member/M2loginform";
		}
		if(!loginPassword.equals(mem.getPassword())) {
			log.info("mem.getPassword())   3333333333");
			return "member/M2loginform";
//			return "redirect:/member/M2loginform";
		}
		
		//	redirectAttributes.addFlashAttribute("msg", idno);
	
		
		return "index.html"; 
//		return "member/loginindex"; 
	}
}
