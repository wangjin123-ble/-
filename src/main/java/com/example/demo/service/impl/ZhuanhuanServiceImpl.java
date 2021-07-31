package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.bean.util.MD5Util;
import com.example.demo.bean.util.OverduUtil;
import com.example.demo.entity.Link;
import com.example.demo.mapper.ZhuanhuanMapper;
import com.example.demo.service.ZhuanhuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangjin
 * @since 2021-07-26
 */
@Service
public class ZhuanhuanServiceImpl  implements ZhuanhuanService {

    @Autowired
    private ZhuanhuanMapper zhuanhuanMapper;



//    /**
//     * 转化url
//     * 查询数据库是否已经存在 如果存在就返回数据库对应的短链接，如果不存在就查询一条新纪录并返回新的短链接
//     * @param zhuanhuan1
//     * @return
//     */
    @Override
    public String save(Link link) {
        String duan = "http://127.0.0.1/";

        String chang = link.getChang();
        Link link2=new Link();
        link2.setChang(chang);

        QueryWrapper<Link> wrapper = new QueryWrapper<>();
        wrapper.eq("chang",link2.getChang());
        Link link1 =  zhuanhuanMapper.selectOne(wrapper);
        if(link1 == null) {
            duan+= this.gererateShortUrl(chang);
            link.setDuan(duan);
            zhuanhuanMapper.insert(link);
            OverduUtil overduUtil = new OverduUtil(zhuanhuanMapper);
            overduUtil.clearKeyTask(link.getId());
            StopWatch stopWatch =new StopWatch();
            System.out.println(stopWatch.elapseTime());
            System.out.println(link);
        }else{
            duan = link1.getDuan();
            System.out.println(link1);
        }
        return duan;

    }






    @Override
    public Link restoreUrl(String url) {
        Link link=new Link();
        link.setDuan(url);
        QueryWrapper<Link> wrapper = new QueryWrapper<>();
        wrapper.eq("chang",link.getDuan());
        Link link1 =  zhuanhuanMapper.selectOne(wrapper);
        return link1;
    }

    @Override
    public String qurry(String url) {
        return null;
    }

//    @Override
//    public String qurry(String url) {
//        Link link=new Link();
//        link.setChang("https://blog.csdn.net/denghan9435/article/details/102398880");
//        Link result =
//
//    }


    /**
     * @param args
     */
//    public static void main(String[] args) {
//
//        String sLongUrl = "http://474515923.qzone.qq.com" ; //长链接
//        LinkServiceImpl link = new LinkServiceImpl();
//        String result = link.gererateShortUrl(sLongUrl);
//        // 打印出结果
//        System.out.println("短链接为： "+ result);
//    }

    /**
     * 将长链接转换为短链接
     * @param url
     * @return
     */
    public String gererateShortUrl(String url) {
        // 可以自定义生成 MD5 加密字符传前的混合 KEY
        String key = "caron" ;
        // 要使用生成 URL 的字符
        String[] chars = new String[] { "a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" ,
                "i" , "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" ,
                "u" , "v" , "w" , "x" , "y" , "z" , "0" , "1" , "2" , "3" , "4" , "5" ,
                "6" , "7" , "8" , "9" , "A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" ,
                "I" , "J" , "K" , "L" , "M" , "N" , "O" , "P" , "Q" , "R" , "S" , "T" ,
                "U" , "V" , "W" , "X" , "Y" , "Z"

        };
        // 对传入网址进行 MD5 加密
        String sMD5EncryptResult = MD5Util.MD5(key+url);
        String hex = sMD5EncryptResult;

//        String[] resUrl = new String[4];
//        for ( int i = 0; i < 4; i++) {

        // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
        String sTempSubString = hex.substring(2 * 8, 2 * 8 + 8);    //固定取第三组

        // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用 long ，则会越界
        long lHexLong = 0x3FFFFFFF & Long.parseLong (sTempSubString, 16);
        String outChars = "" ;
        for ( int j = 0; j < 6; j++) {
            // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
            long index = 0x0000003D & lHexLong;
            // 把取得的字符相加
            outChars += chars[( int ) index];
            // 每次循环按位右移 5 位
            lHexLong = lHexLong >> 5;
        }
        // 把字符串存入对应索引的输出数组
//            resUrl[i] = outChars;
//        }
        return outChars;
    }



}



