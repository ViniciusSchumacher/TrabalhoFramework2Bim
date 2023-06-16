package br.com.unipar.frameworks.model.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PetDoguiLog {
    
	private static final String GERAL = "br.com.unipar.frameworks";	
	private static final String PERSISTENCIA = "br.com.unipar.frameworks.model.dao";

	private static Logger logGERAL = LogManager.getLogger(GERAL);
	private static Logger logPERSISTENCIA = LogManager.getLogger(PERSISTENCIA);

	public static void infoGeral(String msg){
            logGERAL.info("========= INICIO DA MENSAGEM INFO DE GERAL =========");
            logGERAL.info("--Mensagem: " + msg);		
            logGERAL.info("========= FIM DA MENSAGEM INFO DE GERAL =========");
	}


	public static void erroGeral(Exception ex){
		logGERAL.info("========= INICIO DO ERRO DE GERAL =========");
		logGERAL.error(ex.getMessage());
		for(StackTraceElement el : ex.getStackTrace())
			logGERAL.error(el.toString());
		logGERAL.info("========= FIM DO ERRO DE GERAL =========");
	}
 
        
        public static void infoPersistencia(String msg){
		logPERSISTENCIA.info("========= INICIO DA MENSAGEM INFO DE PERSISTENCIA =========");
		logPERSISTENCIA.info("--Mensagem: " + msg);		
		logPERSISTENCIA.info("========= FIM DA MENSAGEM INFO DE PERSISTENCIA =========");
	}


	public static void erroPersistencia(Exception ex){
		logPERSISTENCIA.info("========= INICIO DO ERRO DE PERSISTENCIA =========");
		logPERSISTENCIA.error("--Mensagem:--"+ex.getMessage());
		for(StackTraceElement el : ex.getStackTrace())
			logPERSISTENCIA.error(el.toString());
		logPERSISTENCIA.info("========= FIM DO ERRO DE PERSISTENCIA =========");
	}
}
