package com.example.demo.bean.util;

import com.example.demo.entity.Link;
import com.example.demo.mapper.ZhuanhuanMapper;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class OverduUtil {

    private final ZhuanhuanMapper zhuanhuanMapper;

    public OverduUtil(ZhuanhuanMapper zhuanhuanMapper) {
        this.zhuanhuanMapper = zhuanhuanMapper;
    }

    public void clearKeyTask(String id) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Link link = zhuanhuanMapper.selectById(id);
                link.setId(null);
                zhuanhuanMapper.updateById(link);
            }
        };
        timer.schedule(timerTask,1*1000*60);

    }

}
