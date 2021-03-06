package com.meritamerica.teamnine.bankapp.models;

import java.time.LocalDate;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "AccountHolder")
public class AccountHolder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accountHolder_id")
	Integer id;

	@NotNull(message = "First Name can not be null")
	@NotBlank(message = "First Name can not be blank")
	String firstName;

	String middleName;
	
	@NotNull(message = "Last Name can not be null")
	@NotBlank(message = "Last Name can not be blank")
	String lastName;
	
	@NotNull(message = "SSN can not be null")
	@NotBlank(message = "SSN can not be blank")
	String SSN;
	
	LocalDate birthDate;
	
	@OneToOne(cascade = CascadeType.REMOVE, mappedBy = "accountHolder", fetch = FetchType.LAZY)
	private RolloverIRA rollOverIRA;
	
	@OneToOne(cascade = CascadeType.REMOVE, mappedBy = "accountHolder", fetch = FetchType.LAZY)
	private RothIRA rothIRA;
	
	@OneToOne(cascade = CascadeType.REMOVE, mappedBy = "accountHolder", fetch = FetchType.LAZY)
	private IRA ira;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "accountHolder", fetch = FetchType.LAZY)
	private List<DBAChecking> dbaCheckings;

	@OneToOne(cascade = CascadeType.REMOVE, mappedBy = "accountHolder", fetch = FetchType.LAZY)
	private CheckingAccount checkingAccounts;

	@OneToOne(cascade = CascadeType.REMOVE, mappedBy = "accountHolder", fetch = FetchType.LAZY)
	private SavingsAccount savingsAccounts;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "accountHolder", fetch = FetchType.LAZY)
	private List<CDAccount> cDAccounts;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_holders_contact_details_id", referencedColumnName = "account_holders_contact_details_id") 
	AccountHoldersContactDetails accountHoldersContactDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "users_id") 
	private User user;
	
	public AccountHolder() {
	}

	public AccountHoldersContactDetails getAccountHoldersContactDetails() {
		return accountHoldersContactDetails;
	}

	public void setAccountHoldersContactDetails(AccountHoldersContactDetails accountHoldersContactDetails) {
		this.accountHoldersContactDetails = accountHoldersContactDetails;
	}

	@JsonManagedReference(value="users")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {	
		this.user = user;
	}

	@JsonManagedReference(value="accountHolder")
	public CheckingAccount getCheckingAccounts() {
		return checkingAccounts;
	}

	@JsonManagedReference(value="accountHolder")
	public RolloverIRA getRollOverIRA() {
		return rollOverIRA;
	}
	
	public void setRollOverIRA(RolloverIRA rollOverIRA) {
		this.rollOverIRA = rollOverIRA;
	}
	
	@JsonManagedReference(value="accountHolder")
	public RothIRA getRothIRA() {
		return rothIRA;
	}

	@JsonManagedReference(value="accountHolder")
	public IRA getIra() {
		return ira;
	}

	@JsonManagedReference(value="accountHolder")
	public List<DBAChecking> getDbaCheckings() {
		return dbaCheckings;
	}

	public void setIra(IRA ira) {
		this.ira = ira;
	}

	public void setDbaCheckings(List<DBAChecking> dbaCheckings) {
		this.dbaCheckings = dbaCheckings;
	}

	public void setRothIRA(RothIRA rothIRA) {
		this.rothIRA = rothIRA;
	}

	public void setCheckingAccounts(CheckingAccount checkingAccounts) {
		this.checkingAccounts = checkingAccounts;
	}

	@JsonManagedReference(value="accountHolder")
	public SavingsAccount getSavingsAccounts() {
		return savingsAccounts;
	}
	public void setSavingsAccounts(SavingsAccount savingsAccounts) {
		this.savingsAccounts = savingsAccounts;
	}
	@JsonManagedReference(value="accountHolder")
	public List<CDAccount> getcDAccounts() {
		return cDAccounts;
	}
	public void setcDAccounts(List<CDAccount> cDAccounts) {
		this.cDAccounts = new ArrayList<CDAccount>(cDAccounts);
	}
	public Integer getId() {
		return id;
	}
	public AccountHolder setId(Integer id) {
		this.id = id;
		return this;
	}
	public String getFirstName() {
		return firstName;
	}
	public AccountHolder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public String getMiddleName() {
		return middleName;
	}
	public AccountHolder setMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}
	public String getLastName() {
		return lastName;
	}
	public AccountHolder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public String getSSN() {
		return SSN;
	}
	public AccountHolder setSSN(String sSN) {
		SSN = sSN;
		return this;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public double getCheckingBalance() {
		double totalBalance = 0;
		if (checkingAccounts != null) {

				totalBalance = totalBalance + checkingAccounts.getBalance();

			return totalBalance;
		}
		return 0;
	}

	public double getSavingsBalance() {
		double totalBalance = 0;
		if (savingsAccounts != null) {
			
				totalBalance = totalBalance + savingsAccounts.getBalance();
			
		}
		return totalBalance;
	}
	public int getNumberOfCDAccounts() {
		if (cDAccounts != null) {
			return cDAccounts.size();
		}
		return 0;
	}
	public double getCdbalance() {
		double totalBalance = 0;
		if (cDAccounts != null) {
			for (BankAccount cda : cDAccounts) {
				totalBalance = totalBalance + cda.getBalance();
			}
		}
		return totalBalance;
	}
	public double getCombinedBalance() {
		return getCheckingBalance() + getSavingsBalance() + getCdbalance();
	}
	
	public List<BankAccount> getAllAccounts(){
		List<BankAccount> allAccount = new ArrayList<BankAccount>();
		if(getCheckingAccounts() != null)
			allAccount.add(getCheckingAccounts());
		if(getSavingsAccounts() != null)
			allAccount.add(getSavingsAccounts());
		if(getIra() != null)
			allAccount.add(getIra());
		if(getRothIRA() != null)
			allAccount.add(getRothIRA());
		if(getRollOverIRA() != null)
			allAccount.add(getRollOverIRA());

		for(BankAccount ba : getcDAccounts())
			allAccount.add(ba);
		for(BankAccount ba : getDbaCheckings())
			allAccount.add(ba);
		return allAccount;
	}
}