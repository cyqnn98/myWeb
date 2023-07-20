import axios from 'axios';

const CART_API_BASE_URL = 'http://localhost:8080/api/carts';

class CartService{
    // async getCart(id) {
    //     try {
    //         console.log("in getCart");
    //         console.log(id);
    
    //         const params = { userId: id };
    //         const response = await axios.get('/getCart', {
    //             baseURL: CART_API_BASE_URL, // Assuming CART_API_BASE_URL is defined elsewhere
    //             params: params,
    //         });
    
    //         console.log(response.data);
    //         return response.data;
    //     } catch (error) {
    //         console.error(error);
    //         throw error;
    //     }
    // }
    async getCart(id){
        try {
            console.log("in getCart")
            console.log(id)
            const params = {userId : id}
            const response = await axios({
                method: 'get',
                url: CART_API_BASE_URL + '/getCart',
                params: params,
            });
            console.log(response);
            return response;
        } catch (error) {
            console.log(error);
            throw error;
        }
    }
    // getCart(userId){
    //     const url = PRODUCTS_API_BASE_URL + '/getCart';
    //     const params = { userId: userId };
    //     return axios.get(url, { params: params });
    // }
}

export default new CartService();