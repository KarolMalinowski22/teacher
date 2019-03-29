package com.kavlord.teacher.service.defaultImplementation;

import com.kavlord.teacher.model.Dancer;
import com.kavlord.teacher.model.Group;
import com.kavlord.teacher.model.dto.PersonDto;
import com.kavlord.teacher.repository.DancerRepository;
import com.kavlord.teacher.service.DancerService;
import com.kavlord.teacher.service.GroupService;
import com.kavlord.teacher.service.utils.PersonMap;
import com.kavlord.teacher.service.utils.DtoExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

@Service
public class DancerServiceImpl implements DancerService {
    @Autowired
    DancerRepository dancerRepository;
    @Autowired
    GroupService groupService;

    @Override
    public List<Dancer> findAll() {
        return dancerRepository.findAll();
    }

    @Override
    public List<Dancer> findByGroup(Group group) {
        return dancerRepository.findAllByGroupsContains(group);
    }

    @Override
    public List<Dancer> findAllActive() {
        throw new NotImplementedException();
    }

    @Override
    public Dancer update(Dancer dancer) {
        return dancerRepository.save(dancer);
    }

    @Override
    public Optional<Dancer> findById(Long id) {
        return id == null ? Optional.empty() : dancerRepository.findById(id);
    }

    @Override
    public void save(PersonDto personDto) {
        String groupsIdsString = personDto.getGroupsDto();

        List<Group> groups = PersonMap.fromIds(groupsIdsString, groupService);
        Dancer dancer = DtoExtractor.getDancer(personDto, groups);

        findById(personDto.getId())
                .ifPresent(e -> {
            dancer.setPresence(e.getPresence());
            dancer.setUser(e.getUser());
        });

        dancerRepository.save(dancer);
    }

    @Override
    public void delete(Long id) {
        dancerRepository.deleteById(id);
    }
}
