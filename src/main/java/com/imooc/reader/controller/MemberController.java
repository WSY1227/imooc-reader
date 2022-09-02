package com.imooc.reader.controller;

import com.imooc.reader.entity.Member;
import com.imooc.reader.entity.MemberReadState;
import com.imooc.reader.service.MemberReadStateService;
import com.imooc.reader.service.MemberService;
import com.imooc.reader.utils.ResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Resource
    private MemberReadStateService memberReadStateService;

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

    /**
     * 登录
     *
     * @param username
     * @param password
     * @param vc
     * @param request
     * @return
     */
    @PostMapping("/check-login")
    public ResponseUtils checkLogin(String username, String password, String vc, HttpServletRequest request) {
        String verifyCode = (String) request.getSession().getAttribute("kaptchaVerifyCode");
        ResponseUtils resp;
        if (vc == null || verifyCode == null || !vc.equalsIgnoreCase(verifyCode)) {
            resp = new ResponseUtils("VerifyCodeError", "验证码错误");
        } else {
            //验证码通过后开始登陆
            try {
                Member member = memberService.checkLogin(username, password);
                resp = new ResponseUtils().put("member", member);
            } catch (Exception e) {
                e.printStackTrace();
                resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
            }
        }
        return resp;
    }

    /**
     * 根据id查询用户信息
     *
     * @param memberId
     * @return
     */
    @GetMapping("/select_id")
    public ResponseUtils checkLogin(Long memberId) {
        ResponseUtils resp;
        try {
            Member member = memberService.selectById(memberId);
            resp = new ResponseUtils().put("member", member);
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }

    /**
     * 查询用户阅读状态
     *
     * @param memberId 用户id
     * @param bookId   图书id
     * @return
     */
    @GetMapping("/select_read_state")
    public ResponseUtils selectMemberReadState(Long memberId, Long bookId) {
        ResponseUtils resp;
        try {
            MemberReadState memberReadState = memberReadStateService.selectMemberReadState(memberId, bookId);
            resp = new ResponseUtils().put("readState", memberReadState);
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }

    /**
     * 更新阅读状态
     *
     * @param memberId  用户id
     * @param bookId    图书id
     * @param readState 阅读状态
     * @return
     */
    @PostMapping("/update_read_state")
    public ResponseUtils updateReadState(Long memberId, Long bookId, Integer readState) {
        ResponseUtils resp;
        try {
            MemberReadState memberReadState = memberReadStateService.updateMemberReadState(memberId, bookId, readState);
            resp = new ResponseUtils().put("readState", memberReadState);
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }
}
