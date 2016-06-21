package com.gabrielamorim.drools;

import java.util.Date;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.gabrielamorim.drools.model.Ligacao;
import com.gabrielamorim.drools.model.Usuario;

public class TarifacaoTableXLS {

	public static final void main(String[] args) {
		TarifacaoTableXLS droolsCom = new TarifacaoTableXLS();

		Usuario joao = new Usuario("Joao", "TIM", "Infinity FALE MAIS");
		Usuario maria = new Usuario("Maria", "TIM", "Infinity FALE MAIS");

		// colocar uma liga��o no hist�rico do Jo�o
		joao.getLigacoes().add(new Ligacao(joao, maria, new Date(), 40));

		// inst�ncia a liga��o corrente
		Ligacao ligacao = new Ligacao(joao, maria, new Date(), 45);

		// realiza a tarifa��o
		droolsCom.tarifarLigacao(ligacao);
	}

	public void tarifarLigacao(Ligacao ligacao) {
		try {
			// carrega a knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-dtables");

			// aplica as regras
			System.out.println(ligacao.getPreco());
			kSession.insert(ligacao);
			kSession.fireAllRules();
			System.out.println(ligacao.getPreco());
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}