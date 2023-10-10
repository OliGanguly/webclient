package com.example.pragratask.service;

import com.example.pragratask.Entity.User;
import com.example.pragratask.config.WebClientConfig;
import com.example.pragratask.dto.UserResponse;
import com.example.pragratask.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private WebClientConfig webClientConfig;
    @Autowired
    private UserRepo userRepo;


   public User saveData(User user,String name){
      Optional<User> getUser = userRepo.findByLogin(name);
//       System.out.println(getUser);
       if(getUser==null){
           UserResponse response = webClientConfig.webClientBuilder().build().get()
                   .uri("https://api.github.com/users/OliGanguly")
                   .retrieve()
                   .bodyToMono(UserResponse.class)
                   .block();
//           System.out.println("Response ..."+response);
           User u = new User();
           u.setId(response.getId());
           u.setLogin(response.getLogin());
           u.setCreated_at(response.getCreated_at());
           u.setUpdated_at(response.getUpdated_at());
           return userRepo.save(u);
       }else {
           return userRepo.save(user);

//       UserResponse response = webClientConfig.webClientBuilder().build().get()
//               .uri("https://api.github.com/users/OliGanguly")
//               .retrieve().
//                bodyToMono(UserResponse.class)
//               .block();
//       System.out.println("Response ..."+response);
//       if(response==null){
//           return userRepo.save(user);
//       }else {
//           User u = new User();
//           u.setId(response.getId());
//           u.setLogin(response.getLogin());
//           u.setCreated_at(response.getCreated_at());
//           u.setUpdated_at(response.getUpdated_at());
//           return userRepo.save(u);

//          userRepo.save(response);
       }



   }
}
