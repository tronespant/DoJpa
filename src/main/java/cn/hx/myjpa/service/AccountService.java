package cn.hx.myjpa.service;

import cn.hx.myjpa.pojo.Account;

public interface AccountService {
    void createNewAccount(Account account);
    Account findById(Long id);
}
