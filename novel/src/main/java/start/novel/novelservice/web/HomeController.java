package start.novel.novelservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    //home 요청시 NovelData 로 이동하는 컨트롤러
    @RequestMapping("/")
    public String home() {
        return "redirect:/NovelData";
    }
}
