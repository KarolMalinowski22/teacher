package com.kavlord.teacher.service.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PageUtils {
    public static <T> Page<T> getPageSorted(Pageable pageable, List<T> all, Comparator<T> comparator){
        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        int startIndex = pageSize * pageNumber;
        int allLessonsSize = all.size();
        List<T> lessonList = startIndex < allLessonsSize ?
                all.subList(startIndex, Math.min(startIndex + pageSize, allLessonsSize)).stream().sorted(comparator).collect(Collectors.toList()) :
                Collections.EMPTY_LIST;
        Page<T> page = new PageImpl<>(lessonList, pageable, allLessonsSize);
        return page;
    }
}
