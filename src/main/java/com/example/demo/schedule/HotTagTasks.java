package com.example.demo.schedule;

import com.example.demo.cache.HotTagCache;
import com.example.demo.mapper.QuestionMapper;
import com.example.demo.model.Question;
import com.example.demo.model.QuestionExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author 陈亦铖
 */
@Component
@Slf4j
public class HotTagTasks {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private HotTagCache hotTagCache;
    @Scheduled(cron = "0 0 1 * * *")
    public void hotTagSchedule() {
        int offset = 0;
        int limit = 20;
        log.info("The time is now {}", new Date());
        List<Question> list = new ArrayList<>();
        Map<String, Integer> tagMap =new HashMap<>();
        while (offset == 0 || list.size() == limit) {
            list = questionMapper.selectByExampleWithBLOBsWithRowbounds(new QuestionExample(), new RowBounds(offset, limit));
            for (Question question : list) {

                String[] tags = StringUtils.split(question.getTag(), ",");
                for (String tag : tags) {
                    Integer a = tagMap.get(tag);
                    if (a !=null){
                        tagMap.put(tag,a+5+question.getCommentCount());
                    }else {
                        tagMap.put(tag,5+question.getCommentCount());
                    }
                }
            }
            offset += limit;
        }
        hotTagCache.updateTags(tagMap);
        log.info("The time is now {}", new Date());
    }
}
