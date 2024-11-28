/*
 * Copyright (C) 2024 Gabriel Cândido Ribeiro da Silva <gcrs2018@gmail.com> 
 * Copyright (C) 2024 Gustavo Rezende Gabriel <gustavorezendegabriel@hotmail.com>
 * Copyright (C) 2024 João Vitor Bier Barros <joaovitorbierbarros@gmail.com>
 * Copyright (C) 2024 Theo da Silva Sa <03silva.theo@gmail.com>
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
package Services;

import Dao.DAO_Consultar;
import Dao.DAO_Ordenacao;
import Model.City;
import Utils.Ordenacoes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
/**
 *
 * @author Gabriel Cândido Ribeiro da Silva <gcrs2018@gmail.com>
 * @author Gustavo Rezende Gabriel <gustavorezendegabriel@hotmail.com>
 * @author João Vitor Bier Barros <joaovitorbierbarros@gmail.com>
 * @author Theo da Silva Sa <03silva.theo@gmail.com>
 * @date 03/06/2024
 * @brief Class Main
 */

public class Read {

    DAO_Ordenacao daoOrdenacao = new DAO_Ordenacao();

    public Read() {}

    public ArrayList<City> buscarTodos() throws SQLException {

        //LinkedList<City> cidades = daoOrdenacao.semOrdem();
        //converte a LinkedList em um arraylist e já atribui
        ArrayList<City> cidades = new ArrayList<>(daoOrdenacao.semOrdem());
        return cidades;
    }
    
        public ArrayList<City> buscarOrdenado(Ordenacoes ordenacao) throws SQLException {
        ArrayList<City> cidades = new ArrayList<>(daoOrdenacao.ordenacao(ordenacao));
        return cidades;
    }

    public City melhorPibPerCapta()throws SQLException{

        LinkedList<City> cidades = daoOrdenacao.semOrdem();

        //Complicadinho isso aqui, mas to usando um stream, um stream abre uma stream de dados que percorre toda a lista
        //fazendo algo que vc tenha mandado, no caso eu usei o max para fazer a comparação com o maior PibPCTotal, se não achar nada
        //pq a lista tá vazia ele retorna null, não vai retornar null se o banco tiver com pelo menos uma cidade
        City cidade = cidades.stream()
                .max(Comparator.comparingDouble(City::getPibPcTotal))
                .orElse(null);

        return cidade;

    }

    public City piorPibPerCapta()throws SQLException{

        LinkedList<City> cidades = daoOrdenacao.semOrdem();

        //Complicadinho isso aqui, mas to usando um stream, um stream abre uma stream de dados que percorre toda a lista
        //fazendo algo que vc tenha mandado, no caso eu usei o min para fazer a comparação com os PibPCTotal e achar o min, se não achar nada
        //pq a lista tá vazia ele retorna null, não vai retornar null se o banco tiver com pelo menos uma cidade
        City cidade = cidades.stream()
                .min(Comparator.comparingDouble(City::getPibPcTotal))
                .orElse(null);

        return cidade;

    }

    public City melhorIDHEdu() throws SQLException{
        LinkedList<City> cidades = daoOrdenacao.semOrdem();

        //Complicadinho isso aqui, mas to usando um stream, um stream abre uma stream de dados que percorre toda a lista
        //fazendo algo que vc tenha mandado, no caso eu usei o max para fazer a comparação com o maior IDH, se não achar nada
        //pq a lista tá vazia ele retorna null, não vai retornar null se o banco tiver com pelo menos uma cidade
        City cidade = cidades.stream()
                .max(Comparator.comparingDouble(City::getIdhEducacao))
                .orElse(null);

        return cidade;
    }

    public City piorIDHEdu() throws SQLException{
        LinkedList<City> cidades = daoOrdenacao.semOrdem();

        //Complicadinho isso aqui, mas to usando um stream, um stream abre uma stream de dados que percorre toda a lista
        //fazendo algo que vc tenha mandado, no caso eu usei o max para fazer a comparação com o maior IDH, se não achar nada
        //pq a lista tá vazia ele retorna null, não vai retornar null se o banco tiver com pelo menos uma cidade
        City cidade = cidades.stream()
                .min(Comparator.comparingDouble(City::getIdhEducacao))
                .orElse(null);

        return cidade;
    }


    public City melhorIDH() throws SQLException{
        LinkedList<City> cidades = daoOrdenacao.semOrdem();

        //Complicadinho isso aqui, mas to usando um stream, um stream abre uma stream de dados que percorre toda a lista
        //fazendo algo que vc tenha mandado, no caso eu usei o max para fazer a comparação com o maior IDH, se não achar nada
        //pq a lista tá vazia ele retorna null, não vai retornar null se o banco tiver com pelo menos uma cidade
        City cidade = cidades.stream()
                .max(Comparator.comparingDouble(City::getIdh))
                .orElse(null);

        return cidade;
    }

    public City piorIDH() throws SQLException{
        LinkedList<City> cidades = daoOrdenacao.semOrdem();

        //Complicadinho isso aqui, mas to usando um stream, um stream abre uma stream de dados que percorre toda a lista
        //fazendo algo que vc tenha mandado, no caso eu usei o max para fazer a comparação com o maior IDH, se não achar nada
        //pq a lista tá vazia ele retorna null, não vai retornar null se o banco tiver com pelo menos uma cidade
        City cidade = cidades.stream()
                .min(Comparator.comparingDouble(City::getIdh))
                .orElse(null);

        return cidade;
    }

    public City maiorPibTotal()throws SQLException{

        LinkedList<City> cidades = daoOrdenacao.semOrdem();

        //Complicadinho isso aqui, mas to usando um stream, um stream abre uma stream de dados que percorre toda a lista
        //fazendo algo que vc tenha mandado, no caso eu usei o max para fazer a comparação com o maior PibPCTotal, se não achar nada
        //pq a lista tá vazia ele retorna null, não vai retornar null se o banco tiver com pelo menos uma cidade
        City cidade = cidades.stream()
                .max(Comparator.comparingDouble(City::getPibTotal))
                .orElse(null);

        return cidade;

    }

    public City menorPibTotal()throws SQLException{

        LinkedList<City> cidades = daoOrdenacao.semOrdem();

        //Complicadinho isso aqui, mas to usando um stream, um stream abre uma stream de dados que percorre toda a lista
        //fazendo algo que vc tenha mandado, no caso eu usei o min para fazer a comparação com os PibPCTotal e achar o min, se não achar nada
        //pq a lista tá vazia ele retorna null, não vai retornar null se o banco tiver com pelo menos uma cidade
        City cidade = cidades.stream()
                .min(Comparator.comparingDouble(City::getPibTotal))
                .orElse(null);

        return cidade;

    }
    
    

    public City consultarPorId(int id) throws SQLException {

        DAO_Consultar dao = new DAO_Consultar();
        
        return dao.consultarPorId(id);
    }

    public City consultarPorNome(String municipio) throws SQLException {

        DAO_Consultar dao = new DAO_Consultar();
        
        return dao.consultarPorNome(municipio);
    }
/*
    //JÁ FOI REFEITO, SEU EQUIVALENTE É O buscarTodos()
    public ArrayList<City> FindAll(Lista lista) {
        return lista.getCidades();
    }

    //Já foi refeito pensando em banco de dados na função melhorPibPerCapta
    public City FindBestPibPerCapta(Lista lista) {
        City city = lista.cidades.get(0);
        for (int i = 1; i < lista.cidades.size(); i++) {

            if (lista.cidades.get(i).getPibPcTotal() > city.getPibPcTotal()) {
                city = lista.cidades.get(i);
            }

        }
        return city;
    }

    //Já foi refeito pensando em banco de dados na função melhorIDH
    public City FindBestIdh(Lista lista) {
        City city = lista.cidades.get(0);
        for (int i = 1; i < lista.cidades.size(); i++) {

            if (lista.cidades.get(i).getIdh() > city.getIdh()) {
                city = lista.cidades.get(i);
            }

        }
        return city;
    }

    //Já foi refeito pensando em banco de dados na função menorPibPerCapta
    public City FindWorstPibPerCapta(Lista lista) {
        City city = lista.cidades.get(0);
        for (int i = 1; i < lista.cidades.size(); i++) {

            if (lista.cidades.get(i).getPibPcTotal() < city.getPibPcTotal()) {
                city = lista.cidades.get(i);
            }

        }
        return city;
    }

    //Já foi refeito pensando em banco de dados na função piorIDH
    public City FindWorstIdh(Lista lista) {
        City city = lista.cidades.get(0);
        for (int i = 1; i < lista.cidades.size(); i++) {

            if (lista.cidades.get(i).getIdh() < city.getIdh()) {
                city = lista.cidades.get(i);
            }

        }
        return city;
    }
*/

}