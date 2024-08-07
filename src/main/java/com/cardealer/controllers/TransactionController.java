package com.cardealer.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cardealer.models.Transaction;
import com.cardealer.repositories.TransactionRepository;
import com.cardealer.services.TransactionService;

@Controller
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private TransactionService transactionService;
    
    @GetMapping("/transactions")
    public String transactions(Model model){
        List<Transaction> transactions = transactionService.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "transactionreport";
    }

    @GetMapping("/transactions/{id}")
    public String transDetail(@PathVariable Long id, Model model) {
    Transaction transaction = transactionRepository.findById(id).orElse(null);
    model.addAttribute("transaction", transaction);
    return "transactiondetails";
    }
}
