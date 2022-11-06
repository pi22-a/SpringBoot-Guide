package com.springboot.api.dto;


import org.springframework.web.bind.annotation.GetMapping;

// DTO 클래스에는 전달하고자 하는 필드 객체를 선언하고 getter/setter 메서드를 구현합니다.
// DTO 클래스에 선언된 필드는 컨트롤러의 메서드에서 쿼리 파라미터의 키와 매핑됩니다.
public class MemberDto {
    private  String name;
    private  String email;
    private String organization;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getOrganization(){
        return organization;
    }

    public void  setOrganization(String organization){
        this.organization = organization;
    }

    @Override
    public String toString(){
        return "MemberDto{" +
                "name'" + name + '\'' +
                ", email-'" + email + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }
    // 쿼리스트링의 키가 정해져 있지만 받아야 할 파라미터가 많을 경우에 DTO 객체를 활용해 코드의 가독성을 높힌다.
    // {키}={값} 과 동일한 형태의 쿼리스트링
    @GetMapping(value = "/request")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }


}
