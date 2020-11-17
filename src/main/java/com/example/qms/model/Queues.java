package com.example.qms.model;

import com.example.qms.utility.DatePrefixedSequenceIdGenerator;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name="queues", catalog="QManagementSystem", schema="dbo")
@Table(name = "queues")
public class Queues {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "queue_generator")
    @SequenceGenerator(name = "queue_generator", sequenceName = "queue_seq", allocationSize = 50)
    private Long id;
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_generator")
//    @GenericGenerator(
//            name = "token_generator",
//            strategy = "com.example.qms.utility.DatePrefixedSequenceIdGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = DatePrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
//                    @org.hibernate.annotations.Parameter(name = DatePrefixedSequenceIdGenerator.DATE_NUMBER_SEPARATOR_PARAMETER, value = "."),
//                    @org.hibernate.annotations.Parameter(name = DatePrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})

    //    @GenericGenerator(name = "token_generator", strategy = "com.example.qms.utility.SequenceControlNumber")
//    @GeneratedValue(generator = "token_generator")
//    @Column(name = "token_no", unique = false, nullable = false)
//    @Column(name = "token_no", columnDefinition = "bigint not null constraint DF_mytblid default next value for token_generator")
//    @Generated(GenerationTime.INSERT)
    private String tokenNo;
    @Column(name = "counter_no")
    private String counterNo;
    @Column(name = "status")
    private char status;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "description")
    private String description;
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "category")
    private Integer category;
    @Column(name = "teller_id")
    private Integer tellerId;
    @Column(name = "token_start_time")
    private Date tokenStartTime;
    @Column(name = "token_end_time")
    private Date tokenEndTime;
    @Column(name = "branch_id")
    private String branchId;
    @Column(name = "company_id")
    private String companyId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTokenNo() {
        return tokenNo;
    }

    public void setTokenNo(String tokenNo) {
        this.tokenNo = tokenNo;
    }

    public String getCounterNo() {
        return counterNo;
    }

    public void setCounterNo(String counterNo) {
        this.counterNo = counterNo;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getTellerId() {
        return tellerId;
    }

    public void setTellerId(Integer tellerId) {
        this.tellerId = tellerId;
    }

    public Date getTokenStartTime() {
        return tokenStartTime;
    }

    public void setTokenStartTime(Date tokenStartTime) {
        this.tokenStartTime = tokenStartTime;
    }

    public Date getTokenEndTime() {
        return tokenEndTime;
    }

    public void setTokenEndTime(Date tokenEndTime) {
        this.tokenEndTime = tokenEndTime;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
