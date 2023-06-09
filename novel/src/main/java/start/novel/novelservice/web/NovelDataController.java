package start.novel.novelservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import start.novel.domain.NovelData;
import start.novel.novelservice.repository.NovelDataSearchCond;
import start.novel.novelservice.repository.NovelUpdateDto;
import start.novel.novelservice.service.NovelService;

import java.util.List;

@Controller
@RequestMapping("/NovelData")
@RequiredArgsConstructor
public class NovelDataController {

    private final NovelService novelService;

    @GetMapping
    public String novelData_Collection (@ModelAttribute("NovelDataSearch")NovelDataSearchCond NovelDataSearch , Model model) {
        List<NovelData> novelData_Collection = novelService.findNovelData(NovelDataSearch);
        model.addAttribute("novelData_Collection", novelData_Collection);
        return "novelData_Collection";

    }

    @GetMapping("/{novel_id}")
    public String novelData(@PathVariable long novel_id, Model model) {
        NovelData novelData = novelService.findById(novel_id).get();
        model.addAttribute("novelData" , novelData);
        return "novelData";
    }

    @GetMapping("/add")
    public String addForm() {
        return "addForm";
    }

    @PostMapping("/add")
    public String addNovelData(@ModelAttribute NovelData novelData, RedirectAttributes redirectAttributes) {
        NovelData savedNovelData = novelService.save(novelData);

        redirectAttributes.addAttribute("novel_id", savedNovelData.getNovel_id());
        redirectAttributes.addAttribute("status", true);
        return "redirected:/novelData_Collection/{novel_id}";
    }

    @PostMapping("/{novel_id}/edit")
    public String editForm(@PathVariable Long novel_id, Model model) {
        NovelData novelData = novelService.findById(novel_id).get();
        model.addAttribute("novelData", novel_id);
        return "editForm";
    }

    @PostMapping("/{novel_id}/edit")
    public String edit(@PathVariable Long novel_id, @ModelAttribute NovelUpdateDto updateParam) {
        novelService.update(novel_id, updateParam);
        return "redirect:/novelData_Collection/{novel_id}";
    }
}
