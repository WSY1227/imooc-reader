package com.imooc.reader.task;

import com.imooc.reader.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName: ComputeTask
 * @Description: 定时任务
 * @author: XU
 * @date: 2022年09月02日 21:37
 **/
@Component
public class ComputeTask {
    Logger logger = LoggerFactory.getLogger(ComputeTask.class);
    @Resource
    private BookService bookService;

    //每分钟自动执行更新
    @Scheduled(cron = "0 * * * * ?")
    public void updateScore() {
        bookService.updateScore();
        logger.info("已更新所有图书评分");
    }
}
