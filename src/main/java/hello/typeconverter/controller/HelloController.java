package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    //HTTP 요청 파라미터는 모두 문자형이다 -> 숫자로 변환해야 함
    @GetMapping("hello-v1")
    public String HelloV1(HttpServletRequest request){
        String data = request.getParameter("data");
        Integer intValue = Integer.valueOf(data);
        System.out.println("intValue = " + intValue);

        return "ok";
    }

    //Spring이 제공하는 @RequestParam을 사용하면 HelloV1처럼 귀찮은 형변환 과정 필요 X
    //Spring이 중간에서 타입을 변환해준 거임
    @GetMapping("hello-v2")
    public String HelloV2(@RequestParam Integer data){
        System.out.println("data = " + data);

        return "ok";
    }

    //문자 -> IpPort 객체 타입으로 변환
    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort){
        System.out.println("ipPort IP = " + ipPort.getIp());
        System.out.println("ipPort PORT = " + ipPort.getPort());
        return "ok";
    }
}
