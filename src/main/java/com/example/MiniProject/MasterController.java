package com.example.MiniProject;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.MiniProject.User;
import com.example.MiniProject.SecurityService;
import com.example.MiniProject.UserService;
import com.example.MiniProject.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.MiniProject.Tbl_member;
import com.example.MiniProject.MemberService;

import com.example.MiniProject.Tbl_asset;
import com.example.MiniProject.AssetService;

@Controller
public class MasterController {

	//Member Controller
	@Autowired
	private MemberService memberService;

	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		return "dashboard";
	}

	@RequestMapping("/member")
	public String member(Model model) {
		List<Tbl_member> listMembers = memberService.listAll();
		model.addAttribute("listMembers", listMembers);
		return "member";
	}
	
	@RequestMapping(value = "/member/add", method = RequestMethod.GET)
	public String memberadd(ModelMap model) {
		Tbl_member tbl_member = new Tbl_member();
		model.addAttribute("tbl_member", tbl_member);
		return "memberadd";
	}

	@RequestMapping(value = "/member/savemember", method = RequestMethod.POST)
	public String SaveMember(@Valid Tbl_member tbl_member, BindingResult result, ModelMap model,
			RedirectAttributes redirectattributes) {
		if (result.hasErrors()) {
			return "memberadd";
		}
		memberService.save(tbl_member);
		return "memberadded";
	}
	
	@RequestMapping(value = "/member/update/{id}", method = RequestMethod.GET)
	public String showEditTbl_memberPage(@PathVariable(name = "id") long memberid, Model model) {
		Tbl_member tbl_member = memberService.get(memberid);
		model.addAttribute("tbl_member", tbl_member);
		return "memberupdate";
	}

	@RequestMapping(value = "/member/update/memberupdated", method = RequestMethod.POST)
	public String UpdateMember(@Valid Tbl_member tbl_member, BindingResult result, ModelMap model,
			RedirectAttributes redirectattributes) {
		if (result.hasErrors()) {
			return "memberupdate";
		}
		memberService.save(tbl_member);
		return "memberupdated";
	}
	
	@RequestMapping(value = "/member/delete/{id}", method = RequestMethod.GET)
	public String deleteForm(@PathVariable(name = "id") long memberid) {
		memberService.delete(memberid);
		return "memberdeleted";
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//Asset Controller
	@Autowired
	private AssetService assetService;
	
	
	@RequestMapping("/asset")
	public String asset(Model model) {
		List<Tbl_asset> listAssets = assetService.listAll();
		model.addAttribute("listAssets", listAssets);
		return "asset";
	}

	@RequestMapping(value = "/asset/delete/{id}", method = RequestMethod.GET)
	public String deleteAsset(@PathVariable(name = "id") long assetid) {
		assetService.delete(assetid);
		return "assetdeleted";
	}

	@RequestMapping(value = "/asset/update/{id}", method = RequestMethod.GET)
	public String showEditTbl_assetPage(@PathVariable(name = "id") long assetid, Model model) {
		Tbl_asset tbl_asset = assetService.get(assetid);
		model.addAttribute("tbl_asset", tbl_asset);
		return "assetupdate";
	}

	@RequestMapping(value = "/asset/saveasset", method = RequestMethod.POST)
	public String SaveAsset(@Valid Tbl_asset tbl_asset, BindingResult result, ModelMap model,
			RedirectAttributes redirectattributes) {
		if (result.hasErrors()) {
			return "assetadd";
		}
		assetService.save(tbl_asset);
		return "assetadded";
	}

	@RequestMapping(value = "/asset/update/updateasset", method = RequestMethod.POST)
	public String UpdateAsset(@Valid Tbl_asset tbl_asset, BindingResult result, ModelMap model,
			RedirectAttributes redirectattributes) {
		if (result.hasErrors()) {
			return "assetupdate";
		}
		assetService.save(tbl_asset);
		return "assetupdated";
	}

	@RequestMapping(value = "/asset/add", method = RequestMethod.GET)
	public String assetadd(ModelMap model) {
		Tbl_asset tbl_asset = new Tbl_asset();
		model.addAttribute("tbl_asset", tbl_asset);
		return "assetadd";
	}

	@ModelAttribute("category")
	public List<String> initializeSections() {
		List<String> category = new ArrayList<String>();
		category.add("Asset Tetap");
		category.add("Asset Bergerak");
		return category;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/* Login */

	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registrasi")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "register";
    }

    @PostMapping("/registrasi")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/dashboard";
    }

    @GetMapping("/login")
	public String login(Model model , String error, String logout ) {
		
		  if (error != null) model.addAttribute("error",
		  "Your username and password is invalid.");
		  
		  if (logout != null) model.addAttribute("message",
		  "You have been logged out successfully.");
		 

        return "login";
    }

    @GetMapping({"/", "/dashboard"})
    public String welcome(Model model) {
        return "dashboard";
    }
}