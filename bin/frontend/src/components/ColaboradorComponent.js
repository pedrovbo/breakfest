import React from "react";
import ColaboradorService from "../services/ColaboradorService";
// TODO: continuar na captação da lista de opções de café da manhã!
class ColaboradorComponent extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      colaboradores: []
    }
  }

  componentDidMount() {
    ColaboradorService.getAllColaboradores().then((response) => {
      this.setState({ colaboradores: response.data });
    });
  }

  render() {
    return (
      <div>
        <h1 className="text-center">Lista de Colaboradores</h1>
        <table className="table table-striped">
          <thead>
            <tr>
              <td> Colaborador Id</td>
              <td> Colaborador Nome</td>
              <td> Colaborador CPF</td>
              <td> Colaborador Opção Café da Manhã</td>
            </tr>
          </thead>
          <tbody>
            {this.state.colaboradores.map((colaborador) => (
              <tr key={colaborador.id}>
                <td>{colaborador.id}</td>
                <td>{colaborador.nome}</td>
                <td>{colaborador.cpf}</td>
                <td>{colaborador.opcaoCafeManha}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default ColaboradorComponent;
