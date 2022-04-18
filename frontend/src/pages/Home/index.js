import React from "react";
import { Container, ColaboradorRow } from "./styles";

function Home() {
  const colaboradores = [
    {
      id: 1,
      nome: "João",
      cpf: "123456789",
      opcaoCafeManha: "Café",
    },
    {
      id: 2,
      nome: "Gordon",
      cpf: "653452313",
      opcaoCafeManha: "Cuscuz",
    },
    {
      id: 3,
      nome: "Paula",
      cpf: "5434222",
      opcaoCafeManha: "Bolo",
    }
  ];

  return (
    <Container>
      <h1>Breakfest</h1>
      <h3>Lista de Colaboradores</h3>
      <div id="table-container">
        <table className="table table-striped">
          <thead>
            <tr>
              <td class="table-titles"> Id</td>
              <td class="table-titles"> Nome</td>
              <td class="table-titles"> CPF</td>
              <td class="table-titles"> Opção Café da Manhã</td>
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
