package ro.msg.learning.shop.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.repository.IRepositoryCustomer;

@Service
@AllArgsConstructor
public class ServiceCustomer implements org.springframework.security.core.userdetails.UserDetailsService {

    private final IRepositoryCustomer repositoryCustomer;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var customer = repositoryCustomer.findByUsername(username);
        if(customer != null){
            return new User(customer.getUsername(), customer.getPassword(), AuthorityUtils.NO_AUTHORITIES);
        }
        else{
            throw new RuntimeException();
        }
    }
}
