package com.gabrielamorim.drools;

import java.util.Date;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.gabrielamorim.drools.model.Ligacao;
import com.gabrielamorim.drools.model.Usuario;

public class TarifacaoRules {

	public static final void main(String[] args) {
		TarifacaoRules tarifacao = new TarifacaoRules();

		Usuario joao = new Usuario("Joao", "TIM", "Infinity FALE MAIS");
		Usuario maria = new Usuario("Maria", "TIM", "Infinity FALE MAIS");

		// criar um hist�rico de 40 min de liga��es joao -> maria
		joao.getLigacoes().add(new Ligacao(joao, maria, new Date(), 40));

		// inst�ncia a ligacao corrente
		Ligacao ligacao = new Ligacao(joao, maria, new Date(), 45);

		tarifacao.tarifarLigacao(ligacao);
	}

	public void tarifarLigacao(Ligacao ligacao) {
		try {
			// carrega a knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");

			// aplica as regras
			kSession.insert(ligacao);
			kSession.fireAllRules();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}