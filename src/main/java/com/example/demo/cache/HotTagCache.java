package com.example.demo.cache;

import com.example.demo.dto.HotTagDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author 陈亦铖
 */
@Component
@Data
public class HotTagCache {
    private List<String> hots=new ArrayList<>();
    public void updateTags(Map<String,Integer> tags){
        int max=3;
        PriorityQueue<HotTagDTO> priorityQueue=new PriorityQueue<>(max);

        tags.forEach((name,priority)->{
            HotTagDTO hotTagDTO=new HotTagDTO();
            hotTagDTO.setName(name);
            hotTagDTO.setPriority(priority);
            if (priorityQueue.size()<max){
                priorityQueue.add(hotTagDTO);
            }else {
                HotTagDTO minHot = priorityQueue.peek();
                if (hotTagDTO.compareTo(minHot)>0){
                    priorityQueue.poll();
                    priorityQueue.add(hotTagDTO);
                }
            }
        });
        HotTagDTO poll=priorityQueue.poll();


        while (poll!=null){
            poll=priorityQueue.poll();
            hots.add(0,poll.getName());

        }

    }


}
