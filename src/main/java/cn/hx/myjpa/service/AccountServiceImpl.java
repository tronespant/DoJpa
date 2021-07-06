package cn.hx.myjpa.service;

import cn.hx.myjpa.pojo.Account;
import cn.hx.myjpa.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_UNCOMMITTED,readOnly = false)
    public void createNewAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account findById(Long id) {
        Account result = accountRepository.findById(id).get();
        return result;
    }
}
