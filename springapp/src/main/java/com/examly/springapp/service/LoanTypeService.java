package com.examly.springapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.LoanType;

@Service
public class LoanTypeService {

    private final List<LoanType> loanTypes = new ArrayList<>();
    private int id = 1;

    public LoanType addLoanType(LoanType loanType) {
        loanType.setLoanTypeId((long) id++);
        loanTypes.add(loanType);
        return loanType;
    }

    public List<LoanType> getAllLoanTypes() {
        return loanTypes;
    }

    public LoanType updateLoanType(int id, LoanType updated) {
        for (LoanType lt : loanTypes) {
            if (lt.getLoanTypeId() == id) {
                lt.setTypeName(updated.getTypeName());
                lt.setDescription(updated.getDescription());
                lt.setInterestRate(updated.getInterestRate());
                return lt;
            }
        }
        return null;
    }
}

