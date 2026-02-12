package com.tap.assessment.Entity;

import java.util.Map;
import java.util.HashMap;

import com.tap.assessment.Repository.SubjectRepository;
import com.tap.assessment.Service.SubjectService;
import com.tap.assessment.Service.SubjectServiceImpl;

public class IOCContainer {
    private static Map<Class<?>,Object> beans = new HashMap<>();
    static{
        beans.put(SubjectService.class,new SubjectServiceImpl());
    }

    public static<T> T getBean(Class<T> clazz){
        return clazz.cast(beans.get(clazz));
    }
}
