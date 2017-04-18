package com.example.admin.callingstuff.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mayur on 18/04/17.
 */

public class MiniStatement {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("transactiondate")
    @Expose
    private String transactiondate;
    @SerializedName("closing_balance")
    @Expose
    private String closingBalance;
    @SerializedName("accountno")
    @Expose
    private String accountno;
    @SerializedName("credit_debit_flag")
    @Expose
    private String creditDebitFlag;
    @SerializedName("transaction_amount")
    @Expose
    private String transactionAmount;
    @SerializedName("remark")
    @Expose
    private String remark;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(String transactiondate) {
        this.transactiondate = transactiondate;
    }

    public String getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(String closingBalance) {
        this.closingBalance = closingBalance;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getCreditDebitFlag() {
        return creditDebitFlag;
    }

    public void setCreditDebitFlag(String creditDebitFlag) {
        this.creditDebitFlag = creditDebitFlag;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
