package com.imooc.reader.controller;

import com.imooc.reader.ResponseUtils;
import com.imooc.reader.service.EvaluationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: EvaluationController
 * @Description:
 * @author: XU
 * @date: 2022年09月02日 0:27
 **/
@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {
    @Resource
    private EvaluationService evaluationService;

    /**
     * 根据图书id查询评论和关联评论会员昵称
     *
     * @param bookId 图书id
     * @return
     */
    @GetMapping("/list")
    public ResponseUtils list(Long bookId) {
        ResponseUtils resp = null;
        try {
            List<Map> maps = evaluationService.selectByBookId(bookId);
            resp = new ResponseUtils().put("list", maps);
        } catch (Exception e) {
            e.printStackTrace();
            new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }
}
