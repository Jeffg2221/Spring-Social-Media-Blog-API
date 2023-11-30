package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Optional<Account> findById(Integer accountId){
        return accountRepository.findById(accountId);
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public Optional<Account> findByUsername(String username){
        return accountRepository.findByUsername(username);
    }

    public Account save(Account account){
        // Additional logic/validation before saving
        validateAccountForRegistration(account);

        // Check if an account with the same username already exists
        if (accountRepository.findByUsername(account.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }

        // Save the new account to the database
        return accountRepository.save(account);
    }

    public Account login(String username, String password) {
        // Find the account by username
        Optional<Account> optionalAccount = accountRepository.findByUsername(username);

        // Check if the account exists and the provided password is correct
        if (optionalAccount.isPresent() && optionalAccount.get().getPassword().equals(password)) {
            return optionalAccount.get();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }
    }

    private void validateAccountForRegistration(Account account) {
        // Check if the username is not blank
        if (account.getUsername() == null || account.getUsername().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username cannot be blank");
        }

        // Check if the password is at least 4 characters long
        if (account.getPassword() == null || account.getPassword().length() < 4) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password must be at least 4 characters long");
        }
    }

    public void deleteById(Integer accountId){
        accountRepository.deleteById(accountId);
    }
}
