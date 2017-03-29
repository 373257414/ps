package com.ycw.photosystem.service;

import com.ycw.photosystem.bean.mysql.Event;
import com.ycw.photosystem.dao.mysql.EventDAO;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogService {

    @Autowired
    private EventDAO eventDAO;

    public void save(Event event) {
        eventDAO.save(event);
    }

}
