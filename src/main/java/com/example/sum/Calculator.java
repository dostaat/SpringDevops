package com.example.sum;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
    int sum(int a, int b){
        return a+b;
    }
}