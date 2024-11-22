/*
 * Copyright (C) 2024 Sa_Th
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Dao;

import Utils.Conexao;
import Model.City;

import java.util.List;

/**
 *
 * @author Sa_Th
 */

/*
NOTA PARA O GABRIEL
    sim, eu tive que tirar as classes de interface
    PQ? Pq a implementação da interface EXIGE que a classe que implemente implemente TODAS
    as funções abstratas, então a DAO_Ordenacao teria que implementar o adicionar, atualizar, deletar e consultar, e não
    apenas o ordenacao que era o objetivo, dito isso, só tirei ai a gente implementa em cada classe de uma vez, fica burro? SIM
    mas a gente tá usando isso mais por obrigação de um requisito do professor do que por vonta de própria.
 */

interface DataAcessObject {
    
    public static final Conexao conexao = new Conexao();

}
