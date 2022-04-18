function Home() {
  return (
    <div>
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
            <tr>
              <td>1</td>
              <td>Pedro</td>
              <td>213432453</td>
              <td>Café</td>
            </tr>
            <tr>
              <td>2</td>
              <td>Angela</td>
              <td>31213131</td>
              <td>Chá</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default Home;
