package cn.hx.myjpa.service;

public interface BaseService <T,ID>{
    void save(T t);
    T findById(ID id);
}
