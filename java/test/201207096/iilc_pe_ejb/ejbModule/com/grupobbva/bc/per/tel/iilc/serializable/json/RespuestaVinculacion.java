package com.grupobbva.bc.per.tel.iilc.serializable.json;

import java.io.Serializable;

import com.grupobbva.bc.per.tel.iilc.serializable.Multitabla;

public class RespuestaVinculacion implements Serializable {
	protected String datosDetalleFiltros[][];
	protected long pagActual;
	protected long numPags;
	protected long tipoDetalle;
	protected Multitabla cabeceras[];
	protected String datos[][];
}
