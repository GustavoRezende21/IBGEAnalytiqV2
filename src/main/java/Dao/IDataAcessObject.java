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
public interface IDataAcessObject {
    
    Conexao conexao = new Conexao();

    public List<City> consulta();
    public List<City> ordenacao();
    public void adicionar(City cidade) throws Exception;
    public void atualizar(City cidade) throws Exception;
    public void deletar(City cidade) throws Exception;

}
