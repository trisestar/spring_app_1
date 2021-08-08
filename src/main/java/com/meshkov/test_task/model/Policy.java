package com.meshkov.test_task.model;

import java.util.Objects;

public class Policy {
    int id;
    String clientName;
    String startDate;
    String expirationDate;
    String policyType;

    public Policy() {
    }

    public Policy(String clientName, String startDate, String expirationDate, String policyType) {
        this.clientName = clientName;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
        this.policyType = policyType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return id == policy.id && Objects.equals(clientName, policy.clientName) && Objects.equals(startDate, policy.startDate) && Objects.equals(expirationDate, policy.expirationDate) && Objects.equals(policyType, policy.policyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientName, startDate, expirationDate, policyType);
    }
}
