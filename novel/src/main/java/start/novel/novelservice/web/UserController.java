package start.novel.novelservice.web;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import start.novel.novelservice.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/User")
public class UserController {
    private UserService userService;

}
