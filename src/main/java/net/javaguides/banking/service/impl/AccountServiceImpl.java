package net.javaguides.banking.service.impl;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.entity.mapper.AccountMapper;
import net.javaguides.banking.exception.AccountException;
import net.javaguides.banking.repository.AccountRepository;
import net.javaguides.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    // Spring automatically inject the dependency
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto getAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account not found"));
        return AccountMapper.mapToAccountDto(account);
    }
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
    @Override
    public AccountDto deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account not found"));
        accountRepository.delete(account);
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(updatedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account not found"));
        if (account.getBalance() < amount) {
            throw new AccountException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(updatedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(AccountMapper::mapToAccountDto).toList();
    }
}
