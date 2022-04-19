import React from "react";
import { Container, ColaboradorRow } from "./styles";
import { useState, useEffect } from "react";

function Home() {
  const [colaboradores, setColaboradores] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/colaborador")
      .then((response) => response.json())
      .then((data) => setColaboradores(data));
  }, []);

  return (
    <Container>
      <h1>Breakfast</h1>
      <h3>Lista de Colaboradores</h3>
      <div id="table-container">
        <table className="table table-striped">
          <thead>
            <tr>
              <td> Id</td>
              <td> Nome</td>
              <td> CPF</td>
              <td> Opção Café da Manhã</td>
            </tr>
          </thead>
          <tbody>
            {colaboradores.map((colaborador) => {
              return (
                <ColaboradorRow key={colaborador.id}>
                  <td>{colaborador.id}</td>
                  <td>{colaborador.nome}</td>
                  <td>{colaborador.cpf}</td>
                  {colaborador.opcaoCafeManha.map((opcao)=> {
                      return(
                        <td key={opcao.id}>{opcao.item}</td>
                      )
                  })
                      }
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
