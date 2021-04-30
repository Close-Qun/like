package com.example.demo.service;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.dto.PaginationDTO;
import com.example.demo.dto.QuestionDTO;
import com.example.demo.mapper.NotificationMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 陈亦铖
 */
@Service
public class NotificationService {
    @Autowired
    private NotificationMapper notificationMapper;
    @Autowired
    private UserMapper userMapper;
    public PaginationDTO List(Integer page, Integer size, Long userId) {
        PaginationDTO<NotificationDTO> paginationDTO=new PaginationDTO<>();
        Integer totalPage;
        NotificationExample example = new NotificationExample();
        example.createCriteria()
                .andReceiverEqualTo(userId);
        Integer totalCount=(int)notificationMapper.countByExample(example);

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        paginationDTO.setPagination(totalPage,page);
        Integer offset=size*(page-1);

        NotificationExample example1 = new NotificationExample();
        example1.createCriteria()
                .andReceiverEqualTo(userId);
        List<Notification> notifications= notificationMapper.selectByExampleWithRowbounds(example1,new RowBounds(offset,size));
        if (notifications.size() !=0){
            return paginationDTO;
        }
        Set<Long> disUserId = notifications.stream().map(notification -> notification.getNotifier()).collect(Collectors.toSet());
        List<Long> userIds = new ArrayList<>(disUserId);
        UserExample example2 = new UserExample();
        example2.createCriteria()
                .andIdIn(userIds);
        List<User> users = userMapper.selectByExample(example2);
        Map<Long, User> user = users.stream().collect(Collectors.toMap(u -> u.getId(), u -> u));

        List<NotificationDTO> notificationDTOS = notifications.stream().map(notification -> {
            NotificationDTO notificationDTO = new NotificationDTO();
            BeanUtils.copyProperties(notification, notificationDTO);
            notificationDTO.setNotifier(user.get(notification.getId()));
            return notificationDTO;
        }).collect(Collectors.toList());
        paginationDTO.setQuestion(notificationDTOS);


        return  paginationDTO;
    }
}
