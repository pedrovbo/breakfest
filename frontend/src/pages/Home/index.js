import React from "react";
import { Container, ColaboradorRow } from "./styles";
import { useState, useEffect } from "react";

function Home() {
  /* const colaboradores = [
    
  ]; */

  const [colaboradores, setColaboradores] = useState([]) 

  useEffect(() => {
    fetch('https://breakfest.herokuapp.com/colaborador')
    .then(response => response.json())
    .then(data => console.log(data))
  }, [])

  return (
    <Container>
      <h1>Breakfest</h1>
      <h3>Lista de Colaboradores</h3>
      <div id="table-container">
        <table className="table table-striped">
          <thead>
            <tr>
              <td > Id</td>
              <td > Nome</td>
              <td > CPF</td>
              <td > Opção Café da Manhã</td>
            </tr>
          </thead>
          <tbody>
            {colaboradores.map((colaborador) => {
              return (
                <ColaboradorRow key={colaborador.id}>
                  <td>{colaborador.id}</td>
                  <td>{colaborador.nome}</td>
                  <td>{colaborador.cpf}</td>
                  <td>{colaborador.opcaoCafeManha}</td>
                </ColaboradorRow>
              );
            })}
          </tbody>
        </table>
      </div>
    </Container>
  );
}

export default Home;
