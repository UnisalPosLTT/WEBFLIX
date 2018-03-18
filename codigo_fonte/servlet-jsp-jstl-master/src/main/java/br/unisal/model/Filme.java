package br.unisal.model;

import br.unisal.util.GsonSingleton;
import br.unisal.util.Util;

public class Filme {

	private Long id;
	private String nome;
	private String image;
	private String descricao;
	private String uuid;

	public Filme() {
		this.uuid = Util.UUIDGenerate();
	}

	/**
	 * @param nome
	 */
	public Filme(String nome, String image, String descricao) {
		super();
		this.nome = nome;
		this.image = image;
		this.descricao = descricao;
		this.uuid = Util.UUIDGenerate();
	}

	/*public Filme(String nome, Long id) {
		super();
		this.nome = nome;
		this.uuid = Util.UUIDGenerate();
	}*/

	
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

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return GsonSingleton.getInstance().toJson(this);
	}

}
