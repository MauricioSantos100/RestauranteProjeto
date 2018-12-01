package controller.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import model.CardapioModel;
import model.Entidades.Cardapio;

@FacesConverter(forClass = Cardapio.class)
public class ConverterCar implements Converter, Serializable{
	 
	private static final long serialVersionUID = -1672985896661346103L;
	private CardapioModel cm = new CardapioModel();
	
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String value)
				throws ConverterException {
			Cardapio cardapio = null;
			try {
				
				
				//Cardapio Object = new Cardapio();
				cardapio = cm.buscarPorCategoria(value);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return cardapio;
		}
		
		public String getAsString(FacesContext arg0, UIComponent arg1, Object Object)
				throws ConverterException {
			
			Cardapio cardapio = (Cardapio) Object;
			
			return cardapio.getCodCardapio() + "";
			
			/*
			try {
				if (!Object.equals(new Cardapio())) {
					return ((Cardapio) Object).getCodCardapio().toString();
				}
			} catch (ConverterException e) {
				e.printStackTrace();
			}
			return null;*/
		}
}
