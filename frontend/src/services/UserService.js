import axios from 'axios';

const USER_API_BASE_URL = 'http://localhost:8080/api/users';

class UserService{
    async login(userForm){
        try {
            const response = await axios({
                method: 'post',
                url: USER_API_BASE_URL + '/login',
                data: userForm
            });
            console.log(response);
            return response;
        } catch (error) {
            console.log(error);
            throw error;
        }
    }
    async getUserInfo(token){
        try{
            const response = await axios({
                method: 'post',
                url: USER_API_BASE_URL + '/info',
                data: token
            });
            console.log(response)
            return response
        }catch(error){
            console.log(error)
            throw error
        }
    }
}

export default new UserService();

