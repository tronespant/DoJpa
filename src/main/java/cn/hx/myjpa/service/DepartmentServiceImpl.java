package cn.hx.myjpa.service;

import cn.hx.myjpa.pojo.DepartMent;
import cn.hx.myjpa.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{

    @Resource
    DepartmentRepository departmentRepository;
    @Override
    public void save(DepartMent departMent) {
        departmentRepository.save(departMent);
        log.debug("部门存储成功！"+departMent.toString());
    }

    @Override
    public DepartMent findById(Long aLong) {
       return departmentRepository.getById(aLong);
    }
}
