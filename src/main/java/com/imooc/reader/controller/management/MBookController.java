package com.imooc.reader.controller.management;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imooc.reader.entity.Book;
import com.imooc.reader.service.BookService;
import com.imooc.reader.utils.ResponseUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: MBookController
 * @Description: 后台book管理
 * @author: XU
 * @date: 2022年09月02日 23:37
 **/
@RestController
@RequestMapping("/api/management/book")
public class MBookController {
    @Resource
    private BookService bookService;

    @GetMapping("/list")
    public ResponseUtils list(Integer page, Integer rows) {
        if (page == null) {
            page = 1;
        }
        if (rows == null) {
            rows = 10;
        }
        ResponseUtils resp = null;
        try {
            IPage<Map> p = bookService.selectBookMap(page, rows);
            resp = new ResponseUtils().put("list", p.getRecords()).put("count", p.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }

    /**
     * 新增图书接口
     *
     * @param book
     * @return
     */
    @PostMapping("/createBook")
    public ResponseUtils createBook(Book book) {
        ResponseUtils resp = null;
        try {
            Document doc = Jsoup.parse(book.getDescription());
            //拿到所有img标签
            Elements elements = doc.select("img");
            if (elements.size() == 0) {
                resp = new ResponseUtils("ImageNotFoundError", "图书描述未包含图片封面");
                return resp;
            }
            //拿到第一个img标签的src路径作为封面路径
            String cover = elements.first().attr("src");
            book.setCover(cover);
            book.setEvaluationScore(0d);
            book.setEvaluationQuantity(0);
            bookService.createBook(book);
            resp = new ResponseUtils().put("book", book);
        } catch (Exception e) {
            e.printStackTrace();
            new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }

    /**
     * 文件上传保存
     *
     * @param file
     * @param request
     * @return 返回上传路径和状态码
     * @throws IOException
     */
    @PostMapping("/upload")
    public Map upload(@RequestParam("img") MultipartFile file, HttpServletRequest request) throws IOException {
        //得到上传文件目录
        String uploadPath = request.getServletContext().getResource("/").getPath() + "/upload/";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        /*用格式化得到的时间当文件名*/
        String filename = sdf.format(new Date());
        //获取原文件名
        String originalFilename = file.getOriginalFilename();
        //获取文件后缀名（例如.img）
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //根据传入保存
        file.transferTo(new File(uploadPath + filename + suffix));

        HashMap result = new LinkedHashMap();
        result.put("errno", 0);
        result.put("data", new String[]{"/upload/" + filename + suffix});
        return result;
    }

    /**
     * 更新图书
     *
     * @param book
     * @return
     */
    @PostMapping("/update")
    public ResponseUtils updateBook(Book book) {
        ResponseUtils resp;
        try {
            System.out.println(book.getDescription());
            Document doc = Jsoup.parse(book.getDescription());
            Elements elements = doc.select("img");
            if (elements.size() == 0) {
                resp = new ResponseUtils("ImageNotFoundError", "图书描述未包含封面图片");
                return resp;
            }
            String cover = elements.first().attr("src");
            Book b = bookService.selectById(book.getBookId());
            b.setBookName(book.getBookName());
            b.setSubTitle(book.getSubTitle());
            b.setAuthor(book.getAuthor());
            b.setCategoryId(book.getCategoryId());
            b.setDescription(book.getDescription());
            b.setCover(cover);
            bookService.updateBook(b);
            resp = new ResponseUtils().put("book", b);
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        return resp;
    }

    /**
     * 根据图书id删除图书
     *
     * @param bookId 图书id
     * @return
     */
    @PostMapping("/delete")
    public ResponseUtils deleteBook(Long bookId) {
        ResponseUtils resp = null;
        try {
            bookService.deleteBook(bookId);
            resp = new ResponseUtils();
        } catch (Exception ex) {
            ex.printStackTrace();
            resp = new ResponseUtils(ex.getClass().getSimpleName(), ex.getMessage());
        }
        return resp;
    }
}
