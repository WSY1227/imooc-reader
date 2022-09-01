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
 * @TableName member_read_state
 */
@TableName(value ="member_read_state")
@Data
public class MemberReadState implements Serializable {
    /**
     * 会员阅读状态
     */
    @TableId(value = "rs_id", type = IdType.AUTO)
    private Long rsId;

    /**
     * 图书编号
     */
    @TableField(value = "book_id")
    private Long bookId;

    /**
     * 会员编号
     */
    @TableField(value = "member_id")
    private Long memberId;

    /**
     * 阅读状态 1-想看 2-看过
     */
    @TableField(value = "read_state")
    private Integer readState;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

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
        MemberReadState other = (MemberReadState) that;
        return (this.getRsId() == null ? other.getRsId() == null : this.getRsId().equals(other.getRsId()))
            && (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getReadState() == null ? other.getReadState() == null : this.getReadState().equals(other.getReadState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRsId() == null) ? 0 : getRsId().hashCode());
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getReadState() == null) ? 0 : getReadState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rsId=").append(rsId);
        sb.append(", bookId=").append(bookId);
        sb.append(", memberId=").append(memberId);
        sb.append(", readState=").append(readState);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}