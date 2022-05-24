package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConverterController {

    @GetMapping("/converter-view")
    public String converterView(Model model){
        model.addAttribute("number", 10000);
        model.addAttribute("ipPort", new IpPort("127.0.0.1", 8080));
        return "converter-view";
    }

    //컨버터를 폼에 적용하기
    //IpPort를 뷰 템플릿 폼에 출력한다
    @GetMapping("/converter/edit")
    public String converterForm(Model model){
        IpPort ipPort = new IpPort("127.0.0.1", 8080);
        Form form = new Form(ipPort);

        model.addAttribute("form", form);
        return "converter-form";
    }

    //뷰 템플릿 폼의 IpPort 정보를 받아서 출력한다
    @PostMapping("/converter/edit")
    public String converterEdit(@ModelAttribute Form form, Model model){
        IpPort ipPort = form.getIpPort();
        model.addAttribute("ipPort", ipPort);
        return "converter-view";
    }

    @Data
    static class Form{
        private IpPort ipPort;

        public Form(IpPort ipPort){
            this.ipPort = ipPort;
        }
    }
}

/*
    GET에서는 th:field가 컨버전 서비스 적용
    IpPort 객체 -> String으로 변환

    POST에서는 @ModelAttribute를 사용
    String -> IpPort 객체로 변환
 */
