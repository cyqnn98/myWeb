import axios from 'axios';

const USER_API_BASE_URL = 'http://localhost:8080/api/users';

class UserService{
    login(userForm){
        // axios.post(USER_API_BASE_URL+'/login', {
        //     userForm: userForm
        //   })
        //   .then(function (response) {
        //     console.log(response);
        //   })
        //   .catch(function (error) {
        //     console.log(error);
        //   });
        
        axios({
            method: 'post',
            url: USER_API_BASE_URL+'/login',
            data: userForm
        }).then(function (response){
            console.log(response)
        }).catch(function (error){
            console.log(error)
        });
    }
}

export default new UserService();

