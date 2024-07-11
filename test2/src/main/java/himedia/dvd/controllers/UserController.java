package himedia.dvd.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.dvd.repositories.vo.UserVo;
import himedia.dvd.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RequestMapping("/users")
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	 
	// 媛��엯 �뤌
	@GetMapping({ "", "/", "/join" })
	public String join(@ModelAttribute UserVo userVo) {
		return "users/joinform";
	}

	// 媛��엯 泥섎━
	@PostMapping("/join")
	public String join(@ModelAttribute @Valid UserVo userVo, BindingResult result, Model model) {
		System.out.println("�쉶�썝 媛��엯 �뤌: " + userVo);
		
		// 鍮꾨�踰덊샇�� 鍮꾨�踰덊샇 �솗�씤 寃�利�
        if (!userVo.getPassword().equals(userVo.getPasswordConfirm())) {
            result.rejectValue("passwordConfirm", "error.passwordConfirm", "鍮꾨�踰덊샇媛� �씪移섑븯吏� �븡�뒿�땲�떎.");
        }

     // �빟愿� �룞�쓽 �솗�씤 濡쒖쭅 異붽�
        if (userVo.getAgree() == null || !userVo.getAgree()) {
            result.rejectValue("agree", "agree.required");
        }
        
		// 寃�利� 寃곌낵 �솗�씤
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError e : list) {
				System.err.println("Error" + e);
			}
			model.addAllAttributes(result.getModel());
			return "users/joinform";
		}
		boolean success = userService.join(userVo);
		if (success) { // 媛��엯 �꽦怨�
			// 媛��엯 �꽦怨� �럹�씠吏�濡�
			System.out.println("�쉶�썝 媛��엯 �꽦怨�");
			return "redirect:/users/joinsuccess";
		} else {
			// �떎�뙣
			System.err.println("�쉶�썝 媛��엯 �떎�뙣");
			return "redirect:/users/join";
		}
	}

	// 媛��엯 �꽦怨� �럹�씠吏�
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "users/joinsuccess";
	}

	// 濡쒓렇�씤 �뤌 �럹�씠吏�
	@GetMapping("/login")
	public String loginForm() {
		return "users/loginform";
	}
	


	// 濡쒓렇�씤 �븸�뀡
    @PostMapping("/login")
    public String loginAction(
            @RequestParam(value="email", required=false, defaultValue="") String email,
            @RequestParam(value="password", required=false, defaultValue="") String password,
            HttpSession session) {
        System.out.println("email:" + email);
        System.out.println("password:" + password);
        
        if(email.length() == 0 || password.length() == 0) {
            System.out.println("email �샊�� password媛� �엯�젰�릺吏� �븡�쓬");
            return "redirect:/users/login";
        }
        
        UserVo authUser = userService.login(email, password);
        
        if (authUser != null) {
            if (authUser.getRole() == 1) {
                session.setAttribute("authAdmin", authUser);
                session.setAttribute("authUser", authUser);
                return "redirect:/admin/home";
            } else {
                session.setAttribute("authUser", authUser);
                return "redirect:/";
            }
        } else {
            return "redirect:/users/login";
        }
    }
	// 愿�由ъ옄�슜 �럹�씠吏�
	@GetMapping("/admin")
	public String adminHome() {
		return "admin/home";
	}
	
	//	濡쒓렇�븘�썐
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	
	//	以묐났 �씠硫붿씪 泥댄겕
	@ResponseBody	//	-> MessageConverter �궗�슜
	@RequestMapping("/checkEmail")
	public Object checkEmail(@RequestParam(value="email", 
										required=true,
										defaultValue="") String email) {
		UserVo vo = userService.login(email);
		boolean exists = vo != null ? true: false;
		
		System.out.println("Controller UserVo: " + vo);
		
		Map<String, Object> json = new HashMap<>();
		json.put("result", "success");
		json.put("exists", exists);
		
		return json;
	
	}
	
	/*
	 * @GetMapping("/{userNo}") public String view(@PathVariable("userNo") Long no,
	 * Model model, HttpSession session, RedirectAttributes redirectAttributes) {
	 * UserVo authUser = (UserVo)session.getAttribute("authUser");
	 * 
	 * return "updateuser/updateform"; }
	 */
	
	@GetMapping("{email}/updateform")
	public String updateForm(@PathVariable("email")String email, Model model) {
		model.addAttribute("email",email);
	    return "users/updateform";
	}

	
	@PostMapping("/update")
	public String updateUserAction(@ModelAttribute UserVo vo) {
	    boolean success = userService.updateUser(vo);
	    if (success) {
	        return "redirect:/users/login";
	    } else {
	        return "redirect:/users/updateform";
	    }
	}



	
	// �쉶�썝 �닔�젙 �셿猷� �뤌
//	@RequestMapping("/updatesucess")
//	public String updateSuccess() {
//		return "users/updatesuccess";
//	}
	
	
	
	

}
