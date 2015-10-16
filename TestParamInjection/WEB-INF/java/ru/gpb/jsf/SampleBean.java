package ru.gpb.jsf;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.Param;

@RequestScoped
@Named("SampleBean")
public class SampleBean {
	@Inject @Param(name = "someId")
	private	String someId = "NOT_SET";
	
	public SampleBean() {
		System.out.println("New instance created");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Bean init");
		someId = "INITED";
	}
	
	public void hello() {
		System.out.println("someId = " + getSomeId() + ", IN REQUEST " + FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("someId"));
	}

	public String getSomeId() {
		return someId;
	}

	public void setSomeId(String someId) {
		this.someId = someId;
	}
}
