package cn.hx.myjpa.service;

import cn.hx.myjpa.pojo.Tag;
import cn.hx.myjpa.repository.TagRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class TagServiceImpl implements TagService{
    @Resource
    TagRepository tagRepository;
    @Override
    public void save(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public Tag findById(Long aLong) {
        return tagRepository.findById(aLong).get();
    }
}
