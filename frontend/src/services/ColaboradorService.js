import axios from 'axios'

const COLABORADORES_REST_API_URL = 'http://localhost:8080/colaborador/colaboradores';

class ColaboradorService {

    getAllColaboradores(){
        return axios.get(COLABORADORES_REST_API_URL);
    }
}

export default new ColaboradorService();