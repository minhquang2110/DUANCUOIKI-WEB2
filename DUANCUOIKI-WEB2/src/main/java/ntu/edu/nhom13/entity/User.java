package ntu.edu.nhom13.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public class User implements UserDetails{
	 	
		
		
	 	private final Account account;
	 	private final Scientist scientist;

	 	public User(Account account, Scientist scientist) {
	        this.account = account;
	        this.scientist= scientist;
	    }

	    public Account getAccount() {
	        return account;
	    }
	    public Scientist getScientist() {
	        return scientist;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return List.of(new SimpleGrantedAuthority("ROLE_" + account.getRole()));
	    }

	    @Override
	    public String getPassword() {
	        return account.getPassword(); 
	    }

	    @Override
	    public String getUsername() {
	        return account.getUsername();
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

}
