package it.gestionelibreriaweb.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.gestionelibreriaweb.model.Libro;

public class UtilityLibroForm {

	public static boolean validateInput(String titoloInputParameter, String genereInputParameter,
			String pagineInputParameter, String dataPubblicazioneInputParameter) {

		if (StringUtils.isBlank(titoloInputParameter) || StringUtils.isBlank(genereInputParameter)
				|| !NumberUtils.isCreatable(pagineInputParameter)
				|| StringUtils.isBlank(dataPubblicazioneInputParameter)) {

			return false;
		}

		if (!validateIntPage(pagineInputParameter)) {
			return false;
		}

		return true;

	}

	public static Libro createBin(String titoloInputParameter, String genereInputParameter, String pagineInputParameter,
			String dataPubblicazioneInputParameter) {

		Libro libroBin = new Libro(titoloInputParameter, genereInputParameter);

		if (validateIntPage(pagineInputParameter)) {
			libroBin.setPagine(Integer.parseInt(pagineInputParameter));
		}

		libroBin.setDataDiPubblicazione(parseDataPubblicazioneFromString(dataPubblicazioneInputParameter));

		return libroBin;

	}

	public static Date parseDataPubblicazioneFromString(String dataPubblicazioneInputParameter) {
		if (StringUtils.isBlank(dataPubblicazioneInputParameter))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataPubblicazioneInputParameter);
		} catch (ParseException e) {
			return null;
		}
	}

	public static boolean validateIntPage(String pagineInputParameter) {

		if (!NumberUtils.isCreatable(pagineInputParameter) || NumberUtils.toInt(pagineInputParameter,-1) == -1) {
			return false;
		}
		if(Integer.parseInt(pagineInputParameter) < 1) {
			return false;
		}
		return true;
	}

}
