package com.springboot.hello.controller;

import com.hello.hellospring.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//5.3
//POST API는 웹 애플리케이션을 통해 데이터베이스 등의 저장소에 리소스를 저장할 때 사용되는 API입니다.
//앞서 살펴본 방식은 GET API 에서 URL의 경로나 파라미터에 변수를
@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    // POST API에서 @RequestMapping을 사용하는 방법은 GET API와 비슷하다.
    // 요청 처리 메서드를 정의할 때 GET API와 비슷함
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }
    // 윗 코드에서는 리소스를 받지 않고 단지 POST 요청만 받는 메서드를 구현함.
    // 일반적으로 POST형식의 요청은 클라이언트가 서버에 리소스를 저장할때 사용.
    // 즉 POST 요청에서는 리소스를 담기 위해 HTTP Body에 값을 넣어 전송
    // 일반적으로 JSON 형식으로 값을 주고 받는다.
    // http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/memeber")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
        // 위 코드를 보면 @RequestMapping 대신 @PostMapping을 사용
        // 이 어노테이션을 사용하면 method 요소를 정의하지 않아도 됨.
        // 그 다음 @RequestBody라는 어노테이션을 사용함
        // @RequestBody는 HTTP의 Body 내용을 해당 어노테이션이 지정된 객체에 매핑하는 역할
    }

    // DTO 객체를 활용한 POST API 구현
    // Map 객체는 요청을 통해 어떤 값이 들어오게 될 지 특정하기 어려울 때 주로 사용.
    // 요청 메시지에 들어갈 겂이 정해져 있다면 아래 코드와 같이 DTO객체를 매개변수로 삼아 작성.
    // MemberDto의 멤버 변수를 요청 메시지의 키와 매핑해 값을 가져옵니다.

    //http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}


