package com.example.shoppingmall.controller;

import com.example.shoppingmall.domain.User;
import com.example.shoppingmall.dto.JoinForm;
import com.example.shoppingmall.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.pool.TypePool;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @GetMapping("/login")
    public String login(
            @RequestParam(name = "fail",
                    required = false,
                    defaultValue = "false") String errorFlag){
            return "users/login";
    }

    @GetMapping("/join")
    public String joinform(){
        return "users/joinform";
    }

    @PostMapping("/join")
    public String join(@Valid JoinForm joinForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(bindingResult.toString());
        }
        if (!joinForm.getPassword1().equals(joinForm.getPassword2())) {
            throw new IllegalArgumentException("암호가 다릅니다.");
        }

        User user = new User();
        user.setEmail(joinForm.getEmail());
        user.setName(joinForm.getName());
        user.setNickname(joinForm.getNickname());
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(passwordEncoder.encode(joinForm.getPassword1()));

        User result = userServiceImpl.join(user);

        return "redirect:/users/welcome";
    }

}
