import axios from 'axios';

const http = axios.create({
      baseURL: "http://localhost:3000/authentication"
    })

export default {

  login(user) {
    return http.post('/authenticate', user)
  },

  register(user) {
    return http.post('/register', user)
  },

}