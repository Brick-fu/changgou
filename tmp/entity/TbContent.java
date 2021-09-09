package entity;

import java.io.Serializable;

/**
 * (TbContent)实体类
 *
 * @author makejava
 * @since 2021-08-22 11:23:53
 */
public class TbContent implements Serializable {
    private static final long serialVersionUID = -32753879124860842L;
    
    private Long id;
    /**
    * 内容类目ID
    */
    private Long categoryId;
    /**
    * 内容标题
    */
    private String title;
    /**
    * 链接
    */
    private String url;
    /**
    * 图片绝对路径
    */
    private String pic;
    /**
    * 状态,0无效，1有效
    */
    private String status;
    /**
    * 排序
    */
    private Integer sortOrder;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

}
