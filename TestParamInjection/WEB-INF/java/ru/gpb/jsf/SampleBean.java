package ru.gpb.jsf;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

@RequestScoped
@Named("SampleBean")
public class SampleBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//@Inject
	//@Param
	private	String someId = "NOT_SET";
	
	public SampleBean() {
		System.out.println("New instance created");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Bean init");
		// someId = "INITED";
	}
	
	public void hello() {
		System.out.println("someId = " + getSomeId() + ", IN REQUEST " + FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("someId"));
	}

	public String getSomeId() {
		return someId;
	}

	public void setSomeId(String someId) {
		System.out.println("Set someId = " + someId);
		this.someId = someId;
	}
	
	public void viewAction() {
		System.out.println("View action!");
	}
}
