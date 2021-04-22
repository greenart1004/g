package org.zerock.guestbook.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.guestbook.dto.Member2DTO;
import org.zerock.guestbook.service.Member2Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/member/")
@Log4j2
@RequiredArgsConstructor
public class Member2Controller {

	private final Member2Service member2Service;
	
///////////////////////////////////////////////////////////////////////////
	@GetMapping("/M2register")
	public String register(){
	log.info("regiser get get get...");
	return "member/M2register";   //  member/register.html로 이동
	}
	
	@PostMapping("/M2register")
	public String registerPost(Member2DTO member2DTO, RedirectAttributes redirectAttributes){
	
	log.info("dto1..." + member2DTO);
	//새로 추가된 엔티티의 번호
	Long mno = member2Service.register(member2DTO);
	
	log.info("post post post post " + mno);
	
	redirectAttributes.addFlashAttribute("msg", mno);
	
	return "redirect:/";  ///?????
}

}
