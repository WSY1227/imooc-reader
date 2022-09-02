package com.imooc.reader.controller;

import com.imooc.reader.entity.Evaluation;
import com.imooc.reader.utils.ResponseUtils;
import com.imooc.reader.service.EvaluationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    /**
     * 添加评论
     *
     * @param memberId
     * @param bookId
     * @param score
     * @param content
     * @return
     */
    @PostMapping("/evaluate")
    public ResponseUtils evaluate(Long memberId, Long bookId, Integer score, String content) {
        ResponseUtils resp = null;
        try {
            Evaluation evaluate = evaluationService.evaluate(memberId, bookId, score, content);
            resp = new ResponseUtils().put("evaluate", evaluate);
        } catch (Exception e) {
            e.printStackTrace();
            new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }
}
