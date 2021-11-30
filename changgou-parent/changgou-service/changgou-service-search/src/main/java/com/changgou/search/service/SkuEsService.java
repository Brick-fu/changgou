package com.changgou.search.service;

import java.io.IOException;
import java.util.Map;

public interface SkuEsService {
    /***
     * 导入SKU数据
     */
    void importSku();

    Map<String,Object> search(Map<String,String> condition) throws IOException;
}
