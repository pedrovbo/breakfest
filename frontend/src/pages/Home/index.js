import React from "react";
import { Container, ColaboradorRow } from "./styles";
import { RemoverButton } from "../../components/buttonRemover";
import { useState, useEffect } from "react";
import { EditarButton } from "../../components/buttonEditar";
import {
  AdicionarColaboradorButton,
  AdicionarOpcaoCafeManhaButton,
} from "../../components/buttonAdicionar";
import { TableTitles } from "../../components/tableTitle";
import { ButtonContainer } from "../../components/buttonContainer";

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
              <TableTitles> Ações</TableTitles>
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
                  <ButtonContainer>
                    <span>
                      <AdicionarColaboradorButton type="button">
                      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus-circle"><circle cx="12" cy="12" r="10"></circle><line x1="12" y1="8" x2="12" y2="16"></line><line x1="8" y1="12" x2="16" y2="12"></line></svg>
                      </AdicionarColaboradorButton>
                    </span>
                    <span>
                      <AdicionarOpcaoCafeManhaButton type="button">
                      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-plus-circle"><circle cx="12" cy="12" r="10"></circle><line x1="12" y1="8" x2="12" y2="16"></line><line x1="8" y1="12" x2="16" y2="12"></line></svg>
                      </AdicionarOpcaoCafeManhaButton>
                    </span>
                    <span>
                      <EditarButton type="button">
                      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-edit"><path d="M11 4H4a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7"></path><path d="M18.5 2.5a2.121 2.121 0 0 1 3 3L12 15l-4 1 1-4 9.5-9.5z"></path></svg>
                      </EditarButton>
                    </span>
                    <span>
                      <RemoverButton type="button">
                      <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash-2"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path><line x1="10" y1="11" x2="10" y2="17"></line><line x1="14" y1="11" x2="14" y2="17"></line></svg>
                      </RemoverButton>
                    </span>                    
                  </ButtonContainer>
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
