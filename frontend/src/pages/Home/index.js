import React from "react";
import { Container, ColaboradorRow, AddButtonsContainer } from "./styles";
import { RemoveButton } from "../../components/buttonRemover";
import { useState, useEffect } from "react";
import { EditarButton } from "../../components/buttonEditar";
import {
  AdicionarColaboradorButton,
  AdicionarOpcaoCafeManhaButton,
} from "../../components/buttonAdicionar";
import { TableTitles } from "../../components/tableTitle";

function Home() {
  const [colaboradores, setColaboradores] = useState([]);

  useEffect(() => {
    fetch("https://breakfest.herokuapp.com/colaborador")
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
              <TableTitles> Id</TableTitles>
              <TableTitles> Nome</TableTitles>
              <TableTitles> CPF</TableTitles>
              <TableTitles> Opção Café da Manhã</TableTitles>
            </tr>
          </thead>
          <tbody>
            {colaboradores.map((colaborador) => {
              return (
                <ColaboradorRow key={colaborador.id}>
                  <td>{colaborador.id}</td>
                  <td>{colaborador.nome}</td>
                  <td>{colaborador.cpf}</td>
                  {colaborador.opcaoCafeManha.map((opcao) => {
                    return <td key={opcao.id}>{opcao.item}</td>;
                  })}
                  <td>
                    <span>
                      <EditarButton
                        type="button"
                        name="Editar"
                        value="Editar"
                      />
                    </span>
                  </td>
                  <td>
                    <span>
                      <RemoveButton
                        type="button"
                        name="Remover"
                        value="Remover"
                      />
                    </span>
                  </td>
                </ColaboradorRow>
              );
            })}
          </tbody>
        </table>
        <AddButtonsContainer>
          <AdicionarColaboradorButton
            type="button"
            name="AdicionarColaborador"
            value="Adicionar Colaborador"
          ></AdicionarColaboradorButton>
          <AdicionarOpcaoCafeManhaButton
            type="button"
            name="AdicionarCafe"
            value="Adicionar Café da Manhã"
          ></AdicionarOpcaoCafeManhaButton>
        </AddButtonsContainer>
      </div>
    </Container>
  );
}

export default Home;
