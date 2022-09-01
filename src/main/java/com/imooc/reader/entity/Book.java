package com.imooc.reader.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName book
 */
@TableName(value ="book")
@Data
public class Book implements Serializable {
    /**
     * 图书编号
     */
    @TableId(value = "book_id", type = IdType.AUTO)
    private Long bookId;

    /**
     * 书名
     */
    @TableField(value = "book_name")
    private String bookName;

    /**
     * 子标题
     */
    @TableField(value = "sub_title")
    private String subTitle;

    /**
     * 作者
     */
    @TableField(value = "author")
    private String author;

    /**
     * 封面图片URL
     */
    @TableField(value = "cover")
    private String cover;

    /**
     * 图书详情
     */
    @TableField(value = "description")
    private String description;

    /**
     * 分类编号
     */
    @TableField(value = "category_id")
    private Long categoryId;

    /**
     * 图书评分
     */
    @TableField(value = "evaluation_score")
    private Double evaluationScore;

    /**
     * 评价数量
     */
    @TableField(value = "evaluation_quantity")
    private Integer evaluationQuantity;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Book other = (Book) that;
        return (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getBookName() == null ? other.getBookName() == null : this.getBookName().equals(other.getBookName()))
            && (this.getSubTitle() == null ? other.getSubTitle() == null : this.getSubTitle().equals(other.getSubTitle()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getCover() == null ? other.getCover() == null : this.getCover().equals(other.getCover()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getEvaluationScore() == null ? other.getEvaluationScore() == null : this.getEvaluationScore().equals(other.getEvaluationScore()))
            && (this.getEvaluationQuantity() == null ? other.getEvaluationQuantity() == null : this.getEvaluationQuantity().equals(other.getEvaluationQuantity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getBookName() == null) ? 0 : getBookName().hashCode());
        result = prime * result + ((getSubTitle() == null) ? 0 : getSubTitle().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getCover() == null) ? 0 : getCover().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getEvaluationScore() == null) ? 0 : getEvaluationScore().hashCode());
        result = prime * result + ((getEvaluationQuantity() == null) ? 0 : getEvaluationQuantity().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bookId=").append(bookId);
        sb.append(", bookName=").append(bookName);
        sb.append(", subTitle=").append(subTitle);
        sb.append(", author=").append(author);
        sb.append(", cover=").append(cover);
        sb.append(", description=").append(description);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", evaluationScore=").append(evaluationScore);
        sb.append(", evaluationQuantity=").append(evaluationQuantity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}