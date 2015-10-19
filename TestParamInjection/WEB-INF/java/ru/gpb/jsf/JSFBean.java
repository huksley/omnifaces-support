package ru.gpb.jsf;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@ApplicationScoped
@Named("jsf")
public class JSFBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public String getParam(String name) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
	}
	
	@Produces @MyParam
	public String injectParam(InjectionPoint p) {
		MyParam a = p.getAnnotated().getAnnotation(MyParam.class);
		String n = a.value() == null || a.value().equals("") ? p.getMember().getName() : a.value();
		System.out.println("Injecting " + n + " = " + getParam(n));
		return getParam(n);
	}
}
