package br.udesc.ddm.trabalho2.modelo.dao.core;

import java.util.List;

import br.udesc.ddm.trabalho2.modelo.entidade.Patrocinador;

/**
 * Created by ignoi on 26/10/2016.
 */

public interface PatrocinadorDAO {

    public void inserir(Patrocinador o);

    public void editar(Patrocinador o);

    public Patrocinador pesquisar(int o);

    public List<Patrocinador> listar();

    public void remover(int id);
    
    
}


//    insert into patrocinador(nome, estrelas, valor) values(?,?,?);
//
//
//        update patrocinador set nome = ?, estrelas = ?, valor = ?, where patrocinadorid = ?;
//
//        select * from patrocinador where patrocinadorid = ?;
//
//        delete from patrocinador where patrocinadorid = ?;