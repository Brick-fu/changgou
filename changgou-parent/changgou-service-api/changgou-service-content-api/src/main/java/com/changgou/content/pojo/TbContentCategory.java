package com.changgou.content.pojo;

import java.io.Serializable;

/**
 * 内容分类(TbContentCategory)实体类
 *
 * @author makejava
 * @since 2021-08-22 11:24:39
 */
public class TbContentCategory implements Serializable {
    private static final long serialVersionUID = 480252297027414673L;
    /**
    * 类目ID
    */
    private Long id;
    /**
    * 分类名称
    */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TbContentCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
