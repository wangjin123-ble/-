package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author wangjin
 * @since 2021-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

@ApiModel(value = "Link对象", description = "")
public class Link implements Serializable {

//    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String chang;

    private String duan;

    @TableField(fill = FieldFill.INSERT)
    private Date create_at;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date update_at;

    private String deleted;

//    public Date getCreate_at() {
//        return create_at;
//    }
//
//    public void setCreate_at(Date create_at) {
//        this.create_at = create_at;
//    }
//
//    public Date getUpdate_at() {
//        return update_at;
//    }
//
//    public void setUpdate_at(Date update_at) {
//        this.update_at = update_at;
//    }
//
//    public String getDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(String deleted) {
//        this.deleted = deleted;
//    }
//
////    public static long getSerialVersionUID() {
////        return serialVersionUID;
////    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getChang() {
//        return chang;
//    }
//
//    public void setChang(String chang) {
//        this.chang = chang;
//    }
//
//    public String getDuan() {
//        return duan;
//    }
//
//    public void setDuan(String duan) {
//        this.duan = duan;
//    }

}
