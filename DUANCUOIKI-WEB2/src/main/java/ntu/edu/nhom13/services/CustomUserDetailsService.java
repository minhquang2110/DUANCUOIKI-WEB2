package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import ntu.edu.nhom13.entity.Account;
import ntu.edu.nhom13.entity.Admin;
import ntu.edu.nhom13.entity.Scientist;
import ntu.edu.nhom13.entity.User;
import ntu.edu.nhom13.repositories.AccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private  AccountRepository accountRepository;
    
    @Autowired
	private ScientistService scientistService;
    
    @Autowired
   	private AdminService adminService;

    @Autowired
	private PasswordEncoder passwordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = accountRepository.findByUsername(username);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return org.springframework.security.core.userdetails.User
//            .withUsername(user.getUsername())
//            .password(passwordEncoder.encode(user.getPassword())) 
//            .roles(user.getRole().toString()) 
//            .build();
        if(user == null) {
        	
        }
        if(user.getRole().toString()=="Admin") {
        	Admin scientist= adminService.getAdminByAccountId(user.getAccountId());
        	return new 	User(user,scientist);
        }else {
        	Scientist scientist= scientistService.getScientistByAccountId(user.getAccountId());
        	return new 	User(user,scientist);
        }
    }
    
    public String loginFailed(Model model) {
    	model.addAttribute("failed","Tên đăng nhập hay mật khẩu sai");
    	return "loginTemplate";
    }
}
