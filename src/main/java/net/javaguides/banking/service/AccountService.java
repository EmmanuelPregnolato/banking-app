package net.javaguides.banking.service;

import net.javaguides.banking.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto getAccount(Long id);
    AccountDto createAccount(AccountDto accountDto);
    AccountDto deleteAccount(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id, double amount);
    List<AccountDto> getAllAccounts();
}
