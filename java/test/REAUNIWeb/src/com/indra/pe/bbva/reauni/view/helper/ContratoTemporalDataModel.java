package com.indra.pe.bbva.reauni.view.helper;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.indra.pe.bbva.reauni.model.entidad.ContratoTemporalDto;

public class ContratoTemporalDataModel extends ListDataModel<ContratoTemporalDto> implements SelectableDataModel<ContratoTemporalDto> {

	public ContratoTemporalDataModel(List<ContratoTemporalDto> data) {  
        super(data);  
    }  
	
	@Override
	public ContratoTemporalDto getRowData(String arg0) {
		@SuppressWarnings("unchecked")
		List<ContratoTemporalDto> lista = (List<ContratoTemporalDto>) getWrappedData();  
        
        for(ContratoTemporalDto dto : lista) {  
            if(dto.getCodigoContrato().equals(arg0))  
                return dto;  
        }  
          
        return null;  
	}

	@Override
	public Object getRowKey(ContratoTemporalDto arg0) {
		if(arg0 != null) {
			return arg0.getCodigoContrato();
		} else {
			return "";
		}
		
	}

}
