/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs.homework.currencyapi;

import java.io.Serializable;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.DecimalMin;
 

/**
 *
 * @author carolina albuquerque
 */

@ManagedBean(name="converterBean")
@SessionScoped

public class ConverterBean implements Serializable {
    
    private double amount, result;
    private String from, to;
    private ConvertResponse convert;
    private HashMap<String, String> currencies;
    
    
    @PostConstruct
    public void init(){
        convert =  new ConvertResponse();
        currencies = convert.getList();
    }

    @DecimalMin(value="0.0")
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
    

    public HashMap<String, String> getListCurrencies() { 
        return currencies;
    }

    public void setListCurrencies(HashMap<String, String> currencies) {
        this.currencies = currencies;
    }
        
    public String conversion(){
        result = convert.convert(amount, from, to);
        setResult(result);
        return "index.xhtml";
    }
    
    
}
