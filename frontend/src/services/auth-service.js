import axios from 'axios';

const API_URL = "http://localhost:8080/api/auth/";

class AuthService {
    login(username, password) {
        console.log("auth service . login");
        return axios
            .post(API_URL + "singin", {
                username,
                password
            })
            .then(response=>{
                if(response.data.token) {

                    localStorage.setItem("user", JSON.stringify(response.data));
                }
                return response.data;
            });
    }
    logout() {
        localStorage.removeItem("user");
    }
    register(username, email, password) {
        return axios.post(API_URL+"singup", {
            username,
            email,
            password
        });
    }
    getCurrentUser() {
        return JSON.parse(localStorage.getItem('user'));
    }
    
}

export default new AuthService();

