/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisal.model;

import br.unisal.util.GsonSingleton;
import br.unisal.util.Util;

public class Filme {

	private Long id;
	private String nome;
	private String uuid;


        public Filme() {
		this.uuid = Util.UUIDGenerate();
	}

            
        
        public Filme(String nome) {
		super();
		this.nome = nome;
		this.uuid = Util.UUIDGenerate();
        
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
        
        


	public String toString() {
		return GsonSingleton.getInstance().toJson(this);
	}

}