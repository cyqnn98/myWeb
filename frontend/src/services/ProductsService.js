import axios from 'axios';

const PRODUCTS_API_BASE_URL = 'http://localhost:8080/api/products';

class ProductsService{
    getAllProducts(){
        return axios.get(PRODUCTS_API_BASE_URL);
    }
}

export default new ProductsService();