import axios from 'axios';

const http = axios.create({
      baseURL: "http://localhost:3000"
    })

export default {

  login(user) {
    return http.post('/login', user)
  },

  register(user) {
    return http.post('/register', user)
  },

}