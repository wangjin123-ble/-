package com.example.demo.service;

import com.example.demo.entity.Link;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangjin
 * @since 2021-07-26
 */
public interface ZhuanhuanService  {
     String save(Link link);

    Link restoreUrl(String url);

     String qurry(String url);



}
