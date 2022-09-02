package com.imooc.reader.controller;

import com.imooc.reader.utils.ResponseUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    /**
     * 校验前端数据
     *
     * @param username
     * @param password
     * @param nickname
     * @param vc 前端输入的验证码
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
            resp = new ResponseUtils();
        }
        return resp;
    }
}
