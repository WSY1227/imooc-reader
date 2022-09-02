package com.imooc.reader.controller;

import com.imooc.reader.service.MemberService;
import com.imooc.reader.utils.ResponseUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    /**
     * 注册接口
     *
     * @param username
     * @param password
     * @param nickname
     * @param vc       前端输入的验证码
     * @param request
     * @return
     */
    @PostMapping("/registe")
    public ResponseUtils registe(String username, String password, String nickname, String vc, HttpServletRequest request) {
        String verifyCode = (String) request.getSession().getAttribute("kaptchaVerifyCode");
        ResponseUtils resp;
        if (vc == null || verifyCode == null || !vc.equalsIgnoreCase(verifyCode)) {
            resp = new ResponseUtils("VerifyCodeError", "验证码错误");
        } else {
            //验证码通过后对用户进行注册
            try {
                memberService.createMember(username, password, nickname);
                resp = new ResponseUtils();
            } catch (Exception e) {
                e.printStackTrace();
                resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
            }
        }
        return resp;
    }
}
