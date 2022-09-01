package com.imooc.reader.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName evaluation
 */
@TableName(value ="evaluation")
@Data
public class Evaluation implements Serializable {
    /**
     * 评价编号
     */
    @TableId(value = "evaluation_id", type = IdType.AUTO)
    private Long evaluationId;

    /**
     * 短评内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 评分-5分制
     */
    @TableField(value = "score")
    private Integer score;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 会员编号
     */
    @TableField(value = "member_id")
    private Long memberId;

    /**
     * 图书编号
     */
    @TableField(value = "book_id")
    private Long bookId;

    /**
     * 点赞数量
     */
    @TableField(value = "enjoy")
    private Integer enjoy;

    /**
     * 审核状态 enable-有效 disable-已禁用
     */
    @TableField(value = "state")
    private String state;

    /**
     * 禁用理由
     */
    @TableField(value = "disable_reason")
    private String disableReason;

    /**
     * 禁用时间
     */
    @TableField(value = "disable_time")
    private LocalDateTime disableTime;

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
        Evaluation other = (Evaluation) that;
        return (this.getEvaluationId() == null ? other.getEvaluationId() == null : this.getEvaluationId().equals(other.getEvaluationId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getEnjoy() == null ? other.getEnjoy() == null : this.getEnjoy().equals(other.getEnjoy()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getDisableReason() == null ? other.getDisableReason() == null : this.getDisableReason().equals(other.getDisableReason()))
            && (this.getDisableTime() == null ? other.getDisableTime() == null : this.getDisableTime().equals(other.getDisableTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEvaluationId() == null) ? 0 : getEvaluationId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getEnjoy() == null) ? 0 : getEnjoy().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getDisableReason() == null) ? 0 : getDisableReason().hashCode());
        result = prime * result + ((getDisableTime() == null) ? 0 : getDisableTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", evaluationId=").append(evaluationId);
        sb.append(", content=").append(content);
        sb.append(", score=").append(score);
        sb.append(", createTime=").append(createTime);
        sb.append(", memberId=").append(memberId);
        sb.append(", bookId=").append(bookId);
        sb.append(", enjoy=").append(enjoy);
        sb.append(", state=").append(state);
        sb.append(", disableReason=").append(disableReason);
        sb.append(", disableTime=").append(disableTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}