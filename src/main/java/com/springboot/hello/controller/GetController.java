package com.springboot.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello World";
    }

    //http://localhost:8080/api/v1/get-api/variable1/{String 값} -> 중괄호는 실제로 없이 값만 있음
    //값을 간단히 전달할 때 주로 사용하는 방법, GET 요청에서 많이 사용됩니다.
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){ //매개변수와 그 값을 연결하기 위해 사용 변수 이름을 동일하게 지정 여기선 variable
        return variable;
    }

    //매개변수의 이름이 맞추기 어렵다면 @PathVariable 뒤에 괄호를 열어 변수명을 직접 지정
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    //쿼리 형식으로 전달 가능 URI에서 ?를 기준으로 우측에 '{키}={값}' 형태로 구성된 요청을 전송하는 방법
    //애플리케이션에서 이가 같은 형식을 처리하려면 @RequestParam을 활용, 매개변수 부분에 명시해 쿼리 값과 매핑
    //http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=vlaue3
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    //만약 쿼리스트링에 어떤 값이 들어올지 모른다면 다음과 같이 Map 객체를 활용할 수도 있다.
    //예를 들어 회원가입시 필수로 작성하지 않아도 되는 항목이 있을때 사용
    //http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " +map.getValue() + "\n");
        });

        return sb.toString();
    }



}
