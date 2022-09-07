package com.sbk.MicroserviceBasedApplication.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Entity Annotation Represents that the class is an Entity
@Entity
//Table Annotation is used to map the entity in the SQL Table
@Table(name="ToDoExpense")
public class ToDoExpense {
    //Its is used to specify the primary key of the entity
	@Id
	//it specifies the generation strategies for value of primary keys
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    @Column(name="name", nullable=false)
	private String name;
    @Column(name="costs", nullable=false)
	private Integer costs;
    @Column(name="dates", nullable=false)
    private String date;
    @Column(name="colors", nullable=false)
    private String color;
    @Column(name="urls", nullable=false)
    private String url;
    @Column(name="remarks", nullable=false)
    private String remarks;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getCosts() {
        return costs;
    }
    public void setCosts(Integer costs) {
        this.costs = costs;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public ToDoExpense() {

    }
    public ToDoExpense(String name, Integer costs, String date, String color, String url, String remarks) {
        this.name = name;
        this.costs = costs;
        this.date = date;
        this.color = color;
        this.url = url;
        this.remarks = remarks;
    }
    @Override
	public String toString() {
		return "Id: "+id+" Name: "+name+" Costs: "+costs+" Date: "+date+" Color: "+color+" URL: "+url+" Remarks: "+remarks+"\n";
	}
}
