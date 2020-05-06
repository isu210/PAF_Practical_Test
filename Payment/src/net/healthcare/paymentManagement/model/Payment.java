package net.healthcare.paymentManagement.model;

public class Payment {
  private int id;
  private String amount;
  private String type; 
  private String patient_name;
    

public Payment(int id, String amount, String type, String patient_name) {
	super();
	this.id = id;
	this.amount = amount;
	this.type = type;
	this.patient_name = patient_name;
	
}


public Payment(String amount, String type, String patient_name) {
	super();
	this.amount = amount;
	this.type = type;
	this.patient_name = patient_name;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getPatient_name() {
	return patient_name;
}
public void setPatient_name(String patient_name) {
	this.patient_name = patient_name;
}
  
} 

