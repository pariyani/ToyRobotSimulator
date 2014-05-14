package com.pariyani.faceshelper;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * This is a helper class. It helps the application in getting the translations
 * from the resource bundle.
 * 
 * @author imran
 */
public class FacesUtils {

	public static String	BUNDLE_BASE_NAME	= "msg";

	public static void addMessage(String controlId, javax.faces.application.FacesMessage.Severity sev,
	        String messageKey, Object... args) {
		FacesContext jsf = FacesContext.getCurrentInstance();
		jsf.addMessage(controlId, new FacesMessage(sev, formatMessage(messageKey, args), null));
	}

	public static String formatMessage(String messageKey, Object... args) {
		return MessageFormat.format(getMessage(messageKey), args);
	}

	public static String getMessage(String messageKey) {
		ResourceBundle i18n = getBundle();
		try {
			return i18n.getString(messageKey);
		} catch (java.util.MissingResourceException mre) {
			return "???" + messageKey + "???";
		}
	}

	public static ResourceBundle getBundle() {
		return FacesContext.getCurrentInstance().getApplication()
		        .getResourceBundle(FacesContext.getCurrentInstance(), BUNDLE_BASE_NAME);
	}
}
