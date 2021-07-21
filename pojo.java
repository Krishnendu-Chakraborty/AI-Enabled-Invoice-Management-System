package com.higradius;
import java.sql.Date;
public class pojo {
   private String cus_name;
   private String cus_no;
   private double invoice_id;
   private double invoice_amt;
   private Date due_date;
   private Date predict_date;
   private String notes;
public String getCus_name() {
	return cus_name;
}
public void setCus_name(String cus_name) {
	this.cus_name = cus_name;
}
public String getCus_no() {
	return cus_no;
}
public void setCus_no(String cus_no) {
	this.cus_no = cus_no;
}
public double getInvoice_id() {
	return invoice_id;
}
public void setInvoice_id(double invoice_id) {
	this.invoice_id = invoice_id;
}
public double getInvoice_amt() {
	return invoice_amt;
}
public void setInvoice_amt(double invoice_amt) {
	this.invoice_amt = invoice_amt;
}
public Date getDue_date() {
	return due_date;
}
public void setDue_date(Date due_date) {
	this.due_date = due_date;
}
public Date getPredict_date() {
	return predict_date;
}
public void setPredict_date(Date predict_date) {
	this.predict_date = predict_date;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}

}
