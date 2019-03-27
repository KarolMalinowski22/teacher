package com.kavlord.teacher.service.utils;

import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.service.GroupService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DancerMap {
    public static List<Group> fromIds(String ids, GroupService groupService){
        List<Group> groups = new ArrayList<>();
        if(!"".equals(ids)) {
            groups = Arrays.stream(ids.split(","))
                    .map(_string -> Long.valueOf(_string))
                    .map(_long -> groupService.findById(_long))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        }
        return groups;
    }
}
