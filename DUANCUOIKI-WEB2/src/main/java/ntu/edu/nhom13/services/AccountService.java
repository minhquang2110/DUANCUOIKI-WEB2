package ntu.edu.nhom13.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ntu.edu.nhom13.entity.Account;
import ntu.edu.nhom13.repositories.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService{

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Integer id) {
        return accountRepository.findById(id);
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Integer id) {
        accountRepository.deleteById(id);
    }

    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("loadUserByUsername được gọi với username = " + username);
//        Account account = accountRepository.findByUsername(username);
//        if (account == null) {
//            System.out.println("Không tìm thấy user");
//            throw new UsernameNotFoundException("User không tồn tại");
//        }
//        System.out.println("Tìm thấy user: " + account.getUsername());
//        return User.builder()
//                .username(account.getUsername())
//                .password(passwordEncoder.encode(account.getPassword())) // mật khẩu đã mã hóa (BCrypt)
//                .roles(account.getRole().toString())
//                .build();
//    }

}

